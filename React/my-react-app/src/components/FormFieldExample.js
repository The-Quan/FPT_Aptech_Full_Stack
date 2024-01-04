import React from "react";
import { Button,Checkbox,Form, Label } from "semantic-ui-react";

function FormFieldExample(){
    <Form>
        <Form.Field>
            <Label>First Name</Label>
            <input placeholder="First Name"/>
        </Form.Field>
        <Form.Field>
            <Label>Last Name</Label>
            <input placeholder="First Name"/>
        </Form.Field>
        <Form.Field>
            <Checkbox label ='Tôi đồng ý với các điều khoản'/>
        </Form.Field>
        <Button type="submit">Submit</Button>
    </Form>

}
export default FormFieldExample;