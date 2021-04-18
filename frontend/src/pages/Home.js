import React, { useEffect } from 'react';
import './Home.css';
import Banner from '../components/Banner';
import CityCard from '../components/CityCard';
import ImgCard from '../components/ImgCard';
import villa from '../images/villa.jpg';
import house from '../images/house.jpg';
import studio from '../images/studio.jpg';
import appartment from '../images/appartment.jpg';
import { getTopCities } from '../features/citySlice';
import { useSelector } from 'react-redux';

function Home() {
  const topCities = useSelector((state) => state.cityData.allCities);

  useEffect(() => {
    // fetch cities
    getTopCities();
  }, []);

  return (
    <div className="home">
      <Banner />
      <div className="home__section">
        <h1 className="home__section-title">explore nearby</h1>
        <div className="home__section-contents home__section-contents--explore">
          {topCities &&
            topCities.map((city) => (
              <CityCard
                cityName={city.nameCity}
                src="https://www.visitmorocco.com/sites/default/files/styles/thumbnail_destination_background_top5/public/thumbnails/image/la-mosquee-hassan-ii-au-coucher-du-soleil-a-casablanca-maroc.jpg?itok=-kg3FRws"
                numberOfPostings={city.counter}
              />
            ))}
          {/* <CityCard
            cityName="TANGER"
            src="https://www.h24info.ma/wp-content/uploads/2019/02/tanger.png"
            numberOfPostings={3}
          />
          <CityCard
            cityName="IFRANE"
            src="https://upload.wikimedia.org/wikipedia/commons/7/71/Neige_ifrane.jpg"
            numberOfPostings={31}
          />
          <CityCard
            cityName="MARRAKECH"
            src="https://static.yabiladi.com/files/articles/90663_b719be9c06a166ad7f16889d5ebc0db220200316172647_thumb_565.jpeg"
            numberOfPostings={30}
          />
          <CityCard
            cityName="EL-JADIDA"
            src="https://www.visitmorocco.com/sites/default/files/styles/thumbnail_events_slider/public/thumbnails/image/port-mazagan-eljadida.jpg?itok=z-rl3ips"
            numberOfPostings={15}
          />
          <CityCard
            cityName="AGADIR"
            src="https://i.le360.ma/fr/sites/default/files/styles/image_la_une_on_home_page/public/assets/images/2020/07/marina-d-agadir.jpg"
            numberOfPostings={20}
          />
          <CityCard
            cityName="MEKNES"
            src="https://www.h24info.ma/wp-content/uploads/2018/10/28c66fb60b85b28db60dc883a5a4f206-meknes.jpg"
            numberOfPostings={17}
          />
          <CityCard
            cityName="DAKHLA"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpAahDXAfhIoN6yzCLfirWtcpgGBTG97Z0Hs7TLC8nRLZsv6jX8u3U207--ZyaqZFf9Ik&usqp=CAU"
            numberOfPostings={100}
          /> */}
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
