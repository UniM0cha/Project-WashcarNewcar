import styles from './Search.module.scss';
import Datepicker from '../components/Datepicker';
import { IoIosArrowForward } from 'react-icons/io';
import { BsCheckCircleFill } from 'react-icons/bs';
import { Link } from 'react-router-dom';
import Item from '../components/Item';
import classNames from 'classnames';

const Search = () => {
  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <Link to="/">
          <img
            src="carwash.png"
            alt="carwash-logo"
            className={styles.carwash_logo}
          />
        </Link>
        <Link to="/">
          <img
            src="메인로고.png"
            alt="main-logo"
            className={styles.main_logo}
          />
        </Link>
      </div>
      <div className={styles.date}>
        <div className={styles.date_flex_container}>
          <div className={styles.left}>날짜 선택</div>
        </div>
        <Datepicker />
      </div>

      <div className={styles.flex_container}>
        <div className={styles.left}>지역 선택</div>
        <div className={styles.right}>
          서울 강남구
          <IoIosArrowForward size={30} />
        </div>
      </div>

      <div
        className={classNames(
          styles.flex_container,
          styles.time_flex_container
        )}
      >
        <div className={styles.left}>시간 선택</div>
        <div className={styles.right}>
          <BsCheckCircleFill className={styles.check_icon} />
          당일 가능 업체만
          <IoIosArrowForward size={30} />
        </div>
      </div>

      <Item />
      <Item />
      <Item />
      <Item />
      <Item />
    </div>
  );
};

export default Search;
