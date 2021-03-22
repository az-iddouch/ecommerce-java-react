import React, { useState } from 'react';
import SearchIcon from '@material-ui/icons/Search';
import { Avatar, Button } from '@material-ui/core';
import Search from './Search';
import './Header.css';

function Header() {
  const [showSearch, setShowSearch] = useState(false);
  return (
    <div className="header">
      <div className="header__logo">
        <p>VASH</p>
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
        <p>Become a host</p>
        <Avatar />
      </div>
    </div>
  );
}

export default Header;
