package no.hvl.dat102;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class YtelseEksempel {

    @Param({"1000000",
            "10000000",
            "100000000",
            "1000000000"})
    public long n;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 0)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 2, time = 5)
    @Measurement(iterations = 4, time = 5)
    public void testTid() {
        tid(n);
    }

    public static void tid(long n) {
        long k = 0;
        for (int i = 0; i < n; i++) {
            k = k + 5;
        }
    }
}
