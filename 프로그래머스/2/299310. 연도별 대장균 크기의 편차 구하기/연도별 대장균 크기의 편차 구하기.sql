select YEAR(a.DIFFERENTIATION_DATE) as YEAR, ABS(a.SIZE_OF_COLONY - b.size) as YEAR_DEV, a.ID as ID
from ECOLI_DATA a 
left join (select YEAR(a.DIFFERENTIATION_DATE) as year, max(SIZE_OF_COLONY) as size from ECOLI_DATA a group by YEAR(a.DIFFERENTIATION_DATE)) b on YEAR(a.DIFFERENTIATION_DATE) = b.year
order by YEAR asc, YEAR_DEV asc;
