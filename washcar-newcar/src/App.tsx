import React from 'react';
import logo from './logo.svg';
import './App.css';
import { IsBurgermenuOpenProvider } from './contexts/burgermenu';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Wash from './pages/Wash';
import Register from './pages/Register';
import Login from './pages/Login';
import Reservation from './pages/Reservation';
import LoginRedirect from './pages/LoginRedirect';

function App() {
  return (
    <IsBurgermenuOpenProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/wash" element={<Wash />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/reservation" element={<Reservation />} />
          <Route path="/oauth2/redirect/:token" element={<LoginRedirect />} />
        </Routes>
      </BrowserRouter>
    </IsBurgermenuOpenProvider>
  );
}

export default App;
