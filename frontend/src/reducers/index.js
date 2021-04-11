import { combineReducers } from 'redux';
import authReducer from '../features/authSlice';
import cityReducer from '../features/citySlice';
export default combineReducers({
  auth: authReducer,
  cityData: cityReducer,
});
