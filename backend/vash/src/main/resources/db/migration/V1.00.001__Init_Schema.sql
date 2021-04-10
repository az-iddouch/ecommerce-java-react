 
  -- drop fk
/* alter table city drop constraint fk_city_country;
 alter table property drop constraint fk_property_address;
 alter table property drop constraint fk_property_city;
 alter table property drop constraint fk_property_typeProperty;
 alter table property drop constraint fk_user_id;
 alter table property_image drop constraint FK8myddv2ina4svuo189ju03v9o;
 alter table property_image drop constraint FKnj7tsvxc0y8fsq3cvl0b4ktkc;
 alter table reservation drop constraint fk_reservation_property;
 alter table reservation drop constraint fk_reservation_user;
 alter table review drop constraint fk_review_property;
 alter table review drop constraint fk_review_user;
 alter table t_user drop constraint fk_user_image;
 alter table tags drop constraint fk_tags_image;
 alter table tags_property drop constraint fk_property_tags;
 alter table tags_property drop constraint fk_tags_property;
 alter table user_role drop constraint fk_user_role_role_id;
 alter table user_role drop constraint fk_user_role_user_id;
 */
  -- drop table
 drop table if exists address cascade;
 drop table if exists city cascade;
 drop table if exists country cascade;
 drop table if exists image cascade;
 drop table if exists property cascade;
 drop table if exists property_image cascade;
 drop table if exists reservation cascade;
 drop table if exists review cascade;
 drop table if exists t_role cascade;
 drop table if exists t_user cascade;
 drop table if exists tags cascade;
 drop table if exists tags_property cascade;
 drop table if exists type_property cascade;
 drop table if exists user_role cascade;
 drop table if exists vtopeightville cascade;

 -- create table
 create table address (id  bigserial not null, address varchar(255), primary key (id));
 create table city (id  bigserial not null, name_city varchar(255), country_id int8,url varchar(255), primary key (id));
 create table country (id  bigserial not null, name_country varchar(255), primary key (id));
 create table image (id  bigserial not null, url varchar(255), primary key (id));
 create table property (id  bigserial not null, description varchar(255), equiped boolean, number_max_persons int4, number_room int4, numberwc int4, price float8, surface varchar(255), visible boolean, address_id int8, city_id int8, type_property_id int8, user_id int8, primary key (id));
 create table property_image (property_id int8, id int8 not null, primary key (id));
 create table reservation (id  bigserial not null, date_end timestamp, date_start timestamp, number_persons int4, status varchar(255), property_id int8, user_id int8, primary key (id));
 create table review (id  bigserial not null, comment varchar(255), note float8, property_id int8, user_id int8, primary key (id));
 create table t_role (id  bigserial not null, role varchar(255), primary key (id));
 create table t_user (id  bigserial not null, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), phone_number1 varchar(255), phone_number2 varchar(255), user_name varchar(255), image_id int8, primary key (id));
 create table tags (id  bigserial not null, name_tag varchar(255), image_id int8, primary key (id));
 create table tags_property (tags_id int8 not null, propertys_id int8 not null);
 create table type_property (id  bigserial not null, type varchar(255), primary key (id));
 create table user_role (users_id int8 not null, roles_id int8 not null);
 
 -- add fk
 alter table city add constraint fk_city_country foreign key (country_id) references country;
 alter table property add constraint fk_property_address foreign key (address_id) references address;
 alter table property add constraint fk_property_city foreign key (city_id) references city;
 alter table property add constraint fk_property_typeProperty foreign key (type_property_id) references type_property;
 alter table property add constraint fk_user_id foreign key (user_id) references t_user;
 alter table property_image add constraint FK8myddv2ina4svuo189ju03v9o foreign key (property_id) references property;
 alter table property_image add constraint FKnj7tsvxc0y8fsq3cvl0b4ktkc foreign key (id) references image;
 alter table reservation add constraint fk_reservation_property foreign key (property_id) references property;
 alter table reservation add constraint fk_reservation_user foreign key (user_id) references t_user;
 alter table review add constraint fk_review_property foreign key (property_id) references property;
 alter table review add constraint fk_review_user foreign key (user_id) references t_user;
 alter table t_user add constraint fk_user_image foreign key (image_id) references image;
 alter table tags add constraint fk_tags_image foreign key (image_id) references image;
 alter table tags_property add constraint fk_property_tags foreign key (propertys_id) references property;
 alter table tags_property add constraint fk_tags_property foreign key (tags_id) references tags;
 alter table user_role add constraint fk_user_role_role_id foreign key (roles_id) references t_role;
 alter table user_role add constraint fk_user_role_user_id foreign key (users_id) references t_user;
 
 -- create view 
 create or replace  view vtopeightville as select p.city_id,c.name_City,c.country_id, count(r.id) as counter from reservation r left join property
 p on p.id=r.property_id  left join city c on c.id=p.city_id group by p.city_id,c.name_City,c.country_id  order by counter desc limit 8