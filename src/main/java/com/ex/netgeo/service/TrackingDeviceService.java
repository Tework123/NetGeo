package com.ex.netgeo.service;

import com.ex.netgeo.dto.TrackingDeviceSaveRequestDto;
import com.ex.netgeo.entity.Device;
import com.ex.netgeo.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TrackingDeviceService {
    private final DeviceRepository deviceRepository;


    /**
     * Создает устройство в базе данных.
     *
     * @param request поля устройства
     */
    @Transactional
    public void save(TrackingDeviceSaveRequestDto request) {
        Device trackingDevice = Device.builder()
                .name(request.getName())
                .build();
        deviceRepository.save(trackingDevice);
    }
}
