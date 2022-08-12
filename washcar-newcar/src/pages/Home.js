import Body from '../components/Body';
import Burgermenu from '../components/Burgermenu';
import Header from '../components/Header';
import MainBody from '../components/MainBody';

const Home = () => {
  return (
    <div>
      <Burgermenu />
      <Header />
      <Body>
        <MainBody />
      </Body>
    </div>
  );
};

export default Home;
