package com.yusuf.kusar.takehome.controller;

import com.yusuf.kusar.takehome.request.TemperatureDataRequest;
import com.yusuf.kusar.takehome.response.TemperatureResponse;
import com.yusuf.kusar.takehome.service.TemperatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/temperature")
@RequiredArgsConstructor
public class TemperatureController {

    private final TemperatureService temperatureService;
    @PostMapping
    public ResponseEntity<TemperatureResponse> createTemperatureData(@RequestBody TemperatureDataRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(temperatureService.getTemperatureDataByCityName(request.getQuery()));
    }

    @GetMapping
    public ResponseEntity<TemperatureResponse> getTemperatureDataByCityName(@RequestParam("q") String cityName) {
        return ResponseEntity.status(HttpStatus.OK).body(temperatureService.getTemperatureDataByCityName(cityName));
    }

}
