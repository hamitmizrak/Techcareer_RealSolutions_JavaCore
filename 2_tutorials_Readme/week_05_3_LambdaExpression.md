## Java Core Lambda Expression
```sh 

```
---

### Java'da **Lambda Expression** Nedir?

---

### 📌 1. TANIM: **Lambda Expression** Nedir?

**Lambda Expression**, Java 8 ile gelen ve **anonim bir fonksiyonu** ifade eden bir yapıdır. Kısaca:

> **"Fonksiyonları parametre gibi taşıma ve inline olarak tanımlama yöntemidir."**

Java'da fonksiyonlar nesne değildir, ancak **lambda** ile fonksiyonları **Fonksiyonel Interface’ler** üzerinden taşıyabiliriz.

---

### 📌 2. Temel Söz Dizimi (Syntax)

```java
(parametreListesi) -> { ifade / kod bloğu }
```

#### ✔️ Kısa Kurallar:

| Yazım Şekli                              | Açıklama                                |
| ---------------------------------------- | --------------------------------------- |
| `(a, b) -> a + b`                        | 2 parametre, tek satır işlem            |
| `() -> System.out.println("Merhaba")`    | Parametresiz lambda                     |
| `x -> { return x*x; }`                   | Tek parametre, gövdesi süslü parantezli |
| `(x, y) -> { int z = x + y; return z; }` | Blok gövdeli lambda                     |

---

### 📌 3. Lambda Expression Nasıl Çalışır?

Lambda ifadeleri **sadece Functional Interface'ler** ile birlikte kullanılabilir.

```java
@FunctionalInterface
interface Mesaj {
    void yaz(String msg);
}

// Kullanım
Mesaj m = (String msg) -> System.out.println("Gelen mesaj: " + msg);
m.yaz("Merhaba Lambda");
```

---

### 📌 4. Lambda’nın Arka Planda Ne Yaptığı

```java
// Geleneksel Anonim Inner Class
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Çalıştı!");
    }
};

// Lambda İfadesiyle
Runnable r2 = () -> System.out.println("Çalıştı!");
```

Bu iki kod **aynı anlamdadır**, ancak lambda yazımı çok daha kısa ve okunabilirdir.

---

### 📌 5. Lambda Expression Avantajları

| Avantaj                        | Açıklama                                                      |
| ------------------------------ | ------------------------------------------------------------- |
| ✅ Daha Az Kod                  | Anonim sınıfların yerini alır, kod tekrarını azaltır.         |
| ✅ Daha Okunabilir              | İşlevsel düşünceye yaklaştırır.                               |
| ✅ Daha Fonksiyonel             | Java'yı "functional programming" paradigmasına yakınlaştırır. |
| ✅ Collection API ile uyumludur | `forEach`, `filter`, `map` gibi yapılarla çalışır.            |

---

### 📌 6. Lambda Expression Kullanım Alanları

* **Runnable, Callable, Comparator gibi interface'lerde**
* **Stream API ve Collection API işlemlerinde**
* **EventListener tanımlarında**
* **Predicate, Consumer, Function gibi functional interface'lerle**

---

### ✅ ÖRNEK 1: Lambda ile `Runnable` Kullanımı

```java
public class LambdaRunnable {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Thread çalıştı!");
        new Thread(r).start();
    }
}
```

---

### ✅ ÖRNEK 2: Lambda ile `Comparator` Kullanımı

```java
import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> liste = Arrays.asList("Java", "Python", "C#", "Go");

        // Lambda ile uzunluğa göre sıralama
        Collections.sort(liste, (s1, s2) -> s1.length() - s2.length());

        liste.forEach(System.out::println);
    }
}
```

---

### ✅ ÖRNEK 3: Kendi Functional Interface’inle Lambda Kullanımı

```java
@FunctionalInterface
interface Matematik {
    int islem(int a, int b);
}

public class LambdaIslem {
    public static void main(String[] args) {
        Matematik topla = (a, b) -> a + b;
        Matematik carp = (a, b) -> a * b;

        System.out.println("Toplam: " + topla.islem(5, 3));
        System.out.println("Çarpım: " + carp.islem(5, 3));
    }
}
```

---

### ✅ ÖRNEK 4: Lambda + Stream API Kullanımı

```java
import java.util.Arrays;
import java.util.List;

public class LambdaStream {
    public static void main(String[] args) {
        List<String> isimler = Arrays.asList("Ali", "Ayşe", "Ahmet", "Mehmet");

        // 'A' ile başlayanları yazdır
        isimler.stream()
               .filter(isim -> isim.startsWith("A"))
               .forEach(System.out::println);
    }
}
```

---

### 📌 7. Lambda Expression ile Method Reference Farkı

Lambda:

```java
list.forEach(s -> System.out.println(s));
```

Method Reference:

```java
list.forEach(System.out::println);
```

> **Yani:** Lambda → `(parametre) -> işlem`
>
> Method Reference → `sınıf::method`

---

### 📌 8. Lambda'da Değişken Kullanımı

* Lambda içinde **dışarıdaki final veya efektif final** değişken kullanılabilir.
* Lambda’nın içinde yerel değişken **değiştirilemez**.

```java
int sabit = 10;

Matematik m = (a, b) -> a + b + sabit; // OK
// sabit = 20;  // HATA: lambda sabitleri değiştiremez
```

---

### 📌 9. Lambda'nın Olmadığı Durumda Yazım Zorlukları

Örneğin `ActionListener`:

```java
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Tıklandı");
    }
});
```

Lambda ile:

```java
button.addActionListener(e -> System.out.println("Tıklandı"));
```

---

### 📌 10. Kapanış: Lambda Expression ile Neler Sağlandı?

* Fonksiyonel programlamanın kapısı açıldı
* Kod okunabilirliği arttı
* Java'nın modern dillerle rekabeti güçlendi
* Stream API, Collection API, Concurrent API gibi yapılarla daha etkin kullanım sağlandı

---



## Java Core (Function, Predicate, Consumer, Supplier)
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
