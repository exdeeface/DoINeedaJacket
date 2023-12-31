package com.grae.dinaj;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
@RestController
public class WeatherTestApplication {
	public static DailyForecast requestDailyForecast(String location) throws IOException {
		OkHttpClient client = new OkHttpClient();

		String timestep = "1d";
		String unit = "metric";

		Request request = new Request.Builder()
				.url("https://tomorrow-io1.p.rapidapi.com/v4/weather/forecast?location=" + location + " &timesteps=" + timestep + "&units=" + unit)
				.get()
				.addHeader("X-RapidAPI-Key", System.getenv("X_RAPIDAPI_KEY"))
				.addHeader("X-RapidAPI-Host", "tomorrow-io1.p.rapidapi.com")
				.build();

		Response response = client.newCall(request).execute();

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		DailyForecast dailyForecast = objectMapper.readValue(response.body().string(), DailyForecast.class);
        handleForecast(dailyForecast);

		return dailyForecast;
	}

	@GetMapping("/getWeather")
	public static String displayPage(String location) throws IOException {
		if (Objects.equals(location, "") || location == null) {
			return errorPage();
		} else {
			DailyForecast dailyForecast = requestDailyForecast(location);
			String template;

			try { template = ResponseHandler.createTemplate(dailyForecast); }
			catch (NullPointerException e) { return errorPage(); }
			return template;
		}
	}

	@GetMapping({"/", "/search"})
	public static String searchForm() throws IOException {
		Map<String, Object> context = Maps.newHashMap();
		String template = Resources.toString(Resources.getResource("searchLocation.html"), StandardCharsets.UTF_8);
		var jnj = new Jinjava();
		return jnj.render(template, context);
	}

	@GetMapping({"/error"})
	public static String errorPage() throws IOException {
		Map<String, Object> context = Maps.newHashMap();
		var jnj = new Jinjava();
		String template = Resources.toString(Resources.getResource("errorPage.html"), StandardCharsets.UTF_8);
		return jnj.render(template, context);
	}

	@GetMapping("/getFakeWeather")
	public static DailyForecast requestFakeDailyForecast() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		DailyForecast dailyForecast = objectMapper.readValue(new File("src/testForecast.json"), DailyForecast.class);
		handleForecast(dailyForecast);

		return dailyForecast;
	}

	public static void handleForecast(DailyForecast dailyForecast) {
		if (dailyForecast.getTimelines() == null) { return; }

		if (dailyForecast.getTimelines().getDaily().size() > 5) {
			dailyForecast.getTimelines().getDaily().remove(dailyForecast.getTimelines().getDaily().size()-1);
		}

		for (Daily d : dailyForecast.getTimelines().getDaily()) { d.summariseData(); }
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherTestApplication.class, args);
	}
}
