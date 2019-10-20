const NodeMssql = require('mssql')
const connstring = 'Server:localhost; database=nasarenos; user id= 1; password= adm'

NodeMssql.Connect(connstring)
    .then(conn => console.log('conexão realizada com sucesso.'))
    .catch(err => console.log("Erro: "+ err))
