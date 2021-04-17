import React, { useState, useEffect } from 'react';
import './Search.css';
import 'react-date-range/dist/styles.css'; // main style file
import 'react-date-range/dist/theme/default.css'; // theme css file
import { DateRangePicker } from 'react-date-range';
import { Button } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import Autocomplete from '@material-ui/lab/Autocomplete';
import { getAllCities, getListingsByCity } from '../features/citySlice';
import { useDispatch, useSelector } from 'react-redux';
import { useHistory } from 'react-router-dom';
import {
  setShowSearch,
  setNumberOfPeople,
  setStartDate,
  setEndDate,
} from '../features/commonSlice';

function Search() {
  const [city, setCity] = useState('');
  const dispatch = useDispatch();
  const startDate = useSelector((state) => state.commonState.startDate);
  const endDate = useSelector((state) => state.commonState.endDate);
  const listOfCities = useSelector((state) => state.cityData.allCities);
  const numberOfPeople = useSelector(
    (state) => state.commonState.numberOfPeople
  );
  const history = useHistory();

  const selectionRange = {
    startDate: new Date(startDate),
    endDate: new Date(endDate),
    key: 'selection',
    color: '#00d382',
  };

  useEffect(() => {
    dispatch(getAllCities());
  }, [dispatch]);

  function searchProperties() {
    if (city && city.length > 0) {
      const cityId = city.split('_')[0];
      dispatch(getListingsByCity(cityId, history));
      dispatch(setShowSearch(false));
    }
  }

  function handleSelect(ranges) {
    dispatch(setStartDate(ranges.selection.startDate.toString()));
    dispatch(setEndDate(ranges.selection.endDate.toString()));
  }

  return (
    <div className="search">
      <DateRangePicker ranges={[selectionRange]} onChange={handleSelect} />
      <div className="search__additionals">
        <div className="search__additionals--persons">
          <h2>Number of guests</h2>
          <TextField
            onChange={(e) =>
              dispatch(setNumberOfPeople(parseInt(e.target.value)))
            }
            value={numberOfPeople}
            type="number"
            InputLabelProps={{
              shrink: true,
            }}
            variant="outlined"
          />
        </div>
        <div className="search__additionals--location">
          <h2>Location</h2>
          <Autocomplete
            onChange={(event, value) => setCity(value)}
            className="search__additionals--location-input"
            freeSolo
            options={
              listOfCities &&
              listOfCities.map((option) => option.id + '_' + option.nameCity)
            }
            value={city}
            renderInput={(params) => (
              <TextField {...params} margin="normal" variant="outlined" />
            )}
          />
        </div>
      </div>
      <Button onClick={searchProperties}>Search Vash</Button>
    </div>
  );
}

export default Search;
