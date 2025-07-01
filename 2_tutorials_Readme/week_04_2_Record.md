## Java Core Record
```sh 

```
---


Java'da `record` yapısı, **Java 14** ile preview olarak gelmiş, **Java 16 itibarıyla** ise kalıcı hale gelmiş bir özellik olup, **veri taşıma sınıflarını (DTO)** daha sade ve okunabilir biçimde tanımlamayı amaçlar. `record`, aslında Java’nın "veri sınıfları için resmi çözümüdür".

Aşağıda **çok detaylı, karşılaştırmalı ve örneklerle** konuyu adım adım açıklıyorum.

---

## 📘 1. RECORD NEDİR?

`record`, Java’da bir sınıf türüdür ve temelde **immutable (değiştirilemez)** veri taşımak için kullanılır. Java'da DTO, VO, Entity gibi sınıflarda sıkça yazılan `getter`, `toString`, `equals`, `hashCode`, `constructor` gibi boilerplate kodları **otomatik olarak** üretir.

### Klasik DTO örneği (Java 8):

```java
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object o) { /* ... */ }

    @Override
    public int hashCode() { /* ... */ }
}
```

### Aynısı `record` ile:

```java
public record Person(String name, int age) {}
```

---

## 📌 2. RECORD'UN OTOMATİK SAĞLADIĞI ÖZELLİKLER

Bir `record`, aşağıdaki öğeleri **otomatik olarak üretir**:

| Özellik                   | Açıklama                                                    |
| ------------------------- | ----------------------------------------------------------- |
| `private final` field'lar | Tüm alanlar otomatik olarak `private final` olur            |
| Constructor               | Tüm alanları parametre olarak alan kurucu otomatik üretilir |
| Getter metotları          | `getName()` değil `name()` şeklinde otomatik gelir          |
| `toString()`              | Otomatik oluşturulur                                        |
| `equals()` / `hashCode()` | Alanlara göre otomatik karşılaştırma yapılır                |

---

## 🔒 3. RECORD'UN ÖZELLİKLERİ

* `record` sınıfı **final'dir**, kalıtım yapılamaz.
* Tüm alanlar **immutable** olur.
* `record` yalnızca **constructor, static method** ve **alanları** içerebilir.
* `record`’da ekstra `getter/setter` yazılamaz.
* Alanlara `final` demeye gerek yoktur, zaten sabittir.

---

## 🧪 4. ÖRNEK: RECORD vs CLASS

### Record:

```java
public record User(String username, String email) {}
```

### Kullanımı:

```java
User user = new User("hamitmizrak", "hamit@site.com");

System.out.println(user.username()); // getter
System.out.println(user);            // toString()
```

### Otomatik oluşan yapılar:

```java
// Constructor: public User(String username, String email)
// Getter: public String username()
// toString: User[username=..., email=...]
// equals, hashCode: içerik karşılaştırmalı
```

---

## 🛠️ 5. RECORD İÇİN CUSTOM (ÖZEL) BİLEŞEN EKLEME

### Özel Constructor:

```java
public record Product(String name, double price) {
    public Product {
        if (price < 0) {
            throw new IllegalArgumentException("Fiyat negatif olamaz.");
        }
    }
}
```

### Ekstra static metod:

```java
public record Book(String title, String author) {
    public static Book empty() {
        return new Book("Bilinmiyor", "Bilinmiyor");
    }
}
```

---

## ⚖️ 6. RECORD VE LOMBOK KARŞILAŞTIRMASI

| Özellik         | Lombok (`@Data`)           | Record                     |
| --------------- | -------------------------- | -------------------------- |
| Immutable       | İsteğe bağlı (`final` ile) | Evet (otomatik)            |
| Getter          | Evet (`getX()`)            | Evet (`x()`)               |
| Setter          | Evet                       | Hayır (immutable)          |
| Constructor     | Otomatik / elle yazılır    | Otomatik                   |
| Kalıtım         | Evet                       | Hayır (`final`)            |
| Field türleri   | Her şey olur               | Sadece `private final`     |
| Ek metod yazımı | Mümkün                     | Sınırlı (static, override) |

> `record`, **immutable ve sadece veri taşıyan sınıflar için** uygundur. Lombok ise daha genel bir amaçla esnektir.

---

## 🧩 7. RECORD’UN KULLANILDIĞI ALANLAR

* DTO (Data Transfer Object)
* Response class'ları
* API veri taşımaları
* Configuration/Settings
* `switch` expression ile birlikte pattern matching (Java 17+)

---

## 🧠 8. RECORD NEDEN YARARLI?

* Kod sadeleşir
* Hata riski düşer
* Clean Code prensiplerine uygundur
* `toString()`, `equals()`, `hashCode()` gibi metotlar otomatik oluşur

