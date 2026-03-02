package org.farhan.dsl.lang;

public class StepObjectRefFragments {

    private static int findComponentTypeIndex(String[] words) {
        for (int i = 1; i < words.length; i++) {
            for (StepObjectRefComponentTypes type : StepObjectRefComponentTypes.values()) {
                if (words[i].equals(type.value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int findObjectTypeIndex(String[] words, int startIndex) {
        for (int i = startIndex; i < words.length; i++) {
            for (StepObjectRefObjectEdgeTypes type : StepObjectRefObjectEdgeTypes.values()) {
                if (words[i].equals(type.value)) {
                    return i;
                }
            }
            for (StepObjectRefObjectVertexTypes type : StepObjectRefObjectVertexTypes.values()) {
                if (words[i].equals(type.value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static String joinWords(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i > start) sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public static String getAll(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                int objIdx = findObjectTypeIndex(words, compIdx + 1);
                if (objIdx >= 0) {
                    return joinWords(words, 0, objIdx);
                }
            }
        }
        return "";
    }

    public static String getComponent(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                return joinWords(words, 1, compIdx);
            }
        }
        return "";
    }

    public static String getComponentName(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                return joinWords(words, 1, compIdx - 1);
            }
        }
        return "";
    }

    public static String getComponentType(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                return words[compIdx];
            }
        }
        return "";
    }

    public static String getObject(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                int objIdx = findObjectTypeIndex(words, compIdx + 1);
                if (objIdx >= 0) {
                    return joinWords(words, compIdx + 1, objIdx);
                }
            }
        }
        return "";
    }

    public static String getObjectEdgeType(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                for (int i = compIdx + 1; i < words.length; i++) {
                    for (StepObjectRefObjectEdgeTypes type : StepObjectRefObjectEdgeTypes.values()) {
                        if (words[i].equals(type.value)) {
                            return type.value;
                        }
                    }
                }
            }
        }
        return "";
    }

    public static String getObjectName(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                int objIdx = findObjectTypeIndex(words, compIdx + 1);
                if (objIdx >= 0) {
                    return joinWords(words, compIdx + 1, objIdx - 1);
                }
            }
        }
        return "";
    }

    public static String getObjectType(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                int objIdx = findObjectTypeIndex(words, compIdx + 1);
                if (objIdx >= 0) {
                    return words[objIdx];
                }
            }
        }
        return "";
    }

    public static String getObjectVertexType(String text) {
        if (text != null) {
            String[] words = text.split(" ");
            int compIdx = findComponentTypeIndex(words);
            if (compIdx >= 0) {
                for (int i = compIdx + 1; i < words.length; i++) {
                    for (StepObjectRefObjectVertexTypes type : StepObjectRefObjectVertexTypes.values()) {
                        if (words[i].equals(type.value)) {
                            return type.value;
                        }
                    }
                }
            }
        }
        return "";
    }
}
