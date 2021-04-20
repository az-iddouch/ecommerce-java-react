import { combineReducers } from 'redux';
import authReducer from '../features/authSlice';
import cityReducer from '../features/citySlice';
import common from '../features/commonSlice';
import reservationSlice from '../features/reservationSlice';
export default combineReducers({
  auth: authReducer,
  cityData: cityReducer,
  commonState: common,
  reservationState: reservationSlice,
});
