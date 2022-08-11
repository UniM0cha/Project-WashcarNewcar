import Card from './Card';
import styles from './MainBody.module.css';

const MainBody = () => {
  return (
    <div className={styles.container}>
      <div className={styles.card_grid}>
        <Card type="세차하기" />
        <Card type="예약하기" />
        <Card type="등록하기" />
      </div>
    </div>
  );
};

export default MainBody;
