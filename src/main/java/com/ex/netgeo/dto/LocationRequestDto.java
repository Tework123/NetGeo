package com.ex.netgeo.dto;

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
public class LocationRequestDto {
    private Long deviceId;
    private double latitude;
    private double longitude;
    private LocalDateTime timeCreate;
}
