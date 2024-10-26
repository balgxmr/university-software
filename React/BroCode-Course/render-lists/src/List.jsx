import PropTypes from "prop-types";

function List(props) {
  const itemCategory = props.category;
  const itemList = props.items;

  // Se utiliza key={llave} por que react nos tira un warning: "Each child in a list should have an unique 'key' prop".
  const listItems = itemList.map((item) => (
    <li key={item.id}>
      {item.name}: &nbsp; <b>{item.calories}</b>
    </li>
  ));

  return (
    <>
      <h3 className="list--category">{itemCategory}:</h3>
      <ul className="list--items">{listItems}</ul>
    </>
  );
}

List.propTypes = {
  category: PropTypes.string,
  // Acá para verificar array con PropTypes.shape({atributo: PropTypes.tipoDeDato}, ...)
  items: PropTypes.arrayOf(PropTypes.shape({ id: PropTypes.number }, { name: PropTypes.string }, { calories: PropTypes.number })),
};

List.defaultProps = {
  category: "Category",
  items: [], // En caso de que no exista el array, crea un array vacío, sin esto, no se renderizaría nada ya que estamos intentando mapear un array que no existe
};

export default List;
