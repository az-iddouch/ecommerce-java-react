import React, { useState } from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import { useSelector, useDispatch } from 'react-redux';
import { asyncRegister, setErrors } from '../features/authSlice';
import { useHistory } from 'react-router';

const useStyles = makeStyles((theme) => ({
  paper: {
    marginTop: theme.spacing(8),
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },

  form: {
    width: '100%',
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
    backgroundColor: '#00d382',
    '&:hover': {
      backgroundColor: '#00d382',
    },
  },
}));

export default function SignUp() {
  const classes = useStyles();

  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const [passwordConfirm, setPasswordConfirm] = useState('');
  const [phoneNumber1, setPhoneNumber1] = useState('');
  const [phoneNumber2, setPhoneNumber2] = useState('');

  const errors = useSelector((state) => state.auth.errors);
  const dispatch = useDispatch();
  const history = useHistory();

  function submitRegister(event) {
    event.preventDefault();

    let valid = true;

    // password match validation
    [...password].forEach((char, i) => {
      if (char !== passwordConfirm.charAt(i)) {
        valid = false;
      }
    });

    if (valid) {
      dispatch(
        asyncRegister(
          history,
          firstName,
          lastName,
          email,
          userName,
          phoneNumber1,
          phoneNumber2,
          password
        )
      );
    } else {
      setPasswordConfirm('');
      setPassword('');
      dispatch(setErrors({ password: 'password does not match !' }));
    }
  }

  return (
    <Container component="main" maxWidth="xs">
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Sign up
        </Typography>
        <form className={classes.form} onSubmit={submitRegister} noValidate>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <TextField
                autoComplete="fname"
                name="firstName"
                value={firstName}
                variant="outlined"
                fullWidth
                id="firstName"
                label="First Name*"
                autoFocus
                onChange={(e) => setFirstName(e.target.value)}
                error={errors && errors.firstName ? true : false}
                helperText={errors && errors.firstName ? errors.firstName : ''}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                variant="outlined"
                fullWidth
                value={lastName}
                id="lastName"
                label="Last Name*"
                name="lastName"
                autoComplete="lname"
                onChange={(e) => setLastName(e.target.value)}
                error={errors && errors.lastName ? true : false}
                helperText={errors && errors.lastName ? errors.lastName : ''}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                fullWidth
                id="email"
                label="Email Address*"
                value={email}
                name="email"
                autoComplete="email"
                onChange={(e) => setEmail(e.target.value)}
                error={errors && errors.email ? true : false}
                helperText={errors && errors.email ? errors.email : ''}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                fullWidth
                id="username"
                label="Username*"
                value={userName}
                name="username"
                autoComplete="username"
                onChange={(e) => setUserName(e.target.value)}
                error={errors && errors.userName ? true : false}
                helperText={errors && errors.userName ? errors.userName : ''}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                fullWidth
                id="telephone1"
                label="PhoneNumber1*"
                value={phoneNumber1}
                name="telephone"
                autoComplete="telephone1"
                onChange={(e) => setPhoneNumber1(e.target.value.slice(0, 10))}
                error={errors && errors.phoneNumber1 ? true : false}
                helperText={
                  errors && errors.phoneNumber1 ? errors.phoneNumber1 : ''
                }
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                fullWidth
                id="telephone2"
                label="PhoneNumber2"
                name="telephone2"
                value={phoneNumber2}
                autoComplete="telephone2"
                onChange={(e) => setPhoneNumber2(e.target.value.slice(0, 10))}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                fullWidth
                name="password"
                label="Password*"
                type="password"
                value={password}
                id="password"
                autoComplete="current-password"
                onChange={(e) => setPassword(e.target.value)}
                error={errors && errors.password ? true : false}
                helperText={errors && errors.password ? errors.password : ''}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                variant="outlined"
                fullWidth
                name="confirmPasswd"
                label="Confirm password*"
                value={passwordConfirm}
                type="password"
                id="confirmPasswd"
                autoComplete="confirm-password"
                onChange={(e) => setPasswordConfirm(e.target.value)}
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className={classes.submit}
          >
            Sign Up
          </Button>
          <Grid container justify="flex-end">
            <Grid item>
              <Link href="/login" variant="body2">
                Already have an account? Sign in
              </Link>
            </Grid>
          </Grid>
        </form>
      </div>
    </Container>
  );
}
