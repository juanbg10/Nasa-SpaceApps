// routes.js - módulo de rotas do projeto.

module.exports = function(app, db) {  
    app.get('/download', (req, res) => {    
        // GET Download dos dados 
        res.send('Download de dados')}
    
    app.post('/graficos', (req, res) => {    
        // post Gráficos
        res.send('Rota dos gráficos')}
    
    app.post('/data', (req, res) => {    
        // Data
        res.send('Visualização dos dados')}
    }

