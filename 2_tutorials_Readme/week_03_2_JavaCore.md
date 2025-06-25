## Java Core Class
```sh 

```
---

Java'da `class` (sınıf), **nesne tabanlı programlamanın (OOP)** temel yapı taşıdır. Gerçek dünyadaki varlıkların (örneğin: araba, öğrenci, banka hesabı) **özelliklerini (fields)** ve **davranışlarını (methods)** modelleyen bir **şablondur**. Java, nesne tabanlı bir dil olduğundan **her şey sınıflar etrafında döner**.

---

## 📦 1. Sınıf Nedir? (Tanım)

> **Sınıf (class)**: Nesnelerin oluşturulmasında kullanılan bir kalıptır (blueprint). Sınıf içerisinde veri üyeleri (değişkenler) ve davranışlar (metotlar) tanımlanır.

---

## 🧱 2. Sınıfın Bileşenleri

```java
public class Araba {

    // Field (özellikler / değişkenler)
    String marka;
    int hiz;

    // Constructor (yapıcı metot)
    public Araba(String marka, int hiz) {
        this.marka = marka;
        this.hiz = hiz;
    }

    // Method (davranış)
    public void hizlan(int miktar) {
        this.hiz += miktar;
    }

    public void bilgiGoster() {
        System.out.println("Marka: " + marka + ", Hız: " + hiz);
    }
}
```

---

## 🎯 3. Neden Sınıf Kullanılır?

| Avantajlar                      | Açıklama                                         |
| ------------------------------- | ------------------------------------------------ |
| ✅ **Modülerlik**                | Kodlar gruplara ayrılır                          |
| ✅ **Yeniden Kullanılabilirlik** | Nesne oluşturularak tekrar tekrar kullanılabilir |
| ✅ **Veri Gizleme**              | `private` ile veri saklanabilir (encapsulation)  |
| ✅ **Abstraction**               | Detaylar gizlenip soyutlama yapılır              |
| ✅ **Polimorfizm & Kalıtım**     | OOP özellikleri desteklenir                      |

---

## 🧠 4. Nesne (Object) Nedir?

Sınıf bir **tasarımdır**, nesne ise onun **çalışan örneğidir (instance)**.

```java
Araba benimArabam = new Araba("Toyota", 120);
benimArabam.hizlan(20);
benimArabam.bilgiGoster();
```

> 👉 `new` anahtar kelimesi ile sınıftan nesne oluşturulur.

---

## 🛠️ 5. Sınıf Türleri

| Tür                     | Açıklama                                                 |
| ----------------------- | -------------------------------------------------------- |
| **Normal class**        | Standart sınıflardır                                     |
| **Abstract class**      | Soyut sınıflar, doğrudan nesne oluşturulamaz             |
| **Final class**         | Alt sınıf türetilemez                                    |
| **Static nested class** | İç içe tanımlanan sınıflar                               |
| **Anonymous class**     | İsimsiz sınıflar (genellikle UI ve event listener’larda) |
| **Generic class**       | Tip güvenli, esnek sınıflar                              |

---

## 🔐 6. Access Modifiers (Erişim Belirleyiciler)

Sınıfların ve üyelerinin erişilebilirliğini sınırlar.

| Modifier    | Erişim Alanı                                  |
| ----------- | --------------------------------------------- |
| `public`    | Her yerden erişilebilir                       |
| `private`   | Sadece tanımlandığı sınıf içinde erişilebilir |
| `protected` | Aynı paket + alt sınıflar                     |
| (default)   | Aynı paket                                    |

---

## ⚙️ 7. Constructor (Yapıcı Metot)

Sınıf adıyla aynı adı taşıyan, geri dönüş tipi olmayan özel metottur. Nesne ilk oluşturulurken çağrılır.

```java
public Araba(String marka, int hiz) {
    this.marka = marka;
    this.hiz = hiz;
}
```

---

## 🔄 8. this Anahtar Kelimesi

Sınıfın kendi alanlarını (field) temsil eder. Parametre ile değişken ismi çakıştığında kullanılır.

```java
this.marka = marka;
```

---

## 💡 9. static Keyword

Sınıfa ait olan (ortak) alanları belirtir. Nesneye değil, doğrudan sınıfa aittir.

```java
public static int sayac = 0;
```

---

## 📊 10. Sınıf Örneği: Öğrenci

```java
public class Ogrenci {
    private String isim;
    private int yas;

    // Constructor
    public Ogrenci(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
    }

    // Getter
    public String getIsim() {
        return isim;
    }

    // Setter
    public void setYas(int yas) {
        this.yas = yas;
    }

    // Bilgi göster
    public void bilgiGoster() {
        System.out.println("Ad: " + isim + ", Yaş: " + yas);
    }
}
```

---

## 🧩 11. Sınıf ile İlgili İleri Seviye Konular

| Konu                           | Açıklama                              |
| ------------------------------ | ------------------------------------- |
| **Inheritance**                | Kalıtım: `extends` kullanılır         |
| **Polymorphism**               | Çok biçimlilik: Override, Overload    |
| **Encapsulation**              | Veri gizleme: private + getter/setter |
| **Abstraction**                | Soyut sınıflar / interface            |
| **Composition vs Inheritance** | Nesne içinde nesne kullanımı          |

---

## 📚 12. Bellek (Memory) Açısından Sınıf

* **Heap**: Nesneler burada tutulur (`new` ile oluşturulan her şey).
* **Stack**: Metot çağrıları ve primitifler geçici olarak burada tutulur.
* **Static alanlar**: Class yüklenince sadece bir kez oluşturulur, `Method Area`'da yer alır.

---

## ✅ Özet

| Özellik       | Açıklama                                     |
| ------------- | -------------------------------------------- |
| `class`       | Nesne oluşturma şablonu                      |
| `object`      | class’tan türetilen örnek                    |
| `field`       | Özellik (veri)                               |
| `method`      | Davranış (aksiyon)                           |
| `constructor` | Yapıcı metot                                 |
| `this`        | Sınıf içindeki kendi değişkenini işaret eder |
| `static`      | Nesneye değil, sınıfa ait eleman             |
| `new`         | Nesne oluşturur                              |

