package ru.zinoviev.utils;

public class ServletUtils {

    private static int resultCount = 20;
    private static int startIndex = 0;

    public static int getResultCount() {
        return resultCount;
    }

    public static void setResultCount(int resultCount) {
        ServletUtils.resultCount = resultCount;
    }

    public static int getStartIndex() {
        return startIndex;
    }

    public static void setStartIndex(int startIndex) {
        ServletUtils.startIndex = startIndex;
    }
}
