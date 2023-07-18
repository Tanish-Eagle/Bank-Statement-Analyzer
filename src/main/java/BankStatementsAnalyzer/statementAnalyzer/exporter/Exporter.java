package BankStatementsAnalyzer.statementAnalyzer.exporter;

import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Summary;

public interface Exporter {
    String export(Summary summary);
}
