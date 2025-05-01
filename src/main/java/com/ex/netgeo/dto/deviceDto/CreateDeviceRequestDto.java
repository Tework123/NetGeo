package com.ex.netgeo.dto.deviceDto;

import lombok.*;

/**
 * DTO для регистрации устройства.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDeviceRequestDto {
    private String name;
}
