package BankStatementsAnalyzer.statementAnalyzer.StatementParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Transaction;

import static java.util.stream.Collectors.toList;

public class StatementFullParser implements StatementParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Transaction parseFrom(final String line) {

        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        return new Transaction(date, amount, columns[2]);
    }

    public List<Transaction> parseLinesFrom(final List<String> lines) {
        return lines.stream().map(this::parseFrom).collect(toList());

    }
}
