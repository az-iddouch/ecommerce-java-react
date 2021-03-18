import { Button } from '@material-ui/core';
import React, { useState } from 'react';
import Search from './Search';
import './Banner.css';

function Banner() {
  const [showSearch, setShowSearch] = useState(false);

  return (
    <div className="banner">
      <div className="banner__search">
        <Button
          variant="outline"
          className="banner__search-btn"
          onClick={() => setShowSearch(!showSearch)}
        >
          {showSearch ? 'Hide search' : 'Search dates'}
        </Button>
        {showSearch && <Search />}
      </div>
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
