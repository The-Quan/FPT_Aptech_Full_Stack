function Product(props) {
    return (
        <div>
            <img src={props.img} />
            <h3>{props.name}</h3>
            <p>{props.desc}</p>
            <h3>{props.price}</h3>
        </div>
    );
}
export default Product;