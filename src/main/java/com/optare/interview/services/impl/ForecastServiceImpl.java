package com.optare.interview.services.impl;

import com.jayway.jsonpath.JsonPath;
import com.optare.interview.model.ForecastDTO;
import com.optare.interview.services.ForecastService;
import lombok.SneakyThrows;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final static String URL = "https://www.metaweather.com/api/location/";

    @Override
    @SneakyThrows
    public List<ForecastDTO> findWeatherByCityId(String lat, String lon) {
        final List<ForecastDTO> result = new LinkedList<>();
        final RestTemplate template = new RestTemplate();

        // /api/location/search/?lattlong=36.96,-122.02
        final String urlForCity = URL.concat("search").concat(String.format("/?lattlong=%s", new StringJoiner(",").add(lat).add(lon)));
        final var responseCities = template.getForEntity(urlForCity, String.class);
        final JSONArray cities = JsonPath.read(responseCities.getBody(), "$");

        final Integer cityId = JsonPath.read(cities.get(0), "$.woeid");
        final String urlForWeather = URL.concat(String.valueOf(cityId));
        final var responseWeather = template.getForEntity(urlForWeather, String.class);

        JSONArray weatherList = JsonPath.read(responseWeather.getBody(), "$.consolidated_weather.[*]");
        weatherList.forEach(w -> result.add(ForecastDTO.builder()
                .place(JsonPath.read(cities.get(0), "$.title"))
                .date(JsonPath.read(w, "$.applicable_date"))
                .weather(JsonPath.read(w, "$.weather_state_name")).build()));
        return result;
    }
}