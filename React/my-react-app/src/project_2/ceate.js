
import {Button, CheckBox, Form } from 'semantic-ui-react';
import React, {useState} from "react";
import axios from 'axios';

export default function useState () {
    const[FirstName,setFirsName] = useState('');
    const[LastName,setLastName] = useState('');
    const[CheckBox,setCheckBox] = useState('false');
    const posDate = () =>{
     console.log(FirstName)
     console.log(LastName)
     console.log(CheckBox)
    }



    return(
       <Form classNam ="create-form">
            <Form.Field>
                <label>First Name</label>
                <input placeholder="First Name" onChange={(e) => setFirsName(e.target.value)}></input>
            </Form.Field>
            <Form.Field>
                <label>Last Name</label>
                <input placeholder="First Name" onChange={(e) => setLastName(e.target.value)}></input>
            </Form.Field>
            <Form.Field>
                <CheckBox label=' tôi đồng ý điêù khoản này' onChange={(e) => setLastName(e.target.value)}/>
            </Form.Field>
            <Form.Field>
                <Button type="submit">submit</Button>
            </Form.Field>
       </Form>
    );
};
