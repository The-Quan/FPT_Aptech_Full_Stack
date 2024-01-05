import axios from "axios";
import React, {useEffect, useState} from "react";
import { Table, Button} from "semantic-ui-react";

export default function Read() {
    const [APIData, setAPIData] = useState([]);
    useEffect(() => {
        axios
        .get('https://656ae3dcdac3630cf7276592.mockapi.io/uio')
        .then((Response) => {
          console.log(Response.data);
          setAPIData(Response.data);
    });

},[])
const getData = () =>{
    axios.get().then(() => {})
}
    const onDelete =(id) => {
        axios.delete("https://656ae3dcdac3630cf7276592.mockapi.io/uio/{id}")
        .then(()=>{
            // getData();
            console.log('xóa thành công')
        })
    }

        return (
            <div>
                <Table singleLine>
                    <Table.Header>
                        <Table.Row>
                            <Table.HeaderCell>First Name</Table.HeaderCell>
                            <Table.HeaderCell>Last Name</Table.HeaderCell>
                            <Table.HeaderCell>Check Box</Table.HeaderCell>
                        </Table.Row>
                    </Table.Header>

                    <Table.Body>
                        {APIData.map((data) =>{
                            return (
                                <Table.Row>
                                <Table.Cell>{data.firstName}</Table.Cell>
                                <Table.Cell>{data.lastName}</Table.Cell>
                                <Table.Cell>
                                {data.checkBox ? "checked":"Unchecked"}
                                </Table.Cell>
                                <Table.Call>
                                    <button onClick={()=>onDelete(data.id)}></button>
                                </Table.Call>
                                </Table.Row>
                            );
                        })};
                    </Table.Body>
                </Table>
            </div>
        );
    }