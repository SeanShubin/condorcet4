CREATE TABLE election
(
    name        VARCHAR(100) NOT NULL PRIMARY KEY,
    description VARCHAR(100),
    created     TIMESTAMP,
    start       TIMESTAMP,
    end         TIMESTAMP,
    'group'     VARCHAR(100) -- foreign key
);

CREATE TABLE voter
(
    name     VARCHAR(100) NOT NULL PRIMARY KEY,
    email    VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE candidate
(
    election    VARCHAR(100) NOT NULL, -- foreign key
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(100)
);

CREATE TABLE 'group'
(
    name VARCHAR(100) NOT NULL PRIMARY KEY
);

CREATE TABLE voter_group
(
    voter   VARCHAR(100) NOT NULL, -- foreign key
    'group' VARCHAR(100) NOT NULL  -- foreign key
);
