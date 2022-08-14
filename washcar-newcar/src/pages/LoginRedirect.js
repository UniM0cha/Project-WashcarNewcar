import { useParams } from 'react-router-dom';

const LoginRedirect = () => {
  const { token } = useParams();

  return <div>{token}</div>;
};

export default LoginRedirect;
