## Java Core Lombok
```sh 

```
---

Java'da **Lombok**, geliştiricilerin daha az kod yazarak daha okunabilir ve sade sınıflar oluşturmasına yardımcı olan **bir Java kütüphanesidir**. Özellikle **boilerplate** (tekrarlayan, standart, sıkıcı kodlar) kodları otomatik olarak jenerik hale getirir.

---

## 🔍 1. LOMBOK NEDİR?

Lombok, Java sınıflarında sıkça yazmak zorunda olduğumuz aşağıdaki gibi tekrar eden kodları otomatik olarak oluşturur:

* Getter ve Setter metotları
* `toString()`, `equals()`, `hashCode()` metotları
* Constructor'lar (parametreli, parametresiz)
* Builder pattern
* Logger objesi
* `@Synchronized`, `@Cleanup`, `@SneakyThrows` gibi yardımcı anotasyonlar

---

## 🧠 2. NEDEN LOMBOK KULLANILIR?

| Geleneksel Java                         | Lombok ile                                 |
| --------------------------------------- | ------------------------------------------ |
| Çok sayıda boilerplate kod              | Temiz ve kısa sınıf tanımı                 |
| IDE içinde sürekli getter/setter üretme | Otomatik olarak derleme aşamasında eklenir |
| Kodun okunabilirliği düşer              | Daha sade ve okunaklı sınıflar             |

---

## ⚙️ 3. MAVEN & GRADLE ENTEGRASYONU

### Maven için:

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <scope>provided</scope>
</dependency>
```

### Gradle için:

```groovy
dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.32'
    annotationProcessor 'org.projectlombok:lombok:1.18.32'
}
```

---

## 🧪 4. ÖRNEKLERLE LOMBOK ANOTASYONLARI

### ✅ `@Getter` / `@Setter`

```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private int age;
}
```

> Otomatik olarak `getName()`, `setName()` gibi metotlar oluşturur.

---

### ✅ `@ToString`

```java
import lombok.ToString;

@ToString
public class Book {
    private String title;
    private double price;
}
```

> `toString()` metodunu otomatik üretir.

---

### ✅ `@NoArgsConstructor`, `@AllArgsConstructor`, `@RequiredArgsConstructor`

```java
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
    @NonNull private String name;
    private int age;
}
```

> 3 tip constructor üretir:

* Parametresiz
* Tüm alanları içeren
* Sadece `@NonNull` alanları içeren

---

### ✅ `@Data` (TOPLU ANOTASYON)

```java
import lombok.Data;

@Data
public class Employee {
    private String id;
    private String name;
}
```

> Şunları birden üretir:

* `@Getter`
* `@Setter`
* `@RequiredArgsConstructor`
* `@ToString`
* `@EqualsAndHashCode`

---

### ✅ `@Builder` (Builder Pattern)

```java
import lombok.Builder;

@Builder
public class Car {
    private String brand;
    private String model;
    private int year;
}
```

> Kullanım:

```java
Car car = Car.builder()
             .brand("Toyota")
             .model("Corolla")
             .year(2022)
             .build();
```

---

### ✅ `@Value` (Immutable Class için)

```java
import lombok.Value;

@Value
public class Currency {
    String code;
    double value;
}
```

> Final sınıf gibi davranır. Tüm alanlar `final` olur, setter yoktur.

---

### ✅ `@Slf4j` (Logger Enjeksiyonu)

```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogExample {
    public void doSomething() {
        log.info("Lombok ile loglama");
    }
}
```

---


Lombok, yukarıda anlattıklarımız dışında daha az bilinen ama profesyonel projelerde oldukça işlevsel olan birçok **ileri seviye anotasyon** da sunar. Aşağıda bunları **kategori kategori** ve örneklerle açıklayarak veriyorum.

---

## 📦 1. **KAYNAK YÖNETİMİ ANOTASYONLARI**

### ✅ `@Cleanup`

* Otomatik olarak `close()` metodunu çağırır.
* `try-with-resources` alternatifi gibi çalışır.

```java
import lombok.Cleanup;
import java.io.*;

public class Example {
    public void readFile() throws IOException {
        @Cleanup InputStream in = new FileInputStream("dosya.txt");
        // dosya kapanır
    }
}
```

---

## 🧵 2. **SENKRONİZASYON ANOTASYONU**

### ✅ `@Synchronized`

* `synchronized` keyword'üne alternatif olarak kullanılır.
* Thread-safe metodlar oluşturur.
* Ancak `this` yerine özel bir `lock` objesi kullanır (`$lock`).

```java
import lombok.Synchronized;

public class ThreadSafeCounter {
    private int count = 0;

    @Synchronized
    public void increment() {
        count++;
    }
}
```

---

## 💣 3. **HATA YÖNETİMİ ANOTASYONU**

### ✅ `@SneakyThrows`

* Checked exception'ları `throws` etmeden fırlatır.
* Kodu sadeleştirir ama dikkatli kullanılmalıdır.

```java
import lombok.SneakyThrows;

public class Sneaky {
    @SneakyThrows
    public void riskyMethod() {
        throw new IOException("Hata");
    }
}
```

---

## 🧱 4. **FIELD TANIMLAMA ANOTASYONLARI**

### ✅ `@NonNull`

* Null değer atanmasına karşı runtime'da `NullPointerException` fırlatır.
* `@RequiredArgsConstructor` ile birlikte kullanıldığında constructor içinde kontrol eder.

```java
import lombok.NonNull;

