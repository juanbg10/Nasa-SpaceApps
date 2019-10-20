import React from 'react';
import logo from './nasarenos.png';
import './App.css';
import { Navbar, NavItem, Row} from 'react-materialize';

function App() {
  return (
    <div className="App">
      <header className="App-header row">
       <div class="row container">
         <img src={logo} alt="Logo" className="col s12 m9 l6"></img></div>
       <div className="row">
         <form className="col s12 ">
         <div className="row container ">
           <label  className="input-field col s12 m9 l6">
           <h5>E-mail:</h5>
           <input placeholder="Exemplo: nome@email.com" type="email" name="email" id="email"></input>
          </label></div>
         <div className="row container"><label  class="input-field col s6">
            <h5>Senha:</h5>
           <input placeholder="Digite sua senha..." type="password" name="password" id="password"></input>
         </label></div>
        <div class="align-center"><input type="submit" name="entrar" value="Entrar" id="entrar" class="btn btn-large waves-effect waves-light red align-center" /></div>
       </form>
       </div>
      </header>
    </div>
  );
}


export default App;

