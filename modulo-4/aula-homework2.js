------------
-- Aula 2 --
------------

---- Insert One
db.alunos.insertOne(
{  
  "nome": "Rafael",
  "data_nascimento": new Date (1994,01,27), 
  "idade": 27,
  "curso": {
    "nome": "Ciência da computação"
  },
  "notas": [10.0, 9.0, 7.5],
  "habilidades": [
    {
      "nome": "inglês",
      "nível": "avançado"
    },
    {
      "nome": "jogatina",
      "nível": "intermediário"
    }
  ],
  "status": "A"
})


db.alunos.insertMany([
  { "nome": "Rafael", "data_nascimento": new Date (1994,01,27), "idade": 27, "curso": { "nome": "Ciência da computação" }, "notas": [10.0, 9.0, 7.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "intermediário" } ], "status": "A"},
  { "nome": "Miguel", "data_nascimento": new Date (1993,01,27), "idade": 26, "curso": { "nome": "Artes" }, "notas": [8.0, 9.0, 2.5], "habilidades": [ {  "nome": "inglês",  "nível": "básico" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"},
  { "nome": "Gabriel", "data_nascimento": new Date (1992,01,27), "idade": 25, "curso": { "nome": "Matemática" }, "notas": [8.0, 10.0, 6.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "básico" } ], "status": "I"},
  { "nome": "Ana", "data_nascimento": new Date (1990,01,27), "idade": 23, "curso": { "nome": "Física" }, "notas": [8.0, 9.0, 9.5], "habilidades": [ {  "nome": "inglês",  "nível": "intermediário" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"}
])


---- Find OR / IN
{ <field1>: { <operator1>: <value1> }, ... }
{ status: { $in: [ "A", "D" ] } }

SELECT * FROM alunos WHERE status in ("A", "D")


//RESULTADO $in

db.alunos.find({ status: { $in: [ "A", "D" ] } })

{ _id: ObjectId("624d828adbfc4f03ce613a83"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  curso: { nome: 'Ciência da computação' },
  notas: [ 10, 9, 7.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'intermediário' } ],
  status: 'A' }
{ _id: ObjectId("624d829ddbfc4f03ce613a84"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  curso: { nome: 'Ciência da computação' },
  notas: [ 10, 9, 7.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'intermediário' } ],
  status: 'A' }
{ _id: ObjectId("624d829ddbfc4f03ce613a85"),
  nome: 'Miguel',
  data_nascimento: 1993-02-27T03:00:00.000Z,
  idade: 26,
  curso: { nome: 'Artes' },
  notas: [ 8, 9, 2.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'básico' },
     { nome: 'jogatina', 'nível': 'avançado' } ],
  status: 'A' }
{ _id: ObjectId("624d829ddbfc4f03ce613a87"),
  nome: 'Ana',
  data_nascimento: 1990-02-27T03:00:00.000Z,
  idade: 23,
  curso: { nome: 'Física' },
  notas: [ 8, 9, 9.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'intermediário' },
     { nome: 'jogatina', 'nível': 'avançado' } ],
  status: 'A' }

////////////////////////////////////////////////////////////////////////

//Exemplo de $or

db.alunos.find({
    $or : [
        {"curso.nome" : "Ciência da computação"},
        {"curso.nome" : "Física"},
        {"curso.nome" : "Artes"}
    ],
    "nome" : "Ana"
 })


//RESULTADO $or

db.alunos.find({$or: [{nome: 'Rafael'}, {'curso.nome': 'Ana'}]})

{ _id: ObjectId("624d828adbfc4f03ce613a83"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  curso: { nome: 'Ciência da computação' },
  notas: [ 10, 9, 7.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'intermediário' } ],
  status: 'A' }
{ _id: ObjectId("624d829ddbfc4f03ce613a84"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  curso: { nome: 'Ciência da computação' },
  notas: [ 10, 9, 7.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'intermediário' } ],
  status: 'A' }

////////////////////////////////////////////////////////////////////////




---- Find Expressão
{ nome: /^Ra/ } 

SELECT * FROM alunos WHERE nome LIKE "Ra%")

db.alunos.find({
    "nome": /^Ra/ 
})


//RESULTADO FIND EXPLRESSAO 

db.alunos.find({"nome": /^Ga/})

{ _id: ObjectId("624d829ddbfc4f03ce613a86"),
  nome: 'Gabriel',
  data_nascimento: 1992-02-27T03:00:00.000Z,
  idade: 25,
  curso: { nome: 'Matemática' },
  notas: [ 8, 10, 6.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'básico' } ],
  status: 'I' }

////////////////////////////////////////////////////////////////////////

---- Find Campos aninhados
{"curso.nome" : "Física"}

db.alunos.find({
   "curso.nome" : "Física"
})

db.alunos.find({
   "notas.2" : 9.5
})


---- Update
{
  <update operator>: { <field1>: <value1>, ... },
  <update operator>: { <field2>: <value2>, ... },
  ...
}

db.alunos.updateOne(
   { nome: "Rafael" },
   {
     $set: { "nome": "Rafael", status: "Z" }           
   }
)


//RETORNO UPDATE SEM $set

//antes
{ _id: ObjectId("624d829ddbfc4f03ce613a86"),
  nome: 'Gabriel',
  data_nascimento: 1992-02-27T03:00:00.000Z,
  idade: 25,
  curso: { nome: 'Matemática' },
  notas: [ 8, 10, 6.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'básico' } ],
  status: 'I' }


//update
db.alunos.updateOne(
   { nome: "Gabriel" },
   {
     $set: { "nome": "Marlon" }           
   }
)

//depois
db.alunos.find({'nome': 'Marlon'})
{ _id: ObjectId("624d829ddbfc4f03ce613a86"),
  nome: 'Marlon',
  data_nascimento: 1992-02-27T03:00:00.000Z,
  idade: 25,
  curso: { nome: 'Matemática' },
  notas: [ 8, 10, 6.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'básico' } ],
  status: 'I' }

////////////////////////////////////////////////////////////////////////
