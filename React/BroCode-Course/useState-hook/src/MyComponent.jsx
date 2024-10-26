import { useState } from "react";

function MyComponent() {
  // useState("Guest") - iniital state is guest
  const [name, setName] = useState("Guest");
  const [age, setAge] = useState(0);
  const [isEmployed, setIsEmployed] = useState(false);

  const updateName = () => {
    setName("SpongeBob");
  };

  const incrementAge = () => {
    setAge(age + 1);
  };

  const setEmployedStatus = () => {
    setIsEmployed(!isEmployed);
  };

  return (
    <>
      <div>
        <p>Name: {name}</p>
        <button onClick={updateName}>Set Name</button>

        <p>Age: {age}</p>
        <button onClick={incrementAge}>Increment age</button>

        <p>Employeed: {isEmployed ? "Yes" : "No"}</p>
        <button onClick={setEmployedStatus}>Set employeed status</button>
      </div>
    </>
  );
}

export default MyComponent;
