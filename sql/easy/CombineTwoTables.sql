-- https://leetcode.com/problems/combine-two-tables/

select P.firstName, P.lastName, A.city, A.state
from Person P
left join Address A on P.personID = A.personID;