public class Product {
    public Product(@NonNull String name) {
        // name null ise NPE fırlatılır
    }
}
```

---

## 🧰 5. **ACCESS LEVEL AYARLARI**

### ✅ `@FieldDefaults`

* Tüm alanlara tek satırda erişim belirteci tanımlar (örneğin tüm alanlar `private final` olsun).

```java
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String name;
    int age;
}
```

---

## 🧱 6. **STATİK SINIFLAR VE YARDIMCI ANOTASYONLAR**

### ✅ `@UtilityClass`

* Tüm metotları `static` yapar.
* Constructor’ı private yapar.
* Java’da klasik "Helper" sınıfı oluşturmanın en kısa yolu.

```java
import lombok.experimental.UtilityClass;

@UtilityClass
public class MathUtil {
    public int sum(int a, int b) {
        return a + b;
    }
}
```

---

## 🔂 7. **DEĞİŞMEZLİK (IMMUTABILITY) ANOTASYONLARI**

### ✅ `@Value`

* `@Data`’nın immutable versiyonudur.
* Tüm field’ları `final` yapar, setter oluşturmaz.

### ✅ `@With`

* Immutable sınıflarda alanın yeni bir kopyasını oluşturur (Java'daki `.withX()` gibi çalışır).

```java
import lombok.Value;
import lombok.With;

@Value
public class Person {
    String name;
    @With int age;
}

// Kullanım
Person p1 = new Person("Ali", 25);
Person p2 = p1.withAge(30);
```

---

## 🏗️ 8. **@Builder Gelişmiş Kullanımlar**

### ✅ `@Builder.Default`

* `@Builder` ile birlikte `default` değer atamak istiyorsan kullanılır.

```java
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Employee {
    private String name;

    @Builder.Default
    private int age = 30;
}
```

---

## 🧬 9. **@Accessors (Fluent / Chain Style)**

* `@Getter` ve `@Setter` ile birlikte kullanılır.
* Metot isimlerini `getX()` yerine `x()` olarak veya zincirleme (`.setX().setY()`) şekilde kullanılmasını sağlar.

```java
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true, fluent = true)
public class ChainUser {
    private String name;
    private int age;
}

// Kullanım:
new ChainUser().name("Ali").age(30);
```

---

## 🔐 10. `@EqualsAndHashCode` Gelişmiş Kullanım

```java
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = "age") // bu alanı kıyaslamaya dahil etme
public class Student {
    private String name;
    private int age;
}
```

---

## 📚 11. LOMBOK + JPA UYUMU

Lombok, JPA ile birlikte kullanılırken dikkat edilmesi gereken birkaç nokta vardır:

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
```

> ⚠️ `@Builder` ve `@NoArgsConstructor` birlikte kullanılmazsa JPA hata verebilir.

---

## 🚫 LOMBOK ALTERNATİFLERİ (NOTLAR)

* **AutoValue (Google)**: Immutable sınıflar üretmek için.
* **Immutables**: Daha gelişmiş yapılandırma.
* **Record (Java 14+)**: Java'nın kendi `data class` alternatifi.

---

## 🧭 SONUÇ: LOMBOK’U NE ZAMAN KULLANMALI?

| Kullanım Durumu                     | Lombok Önerisi         |
| ----------------------------------- | ---------------------- |
| DTO, Entity, Config sınıfları       | Evet ✅                 |
| Karmaşık iş mantıklı sınıflar       | Dikkatli ⚠️            |
| Eğitim/öğrenme süreçlerinde         | İlk aşamada hayır ❌    |
| Microservice, Spring Boot projeleri | Güçlü kullanım alanı ✅ |

---



3333333333

## 🛠️ 5. Lombok Nasıl Çalışır?

Lombok, **compile-time annotation processing (APT)** ile çalışır. Yani yazdığınız kodu doğrudan değiştirmez, derleyiciye “bu sınıfa şunları ekle” der. Bu sayede sınıflar temiz kalır ama derlenmiş `.class` dosyalarında tüm metotlar yer alır.

> 💡 IDE'de Lombok çalışması için eklenti yüklenmelidir.
>
> * IntelliJ: `Preferences > Plugins > Lombok Plugin`
> * Eclipse: Lombok jar’ı `-javaagent` olarak tanımlanmalı

---

## 🛑 6. Dezavantajları

| Sorun               | Açıklama                                                            |
| ------------------- | ------------------------------------------------------------------- |
| IDE Uyum Sorunu     | IDE bazen metotları göremez, hata gibi gösterir                     |
| Reflection Zorluğu  | Kod görünmediği için bazı framework’lerde sorun olabilir            |
| Derleme Bağımlılığı | Compile-time'da annotation processor gerektiği için yapı bağımlıdır |

---

## 🎯 7. Hangi Durumlarda Kullanılmalı?

**Kullan:**

* DTO (Data Transfer Object)
* Entity sınıfları
* Basit veri taşıma sınıfları
* Builder Pattern ihtiyaçlarında

**Kullanma:**

* Karmaşık iş mantığı içeren sınıflarda
* Eğitim amaçlı başlangıç seviyesinde (öğrencinin mekanizmayı öğrenmesi için)

---

## 🧩 8. Örnek DTO Öncesi ve Sonrası

### Normal Java DTO

```java
public class Student {
    private String name;
    private int age;

    public Student() {}
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    // ...
}
```

### Lombok ile

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int age;
}
```

---

## 📌 Özetle

| Özellik        | Açıklama                             |
| -------------- | ------------------------------------ |
| Amaç           | Boilerplate kodu azaltmak            |
| Kütüphane      | Compile-time annotation processor    |
| Artı           | Temiz, sade, okunabilir kod          |
| Eksi           | IDE ve reflection sorunları olabilir |
| Kullanım Alanı | DTO, Entity, Builder, Logger         |

---
