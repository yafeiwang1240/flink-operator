package com.github.yafeiwang1240;

import com.github.yafeiwang1240.sink.PrintlnSink;
import com.github.yafeiwang1240.source.SourceFactory;
import com.github.yafeiwang1240.transformation.StringToTuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

public class Job {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(60000);
        DataStreamSource<String> source = SourceFactory.newSelfStream(env);
        source.map(new StringToTuple2())
                .timeWindowAll(Time.seconds(10))
                .sum(1)
                .addSink(new PrintlnSink<>());
        env.execute("test");
    }

}
