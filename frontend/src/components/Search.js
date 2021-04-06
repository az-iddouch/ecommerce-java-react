import React, { useState } from 'react';
import './Search.css';
import 'react-date-range/dist/styles.css'; // main style file
import 'react-date-range/dist/theme/default.css'; // theme css file
import { DateRangePicker } from 'react-date-range';
import { Button } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import Autocomplete from '@material-ui/lab/Autocomplete';

function Search() {
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());

  const selectionRange = {
    startDate: startDate,
    endDate: endDate,
    key: 'selection',
    color: '#00d382',
  };

  function handleSelect(ranges) {
    setStartDate(ranges.selection.startDate);
    setEndDate(ranges.selection.endDate);
  }

  const listOfCities = [
    { title: 'The Shawshank Redemption', year: 1994 },
    { title: 'The Godfather', year: 1972 },
    { title: 'The Godfather: Part II', year: 1974 },
    { title: 'The Dark Knight', year: 2008 },
    { title: '12 Angry Men', year: 1957 },
    { title: "Schindler's List", year: 1993 },
  ];

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
            className="search__additionals--location-input"
            freeSolo
            options={listOfCities.map((option) => option.title)}
            renderInput={(params) => (
              <TextField
                {...params}
                // label="freeSolo"
                margin="normal"
                variant="outlined"
              />
            )}
          />
        </div>
      </div>
      <Button>Search Vash</Button>
    </div>
  );
}

export default Search;
