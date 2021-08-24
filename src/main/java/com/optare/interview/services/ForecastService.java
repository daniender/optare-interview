package com.optare.interview.services;

import com.optare.interview.model.ForecastDTO;

import java.util.List;

public interface ForecastService {

    List<ForecastDTO> findWeatherByCityId(final String lat, final String lon);
}
