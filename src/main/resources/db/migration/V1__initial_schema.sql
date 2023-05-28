drop table if exists user_subject;
drop table if exists user;
drop table if exists subject;

create table subject
(
     id bigint not null auto_increment,
     name varchar(255),
     total integer not null,
     primary key (id)
);

create table `user`
(
    id bigint not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table user_subject
(
    subject_id bigint not null,
    user_id bigint not null,
    primary key (subject_id, user_id)
);
