
## Java Core Static - Final Kavramı
```sh 

```
---

 Java'da **`static`** ve **`final`** anahtar kelimeleri oldukça temel ama etkili kavramlardır. Aşağıda bu iki kavramı **en kapsamlı şekilde**, bol örnekle, teknik detaylarıyla ve karşılaştırmalarla açıklayalım.

---

## ✅ 1. `static` Anahtar Kelimesi

### 🔹 Tanım:

`static`, bir değişkenin, metodun ya da blok yapısının **sınıfa (class)** ait olduğunu belirtir. Yani bu üyeler, **nesneye değil sınıfa aittir**.

### 🔹 Kullanım yerleri:

* static değişken (class variable)
* static method (class method)
* static blok (static initialization block)
* static inner class

---

### 🔸 static Değişken (Class Variable):

```java
public class Sayac {
    public static int sayac = 0;

    public Sayac() {
        sayac++;
    }
}
```

#### Açıklama:

* `sayac` değişkeni static olduğu için **tüm nesneler arasında ortaktır.**
* Her yeni `Sayac` nesnesi oluşturulduğunda sayac artar.

```java
public class Main {
    public static void main(String[] args) {
        new Sayac();
        new Sayac();
        new Sayac();
        System.out.println(Sayac.sayac);  // Çıktı: 3
    }
}
```

---

### 🔸 static Metod (Class Method):

```java
public class Matematik {
    public static int kare(int x) {
        return x * x;
    }
}
```

#### Kullanımı:

```java
int sonuc = Matematik.kare(5);  // 25
```

#### Not:

* static metodlar **sadece static üyeleri** doğrudan kullanabilir.
* Nesne oluşturmadan çağrılabilir.

---

### 🔸 static Block:

```java
public class Veritabani {
    static {
        System.out.println("Veritabanına bağlanılıyor...");
    }
}
```

* Sınıf belleğe yüklendiğinde **ilk çalışan bloktur.**
* Genellikle `static` değişkenleri başlatmak için kullanılır.

---

### 🔸 static İç Sınıf (Nested Class):

```java
public class DisSinif {
    static class IcSinif {
        void mesaj() {
            System.out.println("Static iç sınıf");
        }
    }
}
```

---

## ✅ 2. `final` Anahtar Kelimesi

### 🔹 Tanım:

`final` anahtar kelimesi, bir değişkenin, metodun veya sınıfın **değiştirilemez (immutable)** olduğunu belirtir.

---

### 🔸 final Değişken:

```java
public class Ayarlar {
    public static final double PI = 3.14159;
}
```

#### Özellikleri:

* Bir kez değer atanır, bir daha **değiştirilemez.**
* Genellikle sabitler (`constant`) tanımlamak için `static final` olarak kullanılır.

---

### 🔸 final Metod:

```java
public class Hayvan {
    public final void sesVer() {
        System.out.println("Hayvan sesi");
    }
}
```

#### Not:

* `final` metodlar **override edilemez**. Alt sınıflarda değiştirilemez.

```java
public class Kedi extends Hayvan {
    // Hata verir
    // public void sesVer() { ... }
}
```

---

### 🔸 final Sınıf:

```java
public final class Utility {
    public static void log(String message) {
        System.out.println(message);
    }
}
```

#### Not:

* `final` sınıflar **kalıtılamaz (inheritance yapılamaz).**
* `String`, `Integer`, `LocalDate` gibi birçok Java sınıfı `final`’dır.

---

### 🔸 final Parametreler:

```java
public void yazdir(final int sayi) {
    // sayi = 5; // HATA! çünkü final
    System.out.println(sayi);
}
```

---

## ✅ static ve final Birlikte Kullanımı

```java
public class Sabitler {
    public static final String UYGULAMA_ADI = "AIHEXA Eğitim Sistemi";
}
```

### Özellikler:

* `static`: Nesne oluşturmadan erişilebilir.
* `final`: Sabit olduğu için değiştirilemez.

```java
System.out.println(Sabitler.UYGULAMA_ADI);
```

---

## ✅ static vs final Karşılaştırması

| Özellik          | `static`                           | `final`                                 |
| ---------------- | ---------------------------------- | --------------------------------------- |
| Tanım            | Sınıfa aittir                      | Değiştirilemezliği tanımlar             |
| Hedef            | Bellek paylaşımı (class-level)     | Sabitlik (immutability)                 |
| Değişken etkisi  | Tüm nesneler arasında ortak        | Sadece bir kez atanabilir               |
| Metod etkisi     | Nesne oluşturmadan çağrılabilir    | Override edilemez                       |
| Sınıf etkisi     | Yok                                | Kalıtım yapılamaz                       |
| Bellekte yeri    | Heap değil, **Method Area**        | Normalde stack/heap ama değeri sabittir |
| Kullanım sıklığı | Ortak kaynaklar, yardımcı metodlar | Sabitler, güvenlik, güvenilirlik        |

---

## ✅ Bellek ve Performans Açısından

* `static` üyeler yalnızca **bir kez belleğe yüklenir.**
* Çok sayıda nesne üretildiğinde, `static` değişkenler **bellek tasarrufu** sağlar.
* `final` değişkenler derleme zamanında optimize edilebilir (örneğin inline edilebilir).

---

## ✅ İleri Seviye Notlar