---

## 🎓 Ekstra: Java Class vs Struct (C# veya C++)

| Özellik           | Java `class`                    | C++ `struct`           |
| ----------------- | ------------------------------- | ---------------------- |
| Varsayılan erişim | `default` (package-private)     | `public`               |
| OOP destekleri    | Kalıtım, soyutlama, polimorfizm | Kısıtlı                |
| Veri & Metot      | İkisini de içerir               | Genellikle sadece veri |

---




## Java Core POJO - BEAN 
```sh 

```
---
Java'da `POJO` ve `Java Bean`, özellikle **veri modelleri** yazarken sıkça kullanılan, ama zaman zaman karıştırılan iki önemli sınıf yapısıdır. Her ikisi de birer **Java sınıfıdır**, ama kullanım amaçları ve kuralları farklılık gösterir.

---

## ☕ 1. POJO Nedir?

> **POJO**: "Plain Old Java Object" yani "**Sıradan Java Nesnesi**" anlamına gelir.

### ✅ POJO Tanımı:

POJO, **herhangi bir özel Java kütüphanesi, inheritance (kalıtım), anotasyon, interface veya framework'e bağlı olmayan**, **sadece veri taşıyan** sade bir sınıftır.

### 🔧 POJO Özellikleri:

* Sadece **alanlar (fields)** ve **getter/setter metotları** içerebilir.
* Java'nın temel sınıflarından başka hiçbir şey extend veya implement etmez.
* Anotasyon içermez (özellikle Spring öncesi).
* Genellikle `private` alan + `public` getter/setter ile yazılır ama şart değildir.

### 📦 POJO Örneği:

```java
public class Person {
    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

---

## 🌱 2. JavaBean Nedir?

> **Java Bean**, Java sınıflarının bir türüdür, ama bazı **resmi kurallara** uyması gerekir.

### ✅ Java Bean Özellikleri:

* Alanlar **private** olmalıdır.
* Her alana karşılık gelen **public getter ve setter** metodu olmalıdır.
* **Public parametresiz (default) constructor** içermelidir.
* `Serializable` arayüzünü implement edebilir (genellikle Java EE, Spring, JSP gibi platformlarda gereklidir).

### 💡 Kullanım Yerleri:

* Spring, Hibernate, JSP, JSF, JavaFX, JavaBeans konfigürasyonları
* XML / JSON dönüşümleri (serialization/deserialization)
* Dependency Injection

### 📦 JavaBean Örneği:

```java
import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private double price;

    public Product() {} // default constructor

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
```

---

## 🧬 3. POJO vs Java Bean Karşılaştırması

| Özellik            | POJO                 | JavaBean                             |
| ------------------ | -------------------- | ------------------------------------ |
| Constructor        | Olabilir/Olmayabilir | **Zorunlu: default constructor**     |
| Getter/Setter      | Opsiyonel            | **Zorunlu**                          |
| Serializable       | Gerekli değil        | Genelde implement edilir             |
| Field visibility   | Her tür olabilir     | **private olmalı**                   |
| Framework bağımsız | Evet                 | Genelde Spring, JSP gibi yerlerde    |
| Kullanım amacı     | Genel veri modeli    | Framework’lerde yapılandırma nesnesi |

---

## 📌 4. Sınıfta POJO ile JavaBean Aynı Anda Kullanılır mı?

Evet. Bir sınıf hem POJO’dur hem de JavaBean olabilir. Ancak her JavaBean bir POJO’dur; fakat her POJO bir JavaBean değildir.

---

## 🧠 5. POJO Olmayan Örnek (Yanlış Kullanım)

```java
public class User extends Thread {
    public String name; // field public
}
```

> ❌ Bu sınıf POJO değildir çünkü:

* `Thread` sınıfını extend etmiş
* Field `public` tanımlanmış
* Getter/Setter yok

---

## ✅ 6. Uygulamalı Örnek: POJO vs Bean

### POJO:

```java
public class Address {
    public String city; // POJO: olabilir
}
```

### Java Bean:

```java
public class Address {
    private String city;

    public Address() {}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
```

---

## 🔄 7. Spring Framework ile İlişki

* Spring `@Component`, `@Service`, `@Controller`, `@Repository` gibi bileşenleri aslında **Java Bean** olarak IOC konteynerine dahil eder.
* Spring Boot uygulamasında genellikle POJO sınıflar, **entity/model** olarak kullanılır.
* `@ConfigurationProperties` gibi anotasyonlar genellikle bir `Java Bean` üzerinde çalışır.

---

## 🎓 SONUÇ

| Kavram       | Açıklama                                                          |
| ------------ | ----------------------------------------------------------------- |
| **POJO**     | Sade, framework’ten bağımsız sınıf                                |
| **JavaBean** | Kural setine uyan, özel amaçlı POJO sınıfı                        |
| **class**    | Java’daki her şeyin temel yapısı, POJO ve Bean de birer class'tır |

---





## Java Core Access Modifier
```sh 

```
---

Java'da **Access Modifiers** (erişim belirleyiciler), sınıfların, metotların ve değişkenlerin **erişilebilirliğini** kontrol etmek için kullanılır. Yani, **bir sınıfın ya da alanın nereden erişilebileceğini** belirler.

---

## 🧩 1. Java'daki Erişim Belirleyiciler

| Modifier    | Aynı Sınıf | Aynı Paket | Alt Sınıf (Farklı Paket) | Diğer Paketler |
| ----------- | ---------- | ---------- | ------------------------ | -------------- |
| `public`    | ✅          | ✅          | ✅                        | ✅              |
| `protected` | ✅          | ✅          | ✅                        | ❌              |
| (default)   | ✅          | ✅          | ❌                        | ❌              |
| `private`   | ✅          | ❌          | ❌                        | ❌              |

---

## 🎯 2. Kısaca Açıklamalar

* **`public`**: Her yerden erişilebilir.
* **`protected`**: Sadece aynı paket içinden ve farklı paketteki alt sınıflardan erişilebilir.
* **`default`** (belirtmezsen): Sadece aynı pakette erişilebilir.
* **`private`**: Sadece tanımlandığı sınıf içerisinde erişilebilir.

---

## 🧪 3. Örneklerle Açıklama

### 🗂️ Proje Yapısı

```
com.example.main
 └── Main.java

com.example.model
 └── Person.java

com.example.child
 └── Child.java
```

---

## 📦 Person.java (com.example.model)

```java
package com.example.model;

public class Person {

