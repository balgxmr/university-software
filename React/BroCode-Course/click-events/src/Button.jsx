function ButtonOld() {
  // const handleClick2 = (name) => console.log(`${name} stop clicking me!`);

  // Agregamos () => para que no la llame de una vez, si no cuando accione el onClick.
  // return <button onClick={() => handleClick2("Bro")}>Click Me :D</button>;

  let count = 0;
  const handleClick = (name) => {
    if (count < 3) {
      count++;
      console.log(`${name} you clicked me ${count} time/s!`);
    } else {
      console.log(`${name} stop clicking me!`);
    }
  };

  return <button onClick={() => handleClick("Bro")}>Click Me :D</button>;
}

function Button() {
  const handleClick = (e) => (e.target.textContent = "OUCH D:");

  return <button onClick={(e) => handleClick(e)}>Click me!!! :D</button>;
}

export default Button;
