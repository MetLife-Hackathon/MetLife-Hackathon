alter table consulting alter column summary type VARCHAR(16000);

insert into customer (id, birth_date, email, insurances, name, password) values (1, '2000-09-21', 'a@gamil.com', '보험1', 'metlife', '1234');
insert into consultant (id, name) values (1, '보험설계사');