### 🔹 static + synchronized

```java
public static synchronized void threadSafeMethod() {
    // Thread-safe kod
}
```

> Sınıf düzeyinde senkronizasyon sağlar.

---

### 🔹 final Referanslar ve Mutable Nesneler

```java
final List<String> liste = new ArrayList<>();
liste.add("a");  // geçerli
// liste = new ArrayList<>(); // Hata
```

> Referans değiştirilemez, ancak nesnenin içeriği değiştirilebilir.

---

### 🔹 Java 8 ve Lambda:

`final` ya da "effectively final" değişkenler lambda içinde kullanılabilir.

```java
public void runLambda() {
    final int sayi = 10;
    Runnable r = () -> System.out.println(sayi);
    r.run();
}
```

---

## ✅ Özet

| Durum                           | static | final | static final |
| ------------------------------- | ------ | ----- | ------------ |
| Class'a ait ve değiştirilebilir | ✅      | ❌     | ❌            |
| Nesneye ait ve değiştirilebilir | ❌      | ❌     | ❌            |
| Class'a ait ve sabit            | ✅      | ✅     | ✅            |
| Değiştirilemez ama nesneye ait  | ❌      | ✅     | ❌            |

---

## 🧠 Hatırlatıcı Kısaltmalar

* `static = sınıfa ait`
* `final = değiştirilemez`
* `static final = sabit (constant)`

---






## Java Core static -Constructor
```sh 

```
---

Java'da **`static block`** ve **constructor** birlikte kullanıldığında, **öncelik sıraları farklıdır** çünkü bunlar farklı amaçlara hizmet eder.

Senin verdiğin sınıfa bir constructor ekleyelim ve sonra adım adım nasıl çalıştığını görelim.

---

### 🔧 Kod Örneği:

```java
public class Veritabani {

    // static blok
    static {
        System.out.println("🔌 Veritabanına bağlanılıyor... (static blok)");
    }

    // constructor
    public Veritabani() {
        System.out.println("🛠️ Veritabanı nesnesi oluşturuldu. (constructor)");
    }

    public static void main(String[] args) {
        System.out.println("📌 Program başladı.");
        Veritabani vt1 = new Veritabani();
        Veritabani vt2 = new Veritabani();
    }
}
```

---

### 🧠 Çalışma Mantığı ve Öncelik Sırası

Java’da sıralama **şöyledir**:

1. **`static block` → sınıf belleğe ilk yüklendiğinde sadece 1 kez çalışır.**
2. **`constructor` → her `new` ile çağrıldığında çalışır.**

---

### 🧾 Çıktı:

```
🔌 Veritabanına bağlanılıyor... (static blok)
📌 Program başladı.
🛠️ Veritabanı nesnesi oluşturuldu. (constructor)
🛠️ Veritabanı nesnesi oluşturuldu. (constructor)
```

---

### 📌 Özetle:

| Yapı           | Ne zaman çalışır?                                     | Kaç kere çalışır?  |
| -------------- | ----------------------------------------------------- | ------------------ |
| `static block` | Sınıf **ilk kez yüklendiğinde** (class loader zamanı) | 1 kez              |
| `constructor`  | Her `new` operatöründe                                | Nesne sayısı kadar |

---

### 🎯 Ne zaman ne kullanılır?

* **`static block`** → Ortak işlemler: veritabanı bağlantısı, driver yükleme, static sabitlerin başlatılması.
* **`constructor`** → Her nesneye özel başlangıç: örneğin `this.ad = ad` gibi.

---




## Java Core Inner Class
```sh 

```
---

Java'da **Inner Class** (İç Sınıf), bir sınıfın **başka bir sınıfın içinde tanımlanmasıdır.** Bu kavram, nesne yönelimli programlamada **kapsülleme, mantıksal gruplayarak kodun okunabilirliğini artırma ve sınıf içindeki sınıfa özel davranışlar tanımlama** amacıyla kullanılır.

---

## ✅ 1. Inner Class Nedir?

> Inner Class, bir sınıfın içinde tanımlanmış başka bir sınıftır. Genellikle sadece dış sınıfa (outer class) özel işlemler gerçekleştirmek için kullanılır.

---

## 🔷 2. Inner Class Türleri

Java’da dört temel iç sınıf türü vardır:

| Tür                                       | Açıklama                                        |
| ----------------------------------------- | ----------------------------------------------- |
| 1. **Non-static Inner Class** (Üye sınıf) | Dış sınıfın bir nesnesine bağlıdır              |
| 2. **Static Nested Class**                | Dış sınıfın nesnesine ihtiyaç duymaz            |
| 3. **Local Inner Class**                  | Bir metodun veya blok yapının içinde tanımlanır |
| 4. **Anonymous Inner Class**              | İsimsiz, tek seferlik kullanılan sınıflardır    |

---

## 🔸 1. Non-static Inner Class

```java
public class DisSinif {
    private String mesaj = "Merhaba";

    public class IcSinif {
        public void yazdir() {
            System.out.println("İç Sınıf: " + mesaj);
        }
    }
}
```

### Kullanımı:

```java
DisSinif.IcSinif nesne = new DisSinif().new IcSinif();
nesne.yazdir();
```

🔹 Özellikler:

* Dış sınıfın private üyelerine erişebilir.
* Dış sınıfın bir örneği (instance) olmadan oluşturulamaz.

