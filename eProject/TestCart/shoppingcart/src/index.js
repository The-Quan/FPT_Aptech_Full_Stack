import React, { StrictMode } from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Menu from './component/menu/menu';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <StrictMode>
    <Router>
    <Routes>
    <Route path="/" exact Component={App}></Route>
    </Routes>
    </Router>
  </StrictMode>
);

reportWebVitals();
