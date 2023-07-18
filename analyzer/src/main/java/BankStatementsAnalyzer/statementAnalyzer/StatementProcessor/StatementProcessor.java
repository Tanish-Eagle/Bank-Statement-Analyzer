package BankStatementsAnalyzer.statementAnalyzer.StatementProcessor;

import java.time.Month;
import java.util.List;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.*;

public class StatementProcessor {
    private final List<Transaction> transactions;

    public StatementProcessor(final List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final Transaction transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getDate().getMonth() == month) {
                total += transaction.getAmount();
            }

        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getDescription().equals(category)) {
                total += transaction.getAmount();
            }
        }
        return total;
    }
}
