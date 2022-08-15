import { useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const LoginRedirect = () => {
  const { token } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    localStorage.clear();
    localStorage.setItem('jwt', token);
    navigate('/');
  }, []);

  return <></>;
};

export default LoginRedirect;
