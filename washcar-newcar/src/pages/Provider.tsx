import { Link } from 'react-router-dom';

const Provider = () => {
  const getCalendarList = () => {};

  return (
    <div>
      <button>매장정보 변경</button>
      <div>세차메뉴 입력</div>
      <div>+</div>
      <li>
        <button>
          <div>외부세차</div>
          <div>{'>'}</div>
        </button>
      </li>
      <li>
        <button>
          <div>외부 + 내부 세차</div>
          <div>{'>'}</div>
        </button>
      </li>
    </div>
  );
};

export default Provider;
