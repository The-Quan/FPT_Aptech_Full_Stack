import { render } from "react-dom";

const Student = (props) => {
  return (
    <div className='Student'>
      <h1>list of Student</h1>
      <p>name: {props.Student.name}</p>
      <p>email: {props.Student.email}</p>
    </div>
  );
};

function App11() {
  const Student = {
    name: "quan",
    email: 'quan@gamil.com',
  };
}

render{
  return (
    <div className='App'>
      <Student Student={Student} />
      <hr></hr>
      <car></car>
    </div>
  );
}

export default App11;



// class Car extends Component {
//   constructor() {
//     super();
//     this.state = {
//       car: 'Honda', z
//     };
//   }

//   changeMessage() {
//     this.setState({
//       car: 'Toyota',
//     });
//   }

//   render() {
//     return (
//       <div className='App'>
//         {/* read data via state */}
//         <h1>{this.state.car}</h1>
//         {/* write data via state */}
//         <button onClick={() => this.changeMessage()}>change</button>
//       </div>
//     );
//   }
// }





