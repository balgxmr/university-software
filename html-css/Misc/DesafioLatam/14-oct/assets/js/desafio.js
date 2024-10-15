const nombreAsistentes = [
  {
    id: 1,
    nombre: "Jose",
    finalizada: true,
  },
  {
    id: 2,
    nombre: "Daniel",
    finalizada: false,
  },
  {
    id: 3,
    nombre: "nestor",
    finalizada: false,
  },
  {
    id: 4,
    nombre: "Leonardo",
    finalizada: false,
  },
];

function actualizarListaAsistentes() {
  let html = "";
  for (const asistente of nombreAsistentes) {
    html += `
          <div class="asistente">
            <div class="nombreAsistente">
              ${asistente.nombre}
            </div>

            <div class="estadoTarea">
              <input type="checkbox" checked />
            </div>

            <div class="accionBoton">
              <button onclick="eliminarPersona(${asistente.id})"></button>
            </div>
          </div>
            `;
  }
  document.querySelector("#lista_asistentes").innerHTML = html;
}

const agregarPersona = function (event) {
  event.preventDefault();
  const nuevaPersona = document.querySelector("#nuevo_sh");

  // Date.now() pasa los tiempos en segundos que han pasado desde 1970 hasta ahora
  nombrePersonas.push({ id: Date.now(), nombre: nuevaPersona.value });
  actualizarListaAsistentes();
  nuevaPersona.value = "";
};

const eliminaPersona = function (id) {
  const posicionPersona = nombreAsistentes.findIndex((persona) => persona.id === id);
  nombreAsistentes.splice(posicionPersona, 1);
};
