package com.yusuf.kusar.takehome.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusuf.kusar.takehome.exception.TemperatureDataNotFoundException;
import com.yusuf.kusar.takehome.response.TemperatureDataResponse;
import com.yusuf.kusar.takehome.response.TemperatureResponse;
import com.yusuf.kusar.takehome.service.TemperatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TemperatureServiceImpl implements TemperatureService {
    private final List<TemperatureDataResponse> cityTemperatureInformationResponses;

    public TemperatureServiceImpl() {
        this.cityTemperatureInformationResponses = loadCitiesTemperatureInformation();
    }

    private List<TemperatureDataResponse> loadCitiesTemperatureInformation() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<TemperatureDataResponse>> typeReference = new TypeReference<>() {};
        try{
            InputStream inputTemperatureData = TypeReference.class.getResourceAsStream("/json/temperature-data.json");
            return objectMapper.readValue(inputTemperatureData, typeReference);
        } catch (IOException e) {
            log.info("Static data could not be successfully.No temperature data was found");
            throw new TemperatureDataNotFoundException("No temperature data was found");
        }
    }

    @Override
    public List<TemperatureDataResponse> getAllCitiesTemperatureData() {
        return cityTemperatureInformationResponses;
    }

    @Override
    public TemperatureResponse getTemperatureDataByCityName(String cityName) {
        Optional<TemperatureDataResponse> response = cityTemperatureInformationResponses.stream()
                .filter(city -> city.getCityName().equalsIgnoreCase(cityName))
                .findFirst();
        return response.map(temperatureDataResponse -> new TemperatureResponse("success", temperatureDataResponse)).orElseGet(() -> new TemperatureResponse("failure", null));
    }
}