    public String publicField = "Public";
    protected String protectedField = "Protected";
    String defaultField = "Default"; // default modifier
    private String privateField = "Private";

    public void showAccess() {
        System.out.println("Public: " + publicField);
        System.out.println("Protected: " + protectedField);
        System.out.println("Default: " + defaultField);
        System.out.println("Private: " + privateField);
    }
}
```

---

## 🧒 Child.java (com.example.child)

```java
package com.example.child;

import com.example.model.Person;

public class Child extends Person {
    public void testAccess() {
        System.out.println("From Child:");

        System.out.println(publicField);         // ✅ erişilebilir
        System.out.println(protectedField);      // ✅ erişilebilir (alt sınıf)
        // System.out.println(defaultField);     // ❌ HATA: farklı paket
        // System.out.println(privateField);     // ❌ HATA: sadece Main1 içinde
    }
}
```

---

## 🖥️ Main.java (com.example.main)

```java
package com.example.main;

import com.example.model.Person;
import com.example.child.Child;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.publicField);       // ✅ erişilebilir
        // System.out.println(person.protectedField);  // ❌ HATA
        // System.out.println(person.defaultField);    // ❌ HATA
        // System.out.println(person.privateField);    // ❌ HATA

        System.out.println("----");

        person.showAccess(); // ✅ tüm alanlara kendi sınıfı içinde erişir

        System.out.println("----");

        Child child = new Child();
        child.testAccess(); // ✅ sadece public ve protected'a erişim sağlar
    }
}
```

---

## 📌 4. Access Modifier'lar Nerelerde Kullanılır?

| Yer                  | Kullanılabilir                                     |
| -------------------- | -------------------------------------------------- |
| Sınıf (class)        | `public`, `default`                                |
| Değişken (field)     | Tümü (`public`, `private`, `protected`, `default`) |
| Metot                | Tümü                                               |
| Yapıcı (constructor) | Tümü                                               |
| İç içe sınıflar      | Tümü                                               |

---

## 🔐 5. Erişim Belirleyici Kullanım Örnekleri

### `private` – Encapsulation (veri gizleme)

```java
public class BankAccount {
    private double balance;

    public double getBalance() { return balance; }
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
}
```

### `protected` – Kalıtımda Kullanım

```java
class Hayvan {
    protected void sesCikar() {
        System.out.println("Hayvan sesi");
    }
}

class Kedi extends Hayvan {
    void miyavla() {
        sesCikar(); // erişilebilir
    }
}
```

### `default` – Aynı Paket Erişimi

```java
class PaketIci {
    void yaz() {
        System.out.println("Aynı paket içindeyim");
    }
}
```

---

## ✅ 6. Özet Tablo

| Modifier    | Sınıf Dışı Erişim | Aynı Paket | Alt Sınıf | Kendi Sınıfı |
| ----------- | ----------------- | ---------- | --------- | ------------ |
| `public`    | ✅                 | ✅          | ✅         | ✅            |
| `protected` | ❌                 | ✅          | ✅         | ✅            |
| (default)   | ❌                 | ✅          | ❌         | ✅            |
| `private`   | ❌                 | ❌          | ❌         | ✅            |

---





## Java Core Serileştirme
```sh 

```
---

Java'da **serileştirme (serialization)**, bir nesnenin bellekteki durumunun (alanlarının değerleriyle birlikte) **bayt dizisine (byte stream)** dönüştürülmesi işlemidir. Bu bayt dizisi daha sonra bir dosyaya yazılabilir, ağ üzerinden gönderilebilir veya başka bir sistemde yeniden kullanılabilir hale gelir.

---

## 🧠 1. Serileştirme Nedir?

> **Serialization**: Java nesnelerini bir akış (stream) hâline getirip dosyaya yazmak, veri tabanına kaydetmek veya ağ üzerinden göndermek amacıyla yapılan işlemdir.

> **Deserialization**: Bayt akışından tekrar orijinal nesnenin geri elde edilmesi işlemidir.

---

## 🎯 2. Ne Zaman Kullanılır?

| Kullanım Durumu                                  | Açıklama                                |
| ------------------------------------------------ | --------------------------------------- |
| Dosyaya veri kaydetmek                           | Nesneleri diske yazmak                  |
| Ağ üzerinden nesne göndermek (RMI, Socket, REST) | Java nesnelerini transfer etmek         |
| Cacheleme veya geçici bellek işlemleri           | Nesneleri serialize edip cache'e koymak |
| Nesneleri kalıcı hale getirmek                   | Java nesnesinin durumunu saklamak       |

---

## 🏗️ 3. Java’da Serileştirme Nasıl Yapılır?

### ✅ Gerekli adımlar:

1. Nesne sınıfı `java.io.Serializable` arayüzünü implement etmelidir.
2. `ObjectOutputStream` ile nesne serileştirilir (yazılır).
3. `ObjectInputStream` ile nesne deserialize edilir (okunur).

---

## 🧪 4. Örnek: Serileştirme ve Geri Okuma

### 📦 `Person.java`

```java
import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L; // versiyon kontrolü

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Main1{name='" + name + "', age=" + age + "}";
    }
}
```

### 💾 Serileştirme: `writeObject()`

```java
import java.io.*;

