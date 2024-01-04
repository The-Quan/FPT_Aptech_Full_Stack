import React from "react";
import Home2 from "./project/Home2";
import About2 from "./project/about";
import Register from "./project/register";
import './adm.css'

import { Component } from "react";

import { BrowserRouter, Link, Routes, Route } from "react-router-dom";

class App2 extends Component {
    render(){
      return(
       
         <div className="container">
           <BrowserRouter>
          <ul className="header">
          <li>
              <Link to="/Home2">Home</Link>
            </li>
            <li>
              <Link to="/About2">About us</Link>
            </li>
            <li>
                <Link to="/Register">Resgiter</Link>
            </li>
            
          </ul>
           <Routes>
           <Route path='/Home2' element={<Home2 />} /> 
           <Route path='/About2' element={<About2 />} /> 
           <Route path='/Register' element={<Register />} /> 
           </Routes>
        </BrowserRouter>
        </div>
      );
    }
  }
  export default App2;
  
  