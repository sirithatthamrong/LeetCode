-- https://leetcode.com/problems/department-top-three-salaries/

WITH RankedSalaries AS (
    SELECT 
        d.name Department,
        e.name Employee,
        e.salary Salary,
        DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) SalaryRank
    FROM Employee e JOIN Department d 
    ON e.departmentId = d.id
)

SELECT Department, Employee, Salary
FROM RankedSalaries
WHERE SalaryRank <= 3;

