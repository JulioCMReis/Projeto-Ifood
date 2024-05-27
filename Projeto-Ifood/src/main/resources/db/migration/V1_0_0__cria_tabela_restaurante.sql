CREATE TABLE IF NOT EXISTS restaurante (
    id serial PRIMARY KEY,
    nome varchar not null,
    endereco varchar not null,
    preco_medio integer not null,
    avaliacao numeric (1,1),
    tem_entregador boolean not null
);
