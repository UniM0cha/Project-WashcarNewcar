import { useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const LoginRedirect = () => {
  const { token } = useParams<{ token: string }>();
  const navigate = useNavigate();
  
  useEffect(() => {
    if (!token) {
      navigate('/');
      return;
    }

    localStorage.clear();
    localStorage.setItem('jwt', token);
    navigate('/');
    return;
  }, []);

  return null;
};

export default LoginRedirect;
