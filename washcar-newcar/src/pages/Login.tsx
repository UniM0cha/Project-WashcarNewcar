const Login = () => {
  return (
    <div>
      <a href={process.env.REACT_APP_API + '/oauth2/authorization/kakao'}>
        <img
          src="kakao_login_large_wide.png"
          alt="카카오 로그인"
          style={{ width: 300 }}
        ></img>
      </a>
    </div>
  );
};

export default Login;
