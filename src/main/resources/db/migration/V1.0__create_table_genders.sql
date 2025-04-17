create table if not exists genders (
    id serial,
    name varchar(30) not null,
    description varchar(50) not null,
    constraint pk_genders primary key (id)
);

