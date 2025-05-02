package com.ex.netgeo.mapper;

import com.ex.netgeo.dto.locationPointDto.CreateLocationRequestDto;
import com.ex.netgeo.dto.deviceDto.GetDeviceResponseDto;
import com.ex.netgeo.dto.deviceDto.UpdateDeviceDto;
import com.ex.netgeo.dto.locationPointDto.GetLastLocationPointDto;
import com.ex.netgeo.entity.Device;
import com.ex.netgeo.entity.LocationPoint;
import org.springframework.stereotype.Component;

@Component
public class LocationPointMapper {
    public GetLastLocationPointDto toResponseDto(LocationPoint locationPoint) {
        if (locationPoint == null) return null;

        GetLastLocationPointDto dto = new GetLastLocationPointDto();
        dto.setLatitude(dto.getLatitude());
        dto.setLongitude(dto.getLongitude());
        dto.setDeviceTimestamp(dto.getDeviceTimestamp());
        return dto;
    }

    public LocationPoint toEntity(CreateLocationRequestDto dto, Device device) {
        if (dto == null) return null;

        return LocationPoint.builder()
                .device(device)
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .deviceTimestamp(dto.getDeviceTimestamp())
                .build();
    }

}
