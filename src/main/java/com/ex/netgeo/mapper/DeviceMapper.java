package com.ex.netgeo.mapper;

import com.ex.netgeo.dto.deviceDto.CreateDeviceRequestDto;
import com.ex.netgeo.dto.deviceDto.GetDeviceResponseDto;
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

        Device device = new Device();
        device.setName(dto.getName());
        return device;
    }
}
