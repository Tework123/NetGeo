package com.ex.netgeo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность "Точка местоположения".
 * Хранит координаты устройства в определённый момент времени
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location_point")
public class LocationPoint {

    @Id
    @Column(name = "location_point_id", nullable = false, updatable = false)
    private UUID locationPointId;

    /**
     * Устройство, которому принадлежит данная точка координат.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    /**
     * Широта (latitude) точки координат.
     */
    @Column(name = "latitude", nullable = false)
    private double latitude;

    /**
     * Долгота (longitude) точки координат.
     */
    @Column(name = "longitude", nullable = false)
    private double longitude;

    /**
     * Время создания записи о местоположении.
     */
    @Column(name = "time_create", nullable = false, updatable = false)
    private LocalDateTime timeCreate;

    @PrePersist
    public void prePersist() {
        if (locationPointId == null) {
            locationPointId = UUID.randomUUID();
        }
        timeCreate = LocalDateTime.now();
    }
}