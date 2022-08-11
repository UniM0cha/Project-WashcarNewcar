import styles from './Burgermenu.module.css';
import { useContext } from 'react';
import IsBurgermenuOpenContext from '../contexts/burgermenu';
import { useEffect } from 'react';
import { useState } from 'react';

const Burgermenu = () => {
  const { isOpen, setIsOpen } = useContext(IsBurgermenuOpenContext);
  const [menuRight, setMenuRight] = useState(0);
  const [overlayOpacity, setOverlayOpacity] = useState('0%');

  useEffect(() => {
    if (isOpen) {
      setMenuRight(0);
      setOverlayOpacity('20%');
    } else {
      setMenuRight(-280);
      setOverlayOpacity('0%');
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
        }}
      ></div>
      <div className={styles.menu} style={{ right: menuRight }}>
        <button onClick={onClick}>X</button>
      </div>
    </div>
  );
};

export default Burgermenu;
