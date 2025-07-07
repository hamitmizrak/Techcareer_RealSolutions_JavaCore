## Java Core Stream API (Parallel)
```sh 

```
---


Java'da **`parallelStream()`**, `Stream API`’nin çok çekirdekli (multi-threaded) versiyonudur.
Liste gibi koleksiyonlar üzerinde **verileri paralel olarak işlemek**, yani birden fazla çekirdeği kullanmak için kullanılır.

---

## ✅ 1. `parallelStream()` Nedir?

> `List`, `Set` gibi koleksiyonların verilerini **paralel (çoklu thread) ortamda** işler.
> Java 8'de gelen **ForkJoinPool** altyapısı kullanılır.
> Performans kritik uygulamalarda büyük veri işlemek için çok etkilidir.

---

## 🎯 Ne Zaman Kullanılır?

| Uygun Olduğu Durumlar     | Kaçınılması Gereken Durumlar                  |
| ------------------------- | --------------------------------------------- |
| Büyük veri koleksiyonları | Küçük koleksiyonlar (çünkü thread cost fazla) |
| Ağır CPU işlemleri        | IO ağırlıklı işler (disk, ağ vs.)             |
| Thread-safe işlemler      | Yan etkili (side-effect) işlemler             |

---

## ✅ 2. Basit Karşılaştırmalı Örnek

```java
import java.util.*;
import java.util.stream.*;
import java.time.*;

public class ParallelStreamOrnek {

    public static void main(String[] args) {

        List<Integer> sayilar = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        // Seri stream
        Instant basla1 = Instant.now();
        sayilar.stream()
                .map(ParallelStreamOrnek::agirIslem)
                .collect(Collectors.toList());
        Instant bitir1 = Instant.now();
        System.out.println("Seri stream süresi: " + Duration.between(basla1, bitir1).toMillis() + " ms");

        // Paralel stream
        Instant basla2 = Instant.now();
        sayilar.parallelStream()
                .map(ParallelStreamOrnek::agirIslem)
                .collect(Collectors.toList());
        Instant bitir2 = Instant.now();
        System.out.println("Paralel stream süresi: " + Duration.between(basla2, bitir2).toMillis() + " ms");
    }

    // CPU ağırlıklı işlem simülasyonu
    public static int agirIslem(int sayi) {
        try {
            Thread.sleep(10); // her işlem 10ms sürüyor
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sayi * 2;
    }
}
```

### 🧪 Örnek Sonuçlar:

* **Seri stream süresi**: \~1000 ms
* **Paralel stream süresi**: \~300-500 ms
  (kaç çekirdekli sistemde çalıştığına bağlı olarak değişir)

---

## ✅ 3. Gerçek Hayat Örneği – Ürün Fiyat Güncelleme

```java
class Urun {
    private String ad;
    private double fiyat;

    public Urun(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public Urun fiyatGuncelle() {
        try {
            Thread.sleep(100); // simülasyon: maliyetli işlem
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Urun(ad, fiyat * 1.18); // KDV'li fiyat
    }

    @Override
    public String toString() {
        return ad + " → " + String.format("%.2f", fiyat) + " TL";
    }
}

public class UrunParalel {
    public static void main(String[] args) {
        List<Urun> urunler = Arrays.asList(
                new Urun("Laptop", 20000),
                new Urun("Telefon", 15000),
                new Urun("Tablet", 8000),
                new Urun("Klavye", 500),
                new Urun("Mouse", 400)
        );

        // Seri işlem
        Instant t1 = Instant.now();
        List<Urun> sonuc1 = urunler.stream()
                .map(Urun::fiyatGuncelle)
                .collect(Collectors.toList());
        Instant t2 = Instant.now();
        System.out.println("Seri süre: " + Duration.between(t1, t2).toMillis() + " ms");

        // Paralel işlem
        Instant t3 = Instant.now();
        List<Urun> sonuc2 = urunler.parallelStream()
                .map(Urun::fiyatGuncelle)
                .collect(Collectors.toList());
        Instant t4 = Instant.now();
        System.out.println("Paralel süre: " + Duration.between(t3, t4).toMillis() + " ms");
    }
}
```

---

## ✅ 4. `.stream().parallel()` ile `.parallelStream()` farkı

```java
list.stream().parallel()       // stream açılır, sonra paralel yapılır
list.parallelStream()          // doğrudan paralel açılır
```

> Aralarında fark minimaldir, ancak `stream().parallel()` zincirleme işlemlerde esneklik sağlar.

---

## 🔥 Dikkat Edilmesi Gerekenler

1. **Yan etkili işlemlerde kullanma**:

   ```java
   List<String> sonuc = new ArrayList<>();
   liste.parallelStream().forEach(s -> sonuc.add(s)); // ❌ NOT THREAD SAFE!
   ```

2. **Veri sırası garanti edilmez**:

   ```java
   liste.parallelStream().forEach(System.out::println); // sıralı değil
   ```

3. **Çözüm: forEachOrdered()**

   ```java
   liste.parallelStream().forEachOrdered(System.out::println); // sırayı korur
   ```

---

## 🧠 Bonus: Paralel Stream İş Parçacığı Sayısı

```java
int isParcacigi = ForkJoinPool.commonPool().getParallelism();
System.out.println("Kullanılabilir çekirdek sayısı: " + isParcacigi);
```

> Varsayılan olarak `CPU core sayısı - 1` kadar thread kullanılır.
> Gerekirse `ForkJoinPool` özelleştirilebilir.

---

## 🎯 Özet

| Özellik            | Açıklama                                       |
| ------------------ | ---------------------------------------------- |
| `parallelStream()` | Veriyi paralel işlemek için                    |
| Hız avantajı       | Özellikle büyük veri + ağır işlem varsa        |
| Risk               | Thread-safe olmayan yapılar ve sıralı işlemler |
| `forEachOrdered()` | Paralelde bile sıralı çıktı almak için         |

---
