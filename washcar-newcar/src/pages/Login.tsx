import Burgermenu from '../components/Burgermenu';
import Header from '../components/Header';

const Login = () => {
  return (
    <div>
      <div style={{ paddingTop: '80px' }}>
        <a href="http://localhost:8080/oauth2/authorization/kakao">
          <img src="kakao_login_large_wide.png" style={{ width: 300 }}></img>
        </a>
      </div>
    </div>
  );
};

export default Login;
