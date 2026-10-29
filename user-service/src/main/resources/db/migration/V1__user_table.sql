CREATE TABLE app_users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address TEXT,
    alerting SMALLINT NOT NULL DEFAULT 0,
    energy_alerting_threshold DOUBLE PRECISION NOT NULL DEFAULT 0,
    CONSTRAINT uk_user_email UNIQUE (email)
)