---

## 🔸 2. Static Nested Class

```java
public class DisSinif {
    private static String mesaj = "Statik Mesaj";

    public static class IcStatikSinif {
        public void yazdir() {
            System.out.println("Static İç Sınıf: " + mesaj);
        }
    }
}
```

### Kullanımı:

```java
DisSinif.IcStatikSinif nesne = new DisSinif.IcStatikSinif();
nesne.yazdir();
```

🔹 Özellikler:

* Dış sınıfın static üyelerine erişebilir.
* Dış sınıfın nesnesine ihtiyaç duymaz.

---

## 🔸 3. Local Inner Class

```java
public class DisSinif {
    public void hesapla() {
        class IcYerelSinif {
            public void yazdir() {
                System.out.println("Local Inner Class");
            }
        }

        IcYerelSinif sinif = new IcYerelSinif();
        sinif.yazdir();
    }
}
```

🔹 Özellikler:

* Sadece tanımlandığı metodun içinde kullanılabilir.
* Genellikle küçük, tek seferlik işler için kullanılır.

---

## 🔸 4. Anonymous Inner Class

> İsimsiz olarak tanımlanan, genellikle bir interface veya abstract class’ı implement eden sınıflardır.

```java
abstract class Selam {
    abstract void mesaj();
}

public class DisSinif {
    public static void main(String[] args) {
        Selam nesne = new Selam() {
            @Override
            void mesaj() {
                System.out.println("Anonim İç Sınıf");
            }
        };

        nesne.mesaj();
    }
}
```

🔹 Kullanım yerleri:

* GUI (Swing, Android)
* Event Listener
* Runnable, Callable, Comparator

---

## ✅ Inner Class Kullanımının Avantajları

1. **Kapsülleme**: Dış sınıfa ait olan ama dışarıdan erişilmemesi gereken işlemleri saklar.
2. **Kodun Mantıksal Gruplaması**: İlgili sınıfları bir arada tutarak kod okunabilirliğini artırır.
3. **Dış Sınıfa Kolay Erişim**: Private alanlara doğrudan erişebilir.
4. **Daha Az Kod ve Tek Seferlik Tanımlar**: Özellikle anonymous inner class ile.

---

## ✅ Karşılaştırmalı Özet Tablosu

| Özellik                    | Non-static Inner  | Static Nested   | Local Inner       | Anonymous Inner   |
| -------------------------- | ----------------- | --------------- | ----------------- | ----------------- |
| Dış sınıf nesnesi gerek    | ✅                 | ❌               | ✅                 | ✅                 |
| Static olabilir mi         | ❌                 | ✅               | ❌                 | ❌                 |
| Dış sınıf üyelerine erişim | Tümüne erişebilir | Yalnızca static | Tümüne erişebilir | Tümüne erişebilir |
| Kullanım alanı             | Tüm sınıf         | Tüm sınıf       | Metot/blok içi    | Tek seferlik      |

---

## ✅ Gerçek Hayattan Örnek: JavaFX ActionListener

```java
button.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Butona tıklandı!");
    }
});
```

Bu yapı, bir **anonymous inner class** örneğidir.

---

## ✅ Sonuç

Java’daki `inner class` yapıları, aşağıdaki amaçlarla çok faydalıdır:

* Dış sınıfa sıkı bağlı, yardımcı yapıların tanımlanması
* Kapsam daraltılarak soyutlama sağlanması
* GUI ve event-based programlama
* Dışarıdan erişimin kısıtlanması

---

public class Banka {

    private String bankaAdi = "XYZBANK";

    public class Musteri {
        private String ad;
        private double bakiye;

        public Musteri(String ad, double bakiye) {
            this.ad = ad;
            this.bakiye = bakiye;
        }

        public void bilgiYazdir() {
            System.out.println("Banka: " + bankaAdi);
            System.out.println("Müşteri: " + ad + " - Bakiye: " + bakiye);
        }
    }

    public void yeniMusteri(String ad, double bakiye) {
        Musteri musteri = new Musteri(ad, bakiye);
        musteri.bilgiYazdir();
    }

    public static void main(String[] args) {
        Banka banka = new Banka();
        banka.yeniMusteri("Ahmet", 1500.0);
    }
}



## Başka bir örnek Inner Class

public class Telefon {

    private static String marka = "AIHEXAphone";

    public static class Kamera {
        public void cekimYap() {
            System.out.println(marka + " ile fotoğraf çekildi.");
        }
    }

    public static void main(String[] args) {
        Telefon.Kamera kamera = new Telefon.Kamera();
        kamera.cekimYap();
    }
}




## Java Core Enum
```sh 

```
---

Java'da **`enum`** (enumeration – numaralandırma), **sabit (constant)** değerleri gruplayarak anlamlı ve güvenli bir şekilde kullanmanı sağlayan özel bir veri tipidir.

`enum`, **belirli, değişmez sabitlerin bir koleksiyonunu** temsil eder. Özellikle seçim yapılacak yerlerde (`GÜN`, `AY`, `CİNSİYET`, `DURUM`, `ROL`, `RENK`, vs.) tercih edilir.

---

## ✅ Enum Nedir? (Tanım)

