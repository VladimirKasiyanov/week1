package com.kasiyanov.week1.task1;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneConverter {

    public String stringBufferConverter(List<String> list) {
        StringBuffer sb = new StringBuffer();

        sb.append("(");
        for (int i = 1; i < 4; i++) {
            sb.append(list.get(i));
        }
        sb.append(") ");
        for (int i = 4; i <= 6; i++) {
            sb.append(list.get(i));
        }
        sb.append("-");
        for (int i = 7; i <= 9; i++) {
            sb.append(list.get(i));
        }
        sb.append(list.get(0));

        return new String(sb);
    }

    public String regexConverter(List<String> list) {
        StringBuffer sb = new StringBuffer();
        for (String aList : list) {
            sb.append(aList);
        }

        String value = new String(sb);
        Pattern pattern = Pattern.compile("(\\d{1})(\\d{3})(\\d{3})(\\d{3})");
        Matcher matcher = pattern.matcher(value);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "($2) $3-$4$1");
        }

        return new String(stringBuffer);
    }
}
