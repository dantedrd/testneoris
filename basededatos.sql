CREATE DATABASE testneoris WITH OWNER myusername;


CREATE TABLE public.client (
	identification int8 NOT NULL,
	address varchar(255) NULL,
	age varchar(255) NULL,
	genre varchar(255) NULL,
	"name" varchar(255) NULL,
	phone varchar(255) NULL,
	clientid varchar(255) NULL,
	estado bool NULL,
	"password" varchar(255) NULL,
	CONSTRAINT client_pkey PRIMARY KEY (identification)
);

CREATE TABLE public.account (
	account_number bigserial NOT NULL,
	amount int8 NOT NULL,
	initial_amount int8 NOT NULL,
	state bool NULL,
	type_account varchar(255) NULL,
	client_id int8 NULL,
	CONSTRAINT account_pkey PRIMARY KEY (account_number)
);


-- public.account foreign keys

ALTER TABLE public.account ADD CONSTRAINT fkkm8yb63h4ownvnlrbwnadntyn FOREIGN KEY (client_id) REFERENCES public.client(identification);



CREATE TABLE public.movement (
	id bigserial NOT NULL,
	"date" timestamp NULL,
	movement int8 NOT NULL,
	type_movement varchar(255) NULL,
	account_account_number int8 NOT NULL,
	CONSTRAINT movement_pkey PRIMARY KEY (id)
);



-- public.movement foreign keys

ALTER TABLE public.movement ADD CONSTRAINT fkb8lu2jks0odn0ts1wge4q36oo FOREIGN KEY (account_account_number) REFERENCES public.account(account_number);