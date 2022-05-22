import React, { useEffect } from "react";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { useInitTransaction } from "../hooks/useInitTransaction";
import { Alert, CircularProgress } from "@mui/material";
import { AlertDialog } from "../commun/AlertDialog";

export const Transaction = () => {
  const [initTransaction, responseData, isLoading, isError] =
    useInitTransaction();
  const [openDialog, setOpenDialog] = React.useState(false);
  const [dialogTexts, setDialogTexts] = React.useState({
    title: "",
    description: "",
  });

  const handleOpenDialog = () => {
    setOpenDialog(!openDialog);
  };

  const handleSubmit = React.useCallback(
    async (event: React.FormEvent<HTMLFormElement>) => {
      event.preventDefault();
      const data = new FormData(event.currentTarget);
      await initTransaction({
        customerID: data.get("customerID"),
        initialCredit: Number(data.get("initialCredit")),
      });
    },
    [initTransaction]
  );

  useEffect(() => {
    if (responseData) {
      setDialogTexts({
        title: "Transaction Info",
        description: "Your transaction has been processed !",
      });
      handleOpenDialog();
    } else if (isError) {
      setDialogTexts({
        title: "Transaction Info",
        description:
          "Your transaction hasn't been Processed, there is something wrong in your request !",
      });

      handleOpenDialog();
    }
  }, [isError, responseData]);

  return (
    <Container component="main" maxWidth="xs">
      <Box
        sx={{
          marginTop: 8,
          display: "flex",
        }}
      >
        <Alert severity="info">
          In order to do your test try customer with ID = azerty1234
        </Alert>
      </Box>

      <CssBaseline />
      <Box
        sx={{
          marginTop: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <Typography component="h1" variant="h5">
          Transaction
        </Typography>
        <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
          <TextField
            margin="normal"
            required
            fullWidth
            id="customerID"
            label="Customer ID"
            name="customerID"
            autoComplete="customerID"
            autoFocus
          />
          <TextField
            margin="normal"
            required
            fullWidth
            name="initialCredit"
            label="Initial credit"
            type="initialCredit"
            id="initialCredit"
            autoComplete="current-initialCredit"
          />
          {
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              disabled={isLoading}
            >
              {isLoading ? (
                <CircularProgress color="secondary" size={20} />
              ) : (
                "Send"
              )}
            </Button>
          }
        </Box>
      </Box>
      <AlertDialog
        open={openDialog}
        {...dialogTexts}
        handleClose={handleOpenDialog}
      />
    </Container>
  );
};
