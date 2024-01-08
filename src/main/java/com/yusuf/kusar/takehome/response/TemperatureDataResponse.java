package com.yusuf.kusar.takehome.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureDataResponse {
    private String cityName;
    private String temperature;
    private String unit;
}