---

## 🔥 9. RECORD NE ZAMAN KULLANILMAZ?

* Eğer:

    * Mutable alanlar gerekiyorsa (set etmek istiyorsan)
    * Kapsamlı iş mantığı içeriyorsa
    * Kapsamlı kalıtım, interface implementasyonları gerekiyorsa

> O zaman klasik class kullanmak daha doğru olur.

---

## 🧪 10. RECORD İLE JAVA 17+ ÖZELLİĞİ: PATTERN MATCHING (Ekstra)

```java
record Rectangle(int width, int height) {}

static void printArea(Object shape) {
    if (shape instanceof Rectangle(int w, int h)) {
        System.out.println("Alan: " + (w * h));
    }
}
```

---

## 📍 Özet

| Konu              | Açıklama                                        |
| ----------------- | ----------------------------------------------- |
| Tanım             | Immutable veri sınıfı                           |
| Amaç              | DTO ve veri modellerini sadeleştirmek           |
| Java sürümü       | Java 14 (preview), Java 16+ (kalıcı)            |
| Alternatif        | Lombok `@Data`, Java Class                      |
| Otomatik metotlar | constructor, getter, equals, hashCode, toString |
| Kısıtlamalar      | final, mutable yapı yok, kalıtım yok            |

---

❌ 2. PARAMETRESİZ CONSTRUCTOR (NO-ARGS) YAZABİLİR MİYİZ?
Hayır, record yapısı gereği parametresiz (no-args) constructor yazılamaz. Çünkü record'lar immutable (değiştirilemez) veri taşıyıcı sınıflardır ve tüm alanların ilk anda tanımlanmasını zorunlu kılar.



Aşağıda sana Java'da aynı yapıyı iki farklı şekilde — **klasik sınıf (class)** ve **modern `record` yapısı** — ile detaylı olarak karşılaştırmalı veriyorum.
Senaryo olarak: Bir `Product` sınıfı düşünelim. Bu sınıf sadece `name` ve `price` alanlarını taşıyacak. DTO olarak kullanılacak. Yani veri taşımaktan başka bir amacı yok.
---

## 🧱 1. KLASİK CLASS YAPISI (Java 8–11 Uyumlu)

```java
public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
```

### Kullanımı:

```java
Product product = new Product("Laptop", 14999.0);
System.out.println(product.getName());  // -> Laptop
System.out.println(product);            // -> Product{name='Laptop', price=14999.0}
```

---

## 🧩 2. RECORD YAPISI (Java 16+)

```java
public record Product(String name, double price) {}
```

### Kullanımı:

```java
Product product = new Product("Laptop", 14999.0);
System.out.println(product.name());    // -> Laptop
System.out.println(product);           // -> Product[name=Laptop, price=14999.0]
```

---

## 📊 3. KARŞILAŞTIRMA TABLOSU

| Özellik                    | Class                            | Record                             |
| -------------------------- | -------------------------------- | ---------------------------------- |
| Kod uzunluğu               | Uzun (boilerplate çok)           | Çok kısa                           |
| Getter                     | `getName()`                      | `name()`                           |
| Setter                     | Yok (final kullanılırsa)         | Yok (tüm alanlar final)            |
| toString(), equals()       | Elle override edilmesi gerek     | Otomatik                           |
| Constructor                | Elle yazılır                     | Otomatik                           |
| Kalıtım (inheritance)      | Mümkün (`extends`, `implements`) | Sadece `implements`, `extends` yok |
| Immutable (değiştirilemez) | İsteğe bağlı                     | Varsayılan olarak immutable        |
| Ek metod yazımı            | Serbest                          | Sadece static veya override        |
| Java sürüm                 | Tüm sürümler                     | Java 16+                           |

---

## 🔍 4. HANGİ DURUMDA HANGİSİ?

| Durum                                    | Tercih                                  |
| ---------------------------------------- | --------------------------------------- |
| Sadece veri taşımak (DTO)                | ✅ `record`                              |
| Alanlar değişecek (setter olacak)        | ✅ `class`                               |
| Kapsamlı iş mantığı barındıracak         | ✅ `class`                               |
| JSON serialize/deserialize (Spring Boot) | ✅ `record` veya `class` (ikisi de olur) |
| Kalıtım gerekiyorsa (`extends`)          | ✅ `class`                               |
| Clean code + modern yaklaşım             | ✅ `record`                              |

---

## 📌 Sonuç:

* `record`, **data taşıma** amacıyla mükemmel bir araçtır: sade, okunabilir ve hatasızdır.
* `class`, **esneklik ve genişletilebilirlik** gereken yerlerde daha uygundur.

---
