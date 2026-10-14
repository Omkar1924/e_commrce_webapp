import React, { useEffect, useState } from 'react';
import { useParams, Link } from 'react-router-dom';
import { getProductById } from '../api/productApi';

function ProductDetail() {
    const { id } = useParams();
    const [product, setProduct] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchProduct = async () => {
            try { 
                const response = await getProductById(id);
                setProduct(response.data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };
        fetchProduct();
    }, [id]);

    if (loading) return <p>Loading Product...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div className="container mt-4">
           <Link to='/' className="btn btn-secondary mb-3">Back to Products</Link>
           <div className="card">
            <div className="card-body">
                <img src={product.image} alt={product.name} className="img-fluid" />
                <h2>{product.name}</h2>
                <p>{product.description}</p>
                <h4 className="text-success">₹{product.price}</h4>
                <p>In Stock: {product.stockQuantity}</p>

            </div>
           </div>
        </div>
    );
}

export default ProductDetail;