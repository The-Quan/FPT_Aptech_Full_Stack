import logo from './logo.svg';
import './App.css';
import Create from './components/create';
import FormFieldExample from './components/FormFieldExample';

function App() {
  return (
    <div className='main'>
      <h1 className='main-header'>React CRUD Example</h1>
      <div>
        <Create/>
        {/* <FormFieldExample></FormFieldExample> */}
      </div>

    </div>
  );
}

export default App;
