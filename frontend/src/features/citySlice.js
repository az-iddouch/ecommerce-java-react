import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';

const citySlice = createSlice({
  name: 'cityData',
  initialState: { allCities: [], listings: [] },
  reducers: {
    setAllCities: {
      reducer(state, { payload }) {
        state.allCities = payload;
      },
    },
    setListings: {
      reducer(state, { payload }) {
        state.listings = payload;
      },
    },
  },
});

export const { setAllCities, setListings } = citySlice.actions;
export default citySlice.reducer;

export function getAllCities() {
  return async (dispatch) => {
    await axios
      .get('http://localhost:9091/api/city/all')
      .then((res) => {
        dispatch(setAllCities(res.data));
      })
      .catch((err) => console.log(err));
  };
}

export function getListingsByCity(id, history) {
  return async (dispatch) => {
    await axios
      .get(`http://localhost:9091/api/property/${id}`)
      .then((res) => {
        dispatch(setListings(res.data));
        history.push('/search');
      })
      .catch((err) => console.log(err));
  };
}