public class SerializeExample {
    public static void main(String[] args) {
        Person person = new Person("Hamit", 35);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
            System.out.println("Nesne serileştirildi.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 📖 Deserialization: `readObject()`

```java
import java.io.*;

public class DeserializeExample {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person person = (Person) ois.readObject();
            System.out.println("Okunan Nesne: " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 📚 5. `serialVersionUID` Nedir?

Her Serializable sınıfa özel bir **kimlik numarasıdır**. Eğer bu ID değişirse, deserialization sırasında hata alınabilir.

```java
private static final long serialVersionUID = 1L;
```

> Versiyon kontrolü sağlar. Özellikle sınıf yapısında değişiklik yapılırsa, aynı nesne geri okunamayabilir.

---

## 🔐 6. `transient` Anahtar Kelimesi

Bir alanın serileştirme dışında bırakılmasını sağlar.

```java
private transient String password; // serileştirilmez
```

---

## 🔁 7. Serileştirme & Kalıtım

* Alt sınıf Serializable ise, üst sınıf da Serializable olmalıdır.
* Üst sınıf Serializable değilse ve parametresiz constructor yoksa hata alınabilir.

---

## 🧩 8. Serileştirme ile İlgili Dikkat Edilecekler

| Madde                                            | Açıklama                       |
| ------------------------------------------------ | ------------------------------ |
| Sınıf Serializable olmalı                        | `implements Serializable`      |
| `serialVersionUID` tanımla                       | Uyumlu sürüm sağlamak için     |
| `transient` ile hariç tut                        | Şifre gibi gizli alanlar       |
| `ObjectOutputStream`, `ObjectInputStream` kullan | Java'nın IO API’si             |
| Sınıf yapısı değişirse uyumsuzluk oluşabilir     | `InvalidClassException` alınır |

---

## 🧠 9. JSON/XML vs Java Serialization

| Özellik              | Java Serialization        | JSON/XML                      |
| -------------------- | ------------------------- | ----------------------------- |
| Format               | Binary (bayt dizisi)      | Text tabanlı                  |
| Okunabilirlik        | İnsan tarafından okunamaz | Okunabilir                    |
| Performans           | Daha hızlı                | Daha yavaş                    |
| Platform bağımsızlık | Sadece Java ile uyumlu    | Platformdan bağımsız          |
| Kullanım alanı       | Java içi işlem            | API, Web servis, veri iletimi |

> ✅ Modern uygulamalarda `Jackson`, `Gson` gibi JSON kütüphaneleri tercih edilir.

---

## 🔧 10. Gerçek Hayatta Kullanımı

* Spring Boot → `@Entity` sınıflarında Serializable önerilir.
* JavaFX → `Controller` sınıfı `transient` tanımlanır.
* Android → `Parcelable` yerine bazen `Serializable` kullanılır.
* Network → RMI, WebSocket veya TCP için nesne gönderiminde

---

## ✅ SONUÇ

| Terim                  | Açıklama                 |
| ---------------------- | ------------------------ |
| **Serialization**      | Nesne → Bayt dizisi      |
| **Deserialization**    | Bayt dizisi → Nesne      |
| **serialVersionUID**   | Versiyon kontrolü        |
| **transient**          | Serileştirilmeyecek alan |
| **ObjectOutputStream** | Yazma (serialize)        |
| **ObjectInputStream**  | Okuma (deserialize)      |

---





## Java Core Serileştirmede (serialVersionUID)
```sh 

```
---

IntelliJ IDEA'da bir sınıf içinde `serialVersionUID` alanını **otomatik olarak oluşturmak** oldukça kolaydır. Bu işlem için IDE'nin size sunduğu "Quick Fix" özelliğinden yararlanabilirsiniz.

---

## ✅ 1. Otomatik `serialVersionUID` Oluşturma Adımları

### 🔹 Yöntem 1: Quick Fix (Alt + Enter)

1. Serializable bir sınıf tanımlayın:

```java
public class Person implements Serializable {
    private String name;
    private int age;
}
```

2. Sınıf adının üzerine gelin veya `Serializable` üzerine tıklayın.
3. **Klavyeden `Alt + Enter`** (Mac: `Option + Enter`) tuşlarına basın.
4. Açılan menüden:
   ✅ **"Add 'serialVersionUID' field"** seçeneğini tıklayın.

👉 IntelliJ IDEA, otomatik olarak şu şekilde bir alan ekleyecektir:

```java
private static final long serialVersionUID = 1234567890123456789L;
```

> Bu sayı IntelliJ tarafından hash bazlı hesaplanır ve eşsizdir.

---

### 🔹 Yöntem 2: Kod Tamamlayıcı (Live Template)

1. Sınıf içinde boş bir satıra gelin.
2. `serial` yazın.
3. `Tab` tuşuna basın (veya `Enter`).

```java
private static final long serialVersionUID = 1L;
```

> Bu daha basit olan `1L` değeridir. İstersen kendin değiştirebilirsin.

---

## 🔧 2. Ayarları Özelleştirme (İsteğe Bağlı)

Eğer IntelliJ IDEA'nın UID üretimini özelleştirmek istersen:

* Menüden: `File > Settings > Editor > Inspections`
* Arama kısmına: `serialVersionUID` yaz
* `Serializable class without serialVersionUID` kontrolünü aktif hâle getir
* **Severity** seviyesini `Warning` olarak ayarla
* Böylece IDEA seni uyarır ve otomatik üretme seçeneğini sunar

---

## 🧪 Ek Bilgi: `serialver` Komut Satırı Aracı (Alternatif)

Eğer elle üretmek istersen:

```bash
serialver com.example.Main1
```

> Bu komut, `serialVersionUID`'yi sınıfın yapısına göre üretir.

---

## ✅ Sonuç

| Yöntem            | Açıklama                                |
| ----------------- | --------------------------------------- |
| `Alt + Enter`     | En hızlı ve otomatik yöntem             |
| `serial + Tab`    | Basit UID ekler (`1L`)                  |
| `serialver` aracı | Class dosyasından UID üretir            |
| IDE ayarları      | Uyarı vermesi için konfigüre edilebilir |

---






## Java Core Serileştirmede (serialVersionUID)
```sh 

```
---

Java'da `serialVersionUID` sadece bir sayıdan ibaret değildir; bu değerin **amaçlı bir şekilde kullanılması**, özellikle büyük projelerde **güvenlik**, **versiyon uyumluluğu** ve **bakım kolaylığı** açısından önemlidir.

---

## 🎯 Öncelikle: `serialVersionUID` Ne İşe Yarar?

`serialVersionUID`, Java'nın `Serializable` arayüzünü kullanan sınıflarda, **serileştirilen nesnelerin sınıf yapısıyla uyumlu olup olmadığını** kontrol eder.

* Eğer sınıfın yapısı değişirse ve UID aynı kalırsa → eski nesneler yeni sınıfla deserialize edilebilir.
* Eğer UID farklıysa → `InvalidClassException` alınır.

---

## 🔢 1. `1L` Kullanmak Ne Anlama Gelir?

```java
private static final long serialVersionUID = 1L;
```

Bu, tamamen **manuel ve sabit** bir versiyon numarasıdır. En basit haliyle "versiyon 1" anlamına gelir.

### ✅ Avantajı:

* Basit, kontrol edilmesi kolay.

### ❌ Dezavantajı:

* Eğer sınıf yapısını değiştirirseniz (örneğin yeni bir alan eklerseniz) ve UID hâlâ `1L` ise, Java bu sınıfın eski haliyle **uyumlu olduğunu varsayar**. Bu da **yanıltıcı olabilir**.

---

## 🔑 2. Rastgele (random veya hashlenmiş) UID kullanmak?

```java
private static final long serialVersionUID = 7526472295622776147L;
```

Bu değer genelde:

* **Otomatik olarak Eclipse veya IntelliJ gibi IDE’ler tarafından üretilir.**
* `serialver` aracı (Java SDK içinde) kullanılarak üretilebilir:

```bash
serialver com.example.MyClass
```

### ✅ Avantajı:

* Eğer sınıf yapısı değişirse, UID’yi güncelleyip, geçmiş serileştirmelerle bilinçli olarak uyumsuz hale getirebilirsiniz.
* Daha kontrollü ve güvenlidir.

### ❌ Dezavantajı:

* Değeri takip etmek zor olabilir.
* Eğer UID’yi her değişiklikte rastgele üretirseniz, aynı sınıfın farklı sürümleri arasında uyumluluk **tamamen kopar**.

---

## 🛡️ 3. Hangisi Daha Güvenli?

| Yöntem                      | Güvenlik ve Sürüm Kontrolü               |
| --------------------------- | ---------------------------------------- |
| `1L` sabiti                 | ❌ Güvenli değil, yanlış uyumluluk sağlar |
| Rastgele `serialVersionUID` | ✅ Daha güvenli, değişim fark edilir      |
| `serialver` ile hesaplanan  | ✅ En iyi uygulama (class hash'e göre)    |

---

## 🧠 4. En İyi Uygulama (Best Practice)

> Sınıfınız değişkenlik gösteriyorsa veya başka uygulamalarda deserialize edilecekse:

✅ **`serialver` kullanarak bir kez UID üretin, sonra elle yönetin.**

```bash
serialver com.example.MyClass
```

Eğer sınıf yapısını değiştiriyorsanız:

* Geriye uyumluluk **korunuyorsa**, UID'yi **değiştirme**.
* Geriye uyumluluk **bozulduysa**, UID'yi **yeni değerle değiştir**.

---

## 🧪 Örnek:

```java
// İlk sürüm
public class Product implements Serializable {
    private static final long serialVersionUID = 23451234L;
    private String name;
}

// Yeni sürüm (alan eklendi)
public class Product implements Serializable {
    private static final long serialVersionUID = 23451234L; // Uyumlu kalmak istiyoruz
    private String name;
    private double price;
}
```

---

## ✅ Sonuç

| Seçenek             | Kullanmalı mı?     | Not                               |
| ------------------- | ------------------ | --------------------------------- |
| `1L`                | 🚫 Tavsiye edilmez | Yetersiz sürüm kontrolü           |
| Sabit, anlamlı sayı | ✅ Kullanılabilir   | Sürüm bilinçli kontrol ediliyorsa |
| `serialver` çıktısı | ✅ En doğru yol     | Sınıf yapısına özel               |

---







## Java Core Generics
```sh 

```
---

Java **Generics**, Java SE 5 ile birlikte gelen ve **tip güvenliğini** sağlayan, **tekrarlı kod yazımını azaltan**, **compile-time (derleme zamanı) hatalarını** daha erken yakalamamızı sağlayan güçlü bir özelliktir.

---

## 🔍 1. Neden Generics'e ihtiyaç duyulur?

Java’da bir veri yapısı (`List`, `Map`, `Set`, vb.) veya sınıf oluşturduğunuzda içine her türden veri konulmasına izin verirseniz, **tip dönüşümleri (casting)** yapmak zorunda kalırsınız. Bu hem güvensizdir hem de hataya açıktır.

### 🎯 Generics’in amacı:

* **Tip güvenliğini** sağlar.
* **Casting** ihtiyacını ortadan kaldırır.
* Kodun **yeniden kullanılabilirliğini** artırır.
* Derleme zamanında **tip hatalarını yakalar**.

---

## 🧠 2. Generics Kullanılmadığında Ne Olur?

```java
List names = new ArrayList();
names.add("Hamit");
names.add(5); // HATA: ama derleme zamanı hatası vermez

String name = (String) names.get(1); // ClassCastException oluşur
```

---

## ✅ 3. Generics Kullanıldığında

```java
List<String> names = new ArrayList<>();
names.add("Hamit");
// names.add(5); // Derleme zamanı hatası verir

String name = names.get(0); // Casting yok, güvenli
```

---

## 🏗️ 4. Generic Sınıf (Generic Class)

```java
public class Box<T> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
```

### Kullanımı:

```java
Box<String> stringBox = new Box<>();
stringBox.setData("Merhaba");
String value = stringBox.getData();

Box<Integer> intBox = new Box<>();
intBox.setData(123);
int number = intBox.getData();
```

---

## 🧰 5. Generic Method (Generic Metot)

```java
public class Utility {
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
}
```

### Kullanımı:

```java
String[] names = {"Ali", "Veli"};
Integer[] numbers = {1, 2, 3};

Utility.printArray(names);
Utility.printArray(numbers);
```

---

## 🔠 6. Generic Sınırlamaları (Bounded Generics)

Belli bir sınıfı ya da interface'i implement eden türlerle sınırlandırmak isterseniz:

```java
public class Calculator<T extends Number> {
    public double square(T num) {
        return num.doubleValue() * num.doubleValue();
    }
}
```

### Kullanımı:

```java
Calculator<Integer> intCalc = new Calculator<>();
System.out.println(intCalc.square(4)); // 16.0
```

---

## 🔄 7. Generic Wildcards (Joker Karakterler: `?`)

### a) `<?>` - Unknown Type (Bilinmeyen tip)

```java
public void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}
```

### b) `<? extends T>` - Upper Bound

```java
public void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num.doubleValue());
    }
}
```

### c) `<? super T>` - Lower Bound

```java
public void addIntegers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```

---

## ⚠️ 8. Generics ile İlgili Sınırlamalar

* Java'da **primitive tipler** (int, double, boolean) doğrudan kullanılamaz (ama wrapper class’lar kullanılabilir).

  ```java
  Box<int> // Geçersiz
  Box<Integer> // Geçerli
  ```
* **Generic array oluşturulamaz:**

  ```java
  List<String>[] list = new List<String>[10]; // HATA
  ```
* **Static alanlar Generic olamaz:**

  ```java
  public class MyClass<T> {
      // static T value; // HATALI
  }
  ```

---

## 🧬 9. PECS Kuralı

> **PECS: Producer Extends, Consumer Super**

* Eğer **data sadece okunacaksa** → `<? extends T>` kullan.
* Eğer **data sadece yazılacaksa** → `<? super T>` kullan.

---

## 🎯 10. Java Koleksiyonları ve Generics

Generics, özellikle `List`, `Set`, `Map`, `Queue` gibi koleksiyonlarda kullanılır:

```java
Map<String, Integer> notlar = new HashMap<>();
notlar.put("Matematik", 90);
int matNot = notlar.get("Matematik");
```

---

## 📘 11. Gerçek Hayatta Kullanım Örneği

```java
public class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void save(T item) {
        items.add(item);
    }

    public T findById(int index) {
        return items.get(index);
    }
}
```

### Kullanımı:

```java
Repository<String> userRepo = new Repository<>();
userRepo.save("admin");
String user = userRepo.findById(0);
```

---

## 🧩 12. Derleyici Seviyesinde Generics

Java derleyicisi, generics’i **type erasure** yöntemiyle işler. Yani generic bilgiler derleme zamanında kontrol edilir ve çalışma zamanında silinir:

```java
List<String> list = new ArrayList<>();
List<Integer> list2 = new ArrayList<>();

