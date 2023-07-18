package BankStatementsAnalyzer.statementAnalyzer.StatementProcessor;

import java.time.Month;
import java.util.List;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Summary;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Transaction;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.TransactionFilter;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.TransactionSummary;

public class StatementProcessor {
    private final List<Transaction> transactions;

    public StatementProcessor(final List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Summary summarize() {

        final DoubleSummaryStatistics doubleSummary = transactions.stream().mapToDouble(Transaction::getAmount)
                .summaryStatistics();
        return new Summary(doubleSummary.getSum(), doubleSummary.getMax(), doubleSummary.getMin(),
                doubleSummary.getAverage());
    }

    public double summarizeTransaction(TransactionSummary transactionSummary) {
        double result = 0;
        for (final Transaction transaction : transactions) {
            result = transactionSummary.summarize(result, transaction);

        }
        return result;

    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransaction((acc, transaction) -> transaction.getDate().getMonth() == month
                ? acc + transaction.getAmount()
                : acc);

    }

    public List<Transaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(transactions -> transactions.getAmount() >= amount);
    }

    public List<Transaction> findTransactions(final TransactionFilter transactionFilter) {
        final List<Transaction> result = new ArrayList<>();
        for (final Transaction transaction : transactions) {
            if (transactionFilter.test(transaction)) {
                result.add(transaction);
            }
        }
        return result;
    }
}
