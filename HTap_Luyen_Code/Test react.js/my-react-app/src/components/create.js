import React, { useState } from "react";
import { Button, Checkbox, Form } from "semantic-ui-react";
import axios from "axios";
import {useHistory} from "react-router-dom";

export default function Create() {
  let History = useHistory();
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [Checked, setCheckBox] = useState(false);
  console.log(firstName);
   const postData = () => {
    axios.post('https://656ae3dcdac3630cf7276592.mockapi.io/uio', { firstName, lastName, Checked })
      .then(() => {
        History.push("read");
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
