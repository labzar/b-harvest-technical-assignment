import { backUrl } from "../api/index";
import { useFetch } from "../socle/useFetch";

export type TransactionType = {
  customerID: string;
  initialCredit: number;
};

export const useGetCustomerInfos = (
  customerID: string
): [() => Promise<void>, Record<string, any>, boolean, boolean] => {
  const [getCustomerInfos, data, isLoading, error] = useFetch<any>(
    `${backUrl}/account/${customerID}`
  );

  return [getCustomerInfos, data, isLoading, error];
};
