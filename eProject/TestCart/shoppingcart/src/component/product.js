import '../App.css'

function Product({product, addToCart}){
    return(
        <div className='flex'>
        {
            product.map((productItem, productIndex) => {
                return(
                    <div style={{width: '50%'}}>
                          <div className='product-item'>
                          <img src= {productItem.src} width={"100%"}></img>
                            <p>{productItem.name} /
                               {productItem.category}
                            </p>
                            <p>{productItem.seller}</p>
                            <p>rs. {productItem.price}</p>
                              <button onClick={() => addToCart(productItem)}>add to cart</button>
                          </div>
                    </div>
                )
            })
        }
        </div>
    )
}

export default Product;