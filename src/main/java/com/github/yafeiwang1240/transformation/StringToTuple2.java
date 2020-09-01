package com.github.yafeiwang1240.transformation;

import com.github.yafeiwang1240.utils.FieldUtils;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;

import java.util.HashMap;
import java.util.Map;

public class StringToTuple2 implements MapFunction<String, Tuple2<String, Integer>> {

    @Override
    public Tuple2<String, Integer> map(String s) throws Exception {
        String[] values = FieldUtils.getField(s);
        return new Tuple2(values[FieldUtils.EnumField.name.getIndex()],
                Integer.valueOf(values[FieldUtils.EnumField.id.getIndex()]));
    }
}
