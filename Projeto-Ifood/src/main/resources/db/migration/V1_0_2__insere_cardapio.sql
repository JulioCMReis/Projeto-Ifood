CREATE TABLE IF NOT EXISTS cardapio (
    id serial primary key,
    nome_do_prato varchar not null,
    valor numeric (12,2) not null,
    restaurante_id integer REFERENCES restaurante(id)
);

insert into cardapio(nome_do_prato, valor, restaurante_id)
values
   ('bobo de camarao', 40, 1),
   ('macarrao aglioli', 30, 1),
   ('batata suprema', 20, 2),
   ('ayucas de mandioca', 25, 2),
   ('coxinha de frango', 12, 5);