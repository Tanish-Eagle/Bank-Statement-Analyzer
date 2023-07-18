package BankStatementsAnalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementFullParser;
import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementParser;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.*;

public class AppTest {
    private StatementParser statementParser = new StatementFullParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        String line = "30-01-2017,-50,Tesco";
        Transaction result = statementParser.parseFrom(line);
        Transaction expected = new Transaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}