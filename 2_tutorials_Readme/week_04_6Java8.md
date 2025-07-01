## Java 8 Gelenler
```sh 

```
---

Java 8, Mart 2014'te yayımlanmış ve Java diline **büyük çaplı modern programlama yetenekleri** kazandırmıştır. Özellikle **fonksiyonel programlama**, **lambda ifadeleri**, **stream API**, **zaman API’leri** gibi konular Java tarihinde ciddi bir devrim niteliği taşır.

Bu açıklamada Java 8 ile gelen tüm konuları **çok detaylı** ve **sıralı şekilde** anlatıyorum. Gerekirse yazının devamı için senden onay alacağım.

---

## 🧭 Java 8 ile Gelen Bütün Önemli Özellikler

### 1. 🔥 **Lambda Expressions (Lambda İfadeleri)**

### 2. 🔁 **Functional Interfaces (Fonksiyonel Arayüzler)**

### 3. 📦 **java.util.function Package**

### 4. 🧼 **Method References (Metot Referansları)**

### 5. ⚙️ **Default ve Static Interface Methods**

### 6. 🚿 **Stream API**

### 7. 🧱 **Optional Sınıfı**

### 8. ⏰ **Date and Time API (java.time)**

### 9. 🧩 **Collectors API**

### 10. 📜 **Nashorn JavaScript Engine**

### 11. 🧩 **Base64 Encoding/Decoding API**

### 12. 📌 **@FunctionalInterface Annotation**

### 13. 🗃️ **Parallel Streams**

### 14. 📚 **CompletableFuture (Concurrency)**

### 15. 📘 **Files.list(), Files.walk(), vb. yeni NIO API'ler**

---

## 🔥 1. **Lambda Expressions (Fonksiyonel Programlama’nın Kapısı)**

Lambda ifadeleri, **anonim fonksiyonlar** yazmamızı sağlar. Özellikle interface'leri parametre gibi geçmek için kullanılır.

### Örnek:

```java
// Geleneksel yaklaşım
Runnable r1 = new Runnable() {
    public void run() {
        System.out.println("Çalışıyor...");
    }
};

// Lambda ile
Runnable r2 = () -> System.out.println("Çalışıyor...");
```

### Genel Söz Dizimi:

```java
(parametreler) -> { işlemler }
```

### Örnek:

```java
(int a, int b) -> a + b
() -> System.out.println("Merhaba")
```

---

## 🔁 2. **Functional Interface (Tek Abstract Metodu Olan Interface)**

Lambda ifadeleri sadece **tek abstract metodu** olan interface'lerde kullanılabilir. Bu tür interface'lere **functional interface** denir.

### Örnek:

```java
@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b);
}
```

> Eğer bir interface içinde sadece **1 tane abstract metot** varsa ve `@FunctionalInterface` ile işaretlenmişse, bu **lambda uyumludur.**

---

## 📦 3. **java.util.function Package (Hazır Fonksiyonel Arayüzler)**

Java 8 ile birlikte gelen bu paket, birçok **hazır fonksiyonel interface** içerir:

| Interface           | Giriş | Çıkış   | Açıklama                        |
| ------------------- | ----- | ------- | ------------------------------- |
| `Predicate<T>`      | T     | boolean | Koşul kontrolü                  |
| `Function<T,R>`     | T     | R       | Dönüştürme                      |
| `Consumer<T>`       | T     | void    | İşlem yapar ama sonuç döndürmez |
| `Supplier<T>`       | -     | T       | Değer üretir                    |
| `UnaryOperator<T>`  | T     | T       | T → T işlemi                    |
| `BinaryOperator<T>` | T, T  | T       | İki T türü girdi, bir T çıktısı |

---

## 🧼 4. **Method References (Metot Referansı)**

Lambda ifadelerini daha da sadeleştirir.

### Örnek:

```java
list.forEach(s -> System.out.println(s));

// method reference ile:
list.forEach(System.out::println);
```

### Söz Dizimi:

```java
ClassName::methodName
```

---

## ⚙️ 5. **Default ve Static Interface Methods**

Artık interface'lerde:

* `default` metotlar → override edilebilir.
* `static` metotlar → sadece interface üzerinden çağrılır.

```java
interface Engine {
    default void start() {
        System.out.println("Başlatılıyor...");
    }

    static void info() {
        System.out.println("Motor bilgisi");
    }
}
```

