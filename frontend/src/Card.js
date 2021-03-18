import React from 'react';
import './Card.css';

function Card({ src, cityName, numberOfPostings }) {
  return (
    <div className="city-card">
      <img src={src} alt={cityName} />
      <div className="city-card__infos">
        <h3>{cityName}</h3>
        <h5>{numberOfPostings}</h5> Listings
      </div>
    </div>
  );
}

export default Card;
