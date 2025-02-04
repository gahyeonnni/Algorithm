SELECT DATE_FORMAT(o.SALES_DATE, '%Y') AS YEAR, 
       MONTH(o.SALES_DATE) AS MONTH, 
       COUNT(DISTINCT o.user_id) AS PURCHASED_USERS, 
       ROUND(COUNT(DISTINCT o.user_id) / total_users, 1) AS PURCHASED_RATIO
FROM ONLINE_SALE o
JOIN (SELECT DISTINCT user_id 
      FROM USER_INFO 
      WHERE DATE_FORMAT(joined, '%Y') = 2021) b 
    ON b.user_id = o.user_id
CROSS JOIN (SELECT COUNT(user_id) AS total_users 
            FROM USER_INFO 
            WHERE DATE_FORMAT(joined, '%Y') = 2021) total
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH;
