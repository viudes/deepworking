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

-- work_entry
CREATE SEQUENCE work_entry_id_seq;
CREATE TABLE work_entry (
    id integer PRIMARY KEY,
    project_id integer references project(id),
    amount_time integer not null default(0),
    start_time timestamp,
    description varchar(255) not null
);
ALTER sequence work_entry_id_seq OWNED BY work_entry.id;

-- score
CREATE SEQUENCE score_id_seq;
CREATE TABLE score (
    id integer PRIMARY KEY,
    points integer,
    description varchar(200),
    work_entry_id integer REFERENCES work_entry(id)
);
ALTER SEQUENCE score_id_seq OWNED BY score.id;

-- label
CREATE SEQUENCE label_id_seq;
CREATE TABLE label (
    id integer PRIMARY KEY,
    project_id integer references project(id),
    name varchar(60) not null,
    description varchar(255)
);
ALTER SEQUENCE label_id_seq OWNED BY label.id;

-- work_entry_label
CREATE TABLE work_entry_label (
    work_entry_id integer references work_entry(id),
    label_id integer references label(id),
    constraint work_entry_label_pk primary key (work_entry_id, label_id)
);
