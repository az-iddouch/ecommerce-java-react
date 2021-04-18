import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';
import { setNotification } from '../features/commonSlice';

const reservationSlice = createSlice({
  name: 'reservationState',
  initialState: { reservation: null },
  reducers: {
    setReservation: {
      reducer(state, { payload }) {
        state.reservation = payload;
      },
    },
  },
});

export const { setReservation } = reservationSlice.actions;
export default reservationSlice.reducer;

export function makeReservation(
  startDate,
  endDate,
  numberOfPeople,
  propertyId,
  history
) {
  return async (dispatch) => {
    await axios
      .post('http://localhost:9091/api/reservation/save', null, {
        params: {
          numberPersons: numberOfPeople,
          dateStart: startDate,
          dateEnd: endDate,
          idProperty: propertyId,
        },
      })
      .then((res) => {
        dispatch(setReservation(res.data));
      })
      .catch((err) => {
        if (err.response.status === 403) {
          dispatch(
            setNotification('You should be logged in to make a reservation !')
          );
          history.push('/login');
        }
      });
  };
}
