// Student.jsx is the child, App.jsx is the parent, in this case
// .isStudent necesita un operador ternario o if/else, ya que si lo dejamos a secas, el valor true/false no se despliega.

// propTypes = es un mecanismo que asegura que los valores que son pasados
//             sean del mismo tipo de dato. Es decir int = int, str = str, etc.
// uso:        Edad: propTypes.number
//             Esto no prevendrá que la app deje de correr, pero nos soltará un WARNING en la consola.
import PropTypes from "prop-types";

// defaultProps = son valores por defecto para los props en caso
//                de que no se hayan pasado desde el componente padre.
//                name: "Guest"

function Student(props) {
  return (
    <div className="student">
      <p>Nombre: {props.name}</p>
      <p>Edad: {props.age}</p>
      <p>Es un estudiante: {props.isStudent ? "Yes" : "No"}</p>
    </div>
  );
}

Student.propTypes = {
  name: PropTypes.string,
  age: PropTypes.number,
  isStudent: PropTypes.bool,
};

Student.defaultProps = {
  name: "Guest",
  age: 0,
  isStudent: false,
};

export default Student;
