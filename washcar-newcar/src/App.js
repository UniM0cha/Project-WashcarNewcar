import styles from './App.module.css';
import Burgermenu from './components/Burgermenu';
import Header from './components/Header';
import { IsBurgermenuOpenProvider } from './contexts/burgermenu';

function App() {
  return (
    <IsBurgermenuOpenProvider>
      <div className={styles.App}>
        <Burgermenu />
        <Header />
      </div>
    </IsBurgermenuOpenProvider>
  );
}

export default App;
