import { BeatLoader } from 'react-spinners';
import { MAIN_COLOR } from '../global_variables';
import styles from './Loading.module.css';

const Loading = () => {
  return (
    <div className={styles.container}>
      <BeatLoader color={MAIN_COLOR} />
    </div>
  );
};

export default Loading;
