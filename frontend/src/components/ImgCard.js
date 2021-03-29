import React from 'react';
import './ImgCard.css';

function ImgCard({ src, title }) {
  return (
    <div className="img-card">
      <div className="img-card_img">
        <img src={src} alt={title} />
      </div>
      <h3>{title}</h3>
    </div>
  );
}

export default ImgCard;
