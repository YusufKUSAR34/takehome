package com.yusuf.kusar.takehome.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table
public class TemperatureData {
    @Id
    private String cityName;
    private String temperature;
    private String unit;
}
