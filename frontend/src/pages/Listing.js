import { LocationOn, Star } from '@material-ui/icons';
import { unstable_createMuiStrictModeTheme as createMuiTheme } from '@material-ui/core';
import CropOutlinedIcon from '@material-ui/icons/CropOutlined';
import BathtubOutlinedIcon from '@material-ui/icons/BathtubOutlined';
import HomeWorkOutlinedIcon from '@material-ui/icons/HomeWorkOutlined';
import WeekendOutlinedIcon from '@material-ui/icons/WeekendOutlined';
import DoneIcon from '@material-ui/icons/Done';
import DateFnsUtils from '@date-io/date-fns';
import 'date-fns';
import {
  KeyboardDatePicker,
  MuiPickersUtilsProvider,
} from '@material-ui/pickers';
import React, { useState, useEffect } from 'react';
import { Gallery, Item } from 'react-photoswipe-gallery';
import 'photoswipe/dist/photoswipe.css';
import 'photoswipe/dist/default-skin/default-skin.css';
import './Listing.css';
import { Button, Chip, CircularProgress, TextField } from '@material-ui/core';
import { useHistory, useLocation, useParams } from 'react-router';
import axios from 'axios';
import { useSelector, useDispatch } from 'react-redux';
import {
  setNumberOfPeople,
  setStartDate,
  setEndDate,
} from '../features/commonSlice';
import { makeReservation } from '../features/reservationSlice';

function Listing() {
  const history = useHistory();
  const dispatch = useDispatch();
  const [listing, setListing] = useState(null);
  const numberOfPeople = useSelector(
    (state) => state.commonState.numberOfPeople
  );
  const startDate = useSelector((state) => state.commonState.startDate);
  const endDate = useSelector((state) => state.commonState.endDate);
  const selectedPropertyId = useSelector(
    (state) => state.commonState.selectedPropertyId
  );

  const handleStartDateChange = (date) => {
    dispatch(setStartDate(date.toString()));
  };

  const handleEndDateChange = (date) => {
    dispatch(setEndDate(date.toString()));
  };

  async function fetchListing(id) {
    try {
      const res = await axios.get(
        `http://localhost:9091/api/property/byid/${id}`
      );
      // return res.data;
      setListing(res.data);
    } catch (err) {
      console.log(err);
    }
  }

  useEffect(() => {
    // fetch Listing
    fetchListing(selectedPropertyId);
  }, [selectedPropertyId]);

  function makeReservationHandker() {
    console.log('clicked .....===...===..');
    dispatch(
      makeReservation(
        startDate,
        endDate,
        numberOfPeople,
        selectedPropertyId,
        history
      )
    );
  }

  if (!listing) {
    return <CircularProgress className="loading" />;
  }

  return (
    <div className="listing content">
      <h2>
        {'[' +
          listing.typeProperty.type +
          '] - ' +
          listing.description.substring(0, 14)}
      </h2>
      <div className="listing__infos-top">
        <Star /> 4.15 . <LocationOn />{' '}
        {listing.city.nameCity + ' - ' + listing.address.address}
      </div>

      <Gallery>
        <div className="listing__gallery">
          {listing.images.map((image) => (
            <Item
              original={image.url}
              thumbnail={image.url}
              width="1024"
              height="768"
              key={image.id}
            >
              {({ ref, open }) => (
                <img alt="cats" ref={ref} onClick={open} src={image.url} />
              )}
            </Item>
          ))}
        </div>
      </Gallery>
      <div className="listing__content">
        <div className="listing__content--left">
          <h3>Details</h3>
          <p>{listing.description}</p>
          <hr />
          <ul>
            <li>
              <CropOutlinedIcon />
              {listing.surface}
            </li>
            <li>
              <HomeWorkOutlinedIcon />
              Rooms: {listing.numberRoom}
            </li>
            <li>
              <BathtubOutlinedIcon />
              Bathrooms: {listing.numberWC}
            </li>
            {listing.equiped ? (
              <li>
                <WeekendOutlinedIcon />
                Equipped
              </li>
            ) : null}
          </ul>
          <hr />
          <h3>Amenities</h3>
          <div>
            {listing.tags.map((tag) => (
              <Chip
                key={tag.id}
                className="listing__amenities-tags"
                label={tag.nameTag}
                deleteIcon={<DoneIcon />}
                variant="outlined"
              />
            ))}
          </div>
        </div>
        <div className="listing__content--right">
          <div className="listing__content--right-card">
            <h2>
              MAD {listing.price} <span>/night</span>
            </h2>
            <MuiPickersUtilsProvider utils={DateFnsUtils}>
              <KeyboardDatePicker
                disableToolbar
                variant="inline"
                format="MM/dd/yyyy"
                margin="normal"
                id="date-picker-inline1"
                label="Start date"
                value={startDate}
                onChange={handleStartDateChange}
                KeyboardButtonProps={{
                  'aria-label': 'change date',
                }}
              />
            </MuiPickersUtilsProvider>
            <MuiPickersUtilsProvider utils={DateFnsUtils}>
              <KeyboardDatePicker
                disableToolbar
                variant="inline"
                format="MM/dd/yyyy"
                margin="normal"
                id="date-picker-inline"
                label="End date"
                value={endDate}
                onChange={handleEndDateChange}
                KeyboardButtonProps={{
                  'aria-label': 'change date',
                }}
              />
            </MuiPickersUtilsProvider>
            <TextField
              type="number"
              label="Number of guests"
              value={numberOfPeople}
              onChange={(e) =>
                dispatch(setNumberOfPeople(parseInt(e.target.value)))
              }
            />
            <Button onClick={makeReservationHandker}>Reserve</Button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Listing;
