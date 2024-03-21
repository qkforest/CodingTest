SELECT (CASE 
            WHEN SKILL_CODE & (SELECT CODE
                               FROM SKILLCODES
                               WHERE NAME LIKE "Python")
             AND SKILL_CODE & (SELECT SUM(CODE)
                               FROM SKILLCODES
                               WHERE CATEGORY LIKE "Front End") THEN "A"
            WHEN SKILL_CODE & (SELECT CODE
                                FROM SKILLCODES
                                WHERE NAME LIKE "C#") THEN "B"
            WHEN SKILL_CODE & (SELECT SUM(CODE)
                               FROM SKILLCODES
                               WHERE CATEGORY LIKE "Front End") THEN "C"
        END) AS GRADE,
ID, EMAIL
FROM DEVELOPERS
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID
