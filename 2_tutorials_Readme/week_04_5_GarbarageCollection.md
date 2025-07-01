## Java Core Garbarage Collection
```sh 

```
---


Java'da **Garbage Collection (Çöp Toplama)**, JVM’in (Java Virtual Machine) programcıdan bağımsız olarak **kullanılmayan nesneleri otomatik olarak hafızadan temizlemesi** işlemidir. Java’nın en önemli özelliklerinden biridir ve **bellek yönetimini kolaylaştırır**, manuel `free()` çağrılarına ihtiyaç duymazsınız (C/C++'ta olduğu gibi).

---

## 🧠 1. **Garbage Collection NEDİR?**

Garbage Collection (GC), **heap memory**'de artık referansı kalmamış (kullanılmayan) nesneleri **otomatik olarak silen** bir mekanizmadır.

> Java’daki tüm nesneler heap’te saklanır. GC bu alanı izler ve kullanılmayan nesneleri temizler.

---

## 🧱 2. **Bellek Yapısı (Heap Memory)**

Java bellek yapısı aşağıdaki gibidir:

```
[Heap Memory]
├── Young Generation
│   ├── Eden Space
│   └── Survivor Spaces (S0, S1)
└── Old Generation (Tenured)
```

| Alan                  | Açıklama                                                         |
| --------------------- | ---------------------------------------------------------------- |
| **Eden**              | Yeni nesneler burada oluşturulur                                 |
| **Survivor**          | Eden’den kurtulan nesneler buraya geçer                          |
| **Old**               | Uzun ömürlü nesneler buraya taşınır                              |
| **PermGen/MetaSpace** | Class bilgileri burada tutulur (Java 8+'de MetaSpace kullanılır) |

---

## 🌀 3. **GC NASIL ÇALIŞIR? (Adım Adım)**

### Adım 1: Nesne oluşturulması

```java
Product p = new Product("Kalem");
```

Bu nesne **heap** belleğe yazılır ve `p` değişkeni **stack** üzerinde bu nesneye referans tutar.

---

### Adım 2: Referansın kaybolması

```java
p = null; // Artık heap'teki nesneye ulaşan referans yok
```

Artık `Product` nesnesine hiçbir referans yok. GC bu nesneyi artık **"reachable değil"** olarak işaretler.

---

### Adım 3: GC Tarama ve Temizleme

Bir süre sonra JVM GC algoritması çalışır:

* Reachable olmayan nesneleri tespit eder
* Hafızadan kaldırır
* Boş alanı başka nesneler için kullanılabilir hale getirir

---

## 🔥 4. GC’Yİ MANUEL TETİKLEME (Zorlamak)

```java
System.gc();
```

> JVM’e çöp toplama **tavsiyesi** verir ama çalışacağı **garanti değildir.**

---

## 🧪 5. ÖRNEK: Basit GC Davranışı

```java
public class GarbageDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Ali");
        Person p2 = new Person("Veli");

        p1 = null; // Artık 'Ali' nesnesi referanssız
        p2 = null; // Artık 'Veli' nesnesi referanssız

        System.gc(); // GC çalışması için öneride bulunuyoruz

        System.out.println("Program sonlandı.");
    }
}

class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " nesnesi garbage collector tarafından temizlendi.");
    }
}
```

### Çıktı (JVM'e göre değişebilir):

```
Ali nesnesi garbage collector tarafından temizlendi.
Veli nesnesi garbage collector tarafından temizlendi.
Program sonlandı.
```

> `finalize()` metodu, GC silmeden hemen önce çalışır. **Java 9 itibariyle deprecated** olmuştur.

---

## 🧭 6. GARBAGE COLLECTOR ALGORİTMALARI

### Java’da farklı GC stratejileri vardır:

| GC Türü                         | Açıklama                                         |
| ------------------------------- | ------------------------------------------------ |
| **Serial GC**                   | Tek thread ile çalışır. Küçük uygulamalarda iyi  |
| **Parallel GC**                 | Çok çekirdekli makinelerde hızlı toplama         |
| **CMS (Concurrent Mark Sweep)** | Eş zamanlı çalışır. Pausetime (duraksama) az     |
| **G1 GC (Garbage First)**       | Java 9+ ile öntanımlı, büyük heap'lerde verimli  |
| **ZGC / Shenandoah**            | Java 11+ yüksek performanslı, düşük gecikmeli GC |

---

## 🧯 7. GC NE ZAMAN ÇALIŞIR?

JVM, aşağıdaki durumlarda **otomatik olarak GC'yi tetikler**:

* Heap belleği dolmaya yaklaşırsa
* Eden Space dolarsa
* Kod uzun süre çalışırsa (background'da)
* `System.gc()` ile öneride bulunulursa

---

## 🚫 8. REFERANS TİPLERİ VE GC DAVRANIŞI

### a. **Strong Reference (Varsayılan)**

```java
Person p = new Person("Ali"); // Strong reference
```

> GC bunu **asla temizlemez** (referans olduğu sürece)

---

### b. **WeakReference**

```java
WeakReference<Person> weak = new WeakReference<>(new Person("Veli"));
```

> Eğer başka strong reference yoksa GC **hemen silebilir**.

---

## ✅ 9. GC PERFORMANSINI ARTIRMA (PROFİLLEME)

* JVM argümanları ile GC ayarlanabilir:

```bash
java -XX:+UseG1GC -Xms512m -Xmx1024m -jar app.jar
```

* GC logları alınabilir:

```bash
-verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps
```

---

## 📌 Özet: Garbage Collection Nedir?

| Konu            | Açıklama                                                 |
| --------------- | -------------------------------------------------------- |
| Tanım           | Kullanılmayan nesnelerin otomatik temizlenmesi           |
| Amaç            | Hafızayı verimli kullanmak, bellek sızıntılarını önlemek |
| JVM sorumluluğu | Geliştirici değil, JVM yapar                             |
| Çalışma zamanı  | Otomatik veya `System.gc()` ile önerilir                 |
| Uygulama        | Özellikle heap üzerinde çalışır                          |
| En iyi GC       | Java 9+: G1GC, Java 11+: ZGC, Shenandoah                 |

---


## Java Core Garbarage Collection Manuel Çalıştırmak
```sh 

```
---

Java’da **Garbage Collection (GC)**, JVM tarafından **otomatik olarak tetiklenen** bir bellek yönetim mekanizmasıdır. Normal şartlarda **manuel çalıştırmamız gerekmez**, hatta **genellikle önerilmez**. Ancak bazı **özel senaryolarda** "manuel çalıştırmak isteme" durumu oluşabilir.

Aşağıda bu konuyu **“Neden GC normalde otomatik çalışır?”, “Neden bazı durumlarda manuel çağırma gerekebilir?”** sorularıyla sistematik şekilde açıklıyorum.

---

## ✅ 1. **NEDEN GARBAGE COLLECTOR ZATEN OTOMATİK?**

### Java’nın temel amacı:

> “**Otomatik bellek yönetimi** sayesinde yazılımcının `free()` veya `delete` gibi fonksiyonlar ile uğraşmaması.”

JVM şunları yapar:

* Heap belleğini sürekli izler.
* Kullanılmayan nesneleri otomatik tespit eder.
* Uygun zamanda çöp toplama işlemi yapar (GC cycle).

### Yani:

* Kod yazarken GC’yi düşünmene gerek kalmaz.
* JVM hangi nesnelerin silinmesi gerektiğini **bizden daha iyi bilir.**

---

## 🔍 2. **PEKİ NEDEN MANUEL TETİKLEMEYE İHTİYAÇ DUYARIZ?**

Java'da `System.gc();` ile GC’yi manuel olarak **önermek** mümkündür:

```java
System.gc(); // GC’ye “şimdi çalış” demek, garanti değil!
```

### Ancak bu komut:

* Sadece **tavsiye niteliğindedir**.
* JVM bu çağrıyı **görmezden gelebilir**.
* `gc()` çağrıldığında **full GC** yapılabilir, bu da performans düşürebilir.

---

## 🎯 3. **MANUEL GC NE ZAMAN GEREKLİ OLABİLİR?**

### ✅ A. **Büyük Hafıza Kullanımı Sonrası Temizlik**

Eğer büyük boyutlu nesneler (örneğin `BufferedImage`, `byte[]`, `PDF`, `Excel`, `video`) kullanılmışsa ve bunlar artık kullanılmıyorsa, heap belleği temizletmek isteyebilirsin.

```java
document = null; // referans sil
System.gc();     // manuel tetikleme isteği
```

> Özellikle masaüstü (JavaFX, Swing) ve görsel işleme uygulamalarında tercih edilir.

---

### ✅ B. **Benchmark/Test Durumları**

Performans testi yaparken:

* GC sonrası boş hafıza miktarını ölçmek,
* Nesnelerin yaşam süresini gözlemlemek istersen,

```java
System.gc();
long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
```

---

### ✅ C. **Kritik kaynakların serbest bırakılması gerekiyorsa**

Örneğin:

* Native kaynak kullanan objeler (`InputStream`, `Socket`, `File`)
* `finalize()` (deprecated) veya `Cleaner` ile temizlik yapılan sınıflar

---

### ✅ D. **OutOfMemoryError alındıysa - belki son çare**

Zorunlu durumlarda **biraz yer açmak için** denersin:

```java
try {
    bigArray = new byte[1024 * 1024 * 512];
} catch (OutOfMemoryError e) {
    bigArray = null;
    System.gc(); // belki kurtarır ama garanti yok
}
```

---

## ⚠️ 4. **NEDEN MANUEL GC KULLANIMI TEHLİKELİDİR?**

| Risk                | Açıklama                                                                             |
| ------------------- | ------------------------------------------------------------------------------------ |
| ❌ Performans kaybı  | `System.gc()` Full GC tetikler → CPU tüketir, uygulamayı duraklatır (Stop-the-world) |
| ❌ Zamanlama hatası  | GC çalışması JVM içindeki dinamik analizle belirlenmeli                              |
| ❌ Gereksiz kullanım | JVM zaten akıllı şekilde karar verir, elle tetikleme gereksiz yere yük getirir       |

---

## 🧪 5. ÖRNEK: MANUEL GC UYGULAMASI

```java
public class ManualGcExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new byte[1024 * 1024]; // 1 MB nesneler
        }

        System.out.println("Çöp toplama önerildi.");
        System.gc(); // manuel tetikleme

        System.out.println("İşlem tamam.");
    }
}
```

> Bu örnek JVM tarafından kullanılan heap’i şişirir. `System.gc()` çağrısı ile temizlik önerisinde bulunuruz.

---

## 🔧 6. İLERİ SEVİYE: JVM ARGÜMANLARI İLE GC YÖNETİMİ

GC yönetimini JVM argümanları ile daha iyi kontrol edebilirsin:

```bash
java -Xmx512m -Xms256m -XX:+UseG1GC -verbose:gc -XX:+PrintGCDetails -jar app.jar
```

---

## 🧭 7. SONUÇ: NE ZAMAN MANUEL GC?

| Durum                               | `System.gc()` Gerekli mi?        |
| ----------------------------------- | -------------------------------- |
| Normal uygulama akışı               | ❌ Hayır                          |
| Hafıza doldu, büyük nesne silindi   | ⚠️ Belki                         |
| Performans testleri, profil çıkarma | ✅ Evet                           |
| OOM hatası sonrası son çare         | ⚠️ Evet ama çözüm garantisi yok  |
| Streaming, resim işleme, PDF        | ⚠️ Evet (native kaynaklar varsa) |

---

## 📌 Özet

| Soru                       | Cevap                                                             |
| -------------------------- | ----------------------------------------------------------------- |
| Garbage Collection nedir?  | Heap bellekteki kullanılmayan nesnelerin otomatik temizlenmesidir |
| Manuel çalıştırmalı mıyız? | Genelde hayır. JVM zaten uygun zamanda yapar                      |
| Ne zaman gerekli?          | Büyük nesneler, test ortamları, özel durumlar                     |
| Hangi komut?               | `System.gc()` ancak JVM sadece **tavsiye** olarak kabul eder      |

---