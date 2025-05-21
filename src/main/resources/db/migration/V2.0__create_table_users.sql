create table if not exists users (
    id serial,
    full_name varchar(50) not null,
    user_name varchar(50) not null,
    password varchar(255) not null,
    role varchar(20) not null,
    account_non_expired boolean not null,
    account_non_locked boolean not null,
    credentials_non_expired boolean not null,
    enabled boolean not null,
    constraint pk_user primary key (id),
    constraint unq_user_name unique(user_name)
)