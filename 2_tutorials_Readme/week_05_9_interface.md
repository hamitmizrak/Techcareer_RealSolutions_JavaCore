## Java Core interface
```sh 

```
---


Java’da **`interface` (arayüz)**, sınıfların **hangi davranışları uygulayacağını tanımlayan** bir yapıdır. Gerçek dünyada **“ne yapılacağını tanımlar, nasıl yapılacağını tanımlamaz”**.

---

## ✅ 1. Java'da Interface Nedir?

> **Interface**, metodların sadece imzalarının (signature) yer aldığı, sınıfların bu metodları uygulamak zorunda olduğu bir yapıdır.

Java’da bir interface:

* Değişkenler: **public static final** (sabit)
* Metodlar:

    * Java 7: **sadece abstract**
    * Java 8+: `default` ve `static` metodlar
    * Java 9+: `private` metodlar da desteklenir

---

## 📌 2. Interface’in Amacı Nedir?

* **Soyutlama** (Abstraction) sağlar: Ne yapılacağını belirtir.
* **Bağımlılığı azaltır**: Kodlar interface'e bağlı kalır, somut sınıfa değil.
* **Çoklu kalıtım sağlar**: Java’da çoklu kalıtım `class` ile mümkün değildir, interface ile mümkündür.
* **Contract/Sözleşme görevi görür**: Bu interface’i implemente eden sınıf, tanımlı metodları mutlaka override etmek zorundadır.

---

## 🔍 3. Interface Nasıl Yazılır?

```java
public interface Ulasim {
    void hareketEt();   // otomatik olarak public ve abstract
}
```

### Örnek: Interface Kullanımı

```java
public class Araba implements Ulasim {
    @Override
    public void hareketEt() {
        System.out.println("Araba hareket ediyor.");
    }
}
```

> **Not:** `implements` anahtar kelimesi ile bir sınıf interface’i uygular.

---

## 📌 4. Interface İçinde Neler Olabilir?

| Eleman Türü        | Açıklama                                              |
| ------------------ | ----------------------------------------------------- |
| `abstract method`  | Java 7’ye kadar sadece bu desteklenir.                |
| `default method`   | Java 8 ile geldi. İçinde gövde olabilir.              |
| `static method`    | Java 8 ile geldi. Sınıf adıyla çağrılır.              |
| `private method`   | Java 9 ile geldi. Sadece interface içinden çağrılır.  |
| `constant (sabit)` | Tüm değişkenler otomatik olarak `public static final` |

---

### 🔎 Abstract class ile Interface farkı?

| Özellik                  | Abstract Class            | Interface                       |
| ------------------------ | ------------------------- | ------------------------------- |
| `extends`/`implements`   | extends                   | implements                      |
| Çoklu kalıtım            | ❌ Hayır                   | ✅ Evet                          |
| Constructor olabilir mi? | ✅ Evet                    | ❌ Hayır                         |
| Alan (field) tanımı      | ✅ Evet (değiştirilebilir) | ✅ Sabit (`public static final`) |
| Metot türleri            | Abstract, concrete        | abstract, default, static       |

---

## ✅ 5. `default` ve `static` Metotlar (Java 8)

```java
public interface Ulasim {
    void hareketEt();

    default void bilgiVer() {
        System.out.println("Ulaşım aracı çalışır.");
    }

    static void genelBilgi() {
        System.out.println("Tüm ulaşım araçları için ortak açıklama.");
    }
}
```

---

### Kullanım:

```java
public class Bisiklet implements Ulasim {
    public void hareketEt() {
        System.out.println("Bisiklet pedal çeviriyor.");
    }
}

public class Test {
    public static void main(String[] args) {
        Ulasim b = new Bisiklet();
        b.hareketEt();
        b.bilgiVer();             // default method
        Ulasim.genelBilgi();      // static method
    }
}
```

---

## ✅ 6. Çoklu Interface Kullanımı

```java
public interface Ucan {
    void uc();
}

public interface Yuzebilen {
    void yuz();
}

public class UcanBalik implements Ucan, Yuzebilen {
    public void uc() {
        System.out.println("Balık uçuyor!");
    }

    public void yuz() {
        System.out.println("Balık yüzüyor!");
    }
}
```

> Java sınıflar arasında **çoklu kalıtım** desteklemez, ama interface’ler arasında **çoklu implementasyon** destekler.

---

## ✅ 7. Interface vs Abstract Class – Gerçek Hayat Benzetmesi

| Durum                                     | Açıklama                                                                                 |
| ----------------------------------------- | ---------------------------------------------------------------------------------------- |
| **Interface**: Ne yapılacağı bellidir.    | "Bir alet açılabilir." (interface: `Acilabilir`)                                         |
| **Abstract Class**: Ortak altyapı içerir. | "Tüm elektronik aletler açma-kapama tuşuna sahiptir." (abstract class: `ElektronikAlet`) |

---

## ✅ 8. Functional Interface (Java 8)

Eğer bir interface sadece 1 abstract method içeriyorsa ona `@FunctionalInterface` yazılır.

```java
@FunctionalInterface
public interface Islem {
    int hesapla(int a, int b);
}
```

Bu durumda lambda expression kullanılabilir:

```java
Islem toplama = (a, b) -> a + b;
System.out.println(toplama.hesapla(3, 4)); // 7
```

---

## ✅ 9. Interface'lerin Kullanıldığı Alanlar

| Alan                      | Kullanım                                                      |
| ------------------------- | ------------------------------------------------------------- |
| Spring Framework          | Service, Repository, Controller yapılarında                   |
| Java Collections          | `List`, `Map`, `Set` hep interface’tir                        |
| Dependency Injection      | Interface üzerinden gevşek bağlılık (loose coupling) sağlanır |
| Callback/Strategy Pattern | Farklı davranışları dışarıdan enjekte etmek için              |
| REST API/DTO Katmanları   | Entity-DTO dönüşümleri                                        |

---

## 🔚 Özetle

* Interface, **“ne yapılacağını”** tanımlar; **“nasıl yapılacağını”** değil.
* `implements` ile sınıflar interface’i **uygular**.
* Java 8 ile birlikte interface’ler artık `default` ve `static` methodlar içerebilir.
* Java 9 ile birlikte `private` methodlar da desteklenmektedir.
* Interface kullanımı ile **modülerlik**, **esneklik** ve **çoklu kalıtım** sağlanır.

---
