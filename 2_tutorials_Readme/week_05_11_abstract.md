## Java Core Abstract(Kalıtım)
```sh 

```
---

Java'da `abstract` anahtar kelimesi, hem **sınıflar (class)** hem de **metotlar (method)** için kullanılabilir. Soyutlama (abstraction), nesne yönelimli programlamada (OOP) temel bir ilkedir ve karmaşık sistemlerin sade bir yüzeyle temsil edilmesini sağlar. Java'da bu soyutlama işlemini `abstract class` ve `abstract method` kullanarak yaparız.

---

## ✅ 1. `abstract` Nedir? Genel Tanım

> `abstract`, bir **şablon** tanımlar ama detaylarını alt sınıflara bırakır. Kısacası:
>
> **"Ne yapılacağını söyler, nasıl yapılacağını söylemez."**

---

## 🔑 2. Java'da `abstract` Kullanım Yerleri

| Yapı              | Açıklama                                                      |
| ----------------- | ------------------------------------------------------------- |
| `abstract class`  | Sınıfın tamamlanmamış olduğunu gösterir. Nesne oluşturulamaz. |
| `abstract method` | Alt sınıf tarafından override edilmek zorundadır.             |

---

## 📌 3. `abstract class` Nedir?

* `new` ile nesne **oluşturulamaz.**
* Hem **soyut** (abstract) hem **normal** (somut) metotlar içerebilir.
* Alt sınıflar (`subclass`) bu sınıfı **`extends`** ile kalıtır ve soyut metotları **override etmek zorundadır.**

### Örnek:

```java
public abstract class Sekil {
    // Soyut method
    public abstract void alanHesapla();

    // Normal method
    public void bilgi() {
        System.out.println("Bu bir geometrik şekildir.");
    }
}
```

---

## 📌 4. `abstract method` Nedir?

* **Gövdesizdir**, sadece imzası (signature) yazılır.
* Mutlaka **abstract class** içinde tanımlanabilir.
* Alt sınıf (subclass), bu metodu **override etmek zorundadır.**

### Örnek:

```java
public abstract class Hayvan {
    public abstract void sesCikar(); // alt sınıf zorunlu olarak override eder
}
```

---

## 📌 5. `abstract class` Kullanımı (Gerçek Senaryo)

```java
// Soyut sınıf
public abstract class Calisan {
    private String isim;

    public Calisan(String isim) {
        this.isim = isim;
    }

    public abstract void calis(); // soyut method

    public void bilgi() {
        System.out.println("Çalışan: " + isim);
    }
}

// Alt sınıf
public class Muhendis extends Calisan {
    public Muhendis(String isim) {
        super(isim);
    }

    @Override
    public void calis() {
        System.out.println("Proje geliştiriyor...");
    }
}
```

### Kullanım:

```java
public class Test {
    public static void main(String[] args) {
        Calisan m = new Muhendis("Hamit");
        m.bilgi();
        m.calis();
    }
}
```

---

## 📌 6. `abstract class` ile `interface` Arasındaki Farklar

| Özellik                   | `abstract class`              | `interface`                            |
| ------------------------- | ----------------------------- | -------------------------------------- |
| Nesne oluşturulabilir mi? | ❌ Hayır                       | ❌ Hayır                                |
| Constructor var mı?       | ✅ Evet                        | ❌ Hayır                                |
| Çoklu kalıtım             | ❌ Tek sınıf                   | ✅ Çoklu interface uygulanabilir        |
| Field içerebilir mi?      | ✅ Her tür field               | ✅ Sadece `public static final` (sabit) |
| Method türü               | abstract + somut (`concrete`) | Java 8+: abstract, default, static     |

---

## 📌 7. Hangi Durumlarda `abstract class` Kullanılır?

### Kullanılmalı:

* Ortak **davranışları** (metot) tanımlamak ve kısmen uygulamak istiyorsanız.
* Ortak **verileri** (değişkenler) tanımlayıp bunları alt sınıflarda kullanmak istiyorsanız.
* Uygulama mimarisinde bir **template** oluşturmak istiyorsanız.

### Kullanılmamalı:

* Sadece davranış belirtip uygulama yapmayacaksanız → `interface` tercih edilmeli.

---

## 📌 8. `abstract` Class – Gerçek Hayat Analojisi

### 🚗 Taşıt Örneği:

```java
public abstract class Tasit {
    public abstract void hareketEt(); // ne yapılacağı belli

    public void yakitAl() {
        System.out.println("Yakit alınıyor...");
    }
}
```

```java
public class Araba extends Tasit {
    @Override
    public void hareketEt() {
        System.out.println("Araba tekerlekleriyle ilerliyor...");
    }
}
```

---

## 📌 9. `abstract` ile `final` Aynı Anda Kullanılabilir mi?

> ❌ **Hayır.** `abstract` → override edilmek zorunda,
> `final` → override edilemez.
> Dolayısıyla birlikte kullanılamazlar.

```java
abstract class A {
    // final abstract void x();  // HATA: Anlam çelişkisi
}
```

---

## 📌 10. Derin Örnek: `abstract class` + `template method pattern`

```java
public abstract class YemekTarifi {

    // Şablon metot (final): sıralamayı sabit tutar
    public final void yemekYap() {
        malzemeleriHazirla();
        pisir();
        servisEt();
    }

    public abstract void malzemeleriHazirla();
    public abstract void pisir();

    public void servisEt() {
        System.out.println("Yemek servis edildi.");
    }
}

public class Makarna extends YemekTarifi {
    public void malzemeleriHazirla() {
        System.out.println("Makarna, su, tuz hazırlandı.");
    }

    public void pisir() {
        System.out.println("Makarnalar haşlanıyor.");
    }
}
```

---

### ✅ Özetle

| Başlık            | Açıklama                                                             |
| ----------------- | -------------------------------------------------------------------- |
| `abstract class`  | Ortak yapılar için şablon sınıftır. Nesne oluşturulamaz.             |
| `abstract method` | Alt sınıf tarafından override edilmek zorundadır.                    |
| İçerik türleri    | Abstract + somut metotlar + değişkenler olabilir                     |
| Avantaj           | Kod tekrarını azaltır, mimariyi sadeleştirir                         |
| Kullanım alanı    | Ortak davranışlar, şablonlar, template pattern, servis soyutlamaları |

---
