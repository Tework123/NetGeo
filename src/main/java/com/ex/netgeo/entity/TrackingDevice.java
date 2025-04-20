package com.ex.netgeo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
@Table(name = "tracking_device")
public class TrackingDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceId;

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
    @Column(name = "date_register", nullable = false)
    private LocalDateTime dateRegister;

    /**
     * Последнее время, когда устройство передавало координаты.
     */
    @Column(name = "time_last_seen_at", nullable = true)
    private LocalDateTime timeLastSeenAt;

    @PrePersist
    public void prePersist() {
        dateRegister = LocalDateTime.now();
        active = false;
    }

    @PreUpdate
    public void preUpdate() {
    }
}
