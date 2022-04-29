-- extensions
CREATE SCHEMA extensions;
GRANT USAGE ON SCHEMA extensions TO public;
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA extensions to public;

ALTER DEFAULT PRIVILEGES IN SCHEMA extensions GRANT EXECUTE ON FUNCTIONS TO public;
ALTER DEFAULT PRIVILEGES IN SCHEMA extensions GRANT USAGE ON TYPES TO public;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" SCHEMA extensions;

-- dev schema
CREATE SCHEMA IF NOT EXISTS dev;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA dev TO aid_root;
ALTER ROLE aid_root SET search_path = dev, extensions;

-- initial table
DROP TABLE IF EXISTS aid CASCADE;
CREATE TABLE aid (
    id UUID DEFAULT uuid_generate_v4(),
    latitude VARCHAR(12) NOT NULL,
    longitude VARCHAR(13) NOT NULL,
    title VARCHAR(50) NOT NULL,
    description VARCHAR,
    PRIMARY KEY (id)
);

-- example values
INSERT INTO aid(latitude, longitude, title, description) VALUES ('51.2071453', '24.6924983', 'Medicaments', 'Test description'),
('48.450001', '34.983334', 'Construction materials', 'Test description'),
('50.450001', '30.523333', 'Construction workers', 'Test description'),
('48.748718', '30.221500', 'Picks and shovels', 'Test description'),
('45.357315', '36.468292', 'Medical Help', 'Test description');