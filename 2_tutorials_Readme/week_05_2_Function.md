## Java Core (Java 8 – Functional )
```sh 

```
---


Harika, şimdi Java 8 ile gelen **hazır fonksiyonel interface’leri** (`Function`, `Predicate`, `Consumer`, `Supplier`) hem **teorik** hem de **lambda ile kullanım örnekleri** üzerinden çok detaylı anlatacağım.

---

## ✅ Java 8 Hazır Fonksiyonel Interface’ler ve Lambda Kullanımı

---

### 📦 Paket: `java.util.function`

Java 8 ile birlikte gelen bu package, fonksiyonel programlamayı destekleyen birçok interface barındırır. En önemlileri:

| Interface       | Açıklama                                       |
| --------------- | ---------------------------------------------- |
| `Function<T,R>` | T tipinde alır, R tipinde döner (`apply`)      |
| `Predicate<T>`  | T tipinde alır, `boolean` döner (`test`)       |
| `Consumer<T>`   | T tipinde alır, sonuç döndürmez (`accept`)     |
| `Supplier<T>`   | Parametre almaz, T tipinde sonuç döner (`get`) |

---

## 1️⃣ `Function<T, R>`

* Girdi alır, çıktı döndürür.
* `apply()` metodu kullanılır.

### Örnek:

```java
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> uzunluk = s -> s.length();

        System.out.println("Uzunluk: " + uzunluk.apply("Java")); // 4
    }
}
```

---

## 2️⃣ `Predicate<T>`

* Girdi alır, boolean döner.
* `test()` metodu ile kontrol yapar.

### Örnek:

```java
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> uzunMu = s -> s.length() > 5;

        System.out.println(uzunMu.test("Merhaba")); // true
        System.out.println(uzunMu.test("Java"));    // false
    }
}
```

---

## 3️⃣ `Consumer<T>`

* Girdi alır, geri dönüş yoktur.
* `accept()` metodu ile yan etki (side-effect) oluşturur (örn. konsola yazma).

### Örnek:

```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> yaz = s -> System.out.println("Gelen: " + s);

        yaz.accept("Lambda");
    }
}
```

---

## 4️⃣ `Supplier<T>`

* Girdi almaz, çıktı döner.
* `get()` metodu ile değer üretir.

### Örnek:

```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Double> rastgele = () -> Math.random();

        System.out.println("Sayı: " + rastgele.get());
    }
}
```

---

## ✅ Kombinasyonlu Örnek: `Function + Predicate + Consumer`

### Amaç: Girdi olarak bir string al → harf sayısı 5’ten büyükse → sonucu yazdır.

```java
import java.util.function.*;

public class FonksiyonelKombinasyon {
    public static void main(String[] args) {
        Function<String, Integer> uzunlukHesapla = s -> s.length();
        Predicate<Integer> kontrol = len -> len > 5;
        Consumer<String> yazdir = s -> System.out.println("Uygun kelime: " + s);

        String kelime = "Fonksiyonel";
        int uzunluk = uzunlukHesapla.apply(kelime);

        if (kontrol.test(uzunluk)) {
            yazdir.accept(kelime);
        }
    }
}
```

---

## ✅ Spring Boot ile Lambda ve Functional Interface Kullanımı

Spring, bu interface’leri sıklıkla kullanır. Örneğin:

### 1️⃣ `Predicate` ile Bean Doğrulama

```java
@Component
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String email) {
        return email.contains("@");
    }
}
```

### 2️⃣ `Function` ile DTO → Entity Dönüşümü

```java
@Component
public class DtoToEntityConverter implements Function<UserDto, UserEntity> {
    @Override
    public UserEntity apply(UserDto dto) {
        return new UserEntity(dto.getName(), dto.getEmail());
    }
}
```

---

## ✅ Stream API + Lambda + Predicate/Function

```java
List<String> isimler = Arrays.asList("Ali", "Ayşe", "Ahmet", "Zeynep");

// 'A' harfiyle başlayanları büyük harfle yazdır
isimler.stream()
      .filter(s -> s.startsWith("A"))   // Predicate
      .map(String::toUpperCase)         // Function
      .forEach(System.out::println);    // Consumer
```

---

### 🎯 İPUÇLARI

| Yapı                  | Ne işe yarar?        |
| --------------------- | -------------------- |
| `filter(Predicate)`   | Şartla süzme         |
| `map(Function)`       | Veri dönüştürme      |
| `forEach(Consumer)`   | Sonuçla işlem        |
| `sorted(Comparator)`  | Sıralama             |
| `anyMatch(Predicate)` | En az birini kontrol |

---

### Sonuç:

| Interface       | Kullanım Amacı       | Lambda ile Kısalık |
| --------------- | -------------------- | ------------------ |
| `Function<T,R>` | Dönüştürme işlemleri | `x -> işlem`       |
| `Predicate<T>`  | Şart (true/false)    | `x -> koşul`       |
| `Consumer<T>`   | Yan etki (print vs.) | `x -> işlem`       |
| `Supplier<T>`   | Veri üretimi         | `() -> veri`       |

---
