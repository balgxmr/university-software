import Header from "./Header.jsx";
import Footer from "./Footer.jsx";
import Food from "./Food.jsx";

function App() {
  return (
    // Este <> global es necesario porque solo se puede retornar un <>. Entonces enrollamos todo dentro de un solo <>.
    <>
      <Header />
      <Food />
      <Footer />
    </>
  );
}

export default App;
