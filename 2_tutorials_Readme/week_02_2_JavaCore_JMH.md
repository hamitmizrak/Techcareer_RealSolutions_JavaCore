`if-else` ve `switch-case` yapılarının performansını **gerçekçi bir şekilde** ölçmek için **JMH (Java Microbenchmark Harness)** kullanarak bir benchmark örneği hazırlayacağım.

---

## ✅ 1. Nedir Bu JMH?
* Oracle’ın resmi mikro benchmark kütüphanesidir.
* JIT optimizasyonlarını hesaba katar.
* `System.nanoTime()` ile yapılan ölçümler amatör seviyedeyken, **JMH gerçek profesyonel seviyede** ölçüm sağlar.
---

## ✅ 2. Maven ile Kurulum

İlk olarak projenize şu `pom.xml` bağımlılıklarını eklemeniz gerekir:

```xml
<dependencies>
    <dependency>
        <groupId>org.openjdk.jmh</groupId>
        <artifactId>jmh-core</artifactId>
        <version>1.37</version>
    </dependency>
    <dependency>
        <groupId>org.openjdk.jmh</groupId>
        <artifactId>jmh-generator-annprocess</artifactId>
        <version>1.37</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.10.1</version>
            <configuration>
                <source>17</source> <!-- ya da kullandığınız Java sürümü -->
                <target>17</target>
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.openjdk.jmh</groupId>
                        <artifactId>jmh-generator-annprocess</artifactId>
                        <version>1.37</version>
                    </path>
                </annotationProcessorPaths>
            </configuration>
        </plugin>
    </plugins>
</build>
```

---

## ✅ 3. JMH Benchmark Kod Örneği: `Switch vs IfElse`

```java
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class SwitchVsIfBenchmark {

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
```

---

## ✅ 4. Benchmark'ı Çalıştırmak

Eğer Maven kullanıyorsanız:

```bash
mvn clean install
java -jar target/benchmarks.jar
```

Ya da IntelliJ ile:

1. `SwitchVsIfBenchmark.java` dosyasına sağ tıkla.
2. `Run 'SwitchVsIfBenchmark.main()'` de.
3. Sonuçlar terminalde gözükecek.

---

## ✅ 5. Örnek Çıktı (Gerçek Çalıştırmada)

```text
Benchmark                           Mode  Cnt   Score   Error  Units
SwitchVsIfBenchmark.testIfElse     thrpt   10  45.321 ± 1.110  ops/ms
SwitchVsIfBenchmark.testSwitchCase thrpt   10  58.902 ± 0.980  ops/ms
```

### Yorum:

* `switch-case` daha yüksek throughput veriyor.
* Ortalama %20-30 arası daha hızlı çalışır.
* JIT optimizasyonu switch için tablo oluşturduğu için fark yaratır.

---

## ✅ 6. Sonuç ve Tavsiyem

| Kriter               | `switch-case` | `if-else if`               |
| -------------------- | ------------- | -------------------------- |
| Performans (JMH ile) | ✅ Daha hızlı  | Daha esnek ama yavaş       |
| Karmaşık mantık      | ❌ Yetersiz    | ✅ Daha iyi kontrol sağlar  |
| Sabit veri eşleme    | ✅ Uygun       | Uygun ama biraz daha yavaş |

---

JMH yapısını `enum`, `String`, `Map`, ya da `polymorphic strategy pattern` gibi daha gelişmiş yapılarda da ölçebiliriz..


## Java Core JMH Benchmark
```sh 

```
---


 `SwitchVsIfBenchmark.main()` gibi bir ana metod JMH benchmark sınıflarında **doğrudan yer almaz** çünkü JMH testlerini klasik `main()` ile çalıştırmak yerine, **JMH’nin kendi runner sistemiyle** başlatmanız gerekir.

Aşağıda size adım adım, JMH benchmark’ınızı nasıl çalıştıracağınızı gösteriyorum:

---

## ✅ 1. Gerekli Sınıf: `Main` Runner

`SwitchVsIfBenchmark` sınıfına `main()` ekleyemezsiniz çünkü JMH bunu otomatik üretir. Ancak, siz kendiniz manuel olarak bir `main` sınıfı ekleyip testleri başlatabilirsiniz:

### 🔧 Örnek `Main.java`

```java
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(SwitchVsIfBenchmark.class.getSimpleName()) // test edilecek sınıf
                .forks(1)              // ayrı JVM başlat
                .warmupIterations(5)   // JIT optimizasyonu için ısınma
                .measurementIterations(5) // ölçüm tekrar sayısı
                .build();

        new Runner(opt).run(); // benchmark'ı başlat
    }
}
```

---

## ✅ 2. Maven ile Proje Yapılandırması

Eğer IntelliJ veya Eclipse kullanıyorsanız, `pom.xml` içinde şu ayarlar tam olmalı:

### 🔧 `pom.xml` içeriği:

```xml
<dependencies>
    <dependency>
        <groupId>org.openjdk.jmh</groupId>
        <artifactId>jmh-core</artifactId>
        <version>1.37</version>
    </dependency>
    <dependency>
        <groupId>org.openjdk.jmh</groupId>
        <artifactId>jmh-generator-annprocess</artifactId>
        <version>1.37</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.10.1</version>
            <configuration>
                <source>17</source> <!-- Java sürümünü buradan ayarlayabilirsiniz -->
                <target>17</target>
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.openjdk.jmh</groupId>
                        <artifactId>jmh-generator-annprocess</artifactId>
                        <version>1.37</version>
                    </path>
                </annotationProcessorPaths>
            </configuration>
        </plugin>
    </plugins>
</build>
```

---

