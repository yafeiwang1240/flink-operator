package com.github.yafeiwang1240.sink;

import org.apache.flink.streaming.api.functions.sink.SinkFunction;

public class PrintlnSink<T> implements SinkFunction<T> {

    @Override
    public void invoke(T value, Context context) throws Exception {
        System.out.println(value);
    }
}
