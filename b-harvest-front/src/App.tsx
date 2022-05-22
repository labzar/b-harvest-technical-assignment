import {
  Box,
  List,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  ListSubheader,
} from "@mui/material";
import { Link } from "react-router-dom";
import "./App.css";
import { Copyright } from "./commun/Copyright";
import SendIcon from "@mui/icons-material/Send";
import { useNavigate } from "react-router-dom";

export const App = () => {
  const navigate = useNavigate();

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
          ></nav>
        </div>
        <Box display="flex" alignItems="center" justifyContent="center">
          <List
            sx={{ width: "100%", maxWidth: 360, bgcolor: "#eee" }}
            component="nav"
            aria-labelledby="nested-list-subheader"
            subheader={
              <ListSubheader component="div" id="nested-list-subheader">
                Menu :
              </ListSubheader>
            }
          >
            <ListItemButton onClick={() => navigate("/transaction")}>
              <ListItemIcon>
                <SendIcon />
              </ListItemIcon>
              <ListItemText primary="Transaction" />
            </ListItemButton>
            <ListItemButton onClick={() => navigate("/accountInformations")}>
              <ListItemIcon>
                <SendIcon />
              </ListItemIcon>
              <ListItemText primary="Account Informations" />
            </ListItemButton>
          </List>
        </Box>
      </div>

      <footer className="footer--pin">
        <Copyright sx={{ mt: 8, mb: 4 }} />
      </footer>
    </>
  );
};
