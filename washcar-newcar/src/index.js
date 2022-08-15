import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { IsBurgermenuOpenProvider } from './contexts/burgermenu';
import Home from './pages/Home';
import Wash from './pages/Wash';
import Register from './pages/Register';
import Reservation from './pages/Reservation';
import LoginRedirect from './pages/LoginRedirect';
import Login from './pages/Login';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
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
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
