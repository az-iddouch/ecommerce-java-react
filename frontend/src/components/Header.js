import React, { useState } from 'react';
import SearchIcon from '@material-ui/icons/Search';
import { Avatar, Button } from '@material-ui/core';
import Search from './Search';
import './Header.css';
import { Link } from 'react-router-dom';

function Header() {
  const [showSearch, setShowSearch] = useState(false);
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
          onClick={() => setShowSearch(!showSearch)}
        >
          {showSearch ? 'Hide search' : 'Start your search'}
          <SearchIcon />
        </Button>
        <div className="header__search">{showSearch && <Search />}</div>
      </div>
      <div className="header__right">
        <Link to="/login">Login</Link>
        <Link to="/register">Register</Link>
        <Avatar />
      </div>
    </div>
  );
}

export default Header;
