package BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction;
@FunctionalInterface
public interface TransactionFilter {
boolean test(Transaction transaction);
}
