# Eksempel på bruk av java harness (jmh) for å gjøre ytelsestester i java


```java
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
```

Resultater med konfidensintervall på 99.9%: 
```
Benchmark                      (n)  Mode  Cnt    Score   Error  Units
YtelseEksempel.testTid     1000000  avgt    4    0.390 ± 0.001  ms/op
YtelseEksempel.testTid    10000000  avgt    4    3.897 ± 0.018  ms/op
YtelseEksempel.testTid   100000000  avgt    4   38.980 ± 0.143  ms/op
YtelseEksempel.testTid  1000000000  avgt    4  389.885 ± 1.804  ms/op
```
