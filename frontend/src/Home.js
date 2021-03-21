import React from 'react';
import './Home.css';
import Banner from './Banner';
import CityCard from './CityCard';
import ImgCard from './ImgCard';
import Footer from './Footer.js';
import villa from './images/villa.jpg';
import house from './images/house.jpg';
import studio from './images/studio.jpg';
import appartment from './images/appartment.jpg';

function Home() {
  return (
    <div className="home">
      <Banner />
      <div className="home__section">
        <h1 className="home__section-title">Explore nearby</h1>
        <div className="home__section-contents home__section-contents--explore">
          <CityCard
            cityName="Agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
            numberOfPostings={100}
          />
          <CityCard
            cityName="Agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
            numberOfPostings={100}
          />
          <CityCard
            cityName="Agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
            numberOfPostings={100}
          />
          <CityCard
            cityName="Agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
            numberOfPostings={100}
          />
          <CityCard
            cityName="Agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
            numberOfPostings={100}
          />
          <CityCard
            cityName="Agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
            numberOfPostings={100}
          />
          <CityCard
            cityName="Agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
            numberOfPostings={100}
          />
          <CityCard
            cityName="Agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
            numberOfPostings={100}
          />
        </div>
      </div>

      <div className="home__section">
        <h1 className="home__section-title">Live anywhere</h1>
        <div className="home__section-contents home__section-contents--live">
          <ImgCard src={villa} title="Villa" />
          <ImgCard src={house} title="House" />
          <ImgCard src={studio} title="Studio" />
          <ImgCard src={appartment} title="Appartment" />
        </div>
      </div>
      <Footer />
    </div>
  );
}

export default Home;
