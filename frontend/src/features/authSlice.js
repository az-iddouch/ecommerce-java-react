import { ContactSupportOutlined } from '@material-ui/icons';
import { createSlice } from '@reduxjs/toolkit';
import axios from 'axios';
import setJWTToken from '../securityUtils';

const authSlice = createSlice({
  name: 'auth',
  initialState: { user: null, errors: null },
  reducers: {
    register: {
      reducer(state, { payload }) {
        state.user = payload;
      },
    },
    login: {
      reducer(state, { payload }) {
        state.user = payload;
      },
    },
    setErrors: {
      reducer(state, { payload }) {
        state.errors = payload;
      },
    },
  },
});

export const { register, setErrors, login } = authSlice.actions;
export default authSlice.reducer;

export function asyncLogin(history, userName, password) {
  return async (dispatch) => {
    await axios
      .post('http://localhost:9091/api/users/login', null, {
        params: {
          userName,
          password,
        },
      })
      .then((res) => {
        dispatch(login(res.data));
        localStorage.setItem('user', JSON.stringify(res.data));
        setJWTToken(res.data.token);
        dispatch(setErrors(null));
        history.push('/');
      })
      .catch((err) => dispatch(setErrors(err.response.data)));
  };
}

export function asyncRegister(
  history,
  firstName,
  lastName,
  email,
  userName,
  phoneNumber1,
  phoneNumber2,
  password
) {
  return async (dispatch) => {
    await axios
      .post('http://localhost:9091/api/users/register', {
        history,
        firstName,
        lastName,
        email,
        userName,
        phoneNumber1,
        phoneNumber2,
        password,
      })
      .then((res) => {
        dispatch(register(res.data));
        dispatch(setErrors(null));
        localStorage.setItem('user', JSON.stringify(res.data));
        setJWTToken(res.data.token);
        history.push('/');
      })
      .catch((err) => {
        dispatch(setErrors(err.response.data));
      });
  };
}
