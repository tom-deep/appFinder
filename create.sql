/*
This file is not used, ended up making tables directly in the POSTGRESQL server. 
*/

CREATE TABLE users (
    id serial PRIMARY KEY,
    username character varying(255) UNIQUE,
    email character varying(255),
    password character varying(255)
)