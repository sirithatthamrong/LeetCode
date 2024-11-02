-- https://leetcode.com/problems/employees-earning-more-than-their-managers/

SELECT e1.name "Employee" 
FROM Employee e1
WHERE e1.salary > (
    SELECT e2.salary
    FROM Employee e2
    WHERE e1.managerID = e2.id
);