---

Buraya kadar Java 8’in en temel ve kritik fonksiyonel programlama bileşenlerini anlattım. Devamında şunlar:

* `Stream API`
* `Optional`
* `java.time` tarih/saat yapıları
* `Collectors`
* `Nashorn`, `Base64`, `CompletableFuture`, `Parallel Stream`



## Java 8 Gelenler
```sh 

```
---

Java 8’in en kritik yapı taşlarından biri olan **Stream API** ile devam edilecek. Ardından `Optional`, `Date/Time API`, `Collectors`, `CompletableFuture` gibi yapıları da detaylıca anlatılacaktır.

---

## 🚿 6. **Stream API (Akış İşlemleri)**

### ✅ Nedir?

`Stream API`, koleksiyonlar (List, Set, vb.) üzerinde **daha fonksiyonel ve zincirleme (pipeline)** bir şekilde işlem yapmamızı sağlar.

### ✅ Ne işe yarar?

* Veriyi filtreleme, dönüştürme, sıralama, gruplama gibi işlemleri kolaylaştırır.
* **Immutable** ve **lazy** (geç çalıştırılan) bir yapı sunar.

---

### 🔹 a. Stream nasıl elde edilir?

```java
List<String> isimler = List.of("Ali", "Ayşe", "Veli");
Stream<String> stream = isimler.stream();
```

---

### 🔹 b. Temel işlem zinciri

```java
List<String> sonuc = isimler.stream()
    .filter(s -> s.startsWith("A"))        // Ayşe
    .map(String::toUpperCase)              // AYŞE
    .sorted()
    .collect(Collectors.toList());         // toList() ile topla
```

---

### 🔹 c. Önemli `Stream` Metotları

| Metot                                       | Açıklama                                  |
| ------------------------------------------- | ----------------------------------------- |
| `filter(Predicate)`                         | Koşula uyanları al                        |
| `map(Function)`                             | Dönüştürme işlemi                         |
| `sorted()`                                  | Sıralama                                  |
| `limit(n)` / `skip(n)`                      | İlk n öğeyi al / atla                     |
| `distinct()`                                | Tekrar edenleri çıkar                     |
| `collect()`                                 | Sonucu toplar (`List`, `Set`, `Map`, vb.) |
| `forEach()`                                 | Her eleman için işlem                     |
| `count()`                                   | Eleman sayısı                             |
| `anyMatch()` / `allMatch()` / `noneMatch()` | Koşullu arama                             |
| `reduce()`                                  | Kümülatif işlem (örneğin toplama)         |

---

### 🔹 d. Örnek: Integer Liste Toplamı

```java
List<Integer> sayilar = List.of(1, 2, 3, 4, 5);

int toplam = sayilar.stream()
    .reduce(0, (a, b) -> a + b); // 15
```

> `reduce()` — birikimli işlem yapar. İlk parametre "başlangıç değeri".

---

## 🧱 7. **Optional Sınıfı (NullPointerException’a Karşı)**

Java 8 ile gelen `Optional<T>`, **null olabilecek değerler için güvenli bir kapsayıcıdır.**

---

### 🔹 a. Neden Gerekli?

```java
String name = user.getName(); // NullPointerException riski!
```

---

### 🔹 b. Optional Kullanımı

```java
Optional<String> name = Optional.of("Ali");
Optional<String> bos = Optional.empty();
```

---

### 🔹 c. Temel Metotlar

| Metot                       | Açıklama                    |
| --------------------------- | --------------------------- |
| `isPresent()` / `isEmpty()` | Değer var mı?               |
| `get()`                     | Değeri al (risklidir)       |
| `orElse("X")`               | Yoksa X döndür              |
| `orElseGet(Supplier)`       | Yoksa fonksiyondan değer al |
| `orElseThrow()`             | Yoksa hata fırlat           |
| `ifPresent(Consumer)`       | Değer varsa işlem yap       |
| `map(Function)`             | Değeri dönüştür             |

---

### 🔹 d. Örnek

```java
Optional<String> isim = Optional.ofNullable(getName());

String sonuc = isim
    .map(String::toUpperCase)
    .orElse("İSİM YOK");
```

---

## ⏰ 8. **Date and Time API (java.time paketi)**

Java 8 öncesi `Date`, `Calendar` sınıfları:

