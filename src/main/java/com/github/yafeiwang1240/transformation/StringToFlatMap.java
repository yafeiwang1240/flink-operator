package com.github.yafeiwang1240.transformation;

import com.github.yafeiwang1240.utils.FieldUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import java.util.HashMap;
import java.util.Map;

public class StringToFlatMap implements FlatMapFunction<String, Map<String, Object>> {

    @Override
    public void flatMap(String s, Collector<Map<String, Object>> collector) throws Exception {
        Map<String, Object> map = new HashMap<>(2);
        String[] values = FieldUtils.getField(s);
        map.put("name", values[FieldUtils.EnumField.name.getIndex()]);
        map.put("id", Integer.valueOf(values[FieldUtils.EnumField.id.getIndex()]));
        collector.collect(map);
    }
}
