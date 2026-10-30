-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES 
from REST_INFO 
where (food_type, FAVORITES) in (
    select food_type, MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
Order by FOOD_TYPE DESC;