* Thread-safe değildi
* Kullanımı zordu
* Zaman dilimi desteği eksikti

Java 8 ile gelen `java.time` paketi bu sorunları çözmek için üretildi.

---

### 🔹 a. Temel Sınıflar

| Sınıf           | Açıklama                       |
| --------------- | ------------------------------ |
| `LocalDate`     | Sadece tarih                   |
| `LocalTime`     | Sadece saat                    |
| `LocalDateTime` | Tarih + saat                   |
| `ZonedDateTime` | Zaman dilimi ile tarih/saat    |
| `Period`        | İki tarih arası süre           |
| `Duration`      | Zaman farkı (saat, saniye, ms) |

---

### 🔹 b. Kullanım Örnekleri

```java
LocalDate bugun = LocalDate.now();
LocalDate dogum = LocalDate.of(1990, 5, 20);

Period yas = Period.between(dogum, bugun);
System.out.println("Yaş: " + yas.getYears());

LocalTime saat = LocalTime.now();
System.out.println(saat);
```

---

### 🔹 c. Formatlama / Parse

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String str = bugun.format(formatter);
```

---

## 📦 9. **Collectors API**

`Stream.collect(...)` işlemi için kullanılan utility sınıflardır.

---

### 🔹 a. Sık Kullanılan Collectors

| Metot                       | Açıklama                 |
| --------------------------- | ------------------------ |
| `toList()`                  | Liste döner              |
| `toSet()`                   | Set döner                |
| `joining(", ")`             | String birleştirme       |
| `counting()`                | Eleman sayısı            |
| `summarizingInt(...)`       | İstatistiksel özet       |
| `groupingBy(Function)`      | Gruplama işlemi          |
| `partitioningBy(Predicate)` | true/false olarak ayırır |

---

### 🔹 b. Örnek

```java
List<String> isimler = List.of("Ali", "Ayşe", "Ali");

Map<String, Long> frekans = isimler.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
```

---

Devamında şu başlıklar var:

* `CompletableFuture` (asenkron programlama)
* `Parallel Stream`
* `Nashorn`, `Base64`, `Files.walk()`, `Predicate chaining`, `Interface Enhancements` örnekleri



## Java 8 Gelenler
```sh 

```
---

Harika. Java 8’in son büyük parçaları olan **asenkron işlemler**, **parallel stream**, **Nashorn**, **Base64**, `Files.walk()`, ve diğer yardımcı API’lerle devam ediyorum. Bu bölümler daha çok **sistem düzeyinde geliştirme**, **verimlilik** ve **modern mimari ihtiyaçlarına** hitap eder.

---

## 🔀 10. **CompletableFuture (Asenkron Programlama)**

Java 8 ile gelen `CompletableFuture`, `Future` arayüzünü genişleterek **daha güçlü ve zincirlenebilir asenkron işlemler** yapılmasını sağlar.

### 🔹 a. Neden Kullanılır?

* Bir işlemi **başka bir thread’de** başlatmak ve sonuçları sonra almak
* **Callback**, **thenApply**, **thenCombine**, **exceptionally** gibi zincirleme işlemlerle iş akışı oluşturmak

---

### 🔹 b. Temel Kullanım

```java
CompletableFuture<String> gelecekte = CompletableFuture.supplyAsync(() -> {
    // uzun süren bir işlem
    return "veri";
});

String sonuc = gelecekte.get(); // blocking (bekler)
```

---

### 🔹 c. Zincirleme İşlem

```java
CompletableFuture.supplyAsync(() -> "hamit")
    .thenApply(String::toUpperCase)
    .thenAccept(System.out::println);
```

---

### 🔹 d. Paralel işlemleri birleştirme

```java
CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "A");
CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "B");

CompletableFuture<String> f3 = f1.thenCombine(f2, (a, b) -> a + b);
System.out.println(f3.get()); // AB
```

---

## 🧵 11. **Parallel Stream (Çoklu İş Parçacığı ile Akış)**

Stream API'nin `.parallelStream()` versiyonu, işlemleri **çok çekirdekli olarak çalıştırır**.

---

### 🔹 a. Kullanım

```java
List<String> isimler = List.of("Ali", "Ayşe", "Veli");

isimler.parallelStream()
    .forEach(System.out::println);