System.out.println(list.getClass() == list2.getClass()); // true
```

---

## 🔚 SONUÇ

| Özellik                   | Açıklama                                                  |
| ------------------------- | --------------------------------------------------------- |
| **Tip Güvenliği**         | Yanlış veri tipini compile-time’da engeller               |
| **Kod Tekrarını Azaltır** | Her tür için ayrı sınıf yazma ihtiyacını kaldırır         |
| **Performans**            | Runtime casting yok, daha verimli                         |
| **Hataları Azaltır**      | Kodun okunabilirliğini artırır, test etmeyi kolaylaştırır |

---







## Java Core Collection
```sh 

```
---

Java Core Collection Framework (JCF), Java'nın temel kütüphanelerinde bulunan ve **veri yapıları** ile **veri işlemleri** için kapsamlı bir API setidir. Bu yapı, verilerin **saklanması, sıralanması, erişilmesi ve işlenmesi** için zengin ve güçlü sınıflar sunar.

---

## 🧠 1. Java Collections Nedir?

Java Collections Framework, **collection (koleksiyon)** adı verilen bir grup nesneyi depolamak ve işlemek için geliştirilmiş **arayüzler (interfaces)**, **sınıflar (classes)** ve **algoritmalardan (methods)** oluşur.

---

## 🎯 2. Neden Java Collections Framework?

Önceki sürümlerde (JDK 1.2 öncesi) sadece **Array**, **Vector**, **Hashtable** gibi sınıflar vardı ve esneklik düşüktü. Collection Framework ile birlikte:

* **Standartlaştırılmış** veri yapıları sağlandı.
* Kodun yeniden kullanılabilirliği ve bakım kolaylığı arttı.
* **Generics** ile tip güvenliği geldi.
* **Algoritmalar** (sort, shuffle, search) tanımlandı.

---

## 🧱 3. Java Collection Hiyerarşisi

```
java.util.Collection (interface)
    ├── List (interface)
    │    ├── ArrayList
    │    ├── LinkedList
    │    └── Vector / Stack
    ├── Set (interface)
    │    ├── HashSet
    │    ├── LinkedHashSet
    │    └── TreeSet
    └── Queue (interface)
         ├── PriorityQueue
         └── LinkedList

