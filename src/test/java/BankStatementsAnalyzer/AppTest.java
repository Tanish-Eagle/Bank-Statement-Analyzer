package BankStatementsAnalyzer;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

//import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementFullParser;
//import BankStatementsAnalyzer.statementAnalyzer.StatementParser.StatementParser;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.StatementProcessor;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.TransactionFilter;
import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Transaction;

public class AppTest {
    @Test
    public void shouldFilterTransactionsInFebruary() {

        final Transaction febSalary = new Transaction(LocalDate.of(2019, Month.FEBRUARY, 14), 2_000, "Salary");
        final Transaction marchRoyalties = new Transaction(LocalDate.of(2019, Month.MARCH, 20), 500, "Royalties");
        final List<Transaction> transaction = List.of(febSalary, marchRoyalties);
        final StatementProcessor processor = new StatementProcessor(transaction);
        final List<Transaction> transactions = processor.findTransactions(new TransactionIsInFebruaryAndExpensive());

        assertThat(transactions, contains(febSalary));
        assertThat(transactions, hasSize(1));

    }

    class TransactionIsInFebruaryAndExpensive implements TransactionFilter {
        @Override
        public boolean test(final Transaction transaction) {

            return transaction.getDate().getMonth() == Month.FEBRUARY && transaction.getAmount() >= 1_000;
        }

    }
}