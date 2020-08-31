package com.github.yafeiwang1240.utils;

public class FieldUtils {

    private static final String SPLIT = "\t";
    public enum EnumField {
        name(0, "姓名"),
        id(1, "id");

        private int index;
        private String desc;

        EnumField(int index, String desc) {
            this.index = index;
            this.desc = desc;
        }

        public int getIndex() {
            return index;
        }

        public String getDesc() {
            return desc;
        }
    }

    public static String[] getField(String str) {
        return str.split(SPLIT);
    }
}
