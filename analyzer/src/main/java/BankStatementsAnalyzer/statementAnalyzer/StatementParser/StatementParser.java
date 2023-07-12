package BankStatementsAnalyzer.statementAnalyzer.StatementParser;

import java.util.List;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.*;

public interface StatementParser {
    Transaction parseFrom(String line);

    List<Transaction> parseLinesFrom(List<String> lines);
}
