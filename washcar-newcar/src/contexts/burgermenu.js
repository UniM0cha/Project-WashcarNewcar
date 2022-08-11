import { useState } from 'react';
import { createContext } from 'react';

const IsBurgermenuOpenContext = createContext({
  isOpen: false,
  setIsOpen: () => {},
});

const IsBurgermenuOpenProvider = ({ children }) => {
  const [isOpen, setIsOpen] = useState(false);
  const value = { isOpen: isOpen, setIsOpen: setIsOpen };
  return (
    <IsBurgermenuOpenContext.Provider value={value}>
      {children}
    </IsBurgermenuOpenContext.Provider>
  );
};

export { IsBurgermenuOpenProvider };
export default IsBurgermenuOpenContext;
