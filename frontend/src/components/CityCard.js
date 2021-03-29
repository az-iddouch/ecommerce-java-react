import React from 'react';
import './CityCard.css';

function CityCard({ src, cityName, numberOfPostings }) {
  return (
    <div className="city-card">
      <img src={src} alt={cityName} />
      <div className="city-card__infos">
        <h3>{cityName}</h3>
        <h5>{numberOfPostings}</h5> <span>Listings</span>
      </div>
    </div>
  );
}

export default CityCard;
