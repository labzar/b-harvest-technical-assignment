import { useState, useCallback } from "react";

export const useFetch = <T>(
  url: string
): [
  (option?: Record<string, any>) => Promise<void>,
  T | undefined,
  boolean,
  boolean
] => {
  const [data, setData] = useState<T>();
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(false);

  const doFetch = useCallback(
    async (option?: Record<string, any>): Promise<void> => {
      const config = {
        method: (option && option.method) ?? "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify((option && option.data) ?? null),
      };

      try {
        setData(undefined);
        setIsLoading(true);
        const response = option ? await fetch(url, config) : await fetch(url);
        const json = await response.json();

        if (json && json.status && json.status !== 200) {
          setError(true);
          setData(undefined);
          return;
        }

        if (json) {
          setData(json);
          setIsLoading(false);
          setError(false);
        } else {
          setError(true);
          setData(undefined);
        }
      } catch (error) {
        setError(true);
        setData(undefined);
      } finally {
        setIsLoading(false);
      }
    },
    [url]
  );

  return [doFetch, data, isLoading, error];
};
