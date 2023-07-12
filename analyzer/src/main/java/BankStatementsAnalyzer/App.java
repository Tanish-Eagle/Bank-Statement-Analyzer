package BankStatementsAnalyzer;


import BankStatementsAnalyzer.statementAnalyzer.StatementAnalyzer;
import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementParser;
import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementFullParser;


public class App 
{
    public static void main( String[] args) throws Exception {

        final StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
        final StatementParser statementParser = new StatementFullParser();

        statementAnalyzer.analyze("bank-data-simple.csv", statementParser);
    }
}
