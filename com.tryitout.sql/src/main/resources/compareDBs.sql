SELECT
color,
plate_no,
engine_num,
manuf_date,
country
FROM CAR@REMOTE_SCHEMA

MINUS

SELECT
color,
plate_no,
engine_num,
manuf_date,
country
FROM CAR
