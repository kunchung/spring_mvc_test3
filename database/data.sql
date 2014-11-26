insert into purchase_order (number, create_date) values ('PO1', current_timestamp);
insert into purchase_order_item (purchase_order_id, product_id) values (1, 107);
insert into product (id, number, name) values (101, 'P1', 'Product 1');