CREATE TABLE terrain(id text primary key, 
		     type text);

CREATE TABLE creneau(dates date,
		     heure int,
		     primary key(dates,heure));

CREATE TABLE abonne(ano int primary key,
		    nom text,
		    dateFinAbonnement date,
		    dateNaissance date,
		    tel text,
		    parrain int,
		    foreign key(parrain) references abonne(ano) on DELETE restrict on UPDATE cascade);

CREATE TABLE reservation(ano1 int,
			 ano2 int,
			 date1 date,
			 horaire int,
			 id1 text,
			 validite boolean,
			 primary key(ano1,ano2,date1,horaire,id1),
			 foreign key(ano1) references abonne(ano) on DELETE restrict on UPDATE cascade,
			 foreign key(ano2) references abonne(ano) on DELETE restrict on UPDATE cascade,
			 foreign key(date1,horaire) references creneau(dates,heure) on DELETE restrict on UPDATE cascade,
			 foreign key(id1) references terrain(id) on DELETE restrict on UPDATE cascade);