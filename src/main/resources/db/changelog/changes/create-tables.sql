--liquibase formatted sql
--changeset <romanovosad>:<create-tables>

CREATE SEQUENCE cameras_seq;

CREATE SEQUENCE pictures_seq;

CREATE TABLE IF NOT EXISTS cameras
(
    id         bigint DEFAULT NEXT VALUE FOR cameras_seq,
    name       varchar(255) NOT NULL,
    nasa_id    bigint       NOT NULL,
    created_at timestamp    NOT NULL default now(),
    constraint PK_cameras PRIMARY KEY (id),
    constraint UQ_cameras_nasa_id UNIQUE (nasa_id)
);

CREATE TABLE IF NOT EXISTS pictures
(
    id         bigint DEFAULT NEXT VALUE FOR pictures_seq,
    nasa_id    bigint       NOT NULL,
    img_src    varchar(255) NOT NULL,
    created_at timestamp    NOT NULL DEFAULT now(),
    camera_id  bigint       NOT NULL,
    constraint PK_pictures PRIMARY KEY (id),
    constraint FK_pictures_cameras FOREIGN KEY (camera_id) REFERENCES cameras (id),
    constraint UQ_pictures_nasa_id UNIQUE (nasa_id)
)

