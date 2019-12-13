create table veicoli(
	id int not null auto_increment,
	tipo char(1) not null,
	targa varchar(10),
	produttore varchar(20) not null,
	prezzo decimal(9,2) not null,
	modello varchar(100) not null,
	alimentazione varchar(20) not null,
	colore varchar(20) not null,
	altezzasedile int,
	numeroporte int,
	primary key(id)
);

create table dipendenti(
	id int not null auto_increment,
	nome varchar(30) not null,
	cognome varchar(30) not null,
	matricola char(5) not null,
	ruolo char(1) not null,
	primary key(id)
);