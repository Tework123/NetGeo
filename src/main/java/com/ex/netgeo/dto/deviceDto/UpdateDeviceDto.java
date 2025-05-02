package com.ex.netgeo.dto.deviceDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateDeviceDto {
    private String name;
    private Boolean active;
}
