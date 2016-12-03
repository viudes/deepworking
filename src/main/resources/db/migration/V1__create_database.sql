SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';

SET search_path = public, pg_catalog;
SET default_tablespace = '';
SET default_with_oids = false;

-- project
CREATE sequence project_id_seq;

CREATE TABLE project (
    id integer PRIMARY KEY,
    name varchar(100) not null
);

ALTER SEQUENCE project_id_seq OWNED BY project.id;

-- activity types for one project
CREATE sequence activity_type_id_seq;

CREATE TABLE activity_type (
    id integer PRIMARY KEY,
    name varchar(100) not null,
    project_id integer REFERENCES project(id)
);

ALTER SEQUENCE activity_type_id_seq OWNED BY activity_type.id;

-- activity entry for a project
CREATE SEQUENCE activity_id_seq;

CREATE TABLE activity (
    id integer PRIMARY KEY,
    project_id integer references project(id),
    activity_type integer references activity_type(id),
    start_time timestamp not null,
    amount_time_in_minutes integer not null default(0),
    description varchar(255) not null
);

ALTER sequence activity_id_seq OWNED BY activity.id;

-- score
CREATE SEQUENCE score_id_seq;
CREATE TABLE score (
    id integer PRIMARY KEY,
    points integer not null,
    interruptions integer not null,
    notes varchar(200),
    activity_id integer REFERENCES activity(id)
);
ALTER SEQUENCE score_id_seq OWNED BY score.id;

