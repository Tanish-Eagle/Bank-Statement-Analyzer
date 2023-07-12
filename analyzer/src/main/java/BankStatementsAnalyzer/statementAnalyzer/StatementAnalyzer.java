package BankStatementsAnalyzer.statementAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementFullParser;
import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementParser;

import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.StatementProcessor;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Transaction;

public class StatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final StatementParser statementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<Transaction> transactions = statementParser.parseLinesFrom(lines);
        final StatementProcessor statementProcessor = new StatementProcessor(transactions);
        collectSummary(statementProcessor);
    }

    private static void collectSummary(final StatementProcessor statementProcessor) {
        System.out.println("The total for all transactions is " + statementProcessor.calculateTotalAmount());
        System.out.println(
                "The total for transactions in January is " + statementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println(
                "The total for transactions in January is " + statementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + statementProcessor.calculateTotalForCategory("Salary"));

    }
}
