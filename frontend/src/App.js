import React, { useEffect } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Home from './pages/Home';
import Header from './components/Header';
import './App.css';
import Footer from './components/Footer';
import SearchPage from './pages/SearchPage';
import Listing from './pages/Listing';
import Login from './pages/Login';
import Register from './pages/Register';
import Dashboard from './pages/Dashboard';
import setJWTToken from './securityUtils';
import { useDispatch } from 'react-redux';
import { login } from './features/authSlice';
import axios from 'axios';

function App() {
  const dispatch = useDispatch();

  async function ping() {
    try {
      const res = await axios('http://localhost:9091/api/ping');
      console.log(res.data);
    } catch (err) {
      console.error('!!!!!!' + err);
    }
  }

  useEffect(() => {
    ping();
  }, []);

  let user = localStorage.getItem('user');
  if (user) {
    user = JSON.parse(localStorage.getItem('user'));
    setJWTToken(user.token);
    dispatch(login(user));
  }
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/">
            <Header />
            <Home />
            <Footer />
          </Route>
          <Route path="/search">
            <Header />
            <SearchPage />
            <Footer />
          </Route>
          <Route path="/listings">
            <Header />
            <Listing />
            <Footer />
          </Route>
          <Route path="/login">
            <Header />
            <Login />
            <Footer />
          </Route>
          <Route path="/register">
            <Header />
            <Register />
            <Footer />
          </Route>
          <Route exact path="/dashboard">
            <Dashboard />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
