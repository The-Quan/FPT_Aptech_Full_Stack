import React,{useState} from "react";
import { Button, Checkbox, Form, Label } from "semantic-ui-react";
import axios from "axios";

export default function Create() {
    const[firstName, setFirstName] = useState('');
    const[lastName,setLastName] = useState('');
    const[checkBox, setCheckBox] = useState(false);
    const postData = () =>{
        console.log(firstName);
        console.log(lastName);
        console.log(checkBox);
        // axios.post("https://656ae3cedac3630cf727651e.mockapi.io/Users",
        // {firstName,lastName,checkBox})
    }



  return (
    <Form className="create-form">
      <Form.Field>
        <label>First Name</label>
        <input placeholder="First Name" 
        onChange={(e)=>setFirstName(e.target.value)} />
      </Form.Field>
      <Form.Field>
        <label>Last Name</label>
        <input placeholder="First Name" 
        onChange={(e)=>setLastName(e.target.value)} />
      </Form.Field>
      <Form.Field>
        <Checkbox label="Tôi đồng ý với các điều khoản" 
        onChange={(e)=> setCheckBox(!checkBox)} />
      </Form.Field>
      <Button onClick={postData} type="submit">Submit</Button>
    </Form>
  );
};