```

> `parallelStream()`, varsayılan olarak **ForkJoinPool.commonPool** kullanır.

---

### 🔹 b. Ne zaman kullanmalı?

| Uygunsa                 | Uygun Değilse                                          |
| ----------------------- | ------------------------------------------------------ |
| Çok büyük veri seti     | Küçük veri seti                                        |
| İşlem CPU-bound (yoğun) | I/O ağırlıklı işlemler                                 |
| Side-effect yoksa       | Aynı anda aynı veri yazılıyorsa (thread safety sorunu) |

---

## 🌐 12. **Nashorn JavaScript Engine**

Java 8 ile gelen **Nashorn**, JVM içinde **JavaScript kodu çalıştırmanı** sağlar. Artık Java 15 sonrası kaldırılmıştır ama Java 8'de kullanılabilir.

---

### 🔹 Kullanım

```java
import javax.script.*;

ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval("print('Merhaba JavaScript!')");
```

---

## 🔐 13. **Base64 Encode / Decode**

Java 8 ile gelen `java.util.Base64` sınıfı, metin ve veri şifreleme/çözme için kullanılır.

### 🔹 Kullanım

```java
String metin = "hamit";
String encoded = Base64.getEncoder().encodeToString(metin.getBytes());
byte[] decodedBytes = Base64.getDecoder().decode(encoded);
String decoded = new String(decodedBytes);

System.out.println(encoded); // aGFtaXQ=
System.out.println(decoded); // hamit
```

---

## 🗂️ 14. **Yeni NIO Özellikleri: Files.walk, Files.list**

### 🔹 a. Dizin içeriğini listeleme

```java
Files.list(Paths.get("."))
    .forEach(System.out::println);
```

### 🔹 b. Alt dizinleri dolaşmak (recursive)

```java
Files.walk(Paths.get("."), 2)
    .filter(Files::isRegularFile)
    .forEach(System.out::println);
```

---

## 🧪 15. **Predicate Chaining (And-Or-Negate)**

Java 8’de `Predicate` yapıları zincirleme işlem alabilir.

```java
Predicate<String> uzun = s -> s.length() > 3;
Predicate<String> icA = s -> s.contains("a");

Predicate<String> filtre = uzun.and(icA);

System.out.println(filtre.test("hamit")); // true
```

---

## 🧩 16. **Interface Enhancements: Multiple Default Methods**

Aynı interface içinde birden fazla `default` metot olabilir:

```java
interface A {
    default void run() {
        System.out.println("A çalıştı");
    }
}

interface B {
    default void run() {
        System.out.println("B çalıştı");
    }
}

class C implements A, B {
    public void run() {
        A.super.run(); // ikisinden birini açıkça seçmelisin
    }
}
```

---

## 📌 SONUÇ: Java 8'in Temel Katmanları

| Kategori       | Başlıklar                                                         |
| -------------- | ----------------------------------------------------------------- |
| Fonksiyonel    | Lambda, FunctionalInterface, Method Reference, java.util.function |
| Stream         | Stream API, Collectors, ParallelStream                            |
| Null Güvenliği | Optional                                                          |
| Tarih/Saat     | java.time paketi                                                  |
| Asenkron       | CompletableFuture                                                 |
| Sistem         | Base64, Files.walk, Nashorn                                       |

---




## Java 8 ile birlikte gelen tüm örnekleri içeren demo projeyi
```sh 

```
---

Aşağıda  Java 8 ile gelen tüm konuları kapsayan **örnek bir demo proje yapısı** . Bu demo:

* Tüm ana başlıkları içerir (Lambda, Stream, Optional, Date/Time, CompletableFuture, vs.)
* Maven yapısında organize edilmiştir
* Her konuyu ayrı class olarak modülerleştirir
* `Main.java` dosyasından test edilebilir

---

## 🧱 1. MAVEN PROJE YAPISI

```
java8-demo/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── hamitmizrak/
                    ├── Main.java
                    ├── lambda/
                    │   ├── LambdaExample.java
                    │   └── FunctionalInterfaceExample.java
                    ├── stream/
                    │   ├── StreamExample.java
                    │   └── CollectorsExample.java
                    ├── optional/
                    │   └── OptionalExample.java
                    ├── datetime/
                    │   └── DateTimeExample.java
                    ├── completable/
                    │   └── CompletableFutureExample.java
                    ├── base64/
                    │   └── Base64Example.java
                    ├── nio/
                    │   └── FileWalkExample.java
