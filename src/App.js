import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Nav } from 'react-bootstrap';
import { Form } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import { FormControl } from 'react-bootstrap';
import { NavDropdown } from 'react-bootstrap';
import { Navbar } from 'react-bootstrap';
import { Image } from 'react-bootstrap';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
import logo from './nasarenos.png';
import './App.css';
import Container from 'react-materialize/lib/Container';


function App() {
  return (
    <Container>   
     <div className="center"> 
        <Row  className="justify-content-center">
          <Col xs={6} md={5} ml={3}>
            <p ><Image src={logo} roundedCircle width="40%;"  /></p>
          </Col>
        </Row>
    </div>
  <Navbar bg="light" expand="lg" className="content-center">
      <Navbar.Brand href="#home"></Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link href="#home"></Nav.Link>
              <Nav.Link href="#link">Link</Nav.Link>
                <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
              </NavDropdown>
            </Nav>
    <Form inline>
      <FormControl type="text" placeholder="Search" className="mr-sm-2" />
      <Button variant="outline-success">Search</Button>
    </Form>
         </Navbar.Collapse>
    </Navbar>
    <Row>
      <Col>
        <div class="conteudo">
          <h1>Por que usar?</h1>
          <h6>A busca diária por informações é algo totalmente relevante, atinge diretamente a produtividade para agrupar todos os dados. Com isso esse WebApp vai facilitar a vida de quem vive por informações. </h6>
          <h6>Dados processados e tratados da forma mais fácil e pratica para o seu uso.</h6>
          <h6>Com a diversividade de locais onde os dados se localizam, ter uma plataforma que agrupa todos de forma unificada</h6>
          <h6>cotribui para seu uso e confiabilidade das informações, podendo assim ter veracidade, velocidade e valores ao mesmo tempo.</h6>
          <h6></h6>
        </div>
      </Col>
 
     
    </Row>

    </Container>
  )
}



export default App;

