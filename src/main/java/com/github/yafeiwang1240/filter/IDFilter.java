package com.github.yafeiwang1240.filter;

import com.github.yafeiwang1240.utils.FieldUtils;
import org.apache.flink.api.common.functions.FilterFunction;

import java.util.regex.Pattern;

public class IDFilter implements FilterFunction<String> {

    @Override
    public boolean filter(String s) throws Exception {
        String id = FieldUtils.getField(s)[FieldUtils.EnumField.id.getIndex()];
        return Integer.valueOf(id) % 2 == 1;
    }
}
