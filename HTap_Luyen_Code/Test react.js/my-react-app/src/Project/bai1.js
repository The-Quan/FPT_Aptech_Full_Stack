import React, { Component } from "react";
import { render } from "react-dom";

const Student = (props) => {
  return (
    <div className='Student'>
      <h1>List of Students</h1>
      <p>Name: {props.student.name}</p>
      <p>Email: {props.student.email}</p>
    </div>
  );
};

class App11 extends Component {
  render() {
    const studentData = {
      name: "quan",
      email: 'quan@gmail.com',
    };

    return (
      <div className='App'>
        <Student student={studentData} />
        <hr />
        <Car />
      </div>
    );
  }
}

class Car extends Component {
  constructor() {
    super();
    this.state = {
      car: 'Honda', // Fixed the typo here
    };
  }

  changeMessage() {
    this.setState({
      car: 'Toyota',
    });
  }

  render() {
    return (
      <div className='Car'>
        {/* read data via state */}
        <h1>{this.state.car}</h1>
        {/* write data via state */}
        <button onClick={() => this.changeMessage()}>Change</button>
      </div>
    );
  }
}

export default App11;