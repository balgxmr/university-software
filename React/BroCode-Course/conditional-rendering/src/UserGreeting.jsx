// conditional-rendering = mostrar o no cierto contenido basado en condicionales

import PropTypes from "prop-types";

function UserGreeting(props) {
  // if (props.isLoggedIn) {
  //   return <h2>Welcome {props.username}</h2>;
  // } else {
  //   return <h2>Please login to continue</h2>;
  // }

  const welcomeMessage = <h2 className="welcome-message">Welcome {props.username}</h2>;
  const loginPrompt = <h2 className="login-prompt">Please login to continue</h2>;

  // Or instead, using ternary operator
  return props.isLoggedIn ? welcomeMessage : loginPrompt;
}

UserGreeting.proptypes = {
  isLoggedIn: PropTypes.bool,
  username: PropTypes.string,
};

UserGreeting.defaultProps = {
  isLoggedIn: false,
  username: "Guest",
};

export default UserGreeting;
