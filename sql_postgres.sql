drop table if exists jogo cascade;

create table jogo (
	id serial not null,
	titulo varchar(255), 
	primary key (id)
);

drop table if exists plataforma cascade;

create table plataforma (
	id serial not null,
	nome varchar(32) unique not null, 
	primary key (id)
);

drop table if exists jogo_plataforma cascade;

create table jogo_plataforma (
	jogo_id integer not null,
	plataforma_id integer not null,
	preco_diario decimal(2,10),
	primary key (jogo_id, plataforma_id),
	constraint fk_jogo_platarforma_1 foreign key (jogo_id) references jogo(id),
	constraint fk_jogo_platarforma_2 foreign key (plataforma_id) references plataforma(id)
);

drop table if exists cliente cascade;

create table cliente (
	id serial not null,
	nome varchar(255),
	email varchar(255),
	telefone varchar(255),
	senha varchar(255),
	primary key (id)
);

drop table if exists locacao cascade;

create table locacao (
	id serial not null,
	data timestamp not null default now(),
	cliente_id integer not null,
	primary key (id),
	constraint fk_locacao_1 foreign key (cliente_id) 
	references cliente(id)
);

drop table if exists item_locacao cascade;

create table item_locacao (
	jogo_id integer not null,
	plataforma_id integer not null,
	locacao_id integer not null,
	dias integer,
	quantidade integer,
	primary key (jogo_id, plataforma_id, locacao_id),
	constraint fk_item_locacao_1 foreign key (jogo_id, plataforma_id) references jogo_plataforma(jogo_id, plataforma_id),
	constraint fk_item_locacao_2 foreign key (locacao_id) references locacao(id)
);

drop table if exists console cascade;

create table console (
	id serial not null,
	nome varchar(255) unique not null,
	preco_por_hora decimal(9,2) not null,
	primary key (id)
);

drop table if exists utilizacao_do_console_pelo_cliente cascade;

create table utilizacao_do_console_pelo_cliente(
	id serial not null,
	inicio timestamp not null,
	fim timestamp not null,
	cliente_id int not null,
	console_id int not null,
	primary key (id),
	constraint fk_utilizacao_do_console_pelo_cliente_1 
	foreign key (cliente_id) references cliente(id),
	constraint fk_utilizacao_do_console_pelo_cliente_2 
	foreign key (console_id) references console(id)
);

drop table if exists acessorio cascade;

create table acessorio(
	id serial not null,
	nome varchar(255) unique not null,
	primary key (id)
);

drop table if exists acessorio_console cascade;

create table acessorio_console(
	console_id integer not null,
	acessorio_id integer not null,
	constraint fk_acessorio_console_1 foreign key (acessorio_id) references acessorio(id) on delete cascade,
	constraint fk_acessorio_console_2 foreign key (console_id) references console(id)
);











