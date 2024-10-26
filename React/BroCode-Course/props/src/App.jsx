// props = propiedades de solo lectura que son compartidas entre componentes.
//         Un componente padre (parent) puede enviar datos a un componente hijo (child).
//         <Component key=value />

// Los strings se pasan con "", y lo que no lo sea (por ejemplo numeros, bools), se pasa con {}.

import Student from "./Student.jsx";

function App() {
  return (
    <>
      <Student name="Bob Esponja" age="20" isStudent={true} />
      <Student name="Patricio" age={42} isStudent={false} />
      <Student name="Calamardo" age={50} isStudent={false} />
      <Student name="Sandy" age={20} isStudent={true} />
      <Student />
    </>
  );
}

export default App;
