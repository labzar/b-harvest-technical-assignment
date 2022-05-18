import { Link } from "react-router-dom";
import "./App.css";
import { Copyright } from "./commun/Copyright";

function App() {
  return (
    <>
      <div className="content-container">
        <div>
          <h1>Blue Harvest Technical Assignment</h1>
          <nav
            style={{
              borderBottom: "solid 1px",
              paddingBottom: "1rem",
            }}
          >
            <Link to="/transaction">Transaction</Link> |{" "}
            <Link to="/accountInformations">Account Informations</Link>
          </nav>
        </div>
      </div>
      <footer className="footer--pin">
        <Copyright sx={{ mt: 8, mb: 4 }} />
      </footer>
    </>
  );
}

export default App;
