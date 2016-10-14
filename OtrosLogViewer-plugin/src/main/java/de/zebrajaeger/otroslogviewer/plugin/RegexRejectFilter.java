package de.zebrajaeger.otroslogviewer.plugin;

import pl.otros.logview.api.model.LogData;
import pl.otros.logview.filter.AbstractStringBasedFilter;

import java.awt.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexRejectFilter extends AbstractStringBasedFilter {
private static final String NAME = "Regex Reject Filter";
private static final String DESCRIPTION = "Filtering events based on a regular expression.";
private static final String LABEL_TEXT = "Enter a regular expression";
private static final String DOT_ALL_SUFFIX = ".*";
private String condition = "";
private Pattern pattern = Pattern.compile("");
private boolean patternOk = true;

public RegexRejectFilter() {
    super(NAME, DESCRIPTION, LABEL_TEXT);

    }

protected void performPreFiltering() {
    condition = getFilteringText();
    while (condition.startsWith(DOT_ALL_SUFFIX)) {
    condition = condition.substring(2);
    }
    while (condition.endsWith(DOT_ALL_SUFFIX)) {
    condition = condition.substring(0, condition.length() - 2);
    }
    patternOk = false;
    int flags = 0;
    if (isIgnoreCase()) {
    flags = Pattern.CASE_INSENSITIVE;
    }
    try {
    pattern = Pattern.compile(condition, flags);
    patternOk = true;
    } catch (PatternSyntaxException e) {
    textField.setBackground(Color.RED);
    }

    }

@Override
public boolean accept(LogData logData, int row) {
    if (patternOk && condition.length() > 0) {
    return !pattern.matcher(logData.getMessage()).find();
    }
    return condition.length() == 0 || !patternOk;
    }

    }