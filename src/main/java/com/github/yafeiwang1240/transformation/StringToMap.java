package com.github.yafeiwang1240.transformation;

import com.github.yafeiwang1240.utils.FieldUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.util.Collector;

import java.util.HashMap;
import java.util.Map;

public class StringToMap implements MapFunction<String, Map<String, Object>> {

    @Override
    public Map<String, Object> map(String s) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        String[] values = FieldUtils.getField(s);
        map.put("name", values[FieldUtils.EnumField.name.getIndex()]);
        map.put("id", Integer.valueOf(values[FieldUtils.EnumField.id.getIndex()]));
        return map;
    }
}
