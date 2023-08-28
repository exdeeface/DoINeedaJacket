package com.grae.WeatherTest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
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
import java.util.Map;


@SpringBootApplication
@RestController
public class WeatherTestApplication {
	@GetMapping("/getHourlyWeather")
	public static String requestHourlyForecast(String location) throws IOException {
		OkHttpClient client = new OkHttpClient();

		String timestep = "1h";
		String unit = "metric";

		Request request = new Request.Builder()
				.url("https://tomorrow-io1.p.rapidapi.com/v4/weather/forecast?location=" + location + "&timesteps=1d&units=metric")
				.get()
				.addHeader("X-RapidAPI-Key", System.getenv("X_RAPIDAPI_KEY"))
				.addHeader("X-RapidAPI-Host", "tomorrow-io1.p.rapidapi.com")
				.build();

		Response response = client.newCall(request).execute();

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		HourlyForecast hourlyForecast = objectMapper.readValue(response.body().string(), HourlyForecast.class);
		ResponseHandler responseHandler = new ResponseHandler();
		return responseHandler.createTemplate(hourlyForecast);
	}

	@GetMapping("/getDailyWeather")
	public static String requestDailyForecast(String location) throws IOException {
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
		ResponseHandler responseHandler = new ResponseHandler();
		return responseHandler.createTemplate(dailyForecast);
	}

	@GetMapping("/searchLocation")
	public static String searchForm() throws IOException {
		Map<String, Object> context = Maps.newHashMap();
		String template = Resources.toString(Resources.getResource("searchLocation.html"), Charsets.UTF_8);
		var jnj = new Jinjava();
		return jnj.render(template, context);
	}

	@PostMapping("/searchLocation")
	public static String searchSubmit(@RequestParam("location") String location) throws IOException {
		return requestDailyForecast(location);
	}

	public static String requestFakeDailyForecast() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		DailyForecast dailyForecast = objectMapper.readValue(new File("src/test2.json"), DailyForecast.class);
		ResponseHandler responseHandler = new ResponseHandler();
		return responseHandler.createTemplate(dailyForecast);
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherTestApplication.class, args);
	}
}

//TODO:
	//add a static folder and a css file
	//add a form or search function
	//draw a graph from hourly results?
	//precipitation also
	//peek another api and maybe look for nearby events if the weather is nice??
	//do i need a jacket?
