// Métodos de propiedad
const reproductor = {
  reproducir: function (id) {
    console.log(`Reproduciendo canción con el ID: ${id}`);
  },
  pausar: function () {
    console.log("Canción pausada...");
  },
  crearPlaylist: function (nombre) {
    console.log(`Se ha creado la playlist con el nombre: ${nombre}`);
  },
  reproducirPlaylist: function (nombre) {
    console.log(`Reproduciendo la playlist con el nombre: ${nombre}`);
  },
};

reproductor.borrarCancion = function (id) {
  console.log(`Eliminando la canción con el ID: ${id}`);
};

reproductor.reproducir(3840);
reproductor.pausar();
reproductor.borrarCancion(3841);
reproductor.crearPlaylist("Hololive");
reproductor.reproducirPlaylist("Hololive");
