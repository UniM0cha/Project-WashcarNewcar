import { FiMenu } from 'react-icons/fi';
import styles from './Header.module.css';
import { useContext } from 'react';
import IsBurgermenuOpenContext from '../contexts/burgermenu';
import { Link } from 'react-router-dom';

const Header = () => {
  const { isOpen, setIsOpen } = useContext(IsBurgermenuOpenContext);
  const onClick = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className={styles.container}>
      <div className={styles.left}>
        <Link to="/">
          <img className={styles.main_logo} src="메인로고.png" alt="로고" />
        </Link>
      </div>
      <div className={styles.center}>
        <Link to="/">
          <img className={styles.text_logo} src="세차새차.png" alt="세차새차" />
        </Link>
      </div>
      <div className={styles.right}>
        <button className={styles.menubutton} onClick={onClick}>
          <FiMenu color="#2964F6" strokeWidth={3} size={'100%'} />
        </button>
      </div>
    </div>
  );
};

export default Header;
