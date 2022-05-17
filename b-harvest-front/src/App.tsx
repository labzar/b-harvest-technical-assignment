import React from "react";
import { Link } from "react-router-dom";
import "./App.css";

function App() {
  return (
    <div className="App">
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
  );
}

export default App;
