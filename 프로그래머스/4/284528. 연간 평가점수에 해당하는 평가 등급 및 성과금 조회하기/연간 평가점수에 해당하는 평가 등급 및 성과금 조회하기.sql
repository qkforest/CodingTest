SELECT HR_EMPLOYEES.EMP_NO, EMP_NAME, GRADE, CASE 
                                                    WHEN GRADE LIKE 'S' THEN SAL * 0.2
                                                    WHEN GRADE LIKE 'A' THEN SAL * 0.15
                                                    WHEN GRADE LIKE 'B' THEN SAL * 0.1
                                                    ELSE 0
                                            END AS BONUS
FROM HR_EMPLOYEES
RIGHT JOIN (SELECT EMP_NO, CASE 
                                WHEN AVG(SCORE) >= 96 THEN 'S'
                                WHEN AVG(SCORE) >= 90 THEN 'A'
                                WHEN AVG(SCORE) >= 80 THEN 'B'
                                ELSE 'C'
                            END AS GRADE
            FROM HR_GRADE
            GROUP BY EMP_NO) GRADE
ON HR_EMPLOYEES.EMP_NO = GRADE.EMP_NO
ORDER BY HR_EMPLOYEES.EMP_NO