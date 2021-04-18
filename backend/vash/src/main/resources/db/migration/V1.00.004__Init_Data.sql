
-- update vtopeightville
create or replace  view vtopeightville as select p.city_id,c.name_City,c.country_id, count(r.id) as counter,c.url from reservation r left join property
 p on p.id=r.property_id  left join city c on c.id=p.city_id group by p.city_id,c.name_City,c.url,c.country_id  order by counter desc limit 8