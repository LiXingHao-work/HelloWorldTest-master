create table if not exists `user`
(
    id           int    not null primary key,
    name         char(10)    not null,
    account      varchar(20) not null,
    password     varchar(65) not null,
    insert_time  datetime    not null default current_timestamp,
    update_time  datetime    not null default current_timestamp on update current_timestamp,

    unique (account)
    ) comment '用户表';

insert into `user` (`id`, `name`, `account`, `password`)
values (1,'李兴昊', 'test', '$2a$10$eV9GMyYmKZiDC6mGnkCFl.s2hDGcYmBU3eEEXtlSgKBujKE8lfN0i');