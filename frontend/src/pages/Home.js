import React, { useEffect } from 'react';
import './Home.css';
import Banner from '../components/Banner';
import CityCard from '../components/CityCard';
import ImgCard from '../components/ImgCard';
import villa from '../images/villa.jpg';
import house from '../images/house.jpg';
import studio from '../images/studio.jpg';
import appartment from '../images/appartment.jpg';
import { getAllCities } from '../features/citySlice';
import { useDispatch, useSelector } from 'react-redux';

function Home() {
  const dispatch = useDispatch();
  const cities = useSelector((state) => state.cityData.allCities);

  useEffect(() => {
    dispatch(getAllCities());
  }, [dispatch]);

  console.log(cities);

  return (
    <div className="home">
      <Banner />
      <div className="home__section">
        <h1 className="home__section-title">explore nearby</h1>
        <div className="home__section-contents home__section-contents--explore">
          <CityCard
            cityName="agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9hznufnz37ncjekamz-b4co_zraykcacj75_i="
            numberOfPostings={100}
          />
          <CityCard
            cityName="agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9hznufnz37ncjekamz-b4co_zraykcacj75_i="
            numberOfPostings={100}
          />
          <CityCard
            cityName="agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9hznufnz37ncjekamz-b4co_zraykcacj75_i="
            numberOfPostings={100}
          />
          <CityCard
            cityName="agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9hznufnz37ncjekamz-b4co_zraykcacj75_i="
            numberOfPostings={100}
          />
          <CityCard
            cityName="agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9hznufnz37ncjekamz-b4co_zraykcacj75_i="
            numberOfPostings={100}
          />
          <CityCard
            cityName="agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9hznufnz37ncjekamz-b4co_zraykcacj75_i="
            numberOfPostings={100}
          />
          <CityCard
            cityName="agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9hznufnz37ncjekamz-b4co_zraykcacj75_i="
            numberOfPostings={100}
          />
          <CityCard
            cityName="agadir"
            src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9hznufnz37ncjekamz-b4co_zraykcacj75_i="
            numberOfPostings={100}
          />
        </div>
      </div>

      <div className="home__section">
        <h1 className="home__section-title">live anywhere</h1>
        <div className="home__section-contents home__section-contents--live">
          <ImgCard src={villa} title="villa" />
          <ImgCard src={house} title="house" />
          <ImgCard src={studio} title="studio" />
          <ImgCard src={appartment} title="appartment" />
        </div>
      </div>
    </div>
  );
}

export default Home;
