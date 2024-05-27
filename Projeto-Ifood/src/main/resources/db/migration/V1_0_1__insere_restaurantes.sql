ALTER TABLE restaurante ALTER COLUMN avaliacao TYPE numeric (2,1);

insert into restaurante(nome, endereco, preco_medio, avaliacao, tem_entregador)
values
    ('Restaurante X', 'Rua João Pablo', 40, null, true),
    ('Restaurante Y', 'Rua Félix', 1000, 4.9, true),
    ('Restaurante Z', 'Rua Carlos', 10, null, false);