import { Button } from '@material-ui/core';
import React from 'react';
import { useHistory } from 'react-router';

import './Banner.css';

function Banner() {
  const history = useHistory();

  return (
    <div className="banner">
      <div className="banner__info">
        <h1>Get out there and start living</h1>
        <h5>
          Plane a different kind of getaway to uncover the hidden gems near you.
        </h5>
        <Button variant="outlined" onClick={() => history.push('/search')}>
          Explore Nearby
        </Button>
      </div>
    </div>
  );
}

export default Banner;
