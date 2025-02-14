WITH EMP_GRADES AS (
    SELECT E.EMP_NO, E.EMP_NAME, E.SAL,
           CASE 
               WHEN G.AVG_SCORE >= 96 THEN 'S'
               WHEN G.AVG_SCORE >= 90 THEN 'A'
               WHEN G.AVG_SCORE >= 80 THEN 'B'
               ELSE 'C' 
           END AS GRADE
    FROM HR_EMPLOYEES E
    JOIN (
        SELECT EMP_NO, AVG(SCORE) AS AVG_SCORE 
        FROM HR_GRADE 
        GROUP BY EMP_NO
    ) G ON E.EMP_NO = G.EMP_NO
)

SELECT EMP_NO, EMP_NAME, GRADE,
       CASE
           WHEN GRADE = 'S' THEN SAL * 0.2
           WHEN GRADE = 'A' THEN SAL * 0.15
           WHEN GRADE = 'B' THEN SAL * 0.1
           ELSE 0
       END AS BONUS
FROM EMP_GRADES
ORDER BY EMP_NO;
