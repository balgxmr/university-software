function ProfilePicture() {
  const imageUrl = "./src/assets/aonohako.jpg";

  const handleClick = () => console.log("OUCH");

  return <img className="profile-picture" onClick={handleClick} src={imageUrl} alt="ImageAo" />;
}
export default ProfilePicture;
