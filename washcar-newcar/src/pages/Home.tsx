import Body from '../components/Body';
import Burgermenu from '../components/Burgermenu';
import Header from '../components/Header';
import CardGrid from '../components/CardGrid';

const Home = () => {
  return (
    <div>
      <Burgermenu />
      <Header />
      <Body header>
        <CardGrid />
      </Body>
    </div>
  );
};

export default Home;
