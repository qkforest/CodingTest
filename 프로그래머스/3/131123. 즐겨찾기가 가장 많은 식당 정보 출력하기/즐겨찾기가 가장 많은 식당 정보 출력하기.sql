-- 코드를 입력하세요
SELECT M.FOOD_TYPE, REST_ID, REST_NAME, M.FAVORITES
FROM (SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
FROM REST_INFO
GROUP BY FOOD_TYPE) M LEFT JOIN REST_INFO
ON M.FOOD_TYPE = REST_INFO.FOOD_TYPE AND M.FAVORITES = REST_INFO.FAVORITES
ORDER BY FOOD_TYPE DESC