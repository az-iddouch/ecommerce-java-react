import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';

const commonSlice = createSlice({
  name: 'commonState',
  initialState: {
    showSearch: false,
    startDate: new Date().toString(),
    endDate: new Date().toString(),
    numberOfPeople: 1,
    notification: null,
    selectedPropertyId: null,
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
    setNotification: {
      reducer(state, { payload }) {
        state.notification = payload;
      },
    },
    setSelectedPropertyId: {
      reducer(state, { payload }) {
        state.selectedPropertyId = payload;
      },
    },
  },
});

export const {
  setShowSearch,
  setNumberOfPeople,
  setStartDate,
  setEndDate,
  setNotification,
  setSelectedPropertyId,
} = commonSlice.actions;
export default commonSlice.reducer;
