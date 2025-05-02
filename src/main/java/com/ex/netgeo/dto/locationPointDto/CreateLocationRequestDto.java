package com.ex.netgeo.dto.locationPointDto;

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
public class CreateLocationRequestDto {
    private UUID deviceId;
    private double latitude;
    private double longitude;
    private LocalDateTime deviceTimestamp;
}
