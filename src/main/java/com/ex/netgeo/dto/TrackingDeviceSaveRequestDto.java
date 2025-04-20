package com.ex.netgeo.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO для регистрации устройства.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrackingDeviceSaveRequestDto {
    private String name;
    private double longitude;
    private LocalDateTime timeCreate;
}
