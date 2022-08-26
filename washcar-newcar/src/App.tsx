import './App.css';
import { IsBurgermenuOpenProvider } from './contexts/burgermenu';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Search from './pages/Search';
import Provider from './pages/Provider';
import Login from './pages/Login';
import Reservation from './pages/Reservation';
import LoginRedirect from './pages/LoginRedirect';
import Seller from './pages/Seller';
import LoginCheck from './pages/LoginCheck';

function App() {
  return (
    <IsBurgermenuOpenProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/search" element={<Search />} />
          <Route
            path="/provider"
            element={<LoginCheck next={<Provider />} />}
          />
          <Route path="/login" element={<Login />} />
          <Route path="/reservation" element={<Reservation />} />
          <Route path="/oauth2/redirect/:token" element={<LoginRedirect />} />
          <Route path="/seller" element={<Seller />} />
        </Routes>
      </BrowserRouter>
    </IsBurgermenuOpenProvider>
  );
}

export default App;
