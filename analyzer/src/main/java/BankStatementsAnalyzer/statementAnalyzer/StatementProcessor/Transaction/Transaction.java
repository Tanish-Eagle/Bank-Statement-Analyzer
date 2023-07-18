package BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public Transaction(final LocalDate date, final double amount, final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;

    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;

    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Transaction{" + "date=" + date + "amount=" + amount + "description='" + description + '\'' +
                '}';
    }
}