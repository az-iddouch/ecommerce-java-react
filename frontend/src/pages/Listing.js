import { LocationOn, Star } from '@material-ui/icons';
import CropOutlinedIcon from '@material-ui/icons/CropOutlined';
import BathtubOutlinedIcon from '@material-ui/icons/BathtubOutlined';
import HomeWorkOutlinedIcon from '@material-ui/icons/HomeWorkOutlined';
import WeekendOutlinedIcon from '@material-ui/icons/WeekendOutlined';
import DateFnsUtils from '@date-io/date-fns';
import 'date-fns';
import {
  KeyboardDatePicker,
  MuiPickersUtilsProvider,
} from '@material-ui/pickers';
import React, { useState } from 'react';
import { Gallery, Item } from 'react-photoswipe-gallery';
import 'photoswipe/dist/photoswipe.css';
import 'photoswipe/dist/default-skin/default-skin.css';
import './Listing.css';

function Listing() {
  const [selectedDate, setSelectedDate] = useState(
    new Date('2014-08-18T21:11:54')
  );

  const handleDateChange = (date) => {
    setSelectedDate(date);
  };
  return (
    <div className="listing content">
      <h2>CHAMBRE ENSOLEILLÉE ET CONFORTABLE // PRIVATE ROOM</h2>
      <div className="listing__infos-top">
        <Star /> 4.15 . <LocationOn /> Agadir, Souss-Massa-Draâ, Morocco
      </div>

      <Gallery>
        <div className="listing__gallery">
          <Item
            original="https://placekitten.com/1024/768?image=1"
            thumbnail="https://placekitten.com/1024/768?image=1"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=1"
              />
            )}
          </Item>
          <Item
            original="https://placekitten.com/1024/768?image=2"
            thumbnail="https://placekitten.com/1024/768?image=2"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=2"
              />
            )}
          </Item>
          <Item
            original="https://placekitten.com/1024/768?image=3"
            thumbnail="https://placekitten.com/1024/768?image=3"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=3"
              />
            )}
          </Item>
          <Item
            original="https://placekitten.com/1024/768?image=4"
            thumbnail="https://placekitten.com/1024/768?image=4"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=4"
              />
            )}
          </Item>
          <Item
            original="https://placekitten.com/1024/768?image=5"
            thumbnail="https://placekitten.com/1024/768?image=5"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=5"
              />
            )}
          </Item>
        </div>
      </Gallery>
      <div className="listing__content">
        <div className="listing__content--left">
          <h3>Details</h3>
          {/* Surface / Number of rooms / Number of WC / Equipped */}
          <p>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam odio
            maxime ducimus distinctio! Totam, libero dolorum obcaecati tempore
            eum autem esse corrupti voluptas cum cumque maiores temporibus
            accusantium similique ea sed dolorem cupiditate dolores molestiae
            nihil facilis. Porro at optio voluptas esse? Iusto quisquam
          </p>
          <ul>
            <li>
              <CropOutlinedIcon />
              Surface: 50 m²
            </li>
            <li>
              <HomeWorkOutlinedIcon />
              Rooms: 3
            </li>
            <li>
              <BathtubOutlinedIcon />
              Bathrooms: 2
            </li>
            <li>
              <WeekendOutlinedIcon />
              Equipped
            </li>
          </ul>
        </div>
        <div className="listing__content--right">
          <div className="listing__content--right-card">
            <h2>
              MAD120 <span>/night</span>
            </h2>
            <MuiPickersUtilsProvider utils={DateFnsUtils}>
              <KeyboardDatePicker
                disableToolbar
                variant="inline"
                format="MM/dd/yyyy"
                margin="normal"
                id="date-picker-inline"
                label="Date picker inline"
                value={selectedDate}
                onChange={handleDateChange}
                KeyboardButtonProps={{
                  'aria-label': 'change date',
                }}
              />
            </MuiPickersUtilsProvider>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Listing;