java.util.Map (interface) → ayrı bir hiyerarşi
    ├── HashMap
    ├── LinkedHashMap
    └── TreeMap
```

---

## 🔍 4. Ana Arayüzler ve Amaçları

| Interface    | Açıklama                                                 |
| ------------ | -------------------------------------------------------- |
| `Collection` | Temel arayüz, alt arayüzler: `List`, `Set`, `Queue`      |
| `List`       | Sıralı, index bazlı ve tekrar eden elemanlara izin verir |
| `Set`        | Benzersiz (unique) elemanlar tutar                       |
| `Queue`      | FIFO yapısı (ilk giren ilk çıkar)                        |
| `Map`        | Anahtar-değer (key-value) çiftleri ile çalışır           |

---

## 🧾 5. List Arayüzü ve Alt Sınıfları

### ✅ `ArrayList`

* Dinamik dizi
* Rastgele erişim hızlıdır (index'e göre)
* Ekleme/Silme orta seviyede performans

```java
List<String> list = new ArrayList<>();
list.add("Ali");
list.add("Veli");
list.get(0); // "Ali"
```

---

### ✅ `LinkedList`

* Bağlı liste
* Ekleme ve silme işlemleri hızlı
* Rastgele erişim yavaştır

```java
List<String> list = new LinkedList<>();
list.add("Ayşe");
list.remove(0);
```

---

### ✅ `Vector` (eski ama thread-safe)

```java
Vector<String> vector = new Vector<>();
vector.add("Mehmet");
```

---

## 🧾 6. Set Arayüzü ve Alt Sınıfları

### ✅ `HashSet`

* Tekrarsız veri
* Sıra garanti edilmez
* `null` kabul eder

```java
Set<String> set = new HashSet<>();
set.add("Ali");
set.add("Ali"); // Eklenmez
```

---

### ✅ `LinkedHashSet`

* Eklenme sırasını korur
* HashSet’e benzer ama sıralıdır

```java
Set<String> set = new LinkedHashSet<>();
set.add("A");
set.add("B");
```

---

### ✅ `TreeSet`

* Doğal sıralı (`Comparable`) veya karşılaştırmalı (`Comparator`)
* `null` kabul etmez

```java
Set<Integer> set = new TreeSet<>();
set.add(10);
set.add(2); // Otomatik sıralı
```

---

## 🧾 7. Queue Arayüzü ve Alt Sınıfları

### ✅ `PriorityQueue`

* Elemanları doğal sıraya göre saklar
* FIFO değil, önceliğe göre çıkarır

```java
Queue<Integer> pq = new PriorityQueue<>();
pq.add(3);
pq.add(1);
System.out.println(pq.poll()); // 1
```

---

### ✅ `LinkedList` (aynı zamanda Queue implement eder)

```java
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.offer("B");
queue.poll(); // A
```

---

## 🧾 8. Map Arayüzü ve Alt Sınıfları

### ✅ `HashMap`

* Anahtarlar unique, değerler tekrar edebilir
* `null` key ve value kabul eder
* Hızlıdır

```java
Map<String, Integer> map = new HashMap<>();
map.put("Ahmet", 90);
map.get("Ahmet"); // 90
```

---

### ✅ `LinkedHashMap`

* Eklenme sırasına göre
* HashMap'e ek olarak sıralıdır

---

### ✅ `TreeMap`

* Anahtarları sıralı tutar
* `null` key kabul etmez

---

## 🧰 9. Collections Sınıfı (java.util.Collections)

* Statik yardımcı metodlar içerir:

    * `Collections.sort(list)`
    * `Collections.reverse(list)`
    * `Collections.shuffle(list)`
    * `Collections.binarySearch(list, value)`
    * `Collections.synchronizedList(list)`

---

## 📚 10. Generics ile Collection Kullanımı

```java
List<String> names = new ArrayList<>();
Map<String, Integer> students = new HashMap<>();
Set<Double> numbers = new TreeSet<>();
```

---

## 🚨 11. Collection vs Collections

| Collection                        | Collections                       |
| --------------------------------- | --------------------------------- |
| Arayüzdür                         | Yardımcı sınıftır (utility class) |
| `List`, `Set`, `Queue` altındadır | Algoritmalar içerir               |
| `java.util.Collection`            | `java.util.Collections`           |

---

## ✅ 12. Örnek: List + Sort + Lambda

```java
List<String> names = Arrays.asList("Zeynep", "Ali", "Mehmet");
Collections.sort(names); // Alfabetik sıralar
names.forEach(System.out::println);
```

---

## 🧠 13. Performans Kıyaslama (ArrayList vs LinkedList vs HashSet)

| Yapı       | Ekleme              | Arama               | Sıralama        | Açıklama             |
| ---------- | ------------------- | ------------------- | --------------- | -------------------- |
| ArrayList  | Hızlı               | Hızlı               | Desteklenir     | Sıralı, index bazlı  |
| LinkedList | Çok hızlı (baş/son) | Yavaş (tüm gezilir) | Desteklenir     | Node bazlı           |
| HashSet    | Çok hızlı           | Hızlı               | Yok             | Tekrarı engeller     |
| TreeSet    | Orta                | Orta                | Otomatik sıralı | `Comparable` gerekir |

---

## 🔚 SONUÇ

Java Collection Framework, yazılım geliştirmede:

* Veri yapısı seçimi
* Performans optimizasyonu
* Tip güvenliği (Generics)
* Algoritmalar ve esneklik açısından vazgeçilmezdir.

---






## Java Core Java-8 Gelen özellikler
```sh 

