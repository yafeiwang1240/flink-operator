package com.github.yafeiwang1240.transformation;

import org.apache.flink.streaming.api.functions.co.CoFlatMapFunction;
import org.apache.flink.util.Collector;

public class FlatToString<T1, T2> implements CoFlatMapFunction<T1, T2, String> {
    @Override
    public void flatMap1(T1 value, Collector<String> out) throws Exception {
        out.collect(value.toString());
    }

    @Override
    public void flatMap2(T2 value, Collector<String> out) throws Exception {
        out.collect(value.toString());
    }
}
