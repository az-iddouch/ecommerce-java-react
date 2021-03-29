import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Home from './pages/Home';
import Header from './components/Header';
import './App.css';
import Footer from './components/Footer';
import SearchPage from './pages/SearchPage';
import Listing from './pages/Listing';

function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route path="/search">
            <SearchPage />
          </Route>
          <Route path="/listings/:id">
            <Listing />
          </Route>
        </Switch>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
