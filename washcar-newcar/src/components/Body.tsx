import styles from './Body.module.css';

interface BodyProps {
  children: any;
  header?: boolean;
}

const Body = ({ children, header = false }: BodyProps) => {
  if (header) {
    return <div className={styles.container_with_header}>{children}</div>;
  } else {
    return <div className={styles.container}>{children}</div>;
  }
};

export default Body;
