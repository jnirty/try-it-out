 -- select only cars with latest manufactured date if multiple cars exist
 -- with same: country, color, engine_num but different manuf_date
 select * from 
 (select 
    row_number() over (partition by 
    c.country,
    c.color,
    c.engine_num
    order by c.manuf_date desc nulls last
    ) as n,
    c.country,
    c.manuf_date,
    c.plate_no,
    c.pk_car_id
   
  FROM car c
 ) where n=1