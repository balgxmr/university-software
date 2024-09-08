// Strings o cadenas de texto
const producto = 'Monitor de 20"';
const producto2 = "Monitor HD";
const tweet = "Programando en Visual Studio Code, aprendiendo más sobre desarrollo full stack para poder ganar guita xd";

// Length
console.log(producto);
console.log(tweet.length); // acá no tiene () porque es propiedad, no es una función como tal

// Index Of - nos arroja en donde está ubicado lo que ingresamos en la variable. si nos arroja -1 es que no se encontró
console.log(tweet.indexOf("Visual Studio"));
console.log(tweet.indexOf("Javascript"));

// Include - (retorna true/false si lo ingresado se encuentra en la variable)
console.log(tweet.includes("Visual Studio"));
console.log(tweet.includes("Javascript"));
