package com.hamitmizrak._02_week;


        import org.openjdk.jmh.annotations.*;
        import org.openjdk.jmh.runner.Runner;
        import org.openjdk.jmh.runner.options.Options;
        import org.openjdk.jmh.runner.options.OptionsBuilder;

        import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class _08_3_SwitchVsIfBenchmark {

    private int input;

    @Setup(Level.Invocation)
    public void prepare() {
        input = (int)(Math.random() * 10) + 1; // 1–10 arası sayı
    }

    @Benchmark
    public int testSwitchCase() {
        switch (input) {
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            case 5: return 5;
            case 6: return 6;
            case 7: return 7;
            case 8: return 8;
            case 9: return 9;
            case 10: return 10;
            default: return 0;
        }
    }

    @Benchmark
    public int testIfElse() {
        if (input == 1) return 1;
        else if (input == 2) return 2;
        else if (input == 3) return 3;
        else if (input == 4) return 4;
        else if (input == 5) return 5;
        else if (input == 6) return 6;
        else if (input == 7) return 7;
        else if (input == 8) return 8;
        else if (input == 9) return 9;
        else if (input == 10) return 10;
        else return 0;
    }
}



// TEST
class MainBenchmark {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(_08_3_SwitchVsIfBenchmark.class.getSimpleName()) // test edilecek sınıf
                .forks(1)              // ayrı JVM başlat
                .warmupIterations(5)   // JIT optimizasyonu için ısınma
                .measurementIterations(5) // ölçüm tekrar sayısı
                .build();

        new Runner(opt).run(); // benchmark'ı başlat
    }
}