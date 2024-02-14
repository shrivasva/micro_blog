CREATE TABLE IF NOT EXISTS APP_USERS (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    contact_no VARCHAR(255),
    email_id VARCHAR(255)   UNIQUE,
    gender VARCHAR(255),
    dob date
);

CREATE TABLE IF NOT EXISTS APP_ADDRESS (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    pincode VARCHAR(255),
    address_1 VARCHAR(255),
    address_2 VARCHAR(255),
    landmark VARCHAR(255),
    state VARCHAR(255),
    city VARCHAR(255),
    CONSTRAINT fk_user_id_address FOREIGN KEY (user_id) REFERENCES APP_USERS(id)
);

CREATE TABLE IF NOT EXISTS APP_USERS_SECRET (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    password VARCHAR(255),
    expired BOOLEAN,
    locked boolean,
    fail_attempts SMALLINT,
    valid_till TIMESTAMP,
    last_updated TIMESTAMP,
    CONSTRAINT fk_user_id_secret FOREIGN KEY (user_id) REFERENCES APP_USERS(id)
);

CREATE TABLE IF NOT EXISTS APP_USERS_TEMP (
 password VARCHAR(255)
);