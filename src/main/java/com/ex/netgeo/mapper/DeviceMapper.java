package com.ex.netgeo.mapper;

import com.ex.netgeo.dto.deviceDto.CreateDeviceRequestDto;
import com.ex.netgeo.dto.deviceDto.GetDeviceResponseDto;
import com.ex.netgeo.dto.deviceDto.UpdateDeviceDto;
import com.ex.netgeo.entity.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {
    public GetDeviceResponseDto toResponseDto(Device device) {
        if (device == null) return null;

        GetDeviceResponseDto dto = new GetDeviceResponseDto();
        dto.setName(device.getName());
        dto.setActive(device.isActive());
        dto.setTimeCreate(device.getTimeCreate());
        dto.setTimeLastSeenAt(device.getTimeLastSeenAt());
        return dto;
    }

    public Device toEntity(CreateDeviceRequestDto dto) {
        if (dto == null) return null;

        return Device.builder()
                .name(dto.getName()).build();
    }

    public void updateDeviceFromDto(Device device, UpdateDeviceDto dto) {
        if (dto.getName() != null) {
            device.setName(dto.getName());
        }
        if (dto.getActive() != null) {
            device.setActive(dto.getActive());
        }
    }
}
