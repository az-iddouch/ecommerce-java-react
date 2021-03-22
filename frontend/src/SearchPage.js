import { Button } from '@material-ui/core';
import React from 'react';
import './SearchPage.css';

function SearchPage() {
  return (
    <div className="search-page content">
      <div className="search-page__infos">
        <p>62 stays . 26 august to 30 august . 2 guests </p>
        <h1>Stays nearby</h1>
        <div className="search-page__filters">
          <Button variant="outlined">Cancellation flexibility</Button>
          <Button variant="outlined">Type of place</Button>
          <Button variant="outlined">Price</Button>
          <Button variant="outlined">Rooms and beds</Button>
          <Button variant="outlined">More filters</Button>
        </div>
      </div>
    </div>
  );
}

export default SearchPage;
