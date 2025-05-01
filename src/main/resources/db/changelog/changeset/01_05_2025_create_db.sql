CREATE TABLE device
(
    device_id         UUID PRIMARY KEY,
    name              VARCHAR(255) NOT NULL,
    active            BOOLEAN      NOT NULL,
    time_create       TIMESTAMP    NOT NULL,
    time_last_seen_at TIMESTAMP
);

CREATE TABLE location_point
(
    location_point_id UUID PRIMARY KEY,
    device_id         UUID             NOT NULL,
    latitude          DOUBLE PRECISION NOT NULL,
    longitude         DOUBLE PRECISION NOT NULL,
    time_create       TIMESTAMP        NOT NULL,
    CONSTRAINT fk_location_device FOREIGN KEY (device_id) REFERENCES device (device_id) ON DELETE CASCADE
);

CREATE TABLE notification
(
    notification_id     UUID PRIMARY KEY,
    device_id           UUID      NOT NULL,
    notification_status VARCHAR(50),
    message             TEXT,
    time_create         TIMESTAMP NOT NULL,
    CONSTRAINT fk_notification_device FOREIGN KEY (device_id) REFERENCES device (device_id) ON DELETE CASCADE
);

CREATE TABLE geozone
(
    geozone_id  UUID PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    geometry    geometry(Polygon, 4326) NOT NULL,
    time_create TIMESTAMP    NOT NULL
);