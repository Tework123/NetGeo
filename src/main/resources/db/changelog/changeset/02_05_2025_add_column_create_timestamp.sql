ALTER TABLE location_point
    ADD COLUMN device_timestamp TIMESTAMP;

UPDATE location_point
SET device_timestamp = time_create
WHERE device_timestamp IS NULL;

ALTER TABLE location_point
    ALTER COLUMN device_timestamp SET NOT NULL;