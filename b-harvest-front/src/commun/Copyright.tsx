import { Typography } from "@mui/material";
import { Link } from "react-router-dom";

export const Copyright = (props: any) => {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {"Copyright © "}
      <Link color="inherit" to="#">
        LABZAR Othmane
      </Link>{" "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
};
