import Body from '../components/Body';
import Burgermenu from '../components/Burgermenu';
import Header from '../components/Header';

const Login = () => {
  return (
    <div>
      <Burgermenu />
      <Header />
      <Body>
        <a href="http://localhost:8080/oauth2/authorization/kakao">
          <img src="kakao_login_large_wide.png" style={{ width: 300 }}></img>
        </a>
      </Body>
    </div>
  );
};

export default Login;
