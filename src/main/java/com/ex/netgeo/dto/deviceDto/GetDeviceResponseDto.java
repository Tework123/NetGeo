package com.ex.netgeo.dto.deviceDto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO для вывода информации об устройстве.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetDeviceResponseDto {
    private String name;
    private boolean active;
    private LocalDateTime timeCreate;
    private LocalDateTime timeLastSeenAt;


}
