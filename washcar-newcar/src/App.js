import styles from './App.module.css';
import Burgermenu from './components/Burgermenu';
import Header from './components/Header';
import MainBody from './components/MainBody';
import { IsBurgermenuOpenProvider } from './contexts/burgermenu';

function App() {
  return (
    <IsBurgermenuOpenProvider>
      <div className={styles.App}>
        <Burgermenu />
        <Header />
        <MainBody />
      </div>
    </IsBurgermenuOpenProvider>
  );
}

export default App;
