import Body from '../components/Body';
import Burgermenu from '../components/Burgermenu';
import Datepicker from '../components/Datepicker';
import Header from '../components/Header';

const Search = () => {
  return (
    <div>
      <Burgermenu />
      <Header />
      <Body header>
        <Datepicker />
      </Body>
    </div>
  );
};

export default Search;
