function List() {
  // Array de objetos
  const fruits = [
    {
      id: 1,
      name: "apple",
      calories: 95,
    },
    {
      id: 2,
      name: "orange",
      calories: 45,
    },
    {
      id: 3,
      name: "banana",
      calories: 105,
    },
    {
      id: 4,
      name: "coconut",
      calories: 159,
    },
    {
      id: 5,
      name: "pineapple",
      calories: 37,
    },
  ];

  // fruits.sort((a, b) => a.name.localeCompare(b.name)); // ORDEN ALFABETICO
  // fruits.sort((a, b) => b.name.localeCompare(a.name)); // ORDEN ALFABETICO REVERSO
  // fruits.sort((a, b) => a.calories - b.calories);      // ORDEN NUMÉRICO
  // fruits.sort((a, b) => b.calories - a.calories);      // ORDEN NUMÉRICO REVERSO

  const lowCaloriesFruits = fruits.filter((fruit) => fruit.calories < 100);

  // Se utiliza key={llave} por que react nos tira un warning: "Each child in a list should have an unique 'key' prop".
  const listItems = fruits.map((fruit) => (
    <li key={fruit.id}>
      {fruit.name}: &nbsp; <b>{fruit.calories}</b>
    </li>
  ));

  const listLowItems = lowCaloriesFruits.map((lowCaloriesFruit) => (
    <li key={lowCaloriesFruit.id}>
      {lowCaloriesFruit.name}: &nbsp; <b>{lowCaloriesFruit.calories}</b>
    </li>
  ));

  return (
    <>
      <h2>Fruits and it's calories:</h2>
      <ul>{listItems}</ul>
      <br />
      <h2>Fruits with low calories:</h2>
      <ul>{listLowItems}</ul>
    </>
  );
}

export default List;