```
---

Java 8 (Mart 2014), Java programlama dilinde devrim niteliğinde yenilikler getirmiştir. Bu sürüm, özellikle **fonksiyonel programlama** yaklaşımını Java’ya kazandırmış, kodun daha kısa, okunabilir ve modern yazılmasını sağlamıştır.

Aşağıda Java 8 ile gelen tüm önemli yenilikleri **çok detaylı, örnekli ve teknik temelli** biçimde açıklıyorum:

---

## 🚀 1. **Lambda Expressions (Lambda İfadeleri)**

Lambda, anonim (isimsiz) fonksiyonlardır. Java'da fonksiyonları parametre olarak geçebilmek için kullanılır.

### ✅ Söz Dizimi:

```java
(param1, param2) -> ifade
```

### Örnek:

```java
List<String> names = Arrays.asList("Ali", "Veli", "Zeynep");
names.forEach(name -> System.out.println(name));
```

### Avantaj:

* Daha kısa kod
* Fonksiyonel programlama desteği
* Anonymous inner class yerine kullanılır

---

## 🔁 2. **Functional Interfaces (Fonksiyonel Arayüzler)**

> Sadece **bir tane abstract method** içeren arayüzlerdir. Lambda ile çalışmak için gereklidir.

```java
@FunctionalInterface
interface SayHello {
    void greet(String name);
}
```

```java
SayHello hello = (name) -> System.out.println("Merhaba " + name);
hello.greet("Hamit");
```

### Java 8'de gelen bazı hazır functional interface’ler:

| Arayüz          | Açıklama                                     |
| --------------- | -------------------------------------------- |
| `Predicate<T>`  | Boolean döner: `test(T t)`                   |
| `Function<T,R>` | T alır, R döner: `apply(T t)`                |
| `Consumer<T>`   | Bir işlem yapar, değer döndürmez: `accept()` |
| `Supplier<T>`   | Değer üretir: `get()`                        |

---

## 🔥 3. **Stream API**

Java'daki koleksiyonlar üzerinde fonksiyonel ve zincirleme (chained) işlemler yapmaya olanak tanır.

### Akış yapısı: `Collection → Stream → işlem → sonuç`

### Örnek:

```java
List<String> list = Arrays.asList("Ali", "Veli", "Hamit");
list.stream()
    .filter(name -> name.startsWith("A"))
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);
```

### Yaygın Stream metodları:

| Metot       | Açıklama                         |
| ----------- | -------------------------------- |
| `filter()`  | Eleme yapar (Predicate)          |
| `map()`     | Dönüştürme yapar                 |
| `sorted()`  | Sıralama yapar                   |
| `collect()` | Stream → Collection              |
| `reduce()`  | Tüm veriyi indirger (toplam vb.) |

---

## 🧱 4. **Default ve Static Method'lar (Interface içinde)**

Java 8 ile birlikte interface'ler artık gövdesi olan metotlara sahip olabilir.

### Default Method:

```java
interface Vehicle {
    default void start() {
        System.out.println("Araç çalışıyor...");
    }
}
```

### Static Method:

```java
interface MathUtil {
    static int square(int x) {
        return x * x;
    }
}
```

---

## 📦 5. **java.util.Optional**

NullPointerException riskini azaltmak için gelen bir yapıdır. Null değeri sarmalayıp, fonksiyonel olarak işlem yapmamıza olanak tanır.

### Örnek:

```java
Optional<String> name = Optional.of("Hamit");
name.ifPresent(n -> System.out.println(n)); // varsa yaz
```

### Temel metotlar:

* `Optional.of(value)`
* `Optional.ofNullable(value)`
* `Optional.empty()`
* `isPresent()`, `ifPresent()`
* `orElse(default)`, `orElseGet(Supplier)`
* `map()`, `filter()`

---

## 🧠 6. **Method Reference (Metot Referansı)**

Lambda ifadelerinin daha sade hâlidir. `::` operatörü kullanılır.

### Örnek:

```java
names.forEach(System.out::println); // lambda yerine
```

### Türleri:

* `Class::staticMethod`
* `object::instanceMethod`
* `Class::instanceMethod`
* `Class::new` → constructor referansı

---

## 🧪 7. **New Date and Time API (java.time paketi)**

Java 8’den önce `java.util.Date` ve `Calendar` karmaşıktı ve thread-safe değildi. Yeni API, modern, okunabilir ve güvenli bir yapı sundu.

### Temel sınıflar:

| Sınıf                 | Açıklama              |
| --------------------- | --------------------- |
| `LocalDate`           | Yalnızca tarih        |
| `LocalTime`           | Yalnızca saat         |
| `LocalDateTime`       | Tarih + saat          |
| `ZonedDateTime`       | Zaman dilimi destekli |
| `Period` / `Duration` | Tarih/Süre farkları   |
| `DateTimeFormatter`   | Formatlama için       |

### Örnek:

```java
LocalDate today = LocalDate.now();
LocalDate birth = LocalDate.of(1990, Month.MARCH, 10);
Period age = Period.between(birth, today);
System.out.println("Yaş: " + age.getYears());
```

---

## 🧹 8. **Collectors (java.util.stream.Collectors)**

Stream'den toplayıcı işlemler yapmak için kullanılır:

```java
List<String> names = Arrays.asList("Ali", "Veli", "Ali");

