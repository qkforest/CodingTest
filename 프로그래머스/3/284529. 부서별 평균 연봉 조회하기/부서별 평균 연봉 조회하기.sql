SELECT HR_DEPARTMENT.DEPT_ID AS DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL), 0) AS AVG_SAL
FROM HR_EMPLOYEES
LEFT JOIN HR_DEPARTMENT ON HR_DEPARTMENT.DEPT_ID = HR_EMPLOYEES.DEPT_ID
GROUP BY DEPT_ID
ORDER BY AVG_SAL DESC