package com.github.yafeiwang1240;

import com.github.yafeiwang1240.filter.NameFilter;
import com.github.yafeiwang1240.sink.PrintlnSink;
import com.github.yafeiwang1240.source.SourceFactory;
import com.github.yafeiwang1240.transformation.StringToMap;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Job {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> source = SourceFactory.newSelfStream(env);
        source.filter(new NameFilter()).map(new MapFunction<String, Object>() {
            @Override
            public Object map(String s) throws Exception {
                return s.length();
            }
        }).addSink(new PrintlnSink<>());
        env.execute("test");
    }

}
