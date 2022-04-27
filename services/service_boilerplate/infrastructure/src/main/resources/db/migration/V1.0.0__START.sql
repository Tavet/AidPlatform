CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE aid (
    id UUID DEFAULT uuid_generate_v4(),
    latitude VARCHAR(12) NOT NULL,
    longitude VARCHAR(13) NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR,
    PRIMARY KEY (id)
);