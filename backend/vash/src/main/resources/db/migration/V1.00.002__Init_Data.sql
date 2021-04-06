
--table  t_role 
insert into t_role(role) values ('admin');
insert into t_role(role) values ('client');

-- t_user
insert into t_user(email,first_name,last_name,password,phone_number1,phone_number2,user_name) values ('jocker@gmail.com','jocker','jojo','123456','0000000','00000','jocker');
insert into t_user(email,first_name,last_name,password,phone_number1,phone_number2,user_name) values ('ilias.mabrouk@gmail.com','ilias','mabrouk','123456','0000000','00000','i.mabrouk');
insert into t_user(email,first_name,last_name,password,phone_number1,phone_number2,user_name) values ('abdelaziz.iddouch@gmail.com','jocker','jojo','123456','0000000','00000','a.iddouch');

--user_role
insert into user_role values(1,2);
insert into user_role values(2,2);
insert into user_role values(1,1);
insert into user_role values(3,1);
-- country

insert into country (name_country) values ('JAPAN');
insert into country (name_country) values ('AUSTRALIE');

--city
insert into city (name_city,country_id) values ('tokyo',1);
insert into city (name_city,country_id) values ('kyoto',1);
insert into city (name_city,country_id) values ('osaka',1);
insert into city (name_city,country_id) values ('nagasaki',1);
insert into city (name_city,country_id) values ('sapporo',1);
insert into city (name_city,country_id) values ('hiroshima',1);
insert into city (name_city,country_id) values ('nagoya',1);
insert into city (name_city,country_id) values ('fukuoka',1);
insert into city (name_city,country_id) values ('kanazawa',1);
insert into city (name_city,country_id) values ('kamakura',1);
insert into city (name_city,country_id) values ('nikko',1);
insert into city (name_city,country_id) values ('shinjuku',1);
insert into city (name_city,country_id) values ('sydney',2);
insert into city (name_city,country_id) values ('melboume',2);

-- address 
insert into address (address) values ('38-205, Jonan Tera-machi 5-chome, Tennoji-ku, Osaka, Osaka');
insert into address (address) values ('50-605, Sakura Tera-machi 15-chome, Sakura-ku, tokyo, tokyo');
insert into address (address) values ('92-105, Jonan Tera-machi 45-chome, Jonan-ku, kyoto, kyoto');
insert into address (address) values ('920-105, yubai machi 450-chome, Jonan-ku, kyoto, kyoto');

-- type_property 

insert into type_property(type) values('Appartment');
insert into type_property(type) values('Villa');
insert into type_property(type) values('House');
insert into type_property(type) values('Studio');

-- property 
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id) values ('2 facades vue sur la mer',true,3,2,2,500,'60m',true,1,1,4,1);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id) values ('vue sur la foret',true,5,3,1,1500,'120m',true,2,1,3,2);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id) values ('vue sur le volcan',true,4,2,1,1000,'90m',true,3,1,1,3);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id) values ('vue sur une piscine tropicale',true,7,4,3,2000,'700m',true,4,1,2,1);
