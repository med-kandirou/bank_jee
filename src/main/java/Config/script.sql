CREATE TABLE personne (
                          nom varchar(50) not null,
                          prenom varchar(50) not null,
                          dateNaissance date not null,
                          telephone varchar(50) not null,
);

CREATE TABLE client (
                        code varchar(20) primary key,
                        adresse varchar(50) not null
) INHERITS (Personne);


CREATE TABLE employe (
                        matricule varchar(20) primary key ,
                        dateDeRecrutement date not null,
                        adresseEmail varchar(50) not null
) INHERITS (Personne);
