import React from "react";

const ProductList = ({ products }) => {
  return (
    <div className="row">
      {products?.map((product) => {
        return (
          <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={product?.id}>
            <div className="card h-100">
              <img
                src={product?.imageUrl ?? "https://placehold.co/600X400"}
                className="card-img-top"
                alt={product?.name}
              ></img>
              <div class="card-body">
                <h5 class="card-title">{product?.name}</h5>
                <p class="card-text">{product?.description}</p>
                <a href="#" class="btn btn-primary">
                  {product?.price}
                </a>
              </div>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default ProductList;
