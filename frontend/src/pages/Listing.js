import { LocationOn, Star } from '@material-ui/icons';
import React from 'react';
import { Gallery, Item } from 'react-photoswipe-gallery';
import 'photoswipe/dist/photoswipe.css';
import 'photoswipe/dist/default-skin/default-skin.css';
import './Listing.css';

function Listing() {
  return (
    <div className="listing content">
      <h2>CHAMBRE ENSOLEILLÉE ET CONFORTABLE // PRIVATE ROOM</h2>
      <div className="listing__infos-top">
        <Star /> 4.15 . <LocationOn /> Agadir, Souss-Massa-Draâ, Morocco
      </div>

      <Gallery>
        <div className="listing__gallery">
          <Item
            original="https://placekitten.com/1024/768?image=1"
            thumbnail="https://placekitten.com/1024/768?image=1"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=1"
              />
            )}
          </Item>
          <Item
            original="https://placekitten.com/1024/768?image=2"
            thumbnail="https://placekitten.com/1024/768?image=2"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=2"
              />
            )}
          </Item>
          <Item
            original="https://placekitten.com/1024/768?image=3"
            thumbnail="https://placekitten.com/1024/768?image=3"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=3"
              />
            )}
          </Item>
          <Item
            original="https://placekitten.com/1024/768?image=4"
            thumbnail="https://placekitten.com/1024/768?image=4"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=4"
              />
            )}
          </Item>
          <Item
            original="https://placekitten.com/1024/768?image=5"
            thumbnail="https://placekitten.com/1024/768?image=5"
            width="1024"
            height="768"
          >
            {({ ref, open }) => (
              <img
                alt="cats"
                ref={ref}
                onClick={open}
                src="https://placekitten.com/1024/768?image=5"
              />
            )}
          </Item>
        </div>
      </Gallery>
    </div>
  );
}

export default Listing;
