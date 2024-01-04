import {IconContext} from "react-icons";
import {FaCheckCircle} from "react-icons/fa";

export default function ErrorIcon(){
    return (
        <IconContext.Provider value={{ color: "forestgreen", size: "1.7rem"}}>
            <FaCheckCircle />
        </IconContext.Provider>
    );
}
