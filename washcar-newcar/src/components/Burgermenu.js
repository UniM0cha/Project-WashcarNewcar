import styles from './Burgermenu.module.css';
import { useContext } from 'react';
import IsBurgermenuOpenContext from '../contexts/burgermenu';
import { useEffect } from 'react';
import { useState } from 'react';

const Burgermenu = () => {
  const width = 250;
  const { isOpen, setIsOpen } = useContext(IsBurgermenuOpenContext);
  const [menuRight, setMenuRight] = useState(-width);
  const [overlayOpacity, setOverlayOpacity] = useState('0%');
  const [overlayPointEvent, setOverlayPointEvent] = useState('none');

  useEffect(() => {
    if (isOpen) {
      setMenuRight(0);
      setOverlayOpacity('20%');
      setOverlayPointEvent('all');
    } else {
      setMenuRight(-width);
      setOverlayOpacity('0%');
      setOverlayPointEvent('none');
    }
  }, [isOpen]);

  const onClick = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className={styles.container}>
      <div
        className={styles.overlay}
        style={{
          opacity: overlayOpacity,
          pointerEvents: overlayPointEvent,
        }}
        onClick={onClick}
      ></div>
      <div
        className={styles.menu}
        style={{
          right: menuRight,
          width: width,
        }}
      >
        <button onClick={onClick}>X</button>
      </div>
    </div>
  );
};

export default Burgermenu;
