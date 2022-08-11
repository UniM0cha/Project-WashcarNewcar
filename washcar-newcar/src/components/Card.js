import styles from './Card.module.css';

const Card = ({ type }) => {
  return <button className={styles.container}>{type}</button>;
};

export default Card;
