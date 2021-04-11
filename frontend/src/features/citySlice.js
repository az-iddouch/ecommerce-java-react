import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';

const citySlice = createSlice({
  name: 'cityData',
  initialState: { allCities: [] },
  reducers: {
    setAllCities: {
      reducer(state, { payload }) {
        state.cities = payload;
      },
    },
  },
});

export const { setAllCities } = citySlice.actions;
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
