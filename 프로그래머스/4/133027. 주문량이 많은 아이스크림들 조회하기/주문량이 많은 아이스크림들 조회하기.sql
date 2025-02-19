-- 코드를 입력하세요
SELECT J.FLAVOR
FROM JULY J
JOIN FIRST_HALF F ON F.FLAVOR = J.FLAVOR
GROUP BY J.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER + J.TOTAL_ORDER) DESC
LIMIT 3;