package com.github.yafeiwang1240;

import com.github.yafeiwang1240.filter.NameFilter;
import com.github.yafeiwang1240.sink.PrintlnSink;
import com.github.yafeiwang1240.source.SourceFactory;
import com.github.yafeiwang1240.transformation.StringToTuple2;
import com.github.yafeiwang1240.transformation.SumReduce;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

public class Job {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> source = SourceFactory.newSelfStream(env);
        source.filter(new NameFilter())
                .map(new StringToTuple2())
                .timeWindowAll(Time.seconds(10))
                .reduce(new SumReduce())
                .addSink(new PrintlnSink<>());
        env.execute("test");
    }

}
