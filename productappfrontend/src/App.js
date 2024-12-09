import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { useEffect, useState } from "react";
import ProductList from "./ProductList";
import CategoryFilter from "./CategoryFilter";

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    fetch("http://localhost:8080/api/products/")
      .then((res) => res.json())
      .then((data) => setProducts(data));

    fetch("http://localhost:8080/api/categories/")
      .then((res) => res.json())
      .then((data) => setCategories(data));
  }, []);

  const handleSearchChange = (e) => {
    setSearchTerm(e?.target?.value);
  };

  const handleSortChange = (e) => {
    setSortOrder(e?.target?.value);
  };

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  const filteredProducts = products
    .filter((product) => {
      return (
        (selectedCategory
          ? product?.category?.id === selectedCategory
          : true) &&
        product?.name?.toLowerCase()?.includes(searchTerm?.toLowerCase())
      );
    })
    .sort((a, b) => {
      if (sortOrder === "asc") {
        return a.price - b.price;
      } else {
        return b.price - a.price;
      }
    });

  return (
    <div className="container">
      <h1 className="my-4">Product Catalogue</h1>
      <div className="row align-items-center mb-4">
        <div className="col-md-3 col-sm-12 mb-12">
          <CategoryFilter
            categories={categories}
            onSelect={handleCategorySelect}
          />
        </div>
        <div className="col-md-5 col-sm-12 mb-12">
          <input
            type="text"
            className="form-control"
            placeholder="Search for Products"
            onChange={handleSearchChange}
          />{" "}
        </div>
        <div className="col-md-4 col-sm-12 mb-2">
          <select className="form-control" onChange={handleSortChange}>
            <option value="asc">Sort By Price:Low to High</option>
            <option value="desc">Sort By Price:High to Low</option>
          </select>
        </div>
      </div>
      <div>
        {filteredProducts?.length ? (
          <>
            <ProductList products={filteredProducts} />
          </>
        ) : (
          <p>No Products found</p>
        )}
      </div>
    </div>
  );
}

export default App;
