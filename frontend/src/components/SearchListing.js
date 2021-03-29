import { FavoriteBorderOutlined, Star } from '@material-ui/icons';
import React from 'react';
import './SearchListing.css';

function SearchListing({
  img,
  location,
  title,
  description,
  star,
  price,
  total,
}) {
  return (
    <div className="search-listing">
      <div className="search-listing__img">
        <img src={img} alt="" />
      </div>
      <FavoriteBorderOutlined className="search-listing__heart" />
      <div className="search-listing__info">
        <div className="search-listing__info--top">
          <p>{location}</p>
          <h3>{title}</h3>
          <p>______</p>
          <p>{description}</p>
        </div>
        <div className="search-listing__info--bottom">
          <div className="search-listing__stars">
            <Star className="search-listing__star" />
            <strong>{star}</strong>
          </div>
          <div className="search-listing__price">
            <h2>{price}</h2>
            <p>{total}</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default SearchListing;
