import classNames from 'classnames/bind';
import { FiMenu } from 'react-icons/fi';
import styles from './Header.module.css';
import { useContext } from 'react';
import IsBurgermenuOpenContext from '../contexts/burgermenu';

const cx = classNames.bind(styles);

const Header = () => {
  const { isOpen, setIsOpen } = useContext(IsBurgermenuOpenContext);
  const onClick = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className={styles.container}>
      <div className={styles.left}>
        <img className={styles['main-logo']} src="메인로고.png" alt="로고" />
      </div>
      <div className={styles.center}>
        <img className={cx('text-logo')} src="세차새차.png" alt="세차새차" />
      </div>
      <div className={styles.right}>
        <button onClick={onClick}>
          <FiMenu />
        </button>
      </div>
    </div>
  );
};

export default Header;
