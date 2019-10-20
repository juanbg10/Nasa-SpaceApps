const express = require('express')
const NodeMssql = require('mssql')
const database = require('/config/db')
const app = express()
require('./routes/routes')(app, {});

const bodyParser = require('body-parser')

// Começar a rota:

const porta = 8800

// Iniciar:
app.listen(porta, =>{
    console.log('No ar na porta '+ porta)
})

app.use(bodyParser.urlencoded({ extended: true }))

