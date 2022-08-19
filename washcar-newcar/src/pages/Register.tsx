import { useEffect, useState } from 'react';
import { Navigate } from 'react-router-dom';
import Loading from '../components/Loading';
import { checkLogin } from '../functions/request';

const Register = () => {
  const [isLogind, setIsLogind] = useState(false);
  const [ready, setReady] = useState(false);

  useEffect(() => {
    runAsync();
  }, []);

  const runAsync = async () => {
    setIsLogind(await checkLogin());
    setReady(true);
  };

  if (!ready) {
    return (
      <div style={{ width: '100%', height: '100vh' }}>
        <Loading />
      </div>
    );
  }

  if (!isLogind) {
    return <Navigate to="/login" />;
  }

  return <div>등록 페이지</div>;
};

export default Register;
