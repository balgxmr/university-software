import profilePic from "./assets/aonohako.jpg";

function Card() {
  return (
    <div className="card">
      <img className="card--img" src={profilePic} alt="AoNoHako" />
      <h2 className="card--title">Jose M.</h2>
      <p className="card--desc">I like VFX, GFX, and more</p>
    </div>
  );
}

export default Card;
