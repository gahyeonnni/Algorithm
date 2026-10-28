-- 코드를 입력하세요 
SELECT p.PRODUCT_CODE, sum(o.SALES_AMOUNT * p.price) as sales
from product p
join OFFLINE_SALE o on p.PRODUCT_ID = o.PRODUCT_ID 
group by PRODUCT_CODE
order by sales desc, p.PRODUCT_CODE asc;