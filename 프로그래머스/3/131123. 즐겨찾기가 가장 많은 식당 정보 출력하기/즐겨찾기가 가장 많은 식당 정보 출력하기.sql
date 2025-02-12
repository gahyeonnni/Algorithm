-- 코드를 입력하세요
SELECT food_type, rest_id, rest_name, FAVORITES	
from REST_INFO
where (food_type, favorites) in (select food_type, max(favorites) from rest_info group by food_Type)
order by food_Type desc;