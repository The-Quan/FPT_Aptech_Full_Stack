
--khach hang nao mua san pham gi
select c.first_name,o.order_date,oi.quantity,p.product_name,p.list_price,oi.discount
from sales.customers c
join sales.orders o on C.customer_id = o.customer_id
join sales.order_items oi on o.order_id = oi.order_id
join production.products p on oi.product_id = p.product_id
where c.first_name like 'monica'
order by o.order_date desc