import React, { useState } from 'react';
import SearchIcon from '@material-ui/icons/Search';
import { Avatar, Button } from '@material-ui/core';
import Search from './Search';
import './Header.css';
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { setShowSearch } from '../features/commonSlice';
import { login } from '../features/authSlice';

function Header() {
  const user = useSelector((state) => state.auth.user);
  const showSearch = useSelector((state) => state.commonState.showSearch);
  const dispatch = useDispatch();

  function handleLogout() {
    if (localStorage.getItem('user') != null) {
      localStorage.removeItem('user');
    }
    dispatch(login(null));
  }

  return (
    <div className="header">
      <div className="header__logo">
        <Link to="/">
          <p>VASH</p>
        </Link>
      </div>
      <div className="header__center">
        <Button
          className="header__search-btn"
          onClick={() => dispatch(setShowSearch(!showSearch))}
        >
          {showSearch ? 'Hide search' : 'Start your search'}
          <SearchIcon />
        </Button>
        <div className="header__search">{showSearch && <Search />}</div>
      </div>
      {user ? (
        <div className="header__right">
          <Link to="/dashboard">{user.fullName}</Link>
          <p onClick={handleLogout}>Logout</p>
          <Avatar />
        </div>
      ) : (
        <div className="header__right">
          <Link to="/login">Login</Link>
          <Link to="/register">Register</Link>
          <Avatar />
        </div>
      )}
    </div>
  );
}

export default Header;
