import React, { useState } from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import './Login.css';
import { useSelector, useDispatch } from 'react-redux';
import { asyncLogin } from '../features/authSlice';
import { useHistory } from 'react-router';
import { Alert, AlertTitle } from '@material-ui/lab';

export default function SignIn() {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');
  const notification = useSelector((state) => state.commonState.notification);

  const errors = useSelector((state) => state.auth.errors);
  const dispatch = useDispatch();
  const history = useHistory();

  function handleLogin(e) {
    e.preventDefault();
    dispatch(asyncLogin(history, userName, password));
  }

  return (
    <Container component="main" maxWidth="xs">
      <div className="login content">
        <Avatar className="login_avatar">
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Sign in
        </Typography>
        <form noValidate onSubmit={handleLogin}>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="username"
            label="username"
            name="username"
            autoComplete="username"
            autoFocus
            value={userName}
            onChange={(e) => setUserName(e.target.value)}
            error={errors && errors.userName ? true : false}
            helperText={errors && errors.userName ? errors.userName : ''}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="password"
            label="Password"
            type="password"
            id="password"
            autoComplete="current-password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <Button type="submit" fullWidth variant="contained">
            Sign In
          </Button>
          <Grid container>
            <Grid item>
              <Link href="#" variant="body2">
                {"Don't have an account? Sign Up"}
              </Link>
            </Grid>
          </Grid>
          {notification && (
            <Grid container>
              <Grid item>
                <Alert severity="warning">
                  <AlertTitle>Warning</AlertTitle>
                  {notification}
                </Alert>
              </Grid>
            </Grid>
          )}
        </form>
      </div>
    </Container>
  );
}
