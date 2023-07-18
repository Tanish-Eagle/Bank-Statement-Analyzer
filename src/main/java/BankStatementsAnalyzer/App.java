package BankStatementsAnalyzer;

import BankStatementsAnalyzer.statementAnalyzer.StatementAnalyzer;
import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementParser;
import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementFullParser;

import BankStatementsAnalyzer.statementAnalyzer.exporter.*;

public class App {
    public static void main(final String[] args) throws Exception {

        final StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
        final StatementParser statementParser = new StatementFullParser();

        final Exporter exporter = new HTMLExporter();

        statementAnalyzer.analyze("bank-data-simple.csv", statementParser, exporter);
    }
}
