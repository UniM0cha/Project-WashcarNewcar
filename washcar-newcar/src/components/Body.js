import styles from './Body.module.css';

const Body = ({ children }) => {
  return <div className={styles.container}>{children}</div>;
};

export default Body;
