create table STATION
(
   id bigint auto_increment not null,
   name varchar(255) not null,
   primary key(id)
);

create table if not exists EDGE
(
    id bigint auto_increment not null,
    line_id bigint not null,
    elapsed_time int not null,
    distance decimal(4,2) not null,
    source_station_id int not null,
    target_station_id int not null,
    primary key(id)
);
-- 지하철 노선은 양방향이기 때문에 source와 target의 차이는 없다.

create table if not exists LINE
(
    id bigint auto_increment not null,
    name varchar(255) not null unique,
    start_time time not null,
    end_time time not null,
    interval_time int not null,
    extra_fare int,
    primary key(id)
);