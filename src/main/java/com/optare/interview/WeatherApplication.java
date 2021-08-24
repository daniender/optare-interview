package com.optare.interview;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	@GetMapping("/forecasts")
	public List<Forecast> listOfForecasts(@RequestParam String lat, @RequestParam String lon) {

		List<Forecast> result = new ArrayList<>();

		//TODO: Remove hardcoded Get cityId and cityName from coordinates: https://www.metaweather.com/api
		Integer cityId = 2488853;
		String cityName = "Santa Cruz";

		System.out.println("City " + cityId + cityName);

		String url = "https://www.metaweather.com/api/location/" + cityId;

		ResponseEntity<String> responseWeather = restTemplate.getForEntity(url, String.class);
		JSONArray var0 = JsonPath.read(responseWeather.getBody(), "$.consolidated_weather.[*]");
		for (Object x : var0) {
			String var1 = JsonPath.read(x, "$.weather_state_name");
			String var2 = JsonPath.read(x, "$.applicable_date");
			result.add(new Forecast(cityName, var2, var1));
		}

		return result;
	}


	public class Forecast {

		private String place;
		private String date;
		private String weather;

		public Forecast(String place, String date, String weather) {
			this.place = place;
			this.date = date;
			this.weather = weather;
		}

		public String getPlace() {
			return place;
		}

		public void setPlace(String place) {
			this.place = place;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getWeather() {
			return weather;
		}

		public void setWeather(String weather) {
			this.weather = weather;
		}
	}

}
