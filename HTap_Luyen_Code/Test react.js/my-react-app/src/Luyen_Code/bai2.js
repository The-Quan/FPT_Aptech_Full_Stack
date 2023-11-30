import React from "react";
import  ReactDOM  from "react-dom/client";


function Football(){
    const shoot = () => {
        alert("Great Shot!");
    }

    return (
        <button onClick={shoot}>Take the shot!</button>
    );
}

export default Football;

