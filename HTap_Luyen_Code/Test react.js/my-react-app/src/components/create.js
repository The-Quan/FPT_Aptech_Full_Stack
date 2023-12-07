import React, { useState } from "react";
import { Button, Checkbox, Form } from "semantic-ui-react";
import axios from "axios";
import { useHistory } from 'react-router';
import './App.css';

export default function Create() {
  let history = useHistory();
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [Checked, setCheckBox] = useState(false);
  console.log(firstName);
   const postData = () => {
    axios.post('', { firstName, lastName, Checked })
      .then(() => {
        history.push("read");
      });

    console.log(lastName);
    console.log(Checked);
  }

  return (
    <Form className="create-form">
      <Form.Field>
        <label>First Name</label>
        <input placeholder="First Name"
          onChange={(e) => setFirstName(e.target.value)} />
      </Form.Field>
      <Form.Field>
        <label>Last Name</label>
        <input placeholder="Last Name"
          onChange={(e) => setLastName(e.target.value)} />
      </Form.Field>
      <Form.Field>
        <Checkbox label="Tôi đồng ý với các điều khoản"
          onChange={() => setCheckBox(!Checked)} />
      </Form.Field>
      <Button onClick={postData} type="submit">Submit</Button>
    </Form>
  );
};
