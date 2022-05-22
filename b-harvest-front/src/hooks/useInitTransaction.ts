import { backUrl } from "../api/index";
import { useFetch } from "../socle/useFetch";

export type TransactionType = {
  customerID: string;
  initialCredit: number;
};

export const useInitTransaction = (): [
  (requestData: Record<string, any>) => Promise<void>,
  object,
  boolean,
  boolean
] => {
  const [initTransaction, data, isLoading, error] = useFetch<any>(
    `${backUrl}/transaction`
  );

  const doFetch = (requestData: Record<string, any>) =>
    initTransaction({
      method: "POST",
      data: requestData,
    });

  return [doFetch, data, isLoading, error];
};
