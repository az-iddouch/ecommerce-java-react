import { Button } from '@material-ui/core';
import React from 'react';
import SearchListing from '../components/SearchListing';
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
      <SearchListing
        img="https://cdn.decorilla.com/online-decorating/wp-content/uploads/2020/05/Home-Decor-NYC-Luxurious-New-York-Apartment.jpg"
        location="Tanger"
        title="Stay at the spacious beautiful house"
        description="1 guest . 1 bed . 1 shared bathroom . wifi . free parking . washing machine"
        star={4.5}
        price="$30 / night"
        total="$117 total"
      />
      <SearchListing
        img="https://cdn.decorilla.com/online-decorating/wp-content/uploads/2020/05/Home-Decor-NYC-Luxurious-New-York-Apartment.jpg"
        location="Tanger"
        title="Stay at the spacious beautiful house"
        description="1 guest . 1 bed . 1 shared bathroom . wifi . free parking . washing machine"
        star={4.5}
        price="$30 / night"
        total="$117 total"
      />
    </div>
  );
}

export default SearchPage;
