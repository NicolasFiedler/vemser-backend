CREATE TABLE VEM_SER.PAIS (
	ID_PAIS NUMBER (38,0) NOT NULL,
	NOME VARCHAR2 (50) NOT NULL,
	
	CONSTRAINT PK_ID_PAIS PRIMARY KEY (ID_PAIS)
);

CREATE TABLE VEM_SER.ESTADO (
	ID_ESTADO NUMBER (38,0) NOT NULL,
	ID_PAIS NUMBER (38,0) NOT NULL,
	NOME VARCHAR2 (50) NOT NULL,
	
	CONSTRAINT PK_ID_ESTADO PRIMARY KEY (ID_ESTADO),
	CONSTRAINT FK_ID_PAIS FOREIGN KEY (ID_PAIS) REFERENCES VEM_SER.PAIS (ID_PAIS)
);

CREATE TABLE VEM_SER.CIDADE (
	ID_CIDADE NUMBER (38,0) NOT NULL,
	ID_ESTADO NUMBER (38,0) NOT NULL,
	NOME VARCHAR2 (50) NOT NULL,
	
	CONSTRAINT PK_ID_CIDADE_ESTADO PRIMARY KEY (ID_CIDADE, ID_ESTADO),
	CONSTRAINT FK_ID_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES VEM_SER.ESTADO (ID_ESTADO)
);

CREATE TABLE VEM_SER.BAIRRO (
	ID_BAIRRO NUMBER (38,0) NOT NULL,
	ID_CIDADE NUMBER (38,0) NOT NULL,
	ID_ESTADO NUMBER (38,0) NOT NULL,
	NOME VARCHAR2 (50) NOT NULL,
	
	CONSTRAINT PK_ID_BAIRRO_CIDADE PRIMARY KEY (ID_BAIRRO, ID_CIDADE),
	CONSTRAINT FK_ID_CIDADE_ESTADO FOREIGN KEY (ID_CIDADE, ID_ESTADO) REFERENCES VEM_SER.CIDADE (ID_CIDADE, ID_ESTADO)
);

CREATE TABLE VEM_SER.ENDERECO (
	ID_ENDERECO NUMBER (38,0) NOT NULL,
	ID_BAIRRO NUMBER (38,0) NOT NULL,
	ID_CIDADE  NUMBER (38,0) NOT NULL,
	LOGRADOURO VARCHAR2 (255) NOT NULL,
	NUMERO NUMBER (38,0) NOT NULL,
	COMPLEMENTO VARCHAR2 (100) NOT NULL,
	CEP VARCHAR2 (9) NOT NULL,
	
	CONSTRAINT PK_ID_ENDERECO PRIMARY KEY (ID_ENDERECO),
	CONSTRAINT FK_ID_BAIRRO_CIDADE FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES VEM_SER.BAIRRO (ID_BAIRRO, ID_CIDADE)
);

--SEQUENCES

CREATE SEQUENCE SEQ_PAIS
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_ESTADO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_CIDADE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

DROP SEQUENCE SEQ_PAIS;
DROP SEQUENCE SEQ_ESTADO;
DROP SEQUENCE SEQ_CIDADE;
DROP SEQUENCE SEQ_BAIRRO;
DROP SEQUENCE SEQ_ENDERECO;

--INSERTS

--PAISES
INSERT INTO PAIS VALUES (VEM_SER.SEQ_PAIS.nextval, 'Brasil');
INSERT INTO PAIS VALUES (VEM_SER.SEQ_PAIS.nextval, 'Mexico');



--ESTADOS
INSERT INTO ESTADO VALUES (VEM_SER.SEQ_ESTADO.nextval, 1, 'Rio Grande do Sul');
INSERT INTO ESTADO VALUES (VEM_SER.SEQ_ESTADO.nextval, 1, 'S�o Paulo');

INSERT INTO ESTADO VALUES (VEM_SER.SEQ_ESTADO.nextval, 2, 'Nueva Leon');
INSERT INTO ESTADO VALUES (VEM_SER.SEQ_ESTADO.nextval, 2, 'Santa F�');



--CIDADES
INSERT INTO CIDADE VALUES (VEM_SER.SEQ_CIDADE.nextval, 1, 'Charqueadas');
INSERT INTO CIDADE VALUES (VEM_SER.SEQ_CIDADE.nextval, 2, 'S�o Paulo');

INSERT INTO CIDADE VALUES (VEM_SER.SEQ_CIDADE.nextval, 3, 'Monterrey');
INSERT INTO CIDADE VALUES (VEM_SER.SEQ_CIDADE.nextval, 4, 'Montemorelos');



--BAIRROS
INSERT INTO BAIRRO VALUES (VEM_SER.SEQ_BAIRRO.nextval, 1, 1, 'Sao Lourenco');
INSERT INTO BAIRRO VALUES (VEM_SER.SEQ_BAIRRO.nextval, 2, 2, 'Embura');

INSERT INTO BAIRRO VALUES (VEM_SER.SEQ_BAIRRO.nextval, 3, 3, 'LOS REYES IZTACALA,');
INSERT INTO BAIRRO VALUES (VEM_SER.SEQ_BAIRRO.nextval, 4, 4, 'ALCE BLANCO');



--ENDERECO 
INSERT INTO ENDERECO VALUES (VEM_SER.SEQ_ENDERECO.nextval, 1, 1, 'agice jose ramos', 355, 'centro', '96745-000');
INSERT INTO ENDERECO VALUES (VEM_SER.SEQ_ENDERECO.nextval, 1, 1, 'rua salvador', 389, 'Cohabe', '96745-000');
INSERT INTO ENDERECO VALUES (VEM_SER.SEQ_ENDERECO.nextval, 2, 2, 'Caminho A', 281, 'Centro', '04893-052');
INSERT INTO ENDERECO VALUES (VEM_SER.SEQ_ENDERECO.nextval, 2, 2, 'Rua Ad�o Guerra', 211, 's/n', '04893-030');

INSERT INTO ENDERECO VALUES (VEM_SER.SEQ_ENDERECO.nextval, 3, 3, 'ALAMO', 963, 'S/N', '54090');
INSERT INTO ENDERECO VALUES (VEM_SER.SEQ_ENDERECO.nextval, 3, 3, '6 DE SEPTIEMBRE', 70, 'ap 49', '53370');
INSERT INTO ENDERECO VALUES (VEM_SER.SEQ_ENDERECO.nextval, 4, 4, 'FRANCISCO M OLAGUIBEL', 88, 'centro', '06800');
INSERT INTO ENDERECO VALUES (VEM_SER.SEQ_ENDERECO.nextval, 4, 4, 'DEL CARMEN', 345, ' ', '22100');



--SELECTS

SELECT * FROM PAIS ORDER BY nome DESC;
SELECT logradouro, cep FROM ENDERECO WHERE UPPER(logradouro) LIKE 'A%';
SELECT * FROM ENDERECO WHERE cep LIKE '%0';
SELECT * FROM ENDERECO WHERE numero BETWEEN 1 AND 100;
SELECT * FROM ENDERECO WHERE UPPER(logradouro) LIKE 'RUA%' ORDER BY cep DESC; 
SELECT COUNT(*) FROM ENDERECO;
SELECT COUNT(*) FROM ENDERECO GROUP BY id_cidade; 









