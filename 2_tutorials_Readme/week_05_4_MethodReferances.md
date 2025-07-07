## Java Core Java'da Method Referances
```sh 

```
---


Java’da `Method References` (Metot Referansları), **lambda ifadelerinin daha kısa ve okunabilir** bir alternatifidir. Java 8 ile gelmiştir ve `::` (çift iki nokta) operatörüyle kullanılır.


---

## ✅ 1. Method Reference Nedir?

> Lambda ifadesi zaten var olan bir metodu çalıştırıyorsa, **o metodu doğrudan referans göstererek** yazabiliriz.
> Bu, yazımı kısaltır, okunabilirliği artırır.

---

## 🔍 2. Temel Yapısı

```java
ClassNameOrObject::methodName
```

---

## 📌 3. Method Reference Türleri

| Tür                                   | Açıklama                                       | Örnek                 |
| ------------------------------------- | ---------------------------------------------- | --------------------- |
| 1. Static Method Reference            | Sınıfın static metoduna referans               | `Math::abs`           |
| 2. Instance Method Reference (object) | Nesneye ait örnek metoda referans              | `System.out::println` |
| 3. Instance Method Reference (class)  | Parametreyle gelen nesneye ait metoda referans | `String::toUpperCase` |
| 4. Constructor Reference              | `new` çağrısına referans                       | `ArrayList::new`      |

---

## ✅ 4. Gerçek Hayat Örnekleriyle Açıklamalı Kodlar

---

### 🔹 Örnek 1: Static Method Reference

#### 📌 Senaryo: Sayı listesini mutlak değere çevirmek

```java
import java.util.*;
import java.util.stream.*;

public class StaticMethodReference {

    public static void main(String[] args) {
        List<Integer> sayilar = Arrays.asList(-5, -10, 15, -20, 30);

        // Lambda ile: sayilar.stream().map(x -> Math.abs(x))
        List<Integer> mutlaklar = sayilar.stream()
                .map(Math::abs) // Static method reference
                .collect(Collectors.toList());

        System.out.println(mutlaklar); // [5, 10, 15, 20, 30]
    }
}
```

---

### 🔹 Örnek 2: Instance Method Reference (Mevcut Nesne)

#### 📌 Senaryo: `System.out.println`’u forEach ile çağırmak

```java
import java.util.*;

public class InstanceMethodObject {

    public static void main(String[] args) {
        List<String> isimler = Arrays.asList("Ali", "Ayşe", "Mehmet");

        // Lambda: x -> System.out.println(x)
        isimler.forEach(System.out::println); // instance method reference
    }
}
```

---

### 🔹 Örnek 3: Instance Method Reference (Class üzerinden)

#### 📌 Senaryo: Tüm kelimeleri büyük harfe çevir

```java
import java.util.*;
import java.util.stream.*;

public class InstanceMethodClass {

    public static void main(String[] args) {
        List<String> kelimeler = Arrays.asList("java", "method", "reference");

        // Lambda: x -> x.toUpperCase()
        List<String> sonuc = kelimeler.stream()
                .map(String::toUpperCase) // Class üzerinden method reference
                .collect(Collectors.toList());

        System.out.println(sonuc); // [JAVA, METHOD, REFERENCE]
    }
}
```

---

### 🔹 Örnek 4: Constructor Reference

#### 📌 Senaryo: Listeyi `ArrayList`'e dönüştür

```java
import java.util.*;
import java.util.stream.*;

public class ConstructorReference {

    public static void main(String[] args) {
        Stream<String> akim = Stream.of("a", "b", "c");

        // Lambda: () -> new ArrayList<>()
        List<String> liste = akim.collect(Collectors.toCollection(ArrayList::new)); // constructor reference

        System.out.println(liste); // [a, b, c]
    }
}
```

---

## 🎯 5. Method Reference ile Lambda Kıyaslaması

| Lambda                       | Method Reference      |
| ---------------------------- | --------------------- |
| `x -> x.toUpperCase()`       | `String::toUpperCase` |
| `x -> System.out.println(x)` | `System.out::println` |
| `() -> new ArrayList<>()`    | `ArrayList::new`      |

---

## 🧠 6. Gerçek Hayat Mini Uygulama

### 📌 Senaryo: Öğrencileri soyada göre sıralayıp, adlarını büyük harfle yazdır

```java
import java.util.*;

class Ogrenci {
    String ad;
    String soyad;

    public Ogrenci(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    @Override
    public String toString() {
        return ad + " " + soyad;
    }
}

public class MethodRefGercekHayat {

    public static void main(String[] args) {
        List<Ogrenci> ogrenciler = Arrays.asList(
                new Ogrenci("Zeynep", "Yılmaz"),
                new Ogrenci("Ali", "Demir"),
                new Ogrenci("Mehmet", "Arslan")
        );

        // Soyada göre sıralama (lambda yerine method reference ile)
        ogrenciler.sort(Comparator.comparing(Ogrenci::getSoyad)); // method reference

        // Öğrenci listesini yazdır
        ogrenciler.forEach(System.out::println); // method reference
    }
}
```

---

## ✅ 7. Özetle

| Tür                          | Örnek                 | Açıklama                              |
| ---------------------------- | --------------------- | ------------------------------------- |
| Static method                | `Math::abs`           | `map(x -> Math.abs(x))` yerine        |
| Instance method (object)     | `System.out::println` | `forEach(x -> System.out.println(x))` |
| Instance method (class type) | `String::toLowerCase` | `map(x -> x.toLowerCase())` yerine    |
| Constructor                  | `ArrayList::new`      | `() -> new ArrayList<>()` yerine      |

---
