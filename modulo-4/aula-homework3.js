---- Insert Many
db.alunos.insertMany([
  { "nome": "Rafael", "data_nascimento": new Date (1994,01,27), "idade": 27, "curso": { "nome": "Ciência da computação" }, "notas": [10.0, 9.0, 7.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "intermediário" } ], "status": "A"},
  { "nome": "Miguel", "data_nascimento": new Date (1993,01,27), "idade": 26, "curso": { "nome": "Artes" }, "notas": [8.0, 9.0, 2.5], "habilidades": [ {  "nome": "inglês",  "nível": "básico" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"},
  { "nome": "Gabriel", "data_nascimento": new Date (1992,01,27), "idade": 25, "curso": { "nome": "Matemática" }, "notas": [8.0, 10.0, 6.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "básico" } ], "status": "I"},
  { "nome": "Ana", "data_nascimento": new Date (1990,01,27), "idade": 23, "curso": { "nome": "Física" }, "notas": [8.0, 9.0, 9.5], "habilidades": [ {  "nome": "inglês",  "nível": "intermediário" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"}
])

//EXEMPLO FIND ORDENADO
db.alunos.find({
    notas: { $gte: 9 }      //filtro notas  $gte == >=  | (gt) == >  | (e) == =
}).sort("nome")             //ordena pelo atributo "nome"

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
{ _id: ObjectId("624dc1f5dbfc4f03ce613a8b"),
  nome: 'Ana',
  data_nascimento: 1990-02-27T03:00:00.000Z,
  idade: 23,
  curso: { nome: 'Física' },
  notas: [ 8, 9, 9.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'intermediário' },
     { nome: 'jogatina', 'nível': 'avançado' } ],
  status: 'A' }
{ _id: ObjectId("624dc1f5dbfc4f03ce613a8a"),
  nome: 'Gabriel',
  data_nascimento: 1992-02-27T03:00:00.000Z,
  idade: 25,
  curso: { nome: 'Matemática' },
  notas: [ 8, 10, 6.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'básico' } ],
  status: 'I' }
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
{ _id: ObjectId("624dc1f5dbfc4f03ce613a89"),
  nome: 'Miguel',
  data_nascimento: 1993-02-27T03:00:00.000Z,
  idade: 26,
  curso: { nome: 'Artes' },
  notas: [ 8, 9, 2.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'básico' },
     { nome: 'jogatina', 'nível': 'avançado' } ],
  status: 'A' }
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
{ _id: ObjectId("624dc1f5dbfc4f03ce613a88"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  curso: { nome: 'Ciência da computação' },
  notas: [ 10, 9, 7.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'intermediário' } ],
  status: 'A' }



db.alunos.find({
    notas: { $lt: 6 }                   //filtro notas  $lt == <
}).sort({ curso : 1, nome: -1 })        //ondena os cursos em ordem alfabetica e os nomes em ordem alfabetica inversa

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
{ _id: ObjectId("624dc1f5dbfc4f03ce613a89"),
  nome: 'Miguel',
  data_nascimento: 1993-02-27T03:00:00.000Z,
  idade: 26,
  curso: { nome: 'Artes' },
  notas: [ 8, 9, 2.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'básico' },
     { nome: 'jogatina', 'nível': 'avançado' } ],
  status: 'A' }



db.alunos.updateOne(
   { _id: ObjectId("624d829ddbfc4f03ce613a85")},
   {
     $set: { "nome": "Jonas"}           
   }
)

  { _id: ObjectId("624dc1f5dbfc4f03ce613a89"),
  nome: 'Miguel',
  data_nascimento: 1993-02-27T03:00:00.000Z,
  idade: 26,
  curso: { nome: 'Artes' },
  notas: [ 8, 9, 2.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'básico' },
     { nome: 'jogatina', 'nível': 'avançado' } ],
  status: 'A' }
{ _id: ObjectId("624d829ddbfc4f03ce613a85"),
  nome: 'Jonas',
  data_nascimento: 1993-02-27T03:00:00.000Z,
  idade: 26,
  curso: { nome: 'Artes' },
  notas: [ 8, 9, 2.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'básico' },
     { nome: 'jogatina', 'nível': 'avançado' } ],
  status: 'A' }

