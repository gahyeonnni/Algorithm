-- 코드를 작성해주세요
select i.id, n.fish_name, i.length
from FISH_INFO i
join FISH_NAME_INFO n on i.fish_type = n.fish_type
where i.fish_type in (select fish_type from fish_info group by fish_type having length = max(length))
order by id asc;