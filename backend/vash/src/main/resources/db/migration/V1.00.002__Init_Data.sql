
--table  t_role 
insert into t_role(role) values ('ADMIN');
insert into t_role(role) values ('CLIENT');

-- t_user
insert into t_user(email,first_name,last_name,password,phone_number1,phone_number2,user_name) values ('jocker@gmail.com','jocker','jojo','123456','0000000978','0000000978','jocker');
insert into t_user(email,first_name,last_name,password,phone_number1,phone_number2,user_name) values ('ilias.mabrouk@gmail.com','ilias','mabrouk','123456','0000000178','0000000958','i.mabrouk');
insert into t_user(email,first_name,last_name,password,phone_number1,phone_number2,user_name) values ('abdelaziz.iddouch@gmail.com','jocker','jojo','123456','0230000978','0440000978','a.iddouch');

--user_role
insert into user_role(users_id,roles_id) values(1,2);
insert into user_role(users_id,roles_id) values(2,2);
insert into user_role(users_id,roles_id) values(1,1);
--insert into user_role values(3,1);
-- country

insert into country (name_country) values ('MAROC');
--insert into country (name_country) values ('AUSTRALIE');

--city
insert into city (name_city,url,country_id) values ('CASA-BLANCA','https://www.visitmorocco.com/sites/default/files/styles/thumbnail_destination_background_top5/public/thumbnails/image/la-mosquee-hassan-ii-au-coucher-du-soleil-a-casablanca-maroc.jpg?itok=-kg3FRws',1);
insert into city (name_city,url,country_id) values ('TANGER','https://www.h24info.ma/wp-content/uploads/2019/02/tanger.png',1);
insert into city (name_city,url,country_id) values ('IFRANE','https://lh3.googleusercontent.com/proxy/hu4qwm6_FilY0vm988XwbESlHDnkpRlR_C50i_h0WDQRmB4vX0z3IwYuNOL7akhSK_1hEN74lnjCTDRWbztbIc6cNuC2GtRxLT0Fzw955EZRsjIH6Yob4a_dhtA5YW_OrX58dB4iaK3XfLi-7zOzfQ',1);
insert into city (name_city,url,country_id) values ('EL-JADIDA','https://www.visitmorocco.com/sites/default/files/styles/thumbnail_events_slider/public/thumbnails/image/port-mazagan-eljadida.jpg?itok=z-rl3ips',1);
insert into city (name_city,url,country_id) values ('MARRAKECH','https://static.yabiladi.com/files/articles/90663_b719be9c06a166ad7f16889d5ebc0db220200316172647_thumb_565.jpeg',1);
insert into city (name_city,url,country_id) values ('AGADIR','https://i.le360.ma/fr/sites/default/files/styles/image_la_une_on_home_page/public/assets/images/2020/07/marina-d-agadir.jpg',1);
insert into city (name_city,url,country_id) values ('MEKNES','https://www.h24info.ma/wp-content/uploads/2018/10/28c66fb60b85b28db60dc883a5a4f206-meknes.jpg',1);
insert into city (name_city,url,country_id) values ('IMOUZAR','http://photos.wikimapia.org/p/00/00/67/19/74_big.jpg',1);
insert into city (name_city,url,country_id) values ('DAKHLA','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpAahDXAfhIoN6yzCLfirWtcpgGBTG97Z0Hs7TLC8nRLZsv6jX8u3U207--ZyaqZFf9Ik&usqp=CAU',1);
insert into city (name_city,url,country_id) values ('LAAYOUN','https://i.pinimg.com/originals/34/0d/15/340d15f8cdf7db3cbb976526ed563456.jpg',1);
insert into city (name_city,url,country_id) values ('AZILAL','https://www.infostourismemaroc.com/uploads/images/gallery//5e284c90a9b98_demnate-azilal-ait-attab-ouzoud-infos-tourisme-morocco.jpg',1);
insert into city (name_city,url,country_id) values ('CHEOUEN','https://i.le360.ma/fr/sites/default/files/styles/image_la_une_on_home_page/public/assets/images/2019/03/medina-chaouen.jpg',1);
--insert into city (name_city,url,country_id) values ('sydney',2);
--insert into city (name_city,url,country_id) values ('melboume',2);

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
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('2 facades vue sur la mer',true,3,2,2,500,'60m',true,1,1,4,1);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur la foret',true,5,3,1,1500,'120m',true,2,1,3,2);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur le volcan',true,4,2,1,1000,'90m',true,3,1,1,3);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur une piscine tropicale',true,7,4,3,2000,'700m',true,4,1,2,1);

insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('2 facades vue sur la mer',true,3,2,2,600,'70m',true,1,1,4,3);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur la foret',true,5,3,1,1600,'130m',true,2,1,3,2);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur le volcan',true,4,2,1,1100,'100m',true,3,1,1,1);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur une piscine tropicale',true,7,4,3,2100,'750m',true,4,1,2,1);

insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('2 facades vue sur la mer',true,3,2,2,400,'50m',true,1,2,4,2);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur la foret',true,5,3,1,1400,'110m',true,2,2,3,3);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur le volcan',true,4,2,1,900,'80m',true,3,2,1,1);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur une piscine tropicale',true,7,4,3,2300,'800m',true,4,3,2,2);

insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('2 facades vue sur la mer',true,3,2,2,700,'80m',true,1,3,4,2);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur la foret',true,5,3,1,1700,'140m',true,2,3,3,3);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur le volcan',true,4,2,1,1000,'85m',true,3,3,1,2);
insert into property(description,equiped,number_max_persons,number_room,numberwc,price , surface, visible , address_id , city_id , type_property_id , user_id)
 values ('vue sur une piscine tropicale',true,7,4,3,3000,'1000m',true,4,3,2,3);


-- insert into reservation (date_start,date_end,number_persons,status,property_id,user_id)
-- values('26-04-2021','30-04-2021',3,'pending',1,3);
-- insert into reservation (date_start,date_end,number_persons,status,property_id,user_id)
-- values('16-04-2021','20-04-2021',3,'pending',4,2);
-- insert into reservation (date_start,date_end,number_persons,status,property_id,user_id)
-- values('06-05-2021','10-05-2021',3,'pending',5,2);
-- insert into reservation (date_start,date_end,number_persons,status,property_id,user_id)
-- values('06-04-2021','20-06-2021',3,'pending',7,3);