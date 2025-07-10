## Java Core OOP
```sh 

```
---

Java’da **OOP (Object-Oriented Programming)** yani **Nesne Yönelimli Programlama**, yazılımı nesneler (object) ve sınıflar (class) aracılığıyla modelleme yaklaşımıdır.

OOP, yazılım geliştirmeyi daha **modüler, tekrar kullanılabilir, bakımı kolay** ve **gerçek dünyaya yakın** hale getirmeyi amaçlar.

---

## ✅ Java'da OOP Nedir? (Tanım)

> **Java'da OOP**, programları **sınıf (class)** ve **nesne (object)** temelli olarak tasarlama ve geliştirme yöntemidir. Her şey bir sınıfla başlar ve o sınıftan türetilen nesneler aracılığıyla işlemler gerçekleştirilir.

---

## 🔑 OOP’nin 4 Temel Prensibi

| Prensip                              | Açıklama                                     |
| ------------------------------------ | -------------------------------------------- |
| **1. Encapsulation (Kapsülleme)**    | Verileri ve davranışları bir arada tutmak    |
| **2. Inheritance (Kalıtım)**         | Ortak özelliklerin alt sınıflara aktarılması |
| **3. Polymorphism (Çok Biçimlilik)** | Aynı arayüzle farklı davranışlar üretmek     |
| **4. Abstraction (Soyutlama)**       | Karmaşık detayları gizleyip sade API sunmak  |

---

## 📌 1. Encapsulation (Kapsülleme)

> Nesnenin verilerini (`field`) dış dünyadan gizleyip sadece belirli methodlarla erişim sağlar.

### Örnek:

```java
public class Kisi {
    private String ad;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
```

* `private`: doğrudan erişimi engeller
* `get` / `set`: kontrollü erişim sağlar

---

## 📌 2. Inheritance (Kalıtım)

> Bir sınıfın başka bir sınıfın özelliklerini ve metodlarını miras almasıdır.

### Örnek:

```java
public class Hayvan {
    public void sesCikar() {
        System.out.println("Ses çıkarıyor...");
    }
}

public class Kedi extends Hayvan {
    public void miyavla() {
        System.out.println("Miyav");
    }
}
```

* `Kedi`, `Hayvan` sınıfının tüm özelliklerine sahiptir.
* `extends` ile kalıtım sağlanır.

---

## 📌 3. Polymorphism (Çok Biçimlilik)

> Aynı method adıyla farklı davranışlar sergileyebilme yeteneğidir.

### a) **Overriding (Üzerine Yazma)**

```java
public class Hayvan {
    public void sesCikar() {
        System.out.println("Hayvan sesi");
    }
}

public class Kopek extends Hayvan {
    @Override
    public void sesCikar() {
        System.out.println("Hav hav");
    }
}
```

### b) **Overloading (Aşırı Yükleme)**

```java
public class Hesap {
    public int topla(int a, int b) {
        return a + b;
    }

    public double topla(double a, double b) {
        return a + b;
    }
}
```

---

## 📌 4. Abstraction (Soyutlama)

> Gerçek hayatın karmaşık yönlerini gizleyerek, sadece gerekli detayları ortaya çıkarır. İki yol vardır:

### a) **Abstract class**

```java
public abstract class Sekil {
    public abstract void alanHesapla();
}
```

### b) **Interface**

```java
public interface Ucan {
    void uc();
}
```

---

## 🔧 Java'da OOP Elemanları

| Eleman        | Açıklama                             |
| ------------- | ------------------------------------ |
| `class`       | Nesne şablonudur                     |
| `object`      | Bellekte oluşan gerçek örnektir      |
| `constructor` | Nesne oluştururken çağrılır          |
| `this`        | İçinde bulunulan nesneyi temsil eder |
| `super`       | Üst sınıfı temsil eder               |
| `instanceof`  | Nesnenin tipini kontrol eder         |

---

## ✅ Örnek: Java'da OOP ile Gerçek Dünya Modeli

```java
// Super class
public class Arac {
    private String marka;

    public Arac(String marka) {
        this.marka = marka;
    }

    public void calistir() {
        System.out.println("Araç çalıştı");
    }

    public String getMarka() {
        return marka;
    }
}

// Sub class
public class Araba extends Arac {
    public Araba(String marka) {
        super(marka);
    }

    @Override
    public void calistir() {
        System.out.println(getMarka() + " araba çalıştı");
    }
}
```

---

## OOP'nin Avantajları

| Avantaj                 | Açıklama                                             |
| ----------------------- | ---------------------------------------------------- |
| ✅ Kod tekrarını azaltır | Inheritance sayesinde tekrar kod yazmazsın           |
| ✅ Bakımı kolaylaştırır  | Her nesne kendi sorumluluğuna sahiptir               |
| ✅ Genişletilebilir      | Yeni özellikleri mevcut sistemle entegre etmek kolay |
| ✅ Test edilebilir       | Sınıflar bağımsız test edilebilir                    |

---

### Özetle

> Java'da OOP, yazılımı sınıf ve nesne yapılarıyla modellemektir. Encapsulation, Inheritance, Polymorphism ve Abstraction bu yaklaşımın temelidir. OOP, gerçek dünya problemlerini çözerken **daha anlamlı**, **yapılandırılmış** ve **bakımı kolay** kod yazmamıza olanak sağlar.

---