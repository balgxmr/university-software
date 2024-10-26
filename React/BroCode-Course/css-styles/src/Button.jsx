// (MODULES). Se crea una carpeta con el nombre del componente, se mueve el .jsx dentro y se crea un css con Componente.module.css.
// import styles from "./Button.module.css";

function Button() {
  // Acá (EXTERNAL) perfecto para estilos globales o proyectos pequeños
  return <button className="button">Click me!</button>;

  // Acá (MODULES) se cambia el tipico className = "NombreClase" a un className={styles.button}
  // return <button className={styles.button}>Click me!</button>;

  // Acá (INLINE) es facil y conveniente de entender. Previene conflictos al no estar trabajando con nombres globales. Es ideal para componentes isolados. PERO es menos mantenible en proyectos grandes.
  // const styles = {
  //   backgroundColor: "rgb(14, 159, 35)",
  //   color: "#fff",
  //   border: "none",
  //   borderRadius: "4px",
  //   padding: "1rem 2rem",
  //   cursor: "pointer",
  // };

  // return <button style={styles}>Click me!</button>;
}

export default Button;
