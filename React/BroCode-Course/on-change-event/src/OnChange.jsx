// onChange = event handler usado principalmente con elementos de formularios
//            ej. <input>, <select>, <radio>, <textarea>...
//            Ejecuta una función cada vez que el valor del input cambia

import React, { useState } from "react";

function OnChange() {
  const [name, setNombre] = useState("Invitado");
  const [cantidad, setCantidad] = useState(1);
  const [comentario, setComentario] = useState("");
  const [pago, setPago] = useState("");
  const [envio, setEnvio] = useState("Delivery");

  // Creamos funciones para manejar los cambios
  function handleNameChange(event) {
    setNombre(event.target.value);
  }
  function handleQuantityChange(event) {
    // Solo modificar si la cantidad es mayor a 0
    if (event.target.value > 0) {
      setCantidad(event.target.value);
    }
  }
  function handleCommentChange(event) {
    setComentario(event.target.value);
  }
  function handlePaymentChange(event) {
    setPago(event.target.value);
  }
  function handleShippingChange(event) {
    setEnvio(event.target.value);
  }

  return (
    <>
      <div>
        <input type="text" value={name} onChange={handleNameChange} />
        <p>Name: {name}</p>

        <input type="number" value={cantidad} onChange={handleQuantityChange} />
        <p>Numero: {cantidad}</p>

        <input type="textarea" value={comentario} onChange={handleCommentChange} placeholder="Escribe acá tu comentario" />
        <p>Comentario: {comentario}</p>

        <select name="" id="" value={pago} onChange={handlePaymentChange}>
          <option value="">Selecciona una opción</option>
          <option value="Visa">Visa</option>
          <option value="Mastercard">Mastercard</option>
          <option value="Paypal">Paypal</option>
          <option value="Giftcard">Gift Card</option>
        </select>
        <p>Método de pago: {pago}</p>

        <label>
          {/* Verificamos con checked si envio === tienda (es decir si la variable === value), si sí, se ejecuta onChange  */}
          <input type="radio" value="Tienda" checked={envio === "Tienda"} onChange={handleShippingChange} />
          Recoger en tienda
        </label>
        <br />
        <label>
          {/* Verificamos con checked si envio === tienda (es decir si la variable === value), si sí, se ejecuta onChange  */}
          <input type="radio" value="Delivery" checked={envio === "Delivery"} onChange={handleShippingChange} />
          Delivery
        </label>
        <p>Método de envío: {envio}</p>
      </div>
    </>
  );
}

export default OnChange;