Map<String, Long> counts = names.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
```

| Collectors Metodu  | Açıklama                     |
| ------------------ | ---------------------------- |
| `toList()`         | Liste olarak döner           |
| `toSet()`          | Set olarak döner             |
| `joining(",")`     | String birleştirme           |
| `groupingBy()`     | Gruplama işlemi              |
| `partitioningBy()` | Boolean filtreye göre ayırma |
| `counting()`       | Sayı döner                   |

---

## 💬 9. **ForEach (Stream + Lambda)**

```java
list.forEach(System.out::println);
```

---

## 🔄 10. **Parallel Stream**

Çok çekirdekli işlemcilerden faydalanarak veri üzerinde paralel işlemler yapar.

```java
list.parallelStream()
    .filter(...)
    .map(...)
    .forEach(...);
```

> ⚠️ Küçük verilerde faydası azdır, büyük koleksiyonlarda verimlidir.

---

## ✅ Özet Tablo: Java 8 Yenilikleri

| Özellik                  | Açıklama                       |
| ------------------------ | ------------------------------ |
| Lambda                   | Fonksiyonel, kısa kod          |
| Stream API               | Veri akışı ve işlem zinciri    |
| Optional                 | Null güvenliği                 |
| Method Reference         | Kısa ve sade lambda            |
| Functional Interface     | Lambda için zemin              |
| Date and Time API        | Modern ve güvenli tarih        |
| Default/Static Interface | Geliştirilmiş interface yapısı |
| Collectors               | Gruplama ve toplama işlemleri  |
| Parallel Stream          | Paralel veri işleme            |
| ForEach                  | Döngülerin sade hali           |

---

