
import './App.css';
import Read from './components/read';
import Create from './components/create';
import { Routes, BrowserRouter as Router } from 'react-router-dom';
import FormFieldExample from './components/FormFieldExample';


function App() {
  return (
    <Router>
      <div className='main'>
      <h2 className='main-header'>React Crud Example</h2>
      <div>
        <Routes exact path='/Create' component={Create} />
      </div>
      <div style={{marginTop:20}}>
        <Routes exact path='/reand' component ={Read} />
      </div>
      {/* <Routes path='/updata' component = {updata} /> */}
    </div>
      <FormFieldExample></FormFieldExample>
    </Router>
  );
};
export default App;
