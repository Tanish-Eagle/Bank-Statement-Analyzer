package BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction;

@FunctionalInterface
public interface TransactionSummary {
    double summarize(double accumulator, Transaction transaction);
}
