package com.yusuf.kusar.takehome.service;

import com.yusuf.kusar.takehome.response.TemperatureDataResponse;
import com.yusuf.kusar.takehome.response.TemperatureResponse;

import java.util.List;

public interface TemperatureService {
    List<TemperatureDataResponse> getAllCitiesTemperatureData();
    TemperatureResponse getTemperatureDataByCityName(String cityName);
}
