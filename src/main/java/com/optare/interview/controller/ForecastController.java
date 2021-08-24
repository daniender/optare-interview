package com.optare.interview.controller;

import com.optare.interview.model.ForecastDTO;
import com.optare.interview.services.ForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ForecastController {

    private final ForecastService forecastService;

    @GetMapping("/forecasts")
    public ResponseEntity<List<ForecastDTO>> listOfForecasts(@RequestParam(value = "lat") String lat,
                                                             @RequestParam(value = "lon") String lon) {
        final List<ForecastDTO> result = this.forecastService.findWeatherByCityId(lat, lon);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
