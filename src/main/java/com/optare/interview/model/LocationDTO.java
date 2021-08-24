package com.optare.interview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO {

    String title;
    String locationType;
    Float lattLong;
    Integer woeid;
    Integer distance;

}
