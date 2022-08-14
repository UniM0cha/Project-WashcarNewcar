import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Body from '../components/Body';
import Burgermenu from '../components/Burgermenu';
import Header from '../components/Header';

const Register = () => {
  const [isLogind, setIsLogind] = useState(false);
  const navigate = useNavigate();

  const checkLogin = async () => {
    const response = await fetch('http://localhost:8080/auth/check', {
      method: 'post',
    });
    const data = await response.json();
    console.log(data);
  };

  return (
    <div>
      <Burgermenu />
      <Header />
      <Body>
        <button onClick={checkLogin}>로그인 체크</button>
        <a href="http://localhost:8080/oauth2/authorization/kakao">
          <button>로그인</button>
        </a>

        <Link to="/login">
          <img src="kakao_login_large_wide.png" style={{ width: 300 }}></img>
        </Link>
      </Body>
    </div>
  );
};

export default Register;
