package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseTagFragments {

    private static final Pattern TAG_PATTERN = Pattern.compile("@(\\w+)");

    public static String getTagList(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        if (text.contains("TODO")) {
            return "";
        }
        Matcher matcher = TAG_PATTERN.matcher(text);
        List<String> tags = new ArrayList<>();
        while (matcher.find()) {
            tags.add(matcher.group(1));
        }
        return String.join(", ", tags);
    }
}
