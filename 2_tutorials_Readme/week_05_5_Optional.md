## Java Core Optional
```sh 

```
---


Java'da `Optional<T>`, **null kaynaklı hataları (NullPointerException)** önlemek için Java 8 ile gelen bir sınıftır. Özellikle **"bir değer olabilir de olmayabilir de"** durumları için kullanılır.

Aşağıda sana **çok detaylı bir anlatım** sunuyorum:
Hem teorik olarak, hem de **gerçek hayattan örneklerle, çalışır kodlar ve açıklamalı yorumlarla** birlikte.

---

## ✅ 1. `Optional<T>` Nedir?

> `Optional`, bir değeri sarmalayan (wrapper) yapıdır. İçerisinde bir **nesne olabilir ya da olmayabilir**.
> Null değerle işlem yapmak yerine, `Optional` üzerinden güvenli işlem yapılır.

---

## 📌 2. Neden Kullanılır?

* `null` kontrolü yapılmadan `.get()` gibi işlemler hata üretir.
* Kod okunabilirliğini artırır.
* Null kontrol mantığını kod dışına taşıyarak merkezi hâle getirir.

---

## 🛑 NullPointerException Örneği (Klasik Problem)

```java
String ad = null;
System.out.println(ad.length()); // ➤ NullPointerException
```

---

## ✅ 3. `Optional` ile Aynı Kod Güvenli Hale Getirilir

```java
Optional<String> ad = Optional.ofNullable(null);

// isPresent ile kontrol: varsa true
if (ad.isPresent()) {
    System.out.println(ad.get().length());
} else {
    System.out.println("Ad boş!");
}
```

---

## 🧱 4. `Optional` Oluşturma Yöntemleri

| Yöntem                     | Açıklama                                             |
| -------------------------- | ---------------------------------------------------- |
| `Optional.of(obj)`         | Null olmayan objeyi sarmalar (null verirsen hata)    |
| `Optional.ofNullable(obj)` | Null olabilir, null ise boş `Optional.empty()` döner |
| `Optional.empty()`         | İçinde hiçbir değer olmayan Optional döner           |

```java
Optional<String> o1 = Optional.of("Merhaba");
Optional<String> o2 = Optional.ofNullable(null); // ✔️
Optional<String> o3 = Optional.empty();          // ✔️
```

---

## 🧠 5. Kullanım Metotları ve Örnekleri

---

### 🔹 5.1. `get()`: Değeri döner (ama yoksa exception fırlatır)

```java
Optional<String> mesaj = Optional.of("Java");
System.out.println(mesaj.get()); // Java
```

---

### 🔹 5.2. `isPresent()` / `isEmpty()`: Varlık kontrolü

```java
Optional<String> ad = Optional.ofNullable(null);
if (ad.isPresent()) {
    System.out.println("Ad: " + ad.get());
} else {
    System.out.println("Ad boş");
}
```

---

### 🔹 5.3. `orElse(...)`: Değer yoksa varsayılan ver

```java
String isim = Optional.ofNullable(null).orElse("İsimsiz");
System.out.println(isim); // İsimsiz
```

---

### 🔹 5.4. `orElseGet(Supplier)`: Lazy versiyonu

```java
String isim = Optional.ofNullable(null)
        .orElseGet(() -> "Varsayılan İsim"); // sadece gerekirse çalışır
```

---

### 🔹 5.5. `orElseThrow(Supplier)`: Değer yoksa özel hata fırlat

```java
String veri = Optional.ofNullable(null)
        .orElseThrow(() -> new IllegalArgumentException("Veri bulunamadı!"));
```

---

### 🔹 5.6. `ifPresent(...)`: Varsa çalıştır

```java
Optional<String> eposta = Optional.of("info@example.com");
eposta.ifPresent(e -> System.out.println("E-posta gönderiliyor: " + e));
```

---

### 🔹 5.7. `map()` ve `flatMap()` ile işlem zinciri

```java
Optional<String> ad = Optional.of("hamit");

Optional<String> buyuk = ad.map(String::toUpperCase); // H - A - M - İ - T
System.out.println(buyuk.get()); // HAMIT
```

---

## ✅ 6. Gerçek Hayat Senaryosu – Kullanıcı Telefon Bilgisi

```java
class Kullanici {
    private String ad;
    private Optional<String> telefon;

    public Kullanici(String ad, String telefon) {
        this.ad = ad;
        this.telefon = Optional.ofNullable(telefon);
    }

    public Optional<String> getTelefon() {
        return telefon;
    }

    public String getAd() {
        return ad;
    }
}

public class OptionalGercekHayat {
    public static void main(String[] args) {
        Kullanici k1 = new Kullanici("Ali", "0555 123 4567");
        Kullanici k2 = new Kullanici("Ayşe", null);

        // Varsa yazdır, yoksa "telefon yok" yaz
        System.out.println(k1.getAd() + ": " +
                k1.getTelefon().orElse("Telefon numarası yok"));

        System.out.println(k2.getAd() + ": " +
                k2.getTelefon().orElse("Telefon numarası yok"));
    }
}
```

---

## 🔍 7. Optional Ne Zaman Kullanılmalı / Kullanılmamalı?

| Kullanılmalı                                | Kullanılmamalı                              |
| ------------------------------------------- | ------------------------------------------- |
| Repository’den gelen veri nullable ise      | DTO sınıflarında doğrudan field olarak      |
| Method bir şeyi bulamayabilir               | Performans-kritik yerlerde aşırı kullanma   |
| Optional chaining gerekiyorsa (map, filter) | Büyük veri nesnelerini sarmak için kullanma |

---

## ✅ 8. Optional + Stream API ile Kullanım

```java
List<String> isimler = Arrays.asList("Ali", null, "Zeynep", null, "Mehmet");

// Optional ile null olanları filtrele
List<String> sonuc = isimler.stream()
        .map(Optional::ofNullable)   // her elemanı Optional'a çevir
        .filter(Optional::isPresent)
        .map(Optional::get)          // Optional içinden değeri al
        .collect(Collectors.toList());

System.out.println(sonuc); // [Ali, Zeynep, Mehmet]
```

---

## 🎯 Özet

| Metot            | Açıklama                     |
| ---------------- | ---------------------------- |
| `of()`           | Null olmayan değerler        |
| `ofNullable()`   | Null olabilir                |
| `empty()`        | Boş optional                 |
| `get()`          | Değeri alır, boşsa hata atar |
| `orElse(...)`    | Boşsa varsayılan döner       |
| `orElseGet(...)` | Lazy (gerekirse üret)        |
| `orElseThrow()`  | Boşsa özel exception fırlat  |
| `isPresent()`    | Varlık kontrolü              |
| `ifPresent()`    | Varsa işlem yap              |
| `map()`          | Değeri dönüştürmek için      |

---