```

---

## 🧾 2. `pom.xml` (Java 8 kullanımı için)

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" ...>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.hamitmizrak</groupId>
    <artifactId>java8-demo</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
</project>
```

---

## ✅ 3. `Main.java`

```java
package com.hamitmizrak;

import com.hamitmizrak.lambda.LambdaExample;
import com.hamitmizrak.optional.OptionalExample;
import com.hamitmizrak.stream.StreamExample;

public class Main {
    public static void main(String[] args) {
        LambdaExample.run();
        StreamExample.run();
        OptionalExample.run();
    }
}
```

---

## 🔥 4. Lambda Örneği (`LambdaExample.java`)

```java
package com.hamitmizrak.lambda;

import java.util.function.Consumer;

public class LambdaExample {
    public static void run() {
        Runnable r = () -> System.out.println("Lambda ile çalışıyor");
        r.run();

        Consumer<String> yazici = s -> System.out.println("Yaz: " + s);
        yazici.accept("Merhaba Lambda");
    }
}
```

---

## 🧩 5. Stream Örneği (`StreamExample.java`)

```java
package com.hamitmizrak.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void run() {
        List<String> liste = List.of("java", "react", "spring", "docker");

        List<String> filtre = liste.stream()
                .filter(s -> s.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        filtre.forEach(System.out::println);
    }
}
```

---

## 🧱 6. Optional Örneği (`OptionalExample.java`)

```java
package com.hamitmizrak.optional;

import java.util.Optional;

public class OptionalExample {
    public static void run() {
        Optional<String> ad = Optional.ofNullable("Hamit");
        ad.ifPresent(a -> System.out.println("Ad: " + a));

        String sonuc = ad.map(String::toUpperCase).orElse("BOŞ");
        System.out.println("Sonuç: " + sonuc);
    }
}
```

---

## ⏰ 7. Date/Time (`DateTimeExample.java`)

```java
package com.hamitmizrak.datetime;

import java.time.LocalDate;
import java.time.Period;

public class DateTimeExample {
    public static void run() {
        LocalDate dogum = LocalDate.of(1990, 1, 1);
        LocalDate bugun = LocalDate.now();

        Period yas = Period.between(dogum, bugun);
        System.out.println("Yaş: " + yas.getYears());
    }
}
```

---

## 🔄 8. CompletableFuture (`CompletableFutureExample.java`)

```java
package com.hamitmizrak.completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void run() {
        CompletableFuture.supplyAsync(() -> "Veri")
            .thenApply(String::toUpperCase)
            .thenAccept(System.out::println);
    }
}
```

---

## 🧪 9. Base64 (`Base64Example.java`)

```java
package com.hamitmizrak.base64;

import java.util.Base64;

public class Base64Example {
    public static void run() {
        String veri = "hamit";
        String encoded = Base64.getEncoder().encodeToString(veri.getBytes());
        System.out.println("Encode: " + encoded);

        String decoded = new String(Base64.getDecoder().decode(encoded));
        System.out.println("Decode: " + decoded);
    }
}
```

---

## 🗂️ 10. Dosya Listeleme (`FileWalkExample.java`)

```java
package com.hamitmizrak.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWalkExample {
    public static void run() {
        try {
            Files.walk(Paths.get("."))
                 .filter(Files::isRegularFile)
                 .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 🧪 Test ve Genişletme

Main.java üzerinden tüm sınıflar çağrılır. Yeni modüller şu şekilde entegre edilebilir:

```java
Base64Example.run();
CompletableFutureExample.run();
DateTimeExample.run();
FileWalkExample.run();
```

---

## 📁 Projeyi GitHub’a Aktarmak İçin Hazır README.md Önerisi

````markdown
# Java 8 Demo Projesi

Bu proje, Java 8 ile gelen tüm yeniliklerin uygulamalı örneklerini içerir.

## Konular
- Lambda Expressions
- Functional Interfaces
- Stream API
- Optional
- Date/Time API
- CompletableFuture
- Base64 Encoding/Decoding
- Files.walk (NIO)

## Nasıl çalıştırılır?
```bash
mvn clean compile exec:java -Dexec.mainClass="com.hamitmizrak.Main"
````

## Yazar

Hamit Mızrak

```

---






## Java 8 Gelenler
```sh 

```
---
