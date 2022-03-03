CREATE TABLE VEM_SER.ESTUDANTE (
	id_estudante NUMBER NOT NULL,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) NOT NULL,
	ativo CHAR(1),
	PRIMARY KEY(id_estudante)
);

CREATE SEQUENCE seq_estudante
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE seq_matricula_estudante
START WITH 100
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Nicolas', TO_DATE('19-06-2002', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'S');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Ana Vitória', TO_DATE('11-11-2002', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'S');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Ciro', TO_DATE('01-02-2002', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'N');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Lucas', TO_DATE('02-02-2003', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'S');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Nicole', TO_DATE('21-09-2002', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'S');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Jorge', TO_DATE('01-01-2001', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'S');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Cadu', TO_DATE('16-06-2002', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'N');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Enzo', TO_DATE('20-09-2002', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'S');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Ari', TO_DATE('06-06-2002', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'S');
INSERT INTO VEM_SER.ESTUDANTE VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Cleo', TO_DATE('10-04-2002', 'dd-mm-yyyy'), VEM_SER.seq_matricula_estudante.nextval, 'N');

SELECT * FROM VEM_SER.ESTUDANTE;