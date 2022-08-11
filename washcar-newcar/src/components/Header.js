import { useEffect, useRef, useState } from 'react';
import { FiMenu } from 'react-icons/fi';
import styles from './Header.module.css';
import Sidebar from './Sidebar';

const Header = ({ children }) => {
  const width = 280;
  const [isOpen, setOpen] = useState(false);
  const [xPosition, setX] = useState(-width);
  const side = useRef();

  // button 클릭 시 토글
  const toggleMenu = () => {
    console.log('??');
    if (isOpen === false) {
      console.log('???');
      setX(0);
      setOpen(true);
    } else {
      setX(-width);
      setOpen(false);
    }
  };

  // 사이드바 외부 클릭시 닫히는 함수
  const handleClose = (e) => {
    let sideArea = side.current;
    let sideCildren = side.current.contains(e.target);
    if (isOpen && (!sideArea || !sideCildren)) {
      setX(-width);
      setOpen(false);
    }
  };

  useEffect(() => {
    window.addEventListener('click', handleClose);
    return () => {
      window.removeEventListener('click', handleClose);
    };
  });

  return (
    <div className={styles.container}>
      <div className={styles.left}>
        <img className={styles.mainLogo} src="메인로고.png" />
      </div>
      <div className={styles.center}>
        <img className={styles.textLogo} src="세차새차.png" />
      </div>
      <div className={styles.right}>
        <button onClick={() => toggleMenu()}>
          <FiMenu />
        </button>
      </div>

      <div
        ref={side}
        className={styles.sidebar}
        style={{
          width: `${width}px`,
          height: '100%',
          transform: `translatex(${-xPosition}px)`,
        }}
      >
        {/* <button onClick={() => toggleMenu()} className={styles.button}>
          {isOpen ? <span>X</span> : <img className={styles.openBtn} />}
        </button> */}
        <button onClick={() => toggleMenu()}>X</button>
        <div className={styles.content}>{children}</div>
      </div>
    </div>
  );
};

export default Header;
