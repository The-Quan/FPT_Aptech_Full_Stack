import React from "react";
import './App.css'


function Register() {
  return (
    <div className="regiter">
      <h1>Regiter</h1>
      <div className="dangki">
      <div className="input">
          <h4>Product</h4>
          <input type="text"></input>
        </div>
        <div className="input1">
          <h4>Name</h4>
          <input type="text"></input>
        </div>
        <div className="input2">

          <h4>Phone Number</h4>
          <input type="text"></input>
        </div>
        <div className="input3">

          <h4>Email</h4>
          <input type="text"></input>
        </div>

      </div>
        <div className="button">
        <button type="text">register</button>
        <button type="text">cancel</button>
        </div>
      </div>
  );
};
export default Register;