const API_SERVER = process.env.REACT_APP_API;

interface Parameter {
  path: string;
  options: object;
}

export const checkLogin = async (): Promise<boolean> => {
  const token = {
    Authorization: 'Bearer ' + localStorage.getItem('token'),
  };

  if (!token) return false;

  const response = await fetch(`${API_SERVER}/auth/check`, {
    method: 'post',
    headers: token,
  });
  return (await response.json()) as boolean;
};

export const requestWithToken = async ({
  path,
  options,
}: Parameter): Promise<any> => {
  const token = {
    Authorization: 'Bearer ' + localStorage.getItem('token'),
  };

  if (!token) return false;

  const response = await fetch(`${API_SERVER}${path}`, {
    ...options,
    headers: token,
  });
  return await response.json();
};
