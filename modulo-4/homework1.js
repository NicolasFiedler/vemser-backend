
de.users.insert([
        {
            "id_user" : 1,
            "name" : "admin",
            "email" : "admin",
            "password" : "$2a$12$8ip8ptNhDTAVqH6ePel51O8no1b2MvQZd5PsB.zZhVBWceT61ghu.",
            "type" : false,
            "document" : "73775006036"
        },
        {
            "id_user" : 2,
            "name" : "Liane",
            "email" : "liane@gmail.com",
            "password" : "$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO",
            "type" : false,
            "document" : "23156682047"
        },
        {
            "id_user" : 3,
            "name" : "Claudia",
            "email" : "claudia@gmail.com",
            "password" : "$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO",
            "type" : false,
            "document" : "22157284001"
        },
        {
            "id_user" : 4,
            "name" : "Rodrigo",
            "email" : "rodrigo@gmail.com",
            "password" : "$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO",
            "type" : true,
            "document" : "82112413000122"
        }
    ]
)

// RESULTADO

{ acknowledged: true,
    insertedIds: 
     { '0': ObjectId("624b542376d8af814eab856b"),
       '1': ObjectId("624b542376d8af814eab856c"),
       '2': ObjectId("624b542376d8af814eab856d"),
       '3': ObjectId("624b542376d8af814eab856e") } }



db.users.find()

{ _id: ObjectId("624b542376d8af814eab856b"),
    id_user: 1,
    name: 'admin',
    email: 'admin',
    password: '$2a$12$8ip8ptNhDTAVqH6ePel51O8no1b2MvQZd5PsB.zZhVBWceT61ghu.',
    type: false,
    document: '73775006036' }
{ _id: ObjectId("624b542376d8af814eab856c"),
    id_user: 2,
    name: 'Liane',
    email: 'liane@gmail.com',
    password: '$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO',
    type: false,
    document: '23156682047' }
{ _id: ObjectId("624b542376d8af814eab856d"),
    id_user: 3,
    name: 'Claudia',
    email: 'claudia@gmail.com',
    password: '$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO',
    type: false,
    document: '22157284001' }
{ _id: ObjectId("624b542376d8af814eab856e"),
    id_user: 4,
    name: 'Rodrigo',
    email: 'rodrigo@gmail.com',
    password: '$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO',
    type: true,
    document: '82112413000122' }


db.users.find().pretty()

{ _id: ObjectId("624b542376d8af814eab856b"),
    id_user: 1,
    name: 'admin',
    email: 'admin',
    password: '$2a$12$8ip8ptNhDTAVqH6ePel51O8no1b2MvQZd5PsB.zZhVBWceT61ghu.',
    type: false,
    document: '73775006036' }
{ _id: ObjectId("624b542376d8af814eab856c"),
    id_user: 2,
    name: 'Liane',
    email: 'liane@gmail.com',
    password: '$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO',
    type: false,
    document: '23156682047' }
{ _id: ObjectId("624b542376d8af814eab856d"),
    id_user: 3,
    name: 'Claudia',
    email: 'claudia@gmail.com',
    password: '$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO',
    type: false,
    document: '22157284001' }
{ _id: ObjectId("624b542376d8af814eab856e"),
    id_user: 4,
    name: 'Rodrigo',
    email: 'rodrigo@gmail.com',
    password: '$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO',
    type: true,
    document: '82112413000122' }



db.users.find({'name': 'admin'})

{ _id: ObjectId("624b542376d8af814eab856b"),
    id_user: 1,
    name: 'admin',
    email: 'admin',
    password: '$2a$12$8ip8ptNhDTAVqH6ePel51O8no1b2MvQZd5PsB.zZhVBWceT61ghu.',
    type: false,
    document: '73775006036' }




    db.users.remove({'name': 'admin'})
    'DeprecationWarning: Collection.remove() is deprecated. Use deleteOne, deleteMany, findOneAndDelete, or bulkWrite.'
    { acknowledged: true, deletedCount: 1 }

    db.users.deleteOne({'name': 'Liane'})
    { acknowledged: true, deletedCount: 1 }


    db.users.find()
    { _id: ObjectId("624b542376d8af814eab856d"),
      id_user: 3,
      name: 'Claudia',
      email: 'claudia@gmail.com',
      password: '$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO',
      type: false,
      document: '22157284001' }
    { _id: ObjectId("624b542376d8af814eab856e"),
      id_user: 4,
      name: 'Rodrigo',
      email: 'rodrigo@gmail.com',
      password: '$2a$12$GL8U7Mzas9wie2jntRuuuOAUTOVTquZFng6AzuhStaWm0hCJ455oO',
      type: true,
      document: '82112413000122' }

    