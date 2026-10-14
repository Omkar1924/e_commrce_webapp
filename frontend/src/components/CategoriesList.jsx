import React, { useEffect, useState } from "react";
import { getAllCategories } from "../api/categoryApi";

function CategoriesList() {
  const [categories, setCategories] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchCategories = async () => {
      try {
        const response = await getAllCategories();
        setCategories(response.data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };
    fetchCategories();
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error : {error}</p>;
  return (
    <div className="container mt-4">
      <h2>Categories</h2>
      <div className="row">
        {categories.map((category) => (
          <div className="col-md-4 mb-3" key={category.id}>
            <div className="card">
              <div className="card-body">
                <h5 className="card-title">{category.name}</h5>
                <p className="card-text">{category.description}</p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default CategoriesList;