```java
public enum Gun {
    PAZARTESI, SALI, CARSAMBA, PERSEMBE, CUMA, CUMARTESI, PAZAR
}
```

* `enum` bir sınıf türüdür.
* Her enum sabiti, aslında enum sınıfının bir nesnesidir.
* Değerler **default olarak `public static final`** kabul edilir.
* Genellikle `switch-case`, `if`, `equals`, `==` ile birlikte kullanılır.

---

## ✅ Neden enum Kullanılır?

🔹 Aşağıdaki sorunları çözmek için:

1. **Sabir değerleri anlamlı şekilde gruplamak** (magic number veya string kullanımını önler).
2. **Tip güvenliği sağlamak** (örneğin `String rol = "ADMIN"` yerine `enum Rol { ADMIN, USER }`).
3. **Daha okunabilir ve bakım kolaylığı olan kod** yazmak.

---

## ✅ Enum Kullanım Örneği

### 🔸 Basit enum:

```java
public enum Renk {
    KIRMIZI, MAVI, YESIL
}
```

### Kullanımı:

```java
public class Test {
    public static void main(String[] args) {
        Renk seciliRenk = Renk.MAVI;

        switch (seciliRenk) {
            case KIRMIZI -> System.out.println("Seçilen renk: Kırmızı");
            case MAVI -> System.out.println("Seçilen renk: Mavi");
            case YESIL -> System.out.println("Seçilen renk: Yeşil");
        }
    }
}
```

---

## ✅ Enum Sınıf Gibi Davranabilir mi?

Evet, enum’lar sınıf gibi davranır. Field (alan), constructor ve metod içerebilir.

### 🔸 Alanlı enum:

```java
public enum HataKodu {
    NOT_FOUND(404),
    INTERNAL_ERROR(500),
    BAD_REQUEST(400);

    private final int kod;

    HataKodu(int kod) {
        this.kod = kod;
    }

    public int getKod() {
        return kod;
    }
}
```

### Kullanımı:

```java
System.out.println(HataKodu.NOT_FOUND.getKod());  // 404
```

---

## ✅ enum içinde Metod Yazmak

```java
public enum Mevsim {
    ILKBAHAR, YAZ, SONBAHAR, KIS;

    public boolean sogukMu() {
        return this == KIS || this == SONBAHAR;
    }
}
```

```java
System.out.println(Mevsim.KIS.sogukMu());  // true
```

---

## ✅ Enum ile Interface Kullanımı

```java
interface Yazdir {
    void yaz();
}

public enum Sehir implements Yazdir {
    ISTANBUL, ANKARA, IZMIR;

    @Override
    public void yaz() {
        System.out.println("Şehir: " + this.name());
    }
}
```

---

## ✅ Enum’da Özel Metotlar

