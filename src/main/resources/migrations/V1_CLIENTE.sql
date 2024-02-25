CREATE TABLE IF NOT EXISTS CLIENTE (
    id bigserial not null,
    limite bigint not null,
    saldo bigint  not null,
    constraint pk_cliente PRIMARY KEY(id)
)

CREATE TABLE IF NOT EXISTS TRANSACAO (
    id bigserial not null,
    cliente_id bigint,
    tipo char  ,
    descricao text,
    realizado_em timestamp,
    constraint pk_transacao PRIMARY KEY (id),
    constraint fk_cliente FOREIGN KEY (cliente_id) REFERENCES public.cliente(id)
)

insert into cliente values (1, 100000, 0);

insert into cliente values (2, 80000, 0);

insert into cliente values (3, 1000000, 0);

insert into cliente values (4, 10000000, 0);

insert into cliente values (5, 500000, 0);
