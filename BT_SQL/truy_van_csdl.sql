select * from sales.customers c

join sales.orders o on c.customer_id = o.customer_id
join sales.order_items oi on o.order_id = oi.order_id 

--where c.first_name like '%oh%'

join production.products p on oi.product_id = p.product_id 
where p.list_price > 2000 AND oi.discount >=0.2