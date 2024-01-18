use FptAptechBikeStore
select * from sales.customers

select customer_id , email from sales.customers
where customer_id in('4' ,'8','2')

select * from sales.customers
--order by customer_id desc --=> giam dan
order by customer_id asc --=> tang dan

-- inner join -> them du lieu thong qua 1 gia tri giong nhau
 select khachhang.order_id, hang.shipped_date from sales.order_items as khachhang
 inner join sales.orders hang 
 on khachhang.order_id = hang.order_id

 --group by -> nhom cac du lieu giong nhau
 select khachhang.order_id, hang.shipped_date from sales.order_items as khachhang
 inner join sales.orders hang 
 on khachhang.order_id = hang.order_id 
 group by khachhang.order_id, hang.shipped_date

 --Left join -> lay du lieu theo bang ben trai
  select khachhang.order_id, hang.shipped_date from sales.order_items as khachhang
 left join sales.orders hang 
 on khachhang.order_id = hang.order_id

 -- right join -> lay du lieu theo bang ben phai
 select khachhang.order_id, hang.shipped_date from sales.order_items as khachhang
 right join sales.orders hang 
 on khachhang.order_id = hang.order_id

 --full outer join lay tat ca du lieu lien ket voi nhau
  select * from sales.order_items as khachhang
 full outer join sales.orders as hang 
 on khachhang.order_id = hang.order_id

 --union 
 select order_id from sales.orders
 where order_id in('2','4','6')
 union 
 select order_id from sales.order_items
 where order_id in('2','8')
 --union all
 select order_id from sales.orders
 where order_id in('2','4','6')
 union all
 select order_id from sales.order_items
 where order_id in('2','8')