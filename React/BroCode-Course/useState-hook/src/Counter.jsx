import { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);

  const incrementCounter = () => {
    setCount(count + 1);
  };

  const incrementCounterByTen = () => {
    setCount(count + 10);
  };

  const decrementCounter = () => {
    setCount(count - 1);
  };

  const decrementCounterByTen = () => {
    setCount(count - 10);
  };

  const resetCounter = () => {
    setCount(0);
  };

  return (
    <>
      <div className="counter--container">
        <p className="counter--display">{count}</p>

        <button className="counter--button" onClick={decrementCounterByTen}>
          Decrement by 10
        </button>

        <button className="counter--button" onClick={decrementCounter}>
          Decrement
        </button>

        <button className="counter--button" onClick={resetCounter}>
          Reset
        </button>

        <button className="counter--button" onClick={incrementCounter}>
          Increment
        </button>

        <button className="counter--button" onClick={incrementCounterByTen}>
          Increment by 10
        </button>
      </div>
    </>
  );
}

export default Counter;
