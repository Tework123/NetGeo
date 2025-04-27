package com.ex.netgeo.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO для приёма координат от устройства.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationRequestDto {
    private UUID deviceId;
    private double latitude;
    private double longitude;
    private LocalDateTime timeCreate;
}
