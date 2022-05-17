import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Transaction } from "./routes/transaction";
import { AccountInformations } from "./routes/accountInformations";

const root = ReactDOM.createRoot(
  document.getElementById("root") as HTMLElement
);
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="accountInformations" element={<AccountInformations />} />
        <Route path="transaction" element={<Transaction />} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);
