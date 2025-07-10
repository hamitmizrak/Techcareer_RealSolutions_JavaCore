## Java Core inheritance(Kalıtım)
```sh 

```
---

Java’da **Inheritance** (Türkçesi: **Kalıtım**), nesne yönelimli programlamanın (OOP) temel yapı taşlarından biridir. Bir sınıfın başka bir sınıfın özelliklerini ve davranışlarını **devralmasını** sağlar.

---

## ✅ Java'da Inheritance (Kalıtım) Nedir?

> Inheritance, **ortak özelliklerin ve davranışların** üst (super/base) sınıfta tanımlanıp, alt (sub/derived) sınıflar tarafından **yeniden kullanılmasını ve genişletilmesini** sağlayan bir yapıdır.

---

## 📌 1. Neden Kalıtım Kullanılır?

| Amaç                            | Açıklama                                                         |
| ------------------------------- | ---------------------------------------------------------------- |
| ✅ Kod tekrarını azaltmak        | Ortak kodları üst sınıfta toplarız.                              |
| ✅ Hiyerarşi kurmak              | Sınıflar arasında “is-a” ilişkisi kurarız.                       |
| ✅ Bakımı ve genişletmesi kolay  | Yeni davranışlar kolayca eklenebilir.                            |
| ✅ Polymorphism'e zemin hazırlar | Farklı alt sınıflar, aynı üst sınıf referansıyla kullanılabilir. |

---

## 📌 2. Inheritance Nasıl Kullanılır?

```java
// Üst sınıf (super class / base class)
public class Hayvan {
    public void sesCikar() {
        System.out.println("Hayvan ses çıkarıyor...");
    }
}

// Alt sınıf (sub class / derived class)
public class Kedi extends Hayvan {
    public void miyavla() {
        System.out.println("Kedi miyavlıyor...");
    }
}
```

```java
// Kullanım
Kedi kedi = new Kedi();
kedi.sesCikar();   // Üst sınıftan gelir
kedi.miyavla();    // Alt sınıfa özgü
```

> `extends` anahtar kelimesi ile kalıtım sağlanır.

---

## 📌 3. Super Sınıf – Sub Sınıf İlişkisi

| Terim         | Açıklama                    |
| ------------- | --------------------------- |
| `super class` | Kalıtım veren sınıf         |
| `sub class`   | Kalıtımı alan sınıf         |
| `extends`     | Kalıtım bağlantısını sağlar |

---

## 📌 4. Inheritance ile Constructor (Yapıcı) İlişkisi

* Alt sınıf, üst sınıfın constructor'ını `super(...)` ile çağırabilir.
* Eğer üst sınıfın parametreli constructor'ı varsa, alt sınıfın constructor’ı içinde `super(...)` zorunludur.

### Örnek:

```java
public class Arac {
    private String marka;

    public Arac(String marka) {
        this.marka = marka;
    }

    public void yazdir() {
        System.out.println("Marka: " + marka);
    }
}

public class Araba extends Arac {
    public Araba(String marka) {
        super(marka);  // üst sınıfın constructor'ı çağrılır
    }
}
```

---

## 📌 5. `super` Anahtar Kelimesi

* Üst sınıfın constructor’ını veya metodunu/özelliğini çağırmak için kullanılır.

```java
public class Hayvan {
    public void sesCikar() {
        System.out.println("Hayvan sesi");
    }
}

public class Kopek extends Hayvan {
    @Override
    public void sesCikar() {
        super.sesCikar(); // üst sınıftaki methodu da çağır
        System.out.println("Hav hav!");
    }
}
```

---

## 📌 6. Overriding (Üzerine Yazma)

Alt sınıf, üst sınıftan aldığı bir metodu **kendi ihtiyacına göre yeniden tanımlayabilir**.

```java
public class Hayvan {
    public void sesCikar() {
        System.out.println("Hayvan sesi...");
    }
}

public class Kedi extends Hayvan {
    @Override
    public void sesCikar() {
        System.out.println("Miyav");
    }
}
```

---

## 📌 7. Java'da Kalıtım Kuralları

| Kural                                    | Açıklama                                 |
| ---------------------------------------- | ---------------------------------------- |
| Java **çoklu kalıtımı desteklemez**      | Yani `class A extends B, C` yazılamaz    |
| Sadece **bir sınıftan** kalıtım alabilir | Ancak birçok **interface** uygulanabilir |
| Kalıtımda private alanlar miras alınamaz | Ama `protected` ve `public` alınabilir   |

---

## 📌 8. Protected Erişim Belirteci

* `protected` değişken/method: Aynı paketten veya kalıtım alan sınıflardan erişilebilir.

```java
public class Hayvan {
    protected String tur = "Memeli";
}

public class Kedi extends Hayvan {
    public void yazdir() {
        System.out.println("Türü: " + tur); // Erişim mümkün
    }
}
```

---

## 📌 9. Polymorphism ile Birlikte Kullanımı

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

public class Test {
    public static void main(String[] args) {
        Hayvan h1 = new Kopek();  // Polymorphism
        h1.sesCikar(); // "Hav hav" çağrılır
    }
}
```

---

## 📌 10. Gerçek Dünya Örneği

```java
// Super class
public class Calisan {
    protected String ad;

    public void calis() {
        System.out.println(ad + " çalışıyor.");
    }
}

// Sub class
public class Muhendis extends Calisan {
    public void projeGelistir() {
        System.out.println(ad + " proje geliştiriyor.");
    }
}
```

---

## ✅ Özetle

| Özellik            | Açıklama                                                                 |
| ------------------ | ------------------------------------------------------------------------ |
| **Kalıtım**        | Bir sınıfın başka sınıfın özelliklerini devralmasıdır.                   |
| **Anahtar kelime** | `extends`                                                                |
| **super class**    | Kalıtım veren sınıf                                                      |
| **sub class**      | Kalıtımı alan sınıf                                                      |
| **`super`**        | Üst sınıfın constructor veya methoduna erişim sağlar                     |
| **Overriding**     | Alt sınıf, üst sınıftan gelen metodu kendi ihtiyacına göre yeniden yazar |
| **Çoklu kalıtım**  | Java `class` seviyesinde desteklemez (sadece interface'lerde mümkündür)  |

---
