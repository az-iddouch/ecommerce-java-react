import { Button } from '@material-ui/core';
import React from 'react';
import './Banner.css';

function Banner() {
  return (
    <div className="banner">
      <div className="banner__info">
        <h1>Get out there and start living</h1>
        <h5>
          Plane a different kind of getaway to uncover the hidden gems near you.
        </h5>
        <Button variant="outlined">Explore Nearby</Button>
      </div>
    </div>
  );
}

export default Banner;
