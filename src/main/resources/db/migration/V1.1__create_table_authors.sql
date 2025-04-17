create table if not exists authors (
    id serial,
    name varchar(50) not null,
    country varchar(50) not null,
    constraint pk_authors primary key (id)
);

