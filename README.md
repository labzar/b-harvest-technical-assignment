# b-harvest-technical-assignment

b-harvest bank is bank application, mobile-ready, offline-storage compatible,
ReactJS-powered HTML5 Markdown editor.

## Assessment

The assessment consists of an API to be used for opening a new “current account” of
already existing customers.
Requirements

- The API will expose an endpoint which accepts the user information (customerID,
  initialCredit).
- Once the endpoint is called, a new account will be opened connected to the user
  whose ID is customerID.
- Also, if initialCredit is not 0, a transaction will be sent to the new account.
- Another Endpoint will output the user information showing Name, Surname,
  balance, and transactions of the accounts.

## Tech

b-harvest bank uses a number of open source projects to work properly:

- [ReactJS] - HTML enhanced for web apps!
- [Material ui] - MUI offers a comprehensive suite of UI tools to help you ship new features faster.
- [SpringBoot] - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
- [TypeScript]
- [Java 17]

## Installation

Install the dependencies and devDependencies and start the server.

For frontend environments... (http://localhost:3000)

```sh
cd b-harvest-front
yarn
yarn start
```

For backend environments...(http://localhost:8080)

```sh
cd b-harvest-back
mvn spring-boot:run -Dspring.profiles.active=local
```

N.B: make sure that you have java 17 in your $JAVA_HOME

## License

O.D.L

**Free Software, LABZAR Othmane!**