| Metot Adı         | Açıklama                               |
| ----------------- | -------------------------------------- |
| `name()`          | Enum sabitinin ismini verir            |
| `ordinal()`       | Index sırasını verir (0'dan başlar)    |
| `values()`        | Tüm enum sabitlerini dizi olarak verir |
| `valueOf(String)` | String’ten enum’a çevirir              |

### Örnek:

```java
for (Gun g : Gun.values()) {
    System.out.println(g.name() + " - " + g.ordinal());
}
```

---

## ✅ Enum vs Class Farkları

| Özellik              | enum                              | class                 |
| -------------------- | --------------------------------- | --------------------- |
| Sabit değer içerir   | ✅                                 | ❌                     |
| Nesne oluşturma      | Otomatik yapılır                  | Manuel yapılır        |
| Değiştirilebilir mi? | ❌ (immutable)                     | ✅                     |
| Kalıtım              | `enum` başka sınıfı extend edemez | `class` kalıtılabilir |
| Interface            | ✅ Uygulayabilir                   | ✅                     |

---

## ✅ Gerçek Hayatta enum Kullanımı Örnekleri

1. **HTTP Durum Kodları**:

```java
public enum HttpStatus {
    OK(200), NOT_FOUND(404), SERVER_ERROR(500);
}
```

2. **Kullanıcı Rolü**:

```java
public enum Rol {
    ADMIN, MODERATOR, USER
}
```

3. **Sipariş Durumu**:

```java
public enum SiparisDurumu {
    HAZIRLANIYOR, KARGOLANDI, TESLIM_EDILDI, IPTAL_EDILDI
}
```

---

## ✅ Enum ile Switch-Case Kullanımı

```java
public enum Durum { AKTIF, PASIF, BEKLEMEDE }

Durum d = Durum.BEKLEMEDE;

switch (d) {
    case AKTIF -> System.out.println("Aktif durumda");
    case PASIF -> System.out.println("Pasif durumda");
    case BEKLEMEDE -> System.out.println("Bekliyor...");
}
```

---

## ✅ Enum İçin İleri Seviye Özellikler

* Enum sabitleri `singleton` gibidir (sadece bir örnek oluşturulur).
* Enum sınıfları `final` olarak tanımlanır (extends edilemez).
* Enum’lar `Comparable`, `Serializable` arayüzlerini otomatik olarak uygular.

---

## ✅ Özet

| Özellik                | Açıklama                                             |
| ---------------------- | ---------------------------------------------------- |
| enum nedir?            | Sabit (değişmeyen) değerler kümesi                   |
| default davranış       | `public static final` olarak işler                   |
| neden kullanılır       | Tip güvenliği, okunabilirlik, anlamlı sabit gruplama |
| field/metot tanımı     | Evet, sınıf gibi tanımlanabilir                      |
| sınıf gibi davranır mı | Evet                                                 |
| inheritance            | Sadece `interface` implement edebilir                |

---

## Enum Örnek
public enum SiparisDurumu {
HAZIRLANIYOR, KARGODA, TESLIM_EDILDI, IPTAL_EDILDI;
}


public class Siparis {

    private String urunAdi;
    private SiparisDurumu durum;

    public Siparis(String urunAdi, SiparisDurumu durum) {
        this.urunAdi = urunAdi;
        this.durum = durum;
    }

    public void durumYazdir() {
        switch (durum) {
            case HAZIRLANIYOR -> System.out.println(urunAdi + " hazırlanıyor.");
            case KARGODA -> System.out.println(urunAdi + " kargoya verildi.");
            case TESLIM_EDILDI -> System.out.println(urunAdi + " teslim edildi.");
            case IPTAL_EDILDI -> System.out.println(urunAdi + " siparişi iptal edildi.");
        }
    }

    public static void main(String[] args) {
        Siparis siparis1 = new Siparis("Laptop", SiparisDurumu.HAZIRLANIYOR);
        Siparis siparis2 = new Siparis("Kulaklık", SiparisDurumu.TESLIM_EDILDI);

        siparis1.durumYazdir();
        siparis2.durumYazdir();
    }
}


## Enum Örnek
public enum HavaDurumu {
GUNESLI("Güneşli, dışarı çıkabilirsin."),
YAGMURLU("Yağmurlu, şemsiye al."),
KARLI("Karlı, dikkatli ol."),
BULUTLU("Bulutlu, gri bir gün.");

    private final String mesaj;

    HavaDurumu(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getMesaj() {
        return mesaj;
    }
}






## Java Core Enum - Inner Class Örneği
```sh 

```
---

public class Araba {

    public enum YakitTuru {BENZIN, DIZEL, ELEKTRIKLI}

    private String model;
    private YakitTuru yakit;

    public Araba(String model, YakitTuru yakit) {
        this.model = model;
        this.yakit = yakit;
    }

    public class Motor {
        public void bilgiVer() {
            System.out.println(model + " aracı " + yakit + " ile çalışıyor.");
        }
    }

    public static void main(String[] args) {
        Araba araba = new Araba("Tesla Model Y", YakitTuru.ELEKTRIKLI);
        Araba.Motor motor = araba.new Motor();
        motor.bilgiVer();
    }
}






## Java Core Array
```sh 

```
---

Java'da **`Array` (dizi)**, aynı veri türünden (primitive ya da nesne) birden fazla öğeyi **tek bir koleksiyon içinde tutmaya yarayan** veri yapısıdır. Diziler sabit uzunluktadır ve bellek üzerinde ardışık konumlarda yer alırlar. Aşağıda sana **temelinden ileri seviyeye kadar** Java Array kavramını detaylı şekilde açıklıyorum.

---

## ✅ 1. Array Nedir?

> Array, aynı türden elemanları bir arada tutan **sabit boyutlu** bir veri yapısıdır. Elemanlara **indeks** numarasıyla ulaşılır. İndeksler `0`’dan başlar.

---

## ✅ 2. Array Tanımlama (Syntax)

```java
// 1. Yöntem
int[] sayilar;

// 2. Yöntem
int sayilar2[];
```

---

## ✅ 3. Array Oluşturma

```java
int[] sayilar = new int[5]; // 5 elemanlı dizi tanımı
```

* Varsayılan değer: `int` için `0`, `boolean` için `false`, `String` için `null`.

---

## ✅ 4. Array'e Değer Atama

```java
sayilar[0] = 10;
sayilar[1] = 20;
sayilar[2] = 30;
sayilar[3] = 40;
sayilar[4] = 50;
```

---

## ✅ 5. Tanımla + Atama (Tek satırda)

```java
String[] renkler = {"Kırmızı", "Mavi", "Yeşil"};
```

---

## ✅ 6. Array Elemanlarına Erişim

```java
System.out.println(renkler[0]);  // Kırmızı
System.out.println(renkler[1]);  // Mavi
```

---

## ✅ 7. Array Elemanlarını Döngüyle Yazdırma

### 🔸 for döngüsü:

```java
for (int i = 0; i < sayilar.length; i++) {
    System.out.println("Eleman " + i + ": " + sayilar[i]);
}
```

### 🔸 for-each döngüsü:

```java
for (String renk : renkler) {
    System.out.println(renk);
}
```

---

## ✅ 8. Array Uzunluğu

```java
int[] notlar = new int[10];
System.out.println(notlar.length); // 10
```

> `length` bir özellik (field)’dir, `()` kullanılmaz.

---

## ✅ 9. Array Sıralama

```java
import java.util.Arrays;

int[] dizi = {3, 7, 1, 9, 2};
Arrays.sort(dizi); // Küçükten büyüğe sıralar
System.out.println(Arrays.toString(dizi)); // [1, 2, 3, 7, 9]
```

---

## ✅ 10. Array Karşılaştırma

```java
int[] dizi1 = {1, 2, 3};
int[] dizi2 = {1, 2, 3};

System.out.println(Arrays.equals(dizi1, dizi2)); // true
```

---

## ✅ 11. Çok Boyutlu Diziler (2D Array)

```java
int[][] tablo = {
    {1, 2, 3},
    {4, 5, 6}
};

System.out.println(tablo[1][2]); // 6
```

### Döngü ile gezmek:

```java
for (int i = 0; i < tablo.length; i++) {
    for (int j = 0; j < tablo[i].length; j++) {
        System.out.print(tablo[i][j] + " ");
    }
    System.out.println();
}
```

---

## ✅ 12. Arrays Sınıfı (java.util.Arrays)

| Metot Adı           | Açıklama                              |
| ------------------- | ------------------------------------- |
| `Arrays.toString()` | Dizi içeriğini yazdırır               |
| `Arrays.sort()`     | Sıralama yapar                        |
| `Arrays.equals()`   | İki diziyi karşılaştırır              |
| `Arrays.copyOf()`   | Dizi kopyalama                        |
| `Arrays.fill()`     | Tüm elemanları sabit değerle doldurur |

### Örnek:

```java
int[] orijinal = {1, 2, 3};
int[] kopya = Arrays.copyOf(orijinal, 5);
System.out.println(Arrays.toString(kopya)); // [1, 2, 3, 0, 0]
```

---

## ✅ 13. Array ile Method Kullanımı

### Dizi parametreli metod:

```java
public static int topla(int[] sayilar) {
    int toplam = 0;
    for (int sayi : sayilar) {
        toplam += sayi;
    }
    return toplam;
}
```

### Kullanımı:

```java
int[] dizi = {3, 5, 7};
System.out.println(topla(dizi)); // 15
```

---

## ✅ 14. Dizi Hataları

### 🔸 `ArrayIndexOutOfBoundsException`

```java
int[] sayilar = {1, 2, 3};
System.out.println(sayilar[5]); // HATA!
```

> Belirtilen indeks, dizinin boyutunu aşarsa bu hata oluşur.

---

## ✅ 15. Dizi vs ArrayList Farkı

| Özellik    | Array              | ArrayList                      |
| ---------- | ------------------ | ------------------------------ |
| Boyut      | Sabit              | Dinamik                        |
| Tip        | Primitive + Object | Sadece Nesne (Wrapper/Generic) |
| Performans | Daha hızlı         | Kolay yönetilebilir            |
| Kullanım   | Daha temel         | Gelişmiş API’lere sahip        |

---

## ✅ 16. Gerçek Hayattan Örnek: Sınıf Not Ortalaması

```java
public class NotHesapla {
    public static void main(String[] args) {
        int[] notlar = {70, 85, 90, 60, 100};
        int toplam = 0;
        for (int n : notlar) toplam += n;
        double ortalama = (double) toplam / notlar.length;
        System.out.println("Ortalama: " + ortalama);
    }
}
```

---

## ✅ 17. String Array Örneği

```java
String[] ogrenciler = {"Ayşe", "Mehmet", "Ali"};
for (String isim : ogrenciler) {
    System.out.println("Hoş geldin: " + isim);
}
```

---

## ✅ Özet

| Özellik                 | Açıklama                            |
| ----------------------- | ----------------------------------- |
| Dizi nedir              | Aynı türden değerleri tutan yapıdır |
| Sabit boyutlu mu        | ✅ Evet                              |
| İndeksleme nasıl        | `0`'dan başlar                      |
| Döngü ile kullanılır mı | ✅ for ve for-each ile               |
| Sıralama ve arama       | `Arrays` sınıfı ile yapılır         |
| Çok boyutlu olabilir mi | ✅ (2D, 3D vs.)                      |
| Bellek avantajı         | Performanslı ama esnek değildir     |

---




## Java Core Array Örnek
```sh 

```
---

Aşağıda, Java'da **küçük ama öğretici bir dizi uygulaması** . Bu örnek, bir sınıftaki öğrencilerin notlarını alır, **ortalamasını bulur**, **en yüksek ve en düşük notu** hesaplar ve **kaç kişinin geçtiğini** raporlar.

---

## ✅ 📘 Uygulama: Not Analiz Sistemi

### 📌 Özellikler:

* Öğrenci notlarını dizi ile tutar
* Ortalama hesaplar
* En yüksek ve en düşük notu bulur
* Geçen ve kalan öğrenci sayısını verir

---

### 🧾 Java Kodu:

```java
import java.util.Scanner;

public class NotAnalizUygulamasi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kaç öğrencinin notu girilecek? ");
        int ogrenciSayisi = scanner.nextInt();

        int[] notlar = new int[ogrenciSayisi];

        // Notları alma
        for (int i = 0; i < ogrenciSayisi; i++) {
            System.out.print((i + 1) + ". öğrencinin notu: ");
            notlar[i] = scanner.nextInt();
        }

        // Ortalama hesaplama
        int toplam = 0;
        int enYuksek = notlar[0];
        int enDusuk = notlar[0];
        int gecenSayisi = 0;

        for (int not : notlar) {
            toplam += not;
            if (not > enYuksek) enYuksek = not;
            if (not < enDusuk) enDusuk = not;
            if (not >= 50) gecenSayisi++;
        }

        double ortalama = (double) toplam / ogrenciSayisi;

        // Sonuçları yazdır
        System.out.println("\n--- SONUÇLAR ---");
        System.out.println("Ortalama: " + ortalama);
        System.out.println("En yüksek not: " + enYuksek);
        System.out.println("En düşük not: " + enDusuk);
        System.out.println("Geçen öğrenci sayısı: " + gecenSayisi);
        System.out.println("Kalan öğrenci sayısı: " + (ogrenciSayisi - gecenSayisi));

        scanner.close();
    }
}
```

---

### 💡 Örnek Çalışma:

```
Kaç öğrencinin notu girilecek? 5
1. öğrencinin notu: 70
2. öğrencinin notu: 40
3. öğrencinin notu: 90
4. öğrencinin notu: 55
5. öğrencinin notu: 30

--- SONUÇLAR ---
Ortalama: 57.0
En yüksek not: 90
En düşük not: 30
Geçen öğrenci sayısı: 3
Kalan öğrenci sayısı: 2
```

---


## Java Core File
```sh 

```
---

Java’da **`File` sınıfı**, `java.io` paketinde yer alır ve **dosya veya klasörlerle çalışmak** için kullanılır. Bu sınıf, dosyanın içeriğini değil, **dosya sistemindeki konumunu ve özelliklerini** temsil eder.

Aşağıda, Java’daki `File` sınıfını **çok detaylı, örnekli ve uygulamalı** olarak anlatıyorum.

---

## ✅ 1. `File` Sınıfı Nedir?

> `java.io.File` sınıfı, dosya veya dizin (klasör) nesnesini temsil eder. Dosya **oluşturma, silme, yeniden adlandırma, kontrol etme** gibi işlemler için kullanılır.

---

## ✅ 2. File Sınıfını Kullanmak İçin

```java
import java.io.File;
```

---

## ✅ 3. File Nesnesi Oluşturma

```java
File dosya = new File("veriler.txt");
File klasor = new File("Belgeler/Klasorum");
```

> Not: `File` nesnesi oluşturmak, **dosyayı gerçekten oluşturmaz**. Sadece dosya yolu referansını temsil eder.

---

## ✅ 4. Dosya Oluşturma

```java
import java.io.File;
import java.io.IOException;

public class DosyaOlustur {
    public static void main(String[] args) {
        File dosya = new File("ornek.txt");

        try {
            if (dosya.createNewFile()) {
                System.out.println("Dosya oluşturuldu: " + dosya.getName());
            } else {
                System.out.println("Dosya zaten mevcut.");
            }
        } catch (IOException e) {
            System.out.println("Hata oluştu.");
            e.printStackTrace();
        }
    }
}
```

---

## ✅ 5. Klasör Oluşturma

```java
File klasor = new File("Belgeler");
if (klasor.mkdir()) {
    System.out.println("Klasör oluşturuldu.");
} else {
    System.out.println("Klasör zaten mevcut veya oluşturulamadı.");
}
```

* `mkdir()` → tek klasör oluşturur
* `mkdirs()` → iç içe klasörler oluşturur

---

## ✅ 6. Dosya Bilgilerini Alma

```java
File dosya = new File("ornek.txt");

if (dosya.exists()) {
    System.out.println("Dosya Adı: " + dosya.getName());
    System.out.println("Yolu: " + dosya.getAbsolutePath());
    System.out.println("Yazılabilir mi?: " + dosya.canWrite());
    System.out.println("Okunabilir mi?: " + dosya.canRead());
    System.out.println("Boyutu (byte): " + dosya.length());
}
```

---

## ✅ 7. Dosya Silme

```java
File dosya = new File("ornek.txt");

if (dosya.delete()) {
    System.out.println("Dosya silindi.");
} else {
    System.out.println("Dosya silinemedi.");
}
```

---

## ✅ 8. Klasör İçeriğini Listeleme

```java
File klasor = new File("Belgeler");

String[] icerik = klasor.list();

if (icerik != null) {
    for (String isim : icerik) {
        System.out.println(isim);
    }
}
```

---

## ✅ 9. Dosya veya Klasör Var mı?

```java
File dosya = new File("ornek.txt");

if (dosya.exists()) {
    System.out.println("Dosya mevcut.");
} else {
    System.out.println("Dosya bulunamadı.");
}
```

---

## ✅ 10. Örnek: Dosya Oluştur + Bilgilerini Göster

```java
import java.io.File;
import java.io.IOException;

public class FileOrnek {
    public static void main(String[] args) {
        try {
            File dosya = new File("deneme.txt");
            if (dosya.createNewFile()) {
                System.out.println("Dosya oluşturuldu: " + dosya.getName());
            }

            System.out.println("Dosya Yolu: " + dosya.getAbsolutePath());
            System.out.println("Okunabilir: " + dosya.canRead());
            System.out.println("Yazılabilir: " + dosya.canWrite());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## ✅ 11. `File` Sınıfında Kullanılabilen Yöntemler

| Metot Adı           | Açıklama                               |
| ------------------- | -------------------------------------- |
| `createNewFile()`   | Dosya oluşturur                        |
| `delete()`          | Dosyayı siler                          |
| `exists()`          | Dosya var mı?                          |
| `getName()`         | Dosya adını döner                      |
| `getAbsolutePath()` | Tam yolu verir                         |
| `length()`          | Dosya boyutu (byte)                    |
| `canRead()`         | Okunabilir mi?                         |
| `canWrite()`        | Yazılabilir mi?                        |
| `isFile()`          | Bu bir dosya mı?                       |
| `isDirectory()`     | Bu bir klasör mü?                      |
| `mkdir()`           | Klasör oluşturur                       |
| `mkdirs()`          | Tüm ara klasörlerle birlikte oluşturur |
| `list()`            | Klasördeki dosyaları listeler          |

---

## ✅ 12. File + FileWriter/Scanner ile Yazma & Okuma

```java
import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class DosyaYazOku {
    public static void main(String[] args) throws Exception {
        // Dosyaya yaz
        FileWriter yazici = new FileWriter("notlar.txt");
        yazici.write("Java öğreniyorum.\nFile sınıfı çok faydalı.");
        yazici.close();

        // Dosyadan oku
        File dosya = new File("notlar.txt");
        Scanner scanner = new Scanner(dosya);
        while (scanner.hasNextLine()) {
            String satir = scanner.nextLine();
            System.out.println(satir);
        }
        scanner.close();
    }
}
```

---

## ✅ 13. Dosya ve Klasör Hiyerarşisi Oluşturma

```java
File projeKlasoru = new File("Proje/Dokumanlar");
if (projeKlasoru.mkdirs()) {
    System.out.println("Proje klasörü başarıyla oluşturuldu.");
}
```

---

## ✅ 14. File ile Ne Yapılmaz?

* Dosya içeriğini satır satır okumak/yazmak doğrudan File ile yapılmaz (onun için: `FileReader`, `FileWriter`, `BufferedReader`, `PrintWriter` gibi sınıflar gerekir)
* `File` sınıfı, **veri işlemekten çok dosya sisteminde gezinmek ve yönetmek** içindir

---

## ✅ Özet

| Özellik                  | Açıklama                                             |
| ------------------------ | ---------------------------------------------------- |
| Sınıf                    | `java.io.File`                                       |
| Temel işlev              | Dosya/klasör kontrolü, oluşturma, silme              |
| İçerik okuma/yazma       | `FileReader`, `FileWriter` veya `Scanner` kullanılır |
| Klasör işlemleri         | `mkdir()`, `list()`, `isDirectory()`                 |
| Güvenlik & hata yönetimi | `IOException` için `try-catch` zorunludur            |

---


## Java Core File Örneği
```sh 

```
---

## Süper! O zaman sana Java’da `File` sınıfını kullanarak küçük ve anlamlı bir uygulama yazayım:

## ✅ 📝 Uygulama: **Mini Metin Editörü**

### 📌 Uygulama Özellikleri:

* Kullanıcıdan bir **dosya adı** ister.
* Kullanıcıdan metin girişi alır (birden fazla satır).
* Girilen metni dosyaya yazar.
* Ardından dosyanın içeriğini ekrana geri okur ve gösterir.

---

### 📂 Klasör yapısı:

```
/metinler/  ← yazılacak tüm dosyalar bu klasöre
```

---

### ✅ Java Kodu:

```java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MiniMetinEditor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // 1. Dosya adı al
            System.out.print("Lütfen bir dosya adı girin (örnek: notlar.txt): ");
            String dosyaAdi = input.nextLine();

            // 2. Dosya klasörünü oluştur
            File klasor = new File("metinler");
            if (!klasor.exists()) {
                klasor.mkdirs();
            }

            File dosya = new File(klasor, dosyaAdi);

            // 3. Metin al
            System.out.println("Dosyaya yazmak istediğiniz metni girin (çıkmak için 'bitti' yazın):");
            FileWriter yazici = new FileWriter(dosya);

            while (true) {
                String satir = input.nextLine();
                if (satir.equalsIgnoreCase("bitti")) break;
                yazici.write(satir + "\n");
            }

            yazici.close();
            System.out.println("✅ Metin dosyaya yazıldı: " + dosya.getAbsolutePath());

            // 4. Dosyayı oku ve göster
            System.out.println("\n📖 Dosya içeriği:");
            Scanner okuyucu = new Scanner(dosya);
            while (okuyucu.hasNextLine()) {
                String satir = okuyucu.nextLine();
                System.out.println(satir);
            }
            okuyucu.close();

        } catch (IOException e) {
            System.out.println("⚠️ Dosya işlemi sırasında hata oluştu: " + e.getMessage());
        }

        input.close();
    }
}
```

---

### 💻 Uygulama Akışı:

```
Lütfen bir dosya adı girin (örnek: notlar.txt): notlar.txt
Dosyaya yazmak istediğiniz metni girin (çıkmak için 'bitti' yazın):
Bugün Java öğrendim.
File sınıfını kavradım.
Çok keyifliydi.
bitti

✅ Metin dosyaya yazıldı: C:\...\metinler\notlar.txt

📖 Dosya içeriği:
Bugün Java öğrendim.
File sınıfını kavradım.
Çok keyifliydi.
```

---

## 🎯 Geliştirme Önerileri:

Bu editörü büyütmek istersen:

* Seçilen dosyayı silme özelliği
* Var olan dosyaya ekleme (`FileWriter(file, true)`)
* Dosya içeriğinde arama
* GUI ile JavaFX sürümü
* Sürüm kaydetme sistemi (versiyonlama)

---



