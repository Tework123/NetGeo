package com.ex.netgeo.repository;


import com.ex.netgeo.entity.LocationPoint;
import com.ex.netgeo.entity.TrackingDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с сущностью {@link TrackingDevice}.
 */
@Repository
public interface TrackingDeviceRepository extends JpaRepository<TrackingDevice, Long> {
}
