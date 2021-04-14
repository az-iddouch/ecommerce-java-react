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

function Search() {
  const [city, setCity] = useState('');
  const dispatch = useDispatch();
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const listOfCities = useSelector((state) => state.cityData.allCities);
  const history = useHistory();

  const selectionRange = {
    startDate: startDate,
    endDate: endDate,
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
    }
  }

  function handleSelect(ranges) {
    setStartDate(ranges.selection.startDate);
    setEndDate(ranges.selection.endDate);
  }

  return (
    <div className="search">
      <DateRangePicker ranges={[selectionRange]} onChange={handleSelect} />
      <div className="search__additionals">
        <div className="search__additionals--persons">
          <h2>Number of guests</h2>
          <TextField
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
