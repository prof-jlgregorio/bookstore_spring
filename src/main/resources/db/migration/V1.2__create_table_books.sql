create table if not exists books (
    id serial,
    name varchar(150) not null,
    summary varchar(100) not null,
    author_id bigint not null,
    gender_id bigint not null,
    constraint pk_books primary key (id),
    constraint fk_books_authors foreign key (author_id) references authors (id),
    constraint fk_books_genders foreign key (gender_id) references genders (id)
);