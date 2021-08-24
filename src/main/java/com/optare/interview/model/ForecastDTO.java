package com.optare.interview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ForecastDTO {

    private String place;
    private String date;
    private String weather;
}
