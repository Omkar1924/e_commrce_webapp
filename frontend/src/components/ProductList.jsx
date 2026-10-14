import { useState, useEffect } from "react";
import { getAllproducts } from "../api/productApi";
import { Link } from "react-router-dom";

function ProductList() {
  const [products, setProducts] = useState([]);
  const [Loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await getAllproducts();
        setProducts(response.data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };
    fetchProducts();
  }, []);

  if (Loading) return <p>Loading Products...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <div className="container mt-4">
      <h2>Products</h2>
      <div className="row">
        {products.map((product) => (
          <div className="col-md-4 mb-4" key={product.id}>
            <Link
              to={`/product/${product.id}`}
              className="text-decoration-none text-dark"
            >
              <div className="card">
                <div className="card-body">
                  <img
                    src={product.image}
                    alt={product.name}
                    className="img-fluid mb-3"
                  />
                  <h5 className="card-title">{product.name}</h5>
                  <p className="card-text">{product.description}</p>
                  <p className="fw-bold">₹{product.price}</p>
                </div>
              </div>
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ProductList;
