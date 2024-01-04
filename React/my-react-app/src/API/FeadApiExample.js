// sử dụng Fetch API để :
// Put, Post, get, delete, api

import { useState,useEffect } from "react";
// import { json, useFetcher } from "react-router-dom";

function FetchExample (){
    const [data,setDate] = useState(null);
    // usefetcher dùng cho việc Fetch Api
    useEffect(()=>{
        fetch('https://656ae3dcdac3630cf7276592.mockapi.io/Product')
        .then(Response => Response.json())
        .then(json => setDate(json))
        .catch(error => console.error(error));
    },[]);
    return (
        <div>
             {data ? <pre>{JSON.stringify(data,null,2)}</pre>:"looding....."}
        </div>
    );
};

export default FetchExample;