////////////////////////////////////////////////////////////////////////

db.alunos.find({ }).sort( { idade : 1, status: -1 } )


db.alunos.insertMany([
{ "_id" : 1, "nome" : "aaa", "status" : "ID" },
{ "_id" : 2, "nome" : "bbb", "status" : "ID" },
{ "_id" : 3, "nome" : "ccc", "status" : "ID" },
{ "_id" : 5, "nome" : "ddd", "status" : "ID" },
{ "_id" : 4, "nome" : "eee", "status" : "ID" }
])


db.alunos.find({ }).sort( { _id : 1 } )

db.alunos.find({ status: "ID" }).sort( { _id : 1 } )

db.alunos.deleteMany({ _id : { $lte : 5} })

---- Find Limite

db.alunos.find({ status: "ID" }).sort( { _id : -1 } ).limit(3)


//RESULTADO FIND COM LIMITE DE ENTREGRAS

db.alunos.find({
    notas: { $lt: 6 }                   //filtro notas  $lt == <
}).sort({ curso : 1, nome: -1 })        //ondena os cursos em ordem alfabetica e os nomes em ordem alfabetica inversa
.limit(1)                               //limite de resultados encontrados

{ _id: ObjectId("624dc1f5dbfc4f03ce613a89"),
  nome: 'Miguel',
  data_nascimento: 1993-02-27T03:00:00.000Z,
  idade: 26,
  curso: { nome: 'Artes' },
  notas: [ 8, 9, 2.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'básico' },
     { nome: 'jogatina', 'nível': 'avançado' } ],
  status: 'A' }


////////////////////////////////////////////////////////////////////////

---- Find Array

// Busca nos elementos do array
db.alunos.find({
    notas: { $lt: 4 } 
})


-- produtos

db.inventory.insertMany([
   { item: "journal", qty: 25, tags: ["blank", "red"], dim_cm: [ 14, 21 ] },
   { item: "notebook", qty: 50, tags: ["red", "blank"], dim_cm: [ 14, 21 ] },
   { item: "paper", qty: 100, tags: ["red", "blank", "plain"], dim_cm: [ 14, 21 ] },
   { item: "planner", qty: 75, tags: ["blank", "red"], dim_cm: [ 22.85, 30 ] },
   { item: "postcard", qty: 45, tags: ["blue"], dim_cm: [ 10, 15.25 ] }
]);


// Na ordem exata
db.inventory.find( { tags: ["red", "blank"] } )
//RESULTADO

{ _id: ObjectId("624dc66adbfc4f03ce613a8d"),
  item: 'notebook',
  qty: 50,
  tags: [ 'red', 'blank' ],
  dim_cm: [ 14, 21 ] }

////////////////////////////////////////////////////////////////////////


// Contém
db.inventory.find( { tags: { $all: ["red", "blank"] } } )
//RESULTADO

{ _id: ObjectId("624dc66adbfc4f03ce613a8c"),
  item: 'journal',
  qty: 25,
  tags: [ 'blank', 'red' ],
  dim_cm: [ 14, 21 ] }
{ _id: ObjectId("624dc66adbfc4f03ce613a8d"),
  item: 'notebook',
  qty: 50,
  tags: [ 'red', 'blank' ],
  dim_cm: [ 14, 21 ] }
{ _id: ObjectId("624dc66adbfc4f03ce613a8e"),
  item: 'paper',
  qty: 100,
  tags: [ 'red', 'blank', 'plain' ],
  dim_cm: [ 14, 21 ] }
{ _id: ObjectId("624dc66adbfc4f03ce613a8f"),
  item: 'planner',
  qty: 75,
  tags: [ 'blank', 'red' ],
  dim_cm: [ 22.85, 30 ] }

////////////////////////////////////////////////////////////////////////

// Condição múltipla, no array todo
db.inventory.find( { dim_cm: { $gt: 15, $lt: 20 } } )           //Vem tudo pq uma das condicoes sera valida
//RESULTADO

{ _id: ObjectId("624dc66adbfc4f03ce613a8c"),
  item: 'journal',
  qty: 25,
  tags: [ 'blank', 'red' ],
  dim_cm: [ 14, 21 ] }
{ _id: ObjectId("624dc66adbfc4f03ce613a8d"),
  item: 'notebook',
  qty: 50,
  tags: [ 'red', 'blank' ],
  dim_cm: [ 14, 21 ] }
{ _id: ObjectId("624dc66adbfc4f03ce613a8e"),
  item: 'paper',
  qty: 100,
  tags: [ 'red', 'blank', 'plain' ],
  dim_cm: [ 14, 21 ] }
{ _id: ObjectId("624dc66adbfc4f03ce613a90"),
  item: 'postcard',
  qty: 45,
  tags: [ 'blue' ],
  dim_cm: [ 10, 15.25 ] }

////////////////////////////////////////////////////////////////////////

// Condição múltipla, no mesmo elemento do array 
db.inventory.find( { dim_cm: { $elemMatch: { $gt: 22, $lt: 30 } } } )           //ambos os fatores devem ser verdadeiros
//RESULTADO

{ _id: ObjectId("624dc66adbfc4f03ce613a8f"),
  item: 'planner',
  qty: 75,
  tags: [ 'blank', 'red' ],
  dim_cm: [ 22.85, 30 ] }

////////////////////////////////////////////////////////////////////////

// Usando índice do array, segundo elem > 25
db.inventory.find( { "dim_cm.1": { $gt: 25 } } )
//RESULTADO



////////////////////////////////////////////////////////////////////////

// Tamanho
db.inventory.find( { "tags": { $size: 3 } } )
//RESULTADO



////////////////////////////////////////////////////////////////////////



---- Projections

// Limpar a collection
db.inventory.deleteMany({ })

// Popular a collection
db.inventory.insertMany( [
  { item: "journal", status: "A", size: { h: 14, w: 21, uom: "cm" }, instock: [ { warehouse: "A", qty: 5 } ] },
  { item: "notebook", status: "A",  size: { h: 8.5, w: 11, uom: "in" }, instock: [ { warehouse: "C", qty: 5 } ] },
  { item: "paper", status: "D", size: { h: 8.5, w: 11, uom: "in" }, instock: [ { warehouse: "A", qty: 60 } ] },
  { item: "planner", status: "D", size: { h: 22.85, w: 30, uom: "cm" }, instock: [ { warehouse: "A", qty: 40 } ] },
  { item: "postcard", status: "A", size: { h: 10, w: 15.25, uom: "cm" }, instock: [ { warehouse: "B", qty: 15 }, { warehouse: "C", qty: 35 } ] }
]);


//projection

db.inventory.find( {
    //filtro
}, 
{
     _id: 0, item: 1     //projection
} )


---- Aggregate

db.orders.insertMany( [
   { _id: 0, productName: "Steel beam", status: "new", quantity: 10 },
   { _id: 1, productName: "Steel beam", status: "urgent", quantity: 20 },
   { _id: 2, productName: "Steel beam", status: "urgent", quantity: 30 },
   { _id: 3, productName: "Iron rod", status: "new", quantity: 15 },
   { _id: 4, productName: "Iron rod", status: "urgent", quantity: 50 },
   { _id: 5, productName: "Iron rod", status: "urgent", quantity: 10 }
] )

// urgentes
db.orders.aggregate( [
   { $match: { status: "urgent" } },
   { $group: { _id: "$productName", qtd: { $sum: "$quantity" } } }
] )

{ _id: 'Iron rod', qtd: 60 }
{ _id: 'Steel beam', qtd: 50 }
