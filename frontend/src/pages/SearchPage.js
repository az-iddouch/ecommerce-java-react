import { Button } from '@material-ui/core';
import React from 'react';
import SearchListing from '../components/SearchListing';
import './SearchPage.css';
import { useDispatch, useSelector } from 'react-redux';

function SearchPage() {
  const listings = useSelector((state) => state.cityData.listings);
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
      {listings &&
        listings.map((listing) => {
          return (
            <SearchListing
              img="https://cdn.decorilla.com/online-decorating/wp-content/uploads/2020/05/Home-Decor-NYC-Luxurious-New-York-Apartment.jpg"
              location={listing.city.nameCity + ' - ' + listing.address.address}
              title={
                '[' +
                listing.typeProperty.type +
                '] - ' +
                listing.description.substring(0, 14)
              }
              description={listing.description}
              star={4.5}
              price={listing.price}
              total={parseFloat(listing.price) * 6}
            />
          );
        })}
    </div>
  );
}

export default SearchPage;
