package BankStatementsAnalyzer.statementAnalyzer.exporter;

import BankStatementsAnalyzer.statementAnalyzer.StatementProcessor.Transaction.Summary;

public class HTMLExporter implements Exporter {
    @Override
    public String export(final Summary summary) {
        String result = "<!doctype html>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summary.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summary.getAverage() + "</li>";
        result += "<li><strong>The max is</strong>: " + summary.getMax() + "</li>";
        result += "<li><strong>The min is</strong>: " + summary.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
