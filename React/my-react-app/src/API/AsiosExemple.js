import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";

// dùng Axios Example để crud
// Axios sẽ thường kết hợp với mapp conlection(cấu trúc dữ liệu)

function AxiosExample(){
    const [data,setDate] = useState([]);
    useEffect(() => {
        axios.get('https://656ae3dcdac3630cf7276592.mockapi.io/Product')
        .then(response => {setDate(response.data);})
        .catch(error => {console.error(error);});
    },[]);
    return (
        <ul>
            {data.map(dt => (
                <li key={dt.id}> {dt.name} </li>
            ))}
        </ul>
    )
}
export default AxiosExample;