package com.ex.netgeo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Сущность, представляющая зарегистрированное устройство, отправляющее координаты.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "device")
public class Device {

    @Id
    @Column(name = "device_id", nullable = false, updatable = false)
    private UUID deviceId;

    /**
     * Точки местоположения, связанные с устройством.
     */
    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE,
            orphanRemoval = true, mappedBy = "device")
    private List<LocationPoint> locationPointList = new ArrayList<>();

    /**
     * Название устройства).
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Статус активности (например, включено/отключено).
     */
    @Column(name = "active", nullable = false)
    private boolean active;

    /**
     * Время регистрации устройства.
     */
    @Setter(AccessLevel.NONE)
    @Column(name = "time_create", nullable = false, updatable = false)
    private LocalDateTime timeCreate;

    /**
     * Последнее время, когда устройство передавало координаты.
     */
    @Column(name = "time_last_seen_at")
    private LocalDateTime timeLastSeenAt;

    @PrePersist
    public void prePersist() {
        if (deviceId == null) {
            deviceId = UUID.randomUUID();
        }
        timeCreate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
    }
}
