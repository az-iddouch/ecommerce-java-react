import { FavoriteBorderOutlined, Star } from '@material-ui/icons';
import React from 'react';
import { useHistory } from 'react-router';
import { useDispatch } from 'react-redux';
import { setSelectedPropertyId } from '../features/commonSlice';
import './SearchListing.css';

function SearchListing({ id, img, location, title, description, star, price }) {
  const history = useHistory();
  const dispatch = useDispatch();
  function handleClick(e) {
    dispatch(setSelectedPropertyId(id));
    history.push('/listings');
  }

  return (
    <div className="search-listing" onClick={(e) => handleClick(e)}>
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
            <h2>DH {price}</h2>
          </div>
        </div>
      </div>
    </div>
  );
}

export default SearchListing;
