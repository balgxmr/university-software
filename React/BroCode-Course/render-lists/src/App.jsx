import List from "./List.jsx";

function App() {
  // Array de objetos
  const fruits = [
    { id: 1, name: "apple", calories: 95 },
    { id: 2, name: "orange", calories: 45 },
    { id: 3, name: "banana", calories: 105 },
    { id: 4, name: "coconut", calories: 159 },
    { id: 5, name: "pineapple", calories: 37 },
  ];

  const vegetables = [
    { id: 6, name: "potato", calories: 110 },
    { id: 7, name: "celery", calories: 15 },
    { id: 8, name: "carrot", calories: 25 },
    { id: 9, name: "corn", calories: 63 },
    { id: 10, name: "broccoli", calories: 50 },
  ];

  const fishes = [];

  return (
    // Conditionally render the component using ternary op
    //
    // {fruits.length > 0 ? <List items={fruits} category="Fruits" /> : null}
    // ^ esto es lo mismo que decir lo siguiente:
    // {fruits.length > 0 && <List items={fruits} category="Fruits" />}
    //                    ^^ hemos reemplazado el ? por &&, y además hemos quitado el ": null";
    //                       es una forma más corta, que obliga a la operación a ser cierta, de otro
    //                       modo no se renderizará.
    <>
      {fruits.length > 0 ? <List items={fruits} category="Fruits" /> : null}
      {vegetables.length > 0 ? <List items={vegetables} category="Vegetables" /> : null}
      {fishes.length > 0 ? <List items={fishes} category="Fishes" /> : null}
    </>
  );
}

export default App;
