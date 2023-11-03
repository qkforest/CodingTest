-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF AS F LEFT JOIN ICECREAM_INFO AS I
ON F.FLAVOR = I.FLAVOR
GROUP BY INGREDIENT_TYPE