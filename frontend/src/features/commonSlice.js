import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';

const commonSlice = createSlice({
  name: 'commonState',
  initialState: {
    showSearch: false,
    startDate: new Date().toString(),
    endDate: new Date().toString(),
    numberOfPeople: 1,
  },
  reducers: {
    setShowSearch: {
      reducer(state, { payload }) {
        state.showSearch = payload;
      },
    },
    setNumberOfPeople: {
      reducer(state, { payload }) {
        state.numberOfPeople = payload;
      },
    },
    setStartDate: {
      reducer(state, { payload }) {
        state.startDate = payload;
      },
    },
    setEndDate: {
      reducer(state, { payload }) {
        state.endDate = payload;
      },
    },
  },
});

export const {
  setShowSearch,
  setNumberOfPeople,
  setStartDate,
  setEndDate,
} = commonSlice.actions;
export default commonSlice.reducer;
