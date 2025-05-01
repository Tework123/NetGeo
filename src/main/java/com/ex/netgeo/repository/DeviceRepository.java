package com.ex.netgeo.repository;


import com.ex.netgeo.entity.Device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий для работы с сущностью {@link Device}.
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {

//    Device findById(UUID deviceId);
}
