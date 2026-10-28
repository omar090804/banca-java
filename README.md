# Banca Java

A console banking system written in plain Java, built while learning backend development.

## Features

- [x] Customers (`Cliente`)
- [x] Accounts with checking and savings types (`Conto`)
- [x] Deposits and withdrawals with validation
- [x] Balance calculated from the list of transactions
- [ ] Bank class to manage customers and accounts
- [ ] Transfers between accounts
- [ ] Console menu
- [ ] Saving and loading data from files

## Design notes

- Money is stored as `BigDecimal`, never `double`, to avoid rounding errors.
- The balance is not stored: it is calculated by summing all the transactions.
- Positive amount = money in, negative amount = money out.

## How to run

1. Clone the repository
2. Open the folder in IntelliJ IDEA
3. Run `Main.java`

## Technologies

- Java
- Git and GitHub

## Next steps

Connect the project to the SQL bank database (see my [sql-exercises](https://github.com/omar090804/sql-exercises) repository) using JDBC.