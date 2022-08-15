import { useEffect, useState } from 'react';
import { Navigate } from 'react-router-dom';
import Body from '../components/Body';
import Burgermenu from '../components/Burgermenu';
import Header from '../components/Header';
import { API_SERVER } from '../global_variables';

const Register = () => {
  const [isLogind, setIsLogind] = useState(false);
  const [ready, setReady] = useState(false);
  const jwt = {
    Authorization: 'Bearer ' + localStorage.getItem('jwt'),
  };

  useEffect(() => {
    checkLogin();
  }, []);

  const checkLogin = async () => {
    const response = await fetch(`${API_SERVER}/auth/check`, {
      method: 'post',
      headers: jwt,
    });
    const data = await response.json();
    console.log(`data : ` + data);
    setIsLogind(data);
    setReady(true);
  };

  if (!ready) {
    return <div>loading...</div>;
  }

  if (!isLogind) {
    return <Navigate to="/login" />;
  }

  return (
    <div>
      <Burgermenu />
      <Header />
      <Body>등록 페이지</Body>
    </div>
  );
};

export default Register;
