package org.farhan.dsl.lang;

public class StepDefinitionRefFragments {

    private static int findPartTypeIndex(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (StepDefinitionRefPartTypes type : StepDefinitionRefPartTypes.values()) {
                if (words[i].equals(type.value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static String findStateType(String[] words, int startIndex) {
        if (startIndex + 1 < words.length) {
            String twoWord = words[startIndex] + " " + words[startIndex + 1];
            for (StepDefinitionRefStateTypes type : StepDefinitionRefStateTypes.values()) {
                if (twoWord.equals(type.value)) {
                    return type.value;
                }
            }
        }
        if (startIndex < words.length) {
            for (StepDefinitionRefStateTypes type : StepDefinitionRefStateTypes.values()) {
                if (words[startIndex].equals(type.value)) {
                    return type.value;
                }
            }
        }
        return "";
    }

    private static String joinWords(String[] words, int start, int end) {
        if (start > end) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i > start) sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public static String getAll(String text) {
        return null;
    }

    public static String getPart(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int partIdx = findPartTypeIndex(words);
            if (partIdx >= 0) {
                return joinWords(words, 0, partIdx);
            }
        }
        return "";
    }

    public static String getPartDesc(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int partIdx = findPartTypeIndex(words);
            if (partIdx >= 1) {
                return joinWords(words, 0, partIdx - 1);
            }
        }
        return "";
    }

    public static String getPartType(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int partIdx = findPartTypeIndex(words);
            if (partIdx >= 0) {
                return words[partIdx];
            }
        }
        return "";
    }

    public static String getState(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int partIdx = findPartTypeIndex(words);
            int stateStartIdx = partIdx >= 0 ? partIdx + 1 : 0;
            if (stateStartIdx < words.length) {
                String stateType = findStateType(words, stateStartIdx);
                if (!stateType.isEmpty()) {
                    int stateEndIdx = stateStartIdx + stateType.split(" ").length;
                    if (stateEndIdx < words.length) {
                        return stateType + " " + joinWords(words, stateEndIdx, words.length - 1);
                    }
                    return stateType;
                }
            }
        }
        return "";
    }

    public static String getStateDesc(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int partIdx = findPartTypeIndex(words);
            int stateStartIdx = partIdx >= 0 ? partIdx + 1 : 0;
            if (stateStartIdx < words.length) {
                String stateType = findStateType(words, stateStartIdx);
                if (!stateType.isEmpty()) {
                    int stateEndIdx = stateStartIdx + stateType.split(" ").length;
                    if (stateEndIdx < words.length) {
                        return joinWords(words, stateEndIdx, words.length - 1);
                    }
                }
            }
        }
        return "";
    }

    public static String getStateType(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int partIdx = findPartTypeIndex(words);
            int stateStartIdx = partIdx >= 0 ? partIdx + 1 : 0;
            if (stateStartIdx < words.length) {
                return findStateType(words, stateStartIdx);
            }
        }
        return "";
    }
}
