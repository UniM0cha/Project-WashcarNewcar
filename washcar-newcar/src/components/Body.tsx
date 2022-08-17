import styles from './Body.module.css';

interface BodyProps {
  children: any;
}

const Body = ({ children } : BodyProps) => {
  return <div className={styles.container}>{children}</div>;
};

export default Body;
