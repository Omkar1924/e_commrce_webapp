import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-4">
      <Link to="/" className="navbar-brand">
        My Shop
      </Link>
      <div className="collapse navbar-collapse">
        <ul className="navbar-nav me-auto">
          <li className="nav-item">
            <Link to="/" className="nav-link">
              Products
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/categories">
              Categories
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;
