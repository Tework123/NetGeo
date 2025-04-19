package com.ex.netgeo.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO для приёма координат от устройства.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationRequest {
    private String deviceId;
    private double latitude;
    private double longitude;
    private LocalDateTime timeCreate;
}