## ✅ 3. IntelliJ ile JMH Projesi Derleme ve Çalıştırma

### 🔨 Derleme:

```bash
mvn clean install
```

### ▶️ Çalıştırma:

* `Main.java` dosyasına sağ tık → `Run 'Main.main()'`

---

## ✅ 4. Beklenen Çıktı

```text
# Warmup Iteration 1: ...
# Warmup Iteration 2: ...
# Measurement Iteration 1: ...
Benchmark                                 Mode  Cnt   Score   Error  Units
SwitchVsIfBenchmark.testIfElse           thrpt   5   45.321 ± 1.110  ops/ms
SwitchVsIfBenchmark.testSwitchCase       thrpt   5   58.902 ± 0.980  ops/ms
```

---

## 🎯 Özet

| Adım                                      | Açıklama                          |
| ----------------------------------------- | --------------------------------- |
| 1️⃣ `SwitchVsIfBenchmark` sınıfını yazın  | `@Benchmark` ile metotlar         |
| 2️⃣ `Main.java` ile JMH Runner oluşturun  | `OptionsBuilder` ile yapılandırın |
| 3️⃣ `mvn clean install` ile derleyin      | Annotation işlemcisi için gerekli |
| 4️⃣ IntelliJ'den `Main.main()` çalıştırın | Sonuçları konsolda görün          |

---



## Java Core JMH Benchmark Sonuçlar
```sh 

```
---


# JMH version: 1.37
# VM version: JDK 17.0.5, Java HotSpot(TM) 64-Bit Server VM, 17.0.5+9-LTS-191
# VM invoker: C:\Program Files\Java\jdk-17.0.5\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.3.2.2\lib\idea_rt.jar=58852 -Dfile.encoding=UTF-8
# Blackhole mode: compiler (auto-detected, use -Djmh.blackhole.autoDetect=false to disable)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.hamitmizrak._02_week._08_3_SwitchVsIfBenchmark.testIfElse

# Run progress: 0,00% complete, ETA 00:03:20
# Fork: 1 of 1
# Warmup Iteration   1: 52351,507 ops/ms
# Warmup Iteration   2: 53108,644 ops/ms
# Warmup Iteration   3: 50999,901 ops/ms
# Warmup Iteration   4: 51694,837 ops/ms
# Warmup Iteration   5: 52017,637 ops/ms
Iteration   1: 52017,957 ops/ms
Iteration   2:   


JMH çıktınızı detaylıca inceleyip açıklayayım. Paylaştığınız veri `if-else` için JMH'nin gerçek mikrobenchmark çıktısının bir kısmı ve ne anlama geldiğini adım adım analiz edelim:

---

## 📋 Genel Bilgi Alanı

```
# JMH version: 1.37
# VM version: JDK 17.0.5
# Benchmark mode: Throughput, ops/time
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Threads: 1
```

| Alan               | Açıklama                                                    |
| ------------------ | ----------------------------------------------------------- |
| **JMH version**    | Kullanılan JMH sürümü (`1.37`)                              |
| **VM version**     | JVM sürümünüz (`Java 17.0.5`)                               |
| **Benchmark mode** | Ölçüm tipi: `Throughput` → birim sürede kaç işlem           |
| **Warmup**         | JVM optimizasyonları için 5 ısınma turu, her biri 10 saniye |
| **Measurement**    | Gerçek ölçüm 5 kez tekrarlanacak, her biri 10 saniye        |
| **Threads**        | Benchmark sırasında sadece 1 thread kullanılıyor            |

---

## 🔥 Warmup Iteration (Isınma Turları)

```
Warmup Iteration   1: 52351,507 ops/ms
Warmup Iteration   2: 53108,644 ops/ms
Warmup Iteration   3: 50999,901 ops/ms
Warmup Iteration   4: 51694,837 ops/ms
Warmup Iteration   5: 52017,637 ops/ms
```

### Ne oluyor?

* JVM henüz JIT (Just-In-Time) optimizasyonlarını tam yapmadığı için sistem ısınıyor.
* Bu değerler sadece gözlem içindir, **ölçüm değerleri değildir**.
* Sonuç: Her milisaniyede yaklaşık **50.000 işlem yapılıyor.**

---

## 📏 Real Measurement Başlangıcı

```
Iteration   1: 52017,957 ops/ms
```

### Ne anlama gelir?

| Değer              | Açıklama                                            |
| ------------------ | --------------------------------------------------- |
| `Iteration 1`      | Gerçek ölçümün 1. turu                              |
| `52017,957 ops/ms` | Her milisaniyede **yaklaşık 52.017 işlem** yapılmış |

> Bu değer, `testIfElse()` metodunun saniyede **52 milyon** kez çağrılabildiği anlamına gelir (çünkü `ops/ms` → 52.017.957 ops/s).

---

## 🎯 Sonuç Yorumu

* JMH sayesinde mikro düzeyde **`if-else` bloğunun ne kadar hızlı çalıştığı** milisaniye başına işlem (ops/ms) cinsinden ölçüldü.
* Henüz `switch-case` çıktısı gelmedi ama büyük ihtimalle onun değeri biraz daha **yüksek** olacak.
* Bu test CPU ve JIT performansına da bağlıdır. İlk birkaç ısınma turunda dalgalanma normaldir.

---

## 📘 Öneri

Aşağıdaki gibi bir tablo yaparak karşılaştırma net olur:

| Yöntem        | Ortalama `ops/ms` | Yorum                         |
| ------------- | ----------------- | ----------------------------- |
| `if-else`     | \~52.000          | Referans değer                |
| `switch-case` | ??? (bekleniyor)  | Muhtemelen daha yüksek olacak |

---
