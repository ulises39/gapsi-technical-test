SELECT 'CREATE DATABASE gapsi_db'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'gapsi_db')\gexec

CREATE TABLE public.products (
	id uuid NOT NULL,
	description varchar(200) NOT NULL,
	model varchar(10) NOT NULL,
	"name" varchar(20) NOT NULL,
	price numeric(10, 2) NOT NULL,
	CONSTRAINT products_pkey PRIMARY KEY (id)
);