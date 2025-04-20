package com.ex.netgeo.service;

import com.ex.netgeo.dto.LocationRequestDto;
import com.ex.netgeo.dto.TrackingDeviceSaveRequestDto;
import com.ex.netgeo.entity.LocationPoint;
import com.ex.netgeo.entity.TrackingDevice;
import com.ex.netgeo.repository.TrackingDeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TrackingDeviceService {
    private final TrackingDeviceRepository trackingDeviceRepository;


    /**
     * Создает устройство в базе данных.
     *
     * @param request поля устройства
     */
    @Transactional
    public void save(TrackingDeviceSaveRequestDto request) {
        TrackingDevice trackingDevice = TrackingDevice.builder()
                .name(request.getName())
                .build();
        trackingDeviceRepository.save(trackingDevice);
    }
}
