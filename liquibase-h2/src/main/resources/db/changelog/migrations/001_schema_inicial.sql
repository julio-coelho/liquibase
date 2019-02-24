--liquibase formatted sql

--changeset juliocoelho:1
CREATE TABLE IF NOT EXISTS product (
 id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY CONSTRAINT product_pkey PRIMARY KEY ,
 description VARCHAR(255),
 name VARCHAR(255),
 parent_product_id BIGINT CONSTRAINT product_parent_fkey references product
);

CREATE TABLE IF NOT EXISTS image (
 id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY CONSTRAINT image_pkey PRIMARY KEY,
 type VARCHAR(255),
 product_id BIGINT CONSTRAINT product_image_fkey REFERENCES product
);

--rollback ALTER TABLE image DROP CONSTRAINT product_image_fkey;
--rollback ALTER TABLE product DROP CONSTRAINT product_parent_fkey;
--rollback DROP TABLE image;
--rollback DROP TABLE product;