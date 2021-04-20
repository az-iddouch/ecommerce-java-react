import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';
import { setNotification } from '../features/commonSlice';

const reservationSlice = createSlice({
  name: 'reservationState',
  initialState: { reservation: null, success: null },
  reducers: {
    setReservation: {
      reducer(state, { payload }) {
        state.reservation = payload;
      },
    },
    setSuccess: {
      reducer(state, { payload }) {
        state.success = payload;
      },
    },
  },
});

export const { setReservation, setSuccess } = reservationSlice.actions;
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
        dispatch(setSuccess('Your reservation was successful !'));
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
