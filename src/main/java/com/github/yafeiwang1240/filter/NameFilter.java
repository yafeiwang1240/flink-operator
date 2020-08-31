package com.github.yafeiwang1240.filter;

import com.github.yafeiwang1240.utils.FieldUtils;
import org.apache.flink.api.common.functions.FilterFunction;

import java.util.regex.Pattern;

public class NameFilter implements FilterFunction<String> {

    private Pattern pattern = Pattern.compile("[a-zA-z]");

    @Override
    public boolean filter(String s) throws Exception {
        String name = FieldUtils.getField(s)[FieldUtils.EnumField.name.getIndex()];
        return pattern.matcher(name).find();
    }
}
