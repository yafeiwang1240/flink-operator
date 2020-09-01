package com.github.yafeiwang1240.transformation;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;

public class MaxReduce implements ReduceFunction<Tuple2<String, Integer>> {

    @Override
    public Tuple2<String, Integer> reduce(Tuple2<String, Integer> stringIntegerTuple2, Tuple2<String, Integer> t1) throws Exception {
        stringIntegerTuple2.f1 = Math.max(stringIntegerTuple2.f1, t1.f1);
        return stringIntegerTuple2;
    }
}
