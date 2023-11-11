drop table if exists jogo cascade;

create table jogo (
	id integer not null,
	titulo varchar(255), 
	primary key (id)
);

drop table if exists plataforma cascade;

create table plataforma (
	id integer not null,
	nome varchar(32), 
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


























