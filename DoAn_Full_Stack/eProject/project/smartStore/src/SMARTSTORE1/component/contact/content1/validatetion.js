export default function Validation(value) {
    const errors = {}
    const email_pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const phone_pattern = /^[0-9]{10,12}$/;


    if (value.name === "") {
        errors.name = "name is required";
    }
    if (value.email === "") {
        errors.email = "email is required"
    }
    
    if(value.address === ""){
            errors.address = "address is required";
        } 
    

    if (!email_pattern.test(value.email)) {
        errors.email = "email is not correct"
    }

    if (value.phone === "") {
        errors.phone = "phone is required";
    } else if (!phone_pattern.test(value.phone)) {
        errors.phone = "phone number did'nt match"
    }

    return errors;

}