package com.yusuf.kusar.takehome.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TemperatureResponse {
    private String status;
    private TemperatureDataResponse response;
}
