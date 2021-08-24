package com.optare.interview;

import com.optare.interview.controller.ForecastController;
import com.optare.interview.model.ForecastDTO;
import com.optare.interview.services.ForecastService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherApplicationTests {

    @Mock
    private ForecastService forecastService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ForecastController(forecastService)).build();
    }

    @Test
    @SneakyThrows
    void shouldReturnWeather() {
        String lat = "36.96", lon = "-122.02";

        when(forecastService.findWeatherByCityId(lat, lon)).thenReturn(List.of(ForecastDTO.builder()
                .place("Santa Cruz").date("2020-10-22").weather("Heavy Cloud").build()));

        mockMvc.perform(get("/forecasts")
                        .param("lat", lat).param("lon", lon)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists());

    }


}
