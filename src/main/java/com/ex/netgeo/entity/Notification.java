package com.ex.netgeo.entity;

import com.ex.netgeo.enums.NotificationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Сущность "Уведомление" для устройства.
 * Представляет уведомление для устройства, связанное с его состоянием
 * или действиями в системе.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification")
public class Notification {

    @Id
    @Column(name = "notification_id", nullable = false, updatable = false)
    private UUID notificationId;

    /**
     * Устройство, к которому относится это уведомление.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    /**
     * Статус уведомления.
     */
    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus;

    /**
     * Сообщение, связанное с уведомлением.
     */
    @Column(name = "message")
    private String message;

    /**
     * Время создания уведомления.
     */
    @Column(name = "time_create", nullable = false)
    private LocalDateTime timeCreate;

    @PrePersist
    public void prePersist() {
        if (notificationId == null) {
            notificationId = UUID.randomUUID();
        }
        timeCreate = LocalDateTime.now();
    }

}
