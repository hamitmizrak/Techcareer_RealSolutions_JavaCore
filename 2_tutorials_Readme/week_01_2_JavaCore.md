## Java Core Random
```sh 

```
---


Java’da `Random`, **rastgele (pseudo-random)** sayı üretmek için kullanılan bir sınıftır. Genellikle oyunlarda, test verisi üretiminde, simülasyonlarda veya rastgele kararlar gerektiğinde kullanılır.

---

## ✅ 1. `Random` Nedir?

* `java.util.Random` sınıfı, **deterministik olmayan ama tekrar üretilebilir** rastgele değerler üretir.
* Tamsayı (`int`), ondalık (`float`, `double`), boolean ve uzun sayı (`long`) gibi farklı veri tiplerinde rastgele değerler oluşturabilir.
* Her çalıştırmada farklı sonuçlar verebilir veya sabit tohum (seed) ile aynı sonuçlar alınabilir.

---

## 🧾 2. `Random` Sınıfını Kullanma

### 🔹 Tanımlama:

```java
import java.util.Random;

Random rastgele = new Random();
```

---

## 🔢 3. Yaygın Metotlar

| Metot                | Açıklama                                      |
| -------------------- | --------------------------------------------- |
| `nextInt()`          | Rastgele `int` döndürür (tüm sayı aralığında) |
| `nextInt(int bound)` | `0` ile `bound-1` arasında değer üretir       |
| `nextDouble()`       | `0.0` ile `1.0` arasında `double` değer       |
| `nextFloat()`        | `0.0` ile `1.0` arasında `float` değer        |
| `nextBoolean()`      | `true` veya `false`                           |
| `nextLong()`         | Rastgele `long` değeri                        |
| `setSeed(long seed)` | Aynı seed ile aynı sonuçları üretir           |

---

## 🧪 4. Örnekler

### 📍 A. 0–99 Arasında Rastgele Sayı:

```java
Random r = new Random();
int sayi = r.nextInt(100);  // 0–99 arası
System.out.println("Sayı: " + sayi);
```

### 📍 B. Rastgele boolean:

```java
boolean karar = r.nextBoolean();
System.out.println("Karar: " + karar);
```

### 📍 C. Sabit Seed ile Üretim:

```java
Random r1 = new Random(42);
System.out.println(r1.nextInt()); // Her zaman aynı sayı
```

---

## 🎲 5. Zar Atma Simülasyonu

```java
Random zar = new Random();
int sonuc = zar.nextInt(6) + 1; // 1-6 arası
System.out.println("Zar: " + sonuc);
```

---

## ⚖️ 6. `Math.random()` ile Farkı

| Özellik            | `Random` sınıfı   | `Math.random()`             |
| ------------------ | ----------------- | --------------------------- |
| Kontrol            | Daha fazla yöntem | Sadece `double` üretir      |
| Seed ayarlanabilir | ✅ Evet            | ❌ Hayır                     |
| Nesne gerekir mi?  | ✅ Evet            | ❌ Hayır (statik method)     |
| Geniş kullanım     | Daha profesyonel  | Basit işlemler için yeterli |

---

## 🧮 7. `Math.random()` Kısa Örnek

```java
int sayi = (int)(Math.random() * 100);  // 0-99
```

---

## 🧠 8. Notlar

* `Random` deterministik bir algoritmadır. Aynı seed ile her zaman aynı değer dizisini üretir.
* Gerçek rastgelelik gerektiren yerlerde `SecureRandom` kullanılır (şifreleme vs).

---

## 🎯 Ne Zaman Kullanılır?

* Oyunlarda düşman seçimi, zar, kart çekme
* Test için sahte veri üretimi
* Rastgele renk, koordinat, sayı
* Basit şifre/sayı üreticileri

---

## Özet:

| Özellik       | Açıklama                                    |
| ------------- | ------------------------------------------- |
| Sınıf         | `java.util.Random`                          |
| Görevi        | Rastgele veri üretimi                       |
| Veri türleri  | `int`, `double`, `boolean`, `long`, `float` |
| Deterministik | Evet (aynı seed ile aynı çıktı)             |
| Alternatif    | `Math.random()` veya `SecureRandom`         |

---


## Java Core Seed
```sh 

```
---

Java'da (ve genel olarak programlamada) **`seed` (tohum)**, **rastgele sayı üreticisinin (random number generator - RNG)** başlangıç değeridir. Bu başlangıç değeri, üreteceği rastgele sayıların **başlangıç noktasını belirler**.

---

## ✅ 1. `seed` Nedir?

* Rastgele sayı üreticisi aslında "tam anlamıyla" rastgele değildir.
* Bir matematiksel algoritma üzerinden sayı üretir ve bu algoritma bir **başlangıç değerine** ihtiyaç duyar: işte bu değer **`seed`**’dir.
* Aynı `seed` değeri kullanılırsa her seferinde **aynı “rastgele” sayı dizisi** oluşur.

---

## 🧪 Örnekle Açıklayalım:

### Örnek 1 – Sabit seed kullanımı:

```java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r1 = new Random(42);
        System.out.println(r1.nextInt()); // Her çalıştırmada aynı sayı
    }
}
```

➡️ Çıktı: örneğin `1171806020`

Her seferinde **aynı `seed`** (`42`) kullanıldığından çıktı da **hep aynı** olur.

---

### Örnek 2 – Rastgele seed (varsayılan):

```java
Random r2 = new Random(); // seed yok, JVM saate göre otomatik verir
System.out.println(r2.nextInt());
```

➡️ Her çalıştırmada farklı sayı üretir çünkü **seed rastgele atanır (System.currentTimeMillis())**.

---

## 🧠 2. Seed Neden Önemli?

| Kullanım Durumu                            | Seed Kullanımı |
| ------------------------------------------ | -------------- |
| Oyunlarda her seferinde aynı map’i üretmek | ✅ Gerekli      |
| Test senaryolarında sabit veri üretimi     | ✅ Gerekli      |
| Gerçek rastgelelik (örneğin çekiliş)       | ❌ İstenmez     |

---

## 🔐 3. Güvenlik Açısından

* `Random` sınıfı seed ile tahmin edilebilir → **kriptografik güvenlikte uygun değildir.**
* Gerçek rastgelelik için → `SecureRandom` kullanılmalı:

```java
import java.security.SecureRandom;

SecureRandom sr = new SecureRandom();
int sayi = sr.nextInt(100);
```

---

## 🎯 Özet:

| Terim         | Açıklama                                             |
| ------------- | ---------------------------------------------------- |
| `seed`        | Rastgele sayı üreticisinin başlangıç değeri          |
| Aynı seed     | Aynı rastgele sayı dizisini üretir                   |
| Otomatik seed | JVM sistem saatine göre belirler                     |
| Güvenli değil | `Random` tahmin edilebilir → `SecureRandom` önerilir |

---
