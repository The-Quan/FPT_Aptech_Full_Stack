// call API: XmlHpttRequery
// sử dụng XmlHtpRequery dùng khi muốn read API

import React, { useState } from "react";

function XmlHpttRequeryExample (){
   const [data,setDate] = useState (null);

   function handleClick (){
    const xhr = new XMLHttpRequest ();

    //  get :read

    xhr.open('GET','https://656ae3dcdac3630cf7276592.mockapi.io/Product');
    xhr.onload = function(){
           if(xhr.status === 200){
            setDate(JSON.parse(xhr.responseText))
           }
       };
       xhr.send();
   }
   return (
    <div>
        <button onClick={handleClick}>
            get API data
        </button>
        {data ? <div>{JSON.stringify(data)}</div>:<div>loading data..........</div>}
    </div>
   );
}
export default XmlHpttRequeryExample;