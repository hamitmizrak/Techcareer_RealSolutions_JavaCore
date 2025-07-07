## Java Core Stream Stream API  (Seri)
```sh 

```
---


Java’da **Stream API ile serileştirme** (mapping, dönüştürme, toplama) işlemi, **koleksiyon verilerini** daha fonksiyonel, okunabilir ve zincirleme (pipeline) bir şekilde işlemek anlamına gelir.

Aşağıda sana **çok detaylı ve pratik temelli bir anlatım** sunuyorum:
→ Teorik bilgi
→ Gerçek hayat problemleri
→ Çalışır kodlar + açıklamalı yorumlar

---

## ✅ 1. Stream API Nedir?

> Java 8 ile gelen `Stream API`, **veri koleksiyonları üzerinde filtreleme, sıralama, dönüştürme ve toplama gibi işlemleri fonksiyonel bir şekilde** yapmamıza olanak sağlar.

---

## ✅ 2. Serileştirme (Mapping) Ne Demek?

> Serileştirme = Her elemanı başka bir **şeye dönüştürme**.
> Stream API'de bu işlem genelde `map()` fonksiyonu ile yapılır.

---

## 📌 3. Stream ile Serileştirme Kullanım Alanları

| Amaç                      | Metot                           | Açıklama                               |
| ------------------------- | ------------------------------- | -------------------------------------- |
| Her elemanı dönüştür      | `map()`                         | `String → Integer`, `Entity → DTO` vb. |
| Şartlı filtreleme         | `filter()`                      | `x > 10`, `x.startsWith("A")` gibi     |
| Toplama/sayma/ortalama    | `collect()`, `count()`, `sum()` | Sonuç üretimi                          |
| Listeye, Set’e dönüştürme | `collect(Collectors.toList())`  | Serileştirme sonucu yeni koleksiyon    |

---

## ✅ 4. Gerçek Hayat Senaryosu: Ürün Listesi İşleme

### 📌 Senaryo: Bir e-ticaret sisteminde ürün fiyatlarını %18 KDV ile güncelle, isimleri büyük harfe çevir ve sadece pahalı olanları listele.

```java
import java.util.*;
import java.util.stream.*;
import java.text.DecimalFormat;

class Urun {
    private String ad;
    private double fiyat;

    public Urun(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public String getAd() {
        return ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public double getFiyatKdvli() {
        return fiyat * 1.18;
    }

    @Override
    public String toString() {
        return ad + " → " + new DecimalFormat("0.00").format(fiyat) + " TL";
    }
}

public class StreamSerilestirmeOrnek {

    public static void main(String[] args) {
        List<Urun> urunler = Arrays.asList(
                new Urun("Laptop", 25000),
                new Urun("Telefon", 15000),
                new Urun("Tablet", 8000),
                new Urun("Klavye", 500),
                new Urun("Mouse", 400)
        );

        // 1. Her ürünün KDV'li fiyatını hesaplayalım (map)
        List<Double> kdvliFiyatlar = urunler.stream()
                .map(Urun::getFiyatKdvli) // her Urun nesnesinden kdvli fiyat alınıyor
                .collect(Collectors.toList());

        System.out.println("KDV'li Fiyatlar:");
        kdvliFiyatlar.forEach(f -> System.out.println(String.format("%.2f TL", f)));

        System.out.println("\n---");

        // 2. Ürün adlarını büyük harfe çevirip yeni bir liste oluştur (map)
        List<String> buyukIsimler = urunler.stream()
                .map(Urun::getAd)            // sadece ad bilgisini al
                .map(String::toUpperCase)    // ad'ı büyük harfe çevir
                .collect(Collectors.toList());

        System.out.println("Büyük harfli ürün adları:");
        buyukIsimler.forEach(System.out::println);

        System.out.println("\n---");

        // 3. KDV'li fiyatı 10.000 TL'den büyük olan ürünleri filtrele
        List<Urun> pahaliUrunler = urunler.stream()
                .filter(u -> u.getFiyatKdvli() > 10000) // şartlı filtreleme
                .collect(Collectors.toList());

        System.out.println("Pahalı Ürünler (KDV Dahil > 10.000 TL):");
        pahaliUrunler.forEach(System.out::println);
    }
}
```

---

## 📌 5. map() vs flatMap() Arasındaki Fark

```java
List<String> cumleler = Arrays.asList("Java güzeldir", "Stream API güçlüdür");

List<String[]> kelimeler = cumleler.stream()
        .map(s -> s.split(" "))    // ➤ map: her eleman diziye dönüşür
        .collect(Collectors.toList());
```

Yukarıdaki örnekte `List<String[]>` oluşur.

Ama `flatMap` ile **bütün dizileri açar ve düz hale getirir**:

```java
List<String> kelimeler = cumleler.stream()
        .flatMap(s -> Arrays.stream(s.split(" ")))
        .collect(Collectors.toList());
```

> Sonuç: `List<String>` — düzleştirilmiş kelimeler listesi

---

## ✅ 6. Bonus: DTO – Entity Mapping Örneği (map kullanımı)

```java
class KullaniciEntity {
    String ad;
    String email;

    public KullaniciEntity(String ad, String email) {
        this.ad = ad;
        this.email = email;
    }
    public String getAd() { return ad; }
    public String getEmail() { return email; }
}

class KullaniciDto {
    String ad;

    public KullaniciDto(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "DTO → " + ad;
    }
}

public class EntityToDto {
    public static void main(String[] args) {
        List<KullaniciEntity> entityList = Arrays.asList(
                new KullaniciEntity("Ali", "ali@example.com"),
                new KullaniciEntity("Ayşe", "ayse@example.com")
        );

        List<KullaniciDto> dtoList = entityList.stream()
                .map(e -> new KullaniciDto(e.getAd()))
                .collect(Collectors.toList());

        dtoList.forEach(System.out::println);
    }
}
```

---

## 🎯 Özet

| Stream Metodu | Amaç                                       |
| ------------- | ------------------------------------------ |
| `map()`       | Elemanı başka bir şeye dönüştür            |
| `flatMap()`   | İç içe yapılardan düz yapı üretir          |
| `filter()`    | Şartlı süzme                               |
| `collect()`   | Liste, Set, Map, String gibi çıktıya çevir |
| `forEach()`   | Her elemanı tek tek işleme                 |

---
