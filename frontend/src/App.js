import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Home from './Home';
import Header from './Header';
import './App.css';
import Footer from './Footer';
import SearchPage from './SearchPage';

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
        </Switch>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
