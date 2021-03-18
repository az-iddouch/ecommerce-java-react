import React from 'react';
import SearchIcon from '@material-ui/icons/Search';
import { Avatar } from '@material-ui/core';
import './Header.css';

function Header() {
  return (
    <div className="header">
      <div className="header__logo">
        <p>VASH</p>
      </div>
      <div className="header__center">
        <input type="text" />
        <div className="header__search-btn">
          <SearchIcon />
        </div>
      </div>
      <div className="header__right">
        <p>Become a host</p>
        <Avatar />
      </div>
    </div>
  );
}

export default Header;
