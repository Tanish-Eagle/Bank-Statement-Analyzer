package BankStatementsAnalyzer.statementAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.time.Month;
import java.util.List;

//import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementFullParser;
import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementParser;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.StatementProcessor;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Transaction;
import BankStatementsAnalyzer.statementAnalyzer.exporter.Exporter;
//import BankStatementsAnalyzer.statementAnalyzer.exporter.HTMLExporter;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Summary;

public class StatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final StatementParser statementParser, final Exporter exporter)
            throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<Transaction> transactions = statementParser.parseLinesFrom(lines);
        final StatementProcessor statementProcessor = new StatementProcessor(transactions);
        final Summary summary = statementProcessor.summarize();
        System.out.println(exporter.export(summary));

    }
}
