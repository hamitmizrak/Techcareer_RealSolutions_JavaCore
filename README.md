# Techcareer RealSolutions Java Core
[GitHub]( https://github.com/hamitmizrak/Techcareer_RealSolutions_JavaCore.git )
[JDK](https://www.oracle.com/tr/java/technologies/downloads/#jdk23-windows)
[Intellij Idea Community](https://www.jetbrains.com/idea/download/?section=windows)
[Git](https://git-scm.com/downloads)
[Java Tutorials](https://www.w3schools.com/java/default.asp)


## Git
```sh 
git init
git add .
git commit -m "add message"
git remote origin GİTHUB_URL
git push -u origin master

git clone  https://github.com/hamitmizrak/Techcareer_RealSolutions_JavaCore.git
```
---


## Java Common Rules
```sh 

```
---

### **Java Değişken İsimlendirme Kuralları ve En İyi Uygulamalar**
Java'da değişken isimlendirme kuralları **sözdizimsel (syntax)** kurallar ve **en iyi uygulamalar (best practices)** olarak ikiye ayrılır. Sözdizim kurallarına uyulmazsa derleme hatası alınır, en iyi uygulamalara uyulmaması ise okunabilirliği ve bakımı zorlaştırır.
---

## **1. Java'da Değişken İsimlendirme Kuralları (Syntax Kuralları)**
Java'da değişken isimlendirme aşağıdaki zorunlu kurallara tabidir:

### ✅ **Geçerli Değişken İsimlendirme Kuralları**
1. **Alfabede yer alan harfler (`a-z`, `A-Z`) kullanılabilir.**
2. **Rakamlar (`0-9`) kullanılabilir, ancak değişken ismi rakamla başlayamaz.**
3. **Alt çizgi `_` ve dolar işareti `$` kullanılabilir.**
4. **Java anahtar kelimeleri (reserved words) değişken adı olarak kullanılamaz.**  
   Örneğin, `int`, `class`, `static`, `for`, `if` gibi kelimeler değişken adı olamaz.

### ❌ **Geçersiz Değişken İsimlendirme Örnekleri**
| **Geçersiz Değişken** | **Hata Nedeni** |
|------------------------|-----------------|
| `1number`             | Rakamla başlayamaz |
| `int`                 | Java anahtar kelimesidir |
| `first-name`          | `-` işareti kullanılamaz |
| `@value`              | `@` özel karakteri kullanılamaz |
| `my variable`         | Boşluk içeremez |

---

## **2. Java Değişken İsimlendirme En İyi Uygulamaları (Best Practices)**
Geçerli değişken adları derleme hatası vermez, ancak bazı yazım standartlarına uyulması okunabilirliği artırır. En iyi uygulamalar şunlardır:

### ✅ **1. Camel Case Kullanımı (Önerilir)**
Java'da değişkenler için **camelCase** kullanılır:
- İlk kelime **küçük harfle başlar**, sonraki kelimeler **büyük harfle başlar**.

**Örnek:**
```java
int studentAge;
double accountBalance;
String firstName;
boolean isActive;
```

### ✅ **2. Anlamlı ve Açıklayıcı İsimler Seçin**
- Kısa ve anlamsız değişken adlarından kaçının.
- Değişkenin ne yaptığını veya hangi veriyi sakladığını anlatan isimler kullanın.

❌ Kötü Örnek:
```java
int x;
double y;
```

✅ İyi Örnek:
```java
int studentCount;
double totalSalary;
```

---

### ✅ **3. Değişken Adları Küçük Harfle Başlamalıdır**
- **Java'da değişkenler küçük harfle başlar**, ardından gelen kelimeler büyük harfle devam eder.

❌ Kötü Örnek:
```java
int StudentCount;
```
✅ İyi Örnek:
```java
int studentCount;
```

---

### ✅ **4. Sabit Değerler (Constants) İçin `UPPER_CASE` Kullanılmalı**
- `final` değişkenler **büyük harf** ve **alt çizgi (`_`)** ile yazılmalıdır.

✅ **İyi Örnek (Sabitler için)**:
```java
final double PI = 3.14159;
final int MAX_USERS = 100;
```

---

### ✅ **5. Boşluk ve Özel Karakterler Kullanılmamalıdır**
Değişken isimlerinde **boşluk (space) veya özel karakterler (`@`, `#`, `!`, `-`, `%`)** kullanılamaz.

❌ Geçersiz:
```java
int my variable;
String first-name;
```

✅ Geçerli:
```java
int myVariable;
String firstName;
```

---

### ✅ **6. `_` ve `$` Kullanımı (Genellikle Önerilmez)**
- **`_`** ve **`$`** kullanılabilir, ancak **genellikle değişken isimlerinde kullanılmaz**.
- **Özel durumlar:**
    - `_` genellikle **sabit değerlerde** (`final static`) kullanılır.
    - `$` genellikle **otomatik üretilen kodlarda** kullanılır (örneğin, Java'nın iç mekanizmalarında).

✅ Geçerli:
```java
String _privateVar;  // Genellikle kaçınılır
String $generatedCode;  // Kullanılabilir ama önerilmez
```

---

## **3. Özet**
| **Kural**                           | **Örnek (✅ Doğru)** | **Örnek (❌ Yanlış)** |
|--------------------------------------|---------------------|---------------------|
| **Harf, rakam, `_`, `$` kullanılabilir** | `age`, `userName`, `account_balance` | `user-name`, `1stName`, `my var` |
| **Rakamla başlayamaz**               | `name1`            | `1name` |
| **Anahtar kelimeler kullanılamaz**    | `totalAmount`      | `class`, `int` |
| **Camel case kullanılmalı**          | `studentCount`     | `Studentcount`, `student_count` |
| **Sabit değişkenler büyük harfle yazılmalı** | `MAX_USERS`, `PI`  | `MaxUsers`, `piValue` |
| **Boşluk içeremez**                   | `fullName`         | `full name` |

---

## **4. Örnek Kullanımlar**
### ✅ **İyi Uygulama Örnekleri**
```java
public class NamingExample {
    public static void main(String[] args) {
        int studentCount = 25;
        double accountBalance = 1050.75;
        final double PI = 3.14159;
        boolean isAvailable = true;

        System.out.println("Student Count: " + studentCount);
        System.out.println("Account Balance: $" + accountBalance);
        System.out.println("PI: " + PI);
        System.out.println("Available: " + isAvailable);
    }
}
```
---

### **Sonuç**
- Java değişken isimlendirme kurallarına uymak kodun **okunabilirliğini, bakımını ve standartlarını artırır**.
- **Camel Case** kullanımı önerilir: `myVariable`
- **Sabitler (`final`) büyük harfle yazılır**: `MAX_VALUE`
- **Değişken isimleri anlamlı olmalı**: `userName`, `totalAmount`
- **Java anahtar kelimeleri değişken adı olarak kullanılamaz**.

Bu kurallara uymak, kodunuzu daha **anlaşılır, düzenli ve sürdürülebilir** hale getirecektir. 🚀

## Java Common Rules ()
```sh 
Class isimleri PascalCase göre yazılır
Class isimleri: Fiil olarak kullanmayız (mak-mek)
Class : Java 1 tane public class vardır (inner class hariç)
Class : Java static class yoktur (inner class hariç)

Paket isimleri: küçük harflerle yazılır.
Paket isimleri: fiil olarak kullanmayız (mak-mek)
Paket kısa net bir şekilde olması gerekiyor.

Javada Her biten kelime ; ile bitirmek zorundayız.
```
---


## Java Core Information
```sh 
Java case-sensitive bir dildir. (Küçük büyük harfe duyarlı yüksek seviyede bir dildir.)
```
---


## Maven Nedir ?
```sh 

```
---
### **1. Maven Nedir?**
Maven, Java projelerini oluşturmak, yönetmek ve otomatikleştirmek için kullanılan bir **build automation** (inşa otomasyonu) aracıdır. Apache tarafından geliştirilmiştir ve özellikle Java projelerinde bağımlılık yönetimi, derleme, test etme ve dağıtım süreçlerini kolaylaştırır. Maven, XML tabanlı bir yapılandırma dosyası olan `pom.xml` kullanarak projenin yapılandırmasını ve bağımlılıklarını yönetir.

**Maven’in Sağladıkları:**
- **Bağımlılık Yönetimi:** Projeye eklenmesi gereken kütüphaneleri otomatik olarak indirir.
- **Proje Yapılandırması:** Projeyi standart bir yapıda düzenler.
- **Otomatik Derleme:** Projeyi derler (`mvn compile`).
- **Test Çalıştırma:** JUnit ve TestNG gibi test araçlarıyla testleri çalıştırır (`mvn test`).
- **Paketleme:** Projeyi `jar` veya `war` formatında paketler (`mvn package`).
- **Dağıtım Yönetimi:** Uygulamayı uzak sunuculara veya depolara gönderir (`mvn deploy`).

---

## pom.xml Nedir ?
```sh 

```
### **2. `pom.xml` Nedir?**
`pom.xml` (**Project Object Model**) dosyası, Maven projelerinin merkezi yapılandırma dosyasıdır. Projenin bağımlılıklarını, sürüm bilgilerini, eklentilerini ve yapılandırmalarını içerir.

Örnek bir `pom.xml` dosyası:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>2.7.4</version>
        </dependency>
    </dependencies>
</project>
```
Bu dosya:
- Projenin kimliğini (`groupId`, `artifactId`, `version`)
- Bağımlılıklarını (`dependencies`)
- Yapılandırmalarını içerir.

---

## JDK Nedir ?
```sh 

```
### **3. JDK (Java Development Kit) Nedir?**
**JDK (Java Development Kit)**, Java ile uygulama geliştirmek için kullanılan geliştirme ortamıdır. İçerisinde:
- **JRE (Java Runtime Environment)** (Çalışma zamanı ortamı)
- **JVM (Java Virtual Machine)** (Java Sanal Makinesi)
- **Java Compiler (javac)** (Java derleyicisi)
- **Java Debugger (jdb)** (Hata ayıklayıcı)
- **Java API ve kütüphaneleri** bulunur.

JDK olmadan Java kodu yazılamaz ve çalıştırılamaz.
---

## JRE Nedir ?
```sh 

```
### **4. JRE (Java Runtime Environment) Nedir?**
**JRE (Java Runtime Environment)**, Java uygulamalarını çalıştırmak için gereken ortamdır. İçerisinde:
- **JVM (Java Virtual Machine)** bulunur.
- **Java Kütüphaneleri** içerir.
- **Çalışma zamanı dosyaları** bulunur.

Eğer sadece Java programlarını çalıştırmak istiyorsanız, JDK yerine sadece JRE yükleyebilirsiniz. Ancak, JRE **Java kodu yazmak veya derlemek için yeterli değildir**.
---

### **5. JVM (Java Virtual Machine) Nedir?**
**JVM (Java Virtual Machine)**, Java programlarını çalıştıran sanal bir makinedir. JVM sayesinde Java platform bağımsızdır çünkü Java kodu her işletim sisteminde çalışabilecek **bayt koduna** (`.class` dosyalarına) çevrilir.

JVM’in Görevleri:
- **Bayt kodunu çalıştırır.**
- **Bellek yönetimini yapar (Garbage Collection).**
- **Çoklu iş parçacığını (multithreading) destekler.**
- **Platform bağımsızlığı sağlar.**
---

## Compiler Nedir ?
```sh 

```
### **5. Compiler (Derleyici) Nedir?**
**Compiler (Derleyici)**, insan tarafından yazılan yüksek seviyeli programlama dillerini makine koduna veya bayt koduna dönüştüren bir programdır. Java’da derleyici `javac` olarak adlandırılır.

**Java'da Çalışma Süreci:**
1. **Java kodu yazılır:** `MyClass.java`
2. **Derleyici (`javac`) çalıştırılır:** `javac MyClass.java`
3. **Bayt kodu (`.class` dosyası) oluşturulur:** `MyClass.class`
4. **JVM bayt kodunu çalıştırır.**
---


## Intepreter Nedir ?
```sh 

```
### **7. Interpreter (Yorumlayıcı) Nedir?**
**Interpreter (Yorumlayıcı),** programın satır satır çalıştırılmasını sağlayan bir programdır.
Java’da **JVM içerisinde yer alan yorumlayıcı (interpreter)**, bayt kodlarını satır satır çalıştırır.

**Derleyici (Compiler) vs. Yorumlayıcı (Interpreter):**
- **Derleyici**: Tüm kodu derleyerek tek seferde çalıştırılabilir hale getirir.
- **Yorumlayıcı**: Kodu satır satır çalıştırır.

Java hem **derleyici (`javac`)** hem de **yorumlayıcı (JVM içinde)** kullanır.
---

### **8. Java Nedir?**
Java, **nesne yönelimli (OOP), platform bağımsız, güvenli, çok iş parçacıklı (multithreading) ve taşınabilir** bir programlama dilidir.

- **1995’te Sun Microsystems tarafından geliştirildi.**
- **"Bir kere yaz, her yerde çalıştır" (Write Once, Run Anywhere - WORA)** prensibiyle çalışır.
- **Mobil, web, masaüstü ve büyük ölçekli sistemlerde kullanılır.**
---

### **9. Java’nın Özellikleri Nelerdir?**
- **Platform Bağımsızdır.** (JVM sayesinde her yerde çalışır)
- **Nesne Yönelimli Programlama (OOP) Desteği** vardır.
- **Güvenlidir.** (Bellek yönetimi ve güvenlik mekanizmaları içerir)
- **Çok İş Parçacıklı (Multithreading)** çalışmayı destekler.
- **Otomatik Bellek Yönetimi (Garbage Collection)** yapar.
- **Dağıtık ve Ağ Tabanlı Uygulamaları Destekler.**
---


## 🔧 1. Java'nın Temel Felsefesi
Java, **"Bir kere yaz, her yerde çalıştır" (Write Once, Run Anywhere - WORA)** ilkesine dayanır. Bu prensip, Java kodunun farklı platformlarda çalışabilmesini sağlar. Bunun arkasındaki temel yapı ise **Java Virtual Machine (JVM)**'dir.

---

## 🧠 2. Java Kaynak Kodundan Çalışan Programa Giden Süreç

### A. `.java` ➡ `.class` Derleme Aşaması

1. Geliştirici, Java dilinde bir kaynak dosyası yazar:
   Örnek: `Main.java`

2. `javac` (Java Compiler) kullanılarak bu kaynak kod derlenir:

   ```bash
   javac Main.java
   ```

3. Bu derleyici, `.java` uzantılı dosyayı **bytecode** dediğimiz bir ara koda dönüştürür ve bir `.class` dosyası oluşturur.
   Örnek: `Main.class`

### B. `.class` Dosyasının JVM Tarafından Çalıştırılması

4. JVM (Java Virtual Machine), bu bytecode'u çalıştırır:

   ```bash
   java Main
   ```

5. JVM, bytecode'u **anlık olarak yorumlayarak** (Interpreter) veya **derleyerek** (Just-In-Time - JIT Compilation) çalıştırır.

---

## 🧱 3. Java Sanal Makinesi (JVM) Bileşenleri

### 🧮 1. **Class Loader**

* `.class` dosyalarını yükler.
* Programın ihtiyaç duyduğu tüm sınıfları (yerel ya da dış kaynaklı) belleğe yükler.
* Hiyerarşik olarak çalışır:

    * Bootstrap ClassLoader
    * Extension ClassLoader
    * Application ClassLoader

### 🧾 2. **Bytecode Verifier**

* Bytecode'un kurallara uygunluğunu kontrol eder.
* Bellek ihlali, erişim hatası, güvenlik açığı gibi risklere karşı güvenlik sağlar.

### 🧠 3. **Runtime Data Areas (Bellek Alanları)**

* **Method Area**: Sınıf yapıları, statik veriler burada tutulur.
* **Heap**: Nesnelerin oluşturulduğu yerdir (GC tarafından yönetilir).
* **Stack**: Her thread için ayrı oluşturulan bir yapıdır. Her metod çağrısı bir stack frame oluşturur.
* **Program Counter (PC) Register**: Şu an çalıştırılan bytecode’un adresini tutar.
* **Native Method Stack**: Yerel (C/C++ gibi) kodlar için stack alanı.

### ⚙️ 4. **Execution Engine**

* Bytecode’u çalıştıran motor.
* İki ana bileşeni vardır:

    * **Interpreter**: Bytecode'u satır satır işler (yavaş ama esnektir).
    * **JIT Compiler**: Sık kullanılan kodları makine diline dönüştürür (hızlıdır).
* **Garbage Collector (Çöp Toplayıcı)**: Kullanılmayan nesneleri tespit eder ve belleği temizler.

---

## ⚡ 4. Java’nın Çalışma Zamanı Performans Yöntemleri

* **JIT (Just-In-Time) Compiler**: Kodun sıcak (sık çalışan) bölümlerini analiz eder ve makine diline çevirerek hızlandırır.
* **Garbage Collection**: Çöp toplama işlemi, belleği verimli kullanmak için arka planda çalışan bir algoritma ile yapılır (G1 GC, CMS, ZGC gibi farklı türleri vardır).
* **Multithreading**: JVM her thread için ayrı bir Stack alanı tanımlar, bu da eşzamanlı işlemlerde performans sağlar.

---

## 🧪 5. Java Platform Bağımsızlığı Nasıl Sağlar?

* Java programı, işletim sistemine özgü derlenmez.
* JVM her işletim sistemi için ayrı yazılmıştır.
* Aynı `.class` dosyası, hem Windows hem Linux JVM üzerinde sorunsuzca çalışabilir.

---

## 🔐 6. Java’nın Güvenlik Katmanları

* Bytecode verifier: Zararlı kodu engeller.
* ClassLoader: Erişim kontrolü sağlar.
* Sandbox (özellikle Applet zamanlarında): Sisteme zarar vermesini engeller.
* Security Manager: Özel güvenlik politikaları uygulanabilir.

---

## 🔁 7. Java Çalışma Akışı Özet

```
Kod Yazımı (.java) → Derleyici (javac) → Bytecode (.class)
       ↓
   JVM (Java Virtual Machine)
       ↓
Class Loader → Bytecode Verifier → Execution Engine → Native OS
```

---

## Örnek ile Açıklama

```java
public class Merhaba {
    public static void main(String[] args) {
        System.out.println("Merhaba Java!");
    }
}
```

1. `javac Merhaba.java` ➝ `Merhaba.class`
2. JVM: `java Merhaba`
3. Bytecode: `getstatic`, `ldc`, `invokevirtual` komutları çalıştırılır.
4. `System.out.println` metodu `Execution Engine` tarafından işletilir.
5. Sonuç: Terminalde `"Merhaba Java!"` yazısı görünür.


Java'da **çalışma sıralaması** hem bir Java programı derlendiğinde hem de çalıştırıldığında izlenen adımları ifade eder. Bu sıralama, **koddan yürütmeye kadar olan süreci** içerir.
---



## Primitive Types
```sh 

```
---

# **Java'da Primitive Type (İlkel Veri Tipleri) - Detaylı Açıklama**

Java'da **Primitive Types (İlkel Veri Tipleri)**, temel ve hafif veri tipleridir. Java'nın **hafıza yönetimi**, **hızlı işlem yapabilme** ve **düşük bellek tüketimi** sağlaması için kullanılırlar. Primitive türler, doğrudan bellekte saklanır ve nesne (`Object`) değildirler.

Java’da **8 adet** primitive type vardır:
- **Tam sayı tipleri:** `byte`, `short`, `int`, `long`
- **Ondalıklı sayılar:** `float`, `double`
- **Karakter tipi:** `char`
- **Mantıksal tip:** `boolean`

---

## **1. Java'da Primitive Veri Tiplerinin Genel Özellikleri**
1. **Nesne Değildir:**
    - Primitive değişkenler doğrudan bellekte saklanır.
    - `Integer`, `Double` gibi **Wrapper Class’lar** nesne iken, `int`, `double` gibi **primitive türler** nesne değildir.

2. **Daha Verimlidir:**
    - Nesne yerine doğrudan hafızada saklandıkları için işlemler daha hızlı gerçekleştirilir.
    - Örneğin, `int` yerine `Integer` kullanılırsa **heap bellekte fazladan bir nesne oluşur**.

3. **Varsayılan Değerleri Vardır:**
    - Primitive değişkenler **başlangıç değerleriyle** başlar (örneğin `int` için `0`, `boolean` için `false`).

4. **Değer Tutarlar, Referans Değil:**
    - Primitive türler **değer bazlıdır**, yani doğrudan değişkenin içinde tutulur.
    - `int x = 10;` yazıldığında, `x` değişkeninin içinde `10` değeri saklanır.

---

# **2. Java Primitive Veri Tipleri**
Aşağıda **Java'nın 8 primitive veri tipi** detaylı bir şekilde açıklanmaktadır.

## **A. Tam Sayı Türleri (Integer Types)**
Bu veri tipleri **ondalıklı olmayan** sayıları saklamak için kullanılır.

| **Tip**    | **Boyut** | **Aralık**                 | **Varsayılan Değer** |
|------------|---------|---------------------------|-----------------|
| `byte`     | 1 byte  | -128 to 127               | 0               |
| `short`    | 2 byte  | -32,768 to 32,767         | 0               |
| `int`      | 4 byte  | -2³¹ to (2³¹-1)           | 0               |
| `long`     | 8 byte  | -2⁶³ to (2⁶³-1)           | 0L              |

### **1. `byte` (1 Byte - Küçük Tam Sayılar)**
- **Bellek tasarrufu** sağlamak için kullanılır.
- **Sık kullanılan küçük değerler** için uygundur.
- Örneğin **100 kişilik öğrenci listesi** tutarken kullanışlıdır.

```java
byte smallNumber = 100;
byte minByte = -128;
byte maxByte = 127;
```

### **2. `short` (2 Byte - Orta Büyüklükte Tam Sayılar)**
- `byte`'tan büyük, `int`'ten küçük değerler için kullanılır.
- **Bellek kullanımını optimize etmek** için uygundur.

```java
short shortNumber = 32000;
short minShort = -32768;
short maxShort = 32767;
```

### **3. `int` (4 Byte - Standart Tam Sayılar)**
- Java'da **en çok kullanılan** tam sayı tipidir.
- Varsayılan olarak **tamsayı değerleri `int` türündedir**.

```java
int myAge = 25;
int totalUsers = 500000;
int minInt = -2147483648;
int maxInt = 2147483647;
```

### **4. `long` (8 Byte - Büyük Tam Sayılar)**
- Büyük sayılar için kullanılır.
- Sayının sonuna **`L` harfi** eklenmelidir (`long number = 10000000000L;`).

```java
long population = 7800000000L; // Dünya nüfusu
long distanceToSun = 149600000000L; // Güneşe olan mesafe (km)
```

---

## **B. Ondalıklı Sayılar (Floating Point Types)**
Ondalıklı sayılar için kullanılan **kayan nokta tipleridir**.

| **Tip**    | **Boyut** | **Yaklaşık Hassasiyet** | **Varsayılan Değer** |
|------------|---------|---------------------|-----------------|
| `float`    | 4 byte  | ~7 basamak          | 0.0f            |
| `double`   | 8 byte  | ~15 basamak         | 0.0d            |

### **1. `float` (4 Byte - Daha Az Hassas)**
- Daha az yer kaplar ama **kesinlik kaybı olabilir**.
- Sayının sonuna **`f` eklenmelidir** (`float pi = 3.14f;`).

```java
float pi = 3.14159f;
float gravity = 9.81f;
```

### **2. `double` (8 Byte - Daha Hassas)**
- **Hassas matematiksel işlemler** için kullanılır.
- **Varsayılan ondalıklı veri tipidir.**

```java
double precisePi = 3.141592653589793;
double speedOfLight = 299792458.0;
```

---

## **C. `char` (Karakter Tipi)**
- **Tek bir karakter saklar.**
- **Unicode destekler**, yani her dili ve sembolü içerebilir.

```java
char letter = 'A';
char digit = '5';
char symbol = '@';
char smiley = '\u263A'; // ☺ Unicode karakter
```

---

## **D. `boolean` (Mantıksal Veri Tipi)**
- **İki olası değer alır:** `true` veya `false`
- **Kontrol yapılarında (if, while, for)** yaygın kullanılır.

```java
boolean isJavaFun = true;
boolean isRaining = false;
```

---

# **3. Primitive Türler İçin Varsayılan Değerler**
Java'da bir primitive değişken **başlangıç değeri atanmazsa**, şu varsayılan değerleri alır:

| **Veri Tipi** | **Varsayılan Değer** |
|--------------|-----------------|
| `byte`       | 0               |
| `short`      | 0               |
| `int`        | 0               |
| `long`       | 0L              |
| `float`      | 0.0f            |
| `double`     | 0.0d            |
| `char`       | '\u0000' (Boş karakter) |
| `boolean`    | false           |

---

# **4. Primitive ve Wrapper Class Arasındaki Fark**
Java, primitive türlerin nesne olarak kullanılmasını sağlayan **Wrapper Class’ları** içerir.

| **Primitive Type** | **Wrapper Class** |
|-------------------|-----------------|
| `byte`           | `Byte`           |
| `short`          | `Short`          |
| `int`            | `Integer`        |
| `long`           | `Long`           |
| `float`          | `Float`          |
| `double`         | `Double`         |
| `char`           | `Character`      |
| `boolean`        | `Boolean`        |

Örneğin:
```java
int x = 10;
Integer y = Integer.valueOf(x); // Primitive -> Wrapper (Boxing)
int z = y.intValue(); // Wrapper -> Primitive (Unboxing)
```

---


## Primitive type - Wrapper Type
```sh 

```
---
Java'da **primitive types** (ilkel türler) ve **wrapper types** (sarmalayıcı türler) arasındaki farkları detaylı bir şekilde inceleyelim.

---

## 1. **Primitive Type ve Wrapper Type Nedir?**
- **Primitive Types**: Java'daki en temel veri türleridir. Bellekte doğrudan değerleri saklarlar ve **hafıza açısından daha verimli** çalışırlar.
- **Wrapper Types**: Primitive türlerin nesne (object) olarak kullanılabilmesini sağlayan Java sınıflarıdır. Java'da **koleksiyonlar (List, Set, Map gibi)** nesnelerle çalıştığından, primitive türlerin nesne versiyonları (wrapper types) kullanılır.

---

## 2. **Primitive Types ve Wrapper Types Karşılaştırması**
| **Özellik**            | **Primitive Types**         | **Wrapper Types**          |
|----------------------|------------------------|------------------------|
| **Tanım**            | Doğrudan değeri saklayan türlerdir. | Primitive türleri sarmalayan sınıflardır. |
| **Hafıza Kullanımı**  | Daha az bellek kullanır, daha verimlidir. | Daha fazla bellek tüketir (ekstra nesne oluşturur). |
| **Depolama**         | Stack bellekte saklanır. | Heap bellekte saklanır (Nesne olarak oluşturulduğu için). |
| **Değer Tipi**       | Değer (value) tipindedir. | Referans (object) tipindedir. |
| **Null Olabilir mi?** | **Hayır** (null olamaz). | **Evet** (null olabilir). |
| **Varsayılan Değer**  | int → 0, double → 0.0, boolean → false vb. | null (eğer nesne oluşturulmamışsa). |
| **Nesne Davranışı**  | Nesne değildir, direkt hesaplama yapar. | Nesnedir, metodları vardır. |
| **Koleksiyonlarda Kullanım** | **Doğrudan kullanılamaz** (List<int> gibi bir şey yazamayız). | **Kullanılabilir** (List<Integer> mümkündür). |
| **Dönüştürme İşlemi** | Boxing & Unboxing gerektirir. | Boxing & Unboxing ile primitive türlere dönüşebilir. |

---

## 3. **Primitive Türler ve Karşılık Gelen Wrapper Türler**
| **Primitive Type** | **Wrapper Class** |
|-------------------|-----------------|
| `byte`           | `Byte`          |
| `short`          | `Short`         |
| `int`            | `Integer`       |
| `long`           | `Long`          |
| `float`          | `Float`         |
| `double`         | `Double`        |
| `char`           | `Character`     |
| `boolean`        | `Boolean`       |

---

## 4. **Örneklerle Açıklamalar**

### 4.1 **Primitive Type Kullanımı**
```java
public class PrimitiveExample {
    public static void main(String[] args) {
        int x = 10;
        double y = 20.5;
        boolean isJavaFun = true;

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("Java eğlenceli mi? " + isJavaFun);
    }
}
```
📌 **Burada `x`, `y` ve `isJavaFun` değişkenleri doğrudan bellekte saklanır, nesne oluşturulmaz.**

---

### 4.2 **Wrapper Type Kullanımı**
```java
public class WrapperExample {
    public static void main(String[] args) {
        Integer x = Integer.valueOf(10);
        Double y = Double.valueOf(20.5);
        Boolean isJavaFun = Boolean.TRUE; // veya new Boolean(true) (Eski kullanım)

        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("Java eğlenceli mi? " + isJavaFun);
    }
}
```
📌 **Burada `x`, `y` ve `isJavaFun` nesne olarak saklanır, heap bellekte yer kaplar.**

---

## 5. **Autoboxing ve Unboxing (Primitive ile Wrapper Arasındaki Dönüşüm)**
Java 5 ile gelen **Autoboxing** ve **Unboxing**, primitive ve wrapper türleri arasında otomatik dönüşüm yapılmasını sağlar.

### 5.1 **Autoboxing (Primitive → Wrapper)**
**Primitive türler, otomatik olarak wrapper nesnelere dönüşür.**
```java
public class AutoboxingExample {
    public static void main(String[] args) {
        int primitiveValue = 100;
        Integer wrapperValue = primitiveValue; // Autoboxing

        System.out.println("Wrapper Integer: " + wrapperValue);
    }
}
```
**Bu kod,** `Integer wrapperValue = Integer.valueOf(primitiveValue);` **ile aynıdır.**

---

### 5.2 **Unboxing (Wrapper → Primitive)**
**Wrapper türler, otomatik olarak primitive değerlere dönüşür.**
```java
public class UnboxingExample {
    public static void main(String[] args) {
        Integer wrapperValue = 200;
        int primitiveValue = wrapperValue; // Unboxing

        System.out.println("Primitive int: " + primitiveValue);
    }
}
```
**Bu kod,** `int primitiveValue = wrapperValue.intValue();` **ile aynıdır.**

---

## 6. **Primitive Type vs. Wrapper Type Kullanım Senaryoları**

| **Senaryo** | **Primitive Kullanımı** | **Wrapper Kullanımı** |
|------------|--------------------|--------------------|
| **Hız & Performans Önemli** | ✅ Daha hızlı | ❌ Yavaş |
| **Bellek Verimliliği** | ✅ Az bellek kullanır | ❌ Fazla bellek harcar |
| **Koleksiyonlarda Kullanım (List, Set, Map)** | ❌ Kullanılamaz | ✅ Kullanılabilir |
| **Null Değer Atama** | ❌ Mümkün değil | ✅ Mümkün |
| **Nesne Yönelimli Programlama Gerekirse** | ❌ Uygun değil | ✅ Nesne olarak kullanılabilir |
| **Metodlarla Çalışma** | ❌ Metod içermez | ✅ `Integer.parseInt()`, `Double.valueOf()` gibi metodlar kullanılabilir |

---

## 7. **Ne Zaman Hangi Tür Kullanılmalı?**
- **Performans kritikse ve koleksiyonlarla çalışılmıyorsa → Primitive types kullanılmalı.**
- **Koleksiyonlar (List, Map, Set) veya nesne yönelimli bir yapı gerekiyorsa → Wrapper types kullanılmalı.**
- **Null değerler gerekliliği varsa → Wrapper types tercih edilmeli.**
- **Hesaplamalar yapılıyorsa → Primitive types daha hızlı ve verimli çalışır.**

---

## 8. **Sonuç**
| **Konu** | **Primitive Type** | **Wrapper Type** |
|---------|-----------------|-----------------|
| Hafıza Kullanımı | Az bellek harcar | Daha fazla bellek tüketir |
| Hız | Daha hızlıdır | Daha yavaştır |
| Null Olabilir mi? | ❌ Hayır | ✅ Evet |
| Nesne mi? | ❌ Hayır | ✅ Evet |
| Koleksiyonlarda Kullanılabilir mi? | ❌ Hayır | ✅ Evet |

📌 **Özetle**, performans gereken durumlarda **primitive types** kullanılır, nesne yönelimli işlemler ve koleksiyonlar için **wrapper types** gereklidir.

💡 **Soru:** `List<int> list = new ArrayList<>();` neden hatalıdır?
📌 Çünkü **primitive types koleksiyonlarda kullanılamaz.** `List<Integer> list = new ArrayList<>();` şeklinde **wrapper type** kullanmalıyız.


# **Sonuç**
- **Primitive türler** doğrudan bellekte saklanır, nesne değildir.
- **Daha hızlıdır ve daha az bellek tüketir**.
- **8 temel tür vardır:** `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`.
- **Matematik işlemleri ve kontrollerde en verimli yöntemleri sunar**.

**Primitive türler Java'nın temelini oluşturur ve performans açısından büyük avantaj sağlar! 🚀**

## Wrapper new kullanımı()
```sh 

```
---
Eğer **wrapper sınıflarını** `new` anahtar kelimesiyle oluşturmak istiyorsak, her bir primitive türünün **wrapper sınıfını** kullanarak aşağıdaki gibi yazabiliriz:

```java
public class WrapperExample {
    public static void main(String[] args) {
        Byte wrapperTypeByte = new Byte((byte) 127);
        wrapperTypeByte = null; // Wrapper sınıflar null alabilir
        System.out.println(wrapperTypeByte);

        Short wrapperTypeShort = new Short((short) 32767);
        Integer wrapperTypeInt = new Integer(2147483647);
        Long wrapperTypeLong = new Long(9223372036854775807L);

        Float wrapperTypeFloat = new Float(14.23f);
        Double wrapperTypeDouble = new Double(14.23);

        Boolean wrapperTypeBoolean = new Boolean(true);
        Character wrapperTypeChar = new Character('a');

        System.out.println("Short: " + wrapperTypeShort);
        System.out.println("Integer: " + wrapperTypeInt);
        System.out.println("Long: " + wrapperTypeLong);
        System.out.println("Float: " + wrapperTypeFloat);
        System.out.println("Double: " + wrapperTypeDouble);
        System.out.println("Boolean: " + wrapperTypeBoolean);
        System.out.println("Character: " + wrapperTypeChar);
    }
}
```

### **Önemli Notlar**
1. **Java 9 ve Sonrasında `new` Kullanımı Önerilmez**
    - Java 9'dan itibaren `new Byte()`, `new Integer()` gibi kullanımlar **depreceated (kullanım dışı)** olarak işaretlenmiştir.
    - Bunun yerine **doğrudan atama** yapılmalıdır:
      ```java
      Byte wrapperTypeByte = 127;  // Önerilen kullanım
      ```
    - **Çünkü:** Java **autoboxing** mekanizması sayesinde `new` kullanmadan da bu türleri otomatik olarak wrapper class'lara çevirebilir.

2. **Performans ve Bellek Yönetimi**
    - `new` kullanımı **gereksiz nesne oluşturduğu için heap belleği gereksiz yere doldurur**.
    - Örneğin:
      ```java
      Integer a = 100;  // Autoboxing (Önerilen kullanım)
      Integer b = new Integer(100); // Heap bellekte yeni nesne oluşturur
      ```
    - **`new Integer(100)` kullanırsanız heap’te yeni bir nesne oluşturulur ve gereksiz hafıza tüketilir.**

### **Sonuç**
- **Eğer eski sürümlerle çalışmıyorsanız** ve özel bir nedeniniz yoksa, `new` kullanmadan **autoboxing** yöntemini tercih etmelisiniz.
- **Java 9+ ile çalışıyorsanız**, `new` kullanmaktan kaçının ve doğrudan atamaları kullanın. 🚀

## Stack Memory(Primitive) Heap Memory Memory()
```sh 

```
---
### **Java'da Primitive Stack Hafıza ve Wrapper Heap Hafıza Arasındaki Farklar**

Java'da **primitive veri tipleri** (**int, double, boolean, char, float, long, short, byte**) ve **wrapper sınıfları** (**Integer, Double, Boolean, Character, Float, Long, Short, Byte**) bellek yönetimi açısından farklı yerlerde saklanır. Bu iki veri tipi arasındaki en büyük fark, **stack ve heap bellek yönetimi** ile ilgilidir. Şimdi bu farkları **çok detaylı** şekilde inceleyelim.

---

## **1. Stack ve Heap Hafızasının Tanımı**
Java bellek yönetiminde **iki temel bölge** vardır:
- **Stack (Yığın Hafıza):** Küçük, hızlı ve yönetimi kolaydır. **Primitive veri tipleri burada saklanır.**
- **Heap (Yığın Hafıza):** Daha büyük, daha yavaş ama esnek bir yapıya sahiptir. **Wrapper sınıfları (nesne olarak kullanılan veriler) burada saklanır.**

---

## **2. Stack ve Heap Hafızasının Karşılaştırılması**

| **Özellik**        | **Stack (Yığın Hafıza)** | **Heap (Yığın Hafıza)** |
|--------------------|-----------------------|-----------------------|
| **Saklanan Veri Tipleri** | Primitive değişkenler (`int, double, char`) | Nesneler ve Wrapper sınıfları (`Integer, Double, Character`) |
| **Bellek Yönetimi** | LIFO (Last In First Out – Son giren, ilk çıkar) | Garbage Collector tarafından yönetilir |
| **Hız** | Çok hızlı | Görece daha yavaş |
| **Erişim Süresi** | Stack değişkenlerine erişim **daha hızlıdır** | Heap değişkenlerine erişim **daha yavaştır** |
| **Ömür** | Bir metodun çalışma süresi boyunca var olur | Program çalıştığı sürece var olabilir |
| **Bellek Alanı** | Küçüktür | Daha büyüktür |
| **Çoklu Thread Kullanımı** | Thread'e özeldir (Her thread'in kendi stack’i vardır) | Heap bellek **tüm thread’ler tarafından paylaşılır** |
| **Otomatik Temizleme** | Otomatik temizlenir, Garbage Collector çalışmasına gerek yoktur | Garbage Collector tarafından yönetilir, bellek temizliği gerektiğinde yapılır |

---

## **3. Primitive ve Wrapper Arasındaki Bellek Kullanım Farkı**

### **A) Primitive Veri Tipleri (Stack)**
Primitive veri tipleri **hafızada doğrudan değer olarak saklanır**. Örneğin:

```java
int x = 10;
```
- `x` değişkeni **stack hafızada** saklanır.
- Stack, değişkenleri hızlı bir şekilde yönetir ve **fonksiyon bittiğinde** otomatik olarak temizler.

Stack'teki bellek organizasyonu şu şekildedir:

```
Stack Memory:
+----------------------+
| int x = 10          |
+----------------------+
```

---

### **B) Wrapper Sınıfları (Heap)**
Eğer primitive yerine bir **wrapper class** (nesne) kullanırsak:

```java
Integer y = new Integer(10);
```

Bu durumda, bellek yapısı şu şekilde olur:
- `y` değişkeni **stack içinde bir referans** olarak saklanır.
- `new Integer(10)` ifadesiyle oluşturulan nesne **heap hafızada** saklanır.
- Heap’te saklanan nesneye erişmek için stack’te bir referans (adres) tutulur.

```
Stack Memory:
+----------------------+
| Integer y (ref: 0xA) |
+----------------------+

Heap Memory:
+----------------------+
| [Integer: 10] (0xA) |
+----------------------+
```

Yani, **primitive bir değişken doğrudan değeri içerirken**, wrapper class'lar **referansları saklar ve asıl veri heap içinde tutulur**.

---

## **4. Detaylı Örnek: Stack ve Heap Karşılaştırması**

Şimdi stack ve heap farkını anlamak için aşağıdaki kodu inceleyelim:

```java
public class MemoryTest {
    public static void main(String[] args) {
        int a = 5;
        Integer b = new Integer(5);
        
        modify(a, b);
        
        System.out.println("a: " + a);  // 5
        System.out.println("b: " + b);  // 5
    }
    
    public static void modify(int x, Integer y) {
        x = 10;       // Stack içindeki x değişir
        y = new Integer(10); // Yeni bir nesne oluşturulur (Heap)
    }
}
```

### **Kod Çalışma Mantığı**
1. `int a = 5;`  → **Stack'te doğrudan 5 değeri saklanır.**
2. `Integer b = new Integer(5);`  → **Heap’te yeni bir Integer nesnesi oluşturulur. Stack'te referansı tutulur.**
3. `modify(a, b);` metoduna çağrılırken:
    - `x` → yeni bir stack değişkeni olarak **5 değerini kopyalar** (pass by value).
    - `y` → referans olarak **yeni bir Integer nesnesi alır**.
4. `x = 10;` → **Stack içinde yeni bir değişken oluşturulur ve değer değiştirilir.**
5. `y = new Integer(10);` → **Heap’te yeni bir Integer nesnesi oluşturulur, ancak bu `modify` metodu içinde kalır ve main metodundaki `b` değişkenini etkilemez.**
6. `main` metodu bittiğinde, `a` hâlâ `5`, `b` hâlâ `5` olarak kalır.

Bu durum, **primitive’lerin değiştirilememesi (pass-by-value) ve wrapper nesnelerinin yeni bir nesne oluşturduğunda eski referanslarını kaybetmesi nedeniyle** oluşur.

---

## **5. Wrapper Sınıfları ve Otomatik Boxing / Unboxing**
Java, primitive ve wrapper sınıfları arasında otomatik dönüşüm sağlar. Buna **Autoboxing ve Unboxing** denir.

### **Autoboxing (Primitive → Wrapper)**
```java
int primitiveValue = 100;
Integer wrapperValue = primitiveValue; // Autoboxing
```
- Burada **`primitiveValue`**, otomatik olarak `Integer` nesnesine dönüştürülür ve heap’te saklanır.

### **Unboxing (Wrapper → Primitive)**
```java
Integer wrapperValue = 200;
int primitiveValue = wrapperValue; // Unboxing
```
- `wrapperValue`, heap’ten alınıp stack’te saklanan `primitiveValue` değişkenine atanır.

Bu dönüşümler bazı **performans kayıplarına** neden olabilir, çünkü primitive tiplerde heap erişimi olmadığı için daha hızlı işlem yapılır.

---

## **6. Ne Zaman Primitive, Ne Zaman Wrapper Kullanmalıyız?**
| Kullanım Durumu | Primitive Kullan (Stack) | Wrapper Kullan (Heap) |
|----------------|------------------------|----------------------|
| **Hafıza Verimliliği** | ✅ | ❌ (Heap daha fazla bellek kullanır) |
| **Performans (Hızlı Erişim)** | ✅ | ❌ (Heap erişimi daha yavaş) |
| **Nesne Odaklı Programlama (OOP)** | ❌ | ✅ (Nesne özellikleri ile kullanılabilir) |
| **Nullable Değerler (Null Atama)** | ❌ | ✅ (Primitive null olamaz, wrapper olabilir) |
| **Collection (List, Set, Map)** | ❌ | ✅ (Primitive veri tipleri Collection ile kullanılamaz) |

Eğer **hafıza ve hız önemliyse**, **primitive tipleri** kullanmalıyız.  
Eğer **nesne tabanlı programlama, null değeri saklama veya koleksiyonlar (List, Set, Map) ile çalışma gerekiyorsa**, **wrapper sınıfları** kullanmalıyız.

---

## **Sonuç**
- **Primitive değişkenler stack hafızada tutulur, doğrudan değeri içerir ve daha hızlıdır.**
- **Wrapper sınıfları heap hafızada saklanır, referans üzerinden erişilir ve daha fazla bellek kullanır.**
- **Otomatik Boxing/Unboxing sayesinde dönüşümler mümkündür, ancak performansa dikkat edilmelidir.**

Bu bilgiler doğrultusunda, projenin gereksinimlerine göre en uygun bellek kullanım stratejisini belirlemek gerekir. 🚀

## Wrapper new kullanımı
```sh 
Short wrapperTypeShort = new Short((short) 32767); 
bununla Short wrapperTypeShort 2=32767 arasındaki far nedir ?
```
---

Java'da aşağıdaki iki satır arasındaki farkı inceleyelim:

```java
Short wrapperTypeShort1 = new Short((short) 32767); // 1. Yöntem (Explicit Object Creation - new kullanımı)
Short wrapperTypeShort2 = 32767; // 2. Yöntem (Autoboxing)
```

Bu iki yaklaşımın arasındaki temel farklar şunlardır:

---

## **1. `new Short((short) 32767)` Kullanımı (Heap Bellekte Yeni Nesne Oluşturur)**
```java
Short wrapperTypeShort1 = new Short((short) 32767);
```
- `new` anahtar kelimesi kullanıldığı için **her çağrıldığında yeni bir nesne oluşturulur**.
- **Heap bellekte ayrı bir nesne** oluşturılır.
- **Garbage Collector (GC)** tarafından temizlenmesi gerekir.
- **Bellek tüketimi ve performans açısından dezavantajlıdır.**
- **`==` operatörü ile karşılaştırıldığında farklı nesneler olduğu için false dönebilir.**
- Java 9 ve sonraki sürümlerde bu yöntem **depreceated (kullanım dışı)** hale gelmiştir.

---

## **2. `Short wrapperTypeShort2 = 32767;` Kullanımı (Autoboxing - Cached Object Kullanımı)**
```java
Short wrapperTypeShort2 = 32767;
```
- **Autoboxing** sayesinde primitive `short` değeri otomatik olarak `Short` nesnesine dönüştürülür.
- **Java'nın Integer ve Short için cache mekanizmasını kullanır.**
- Küçük sayı aralıklarında (`-128` ile `127` arasında) **önbellekten (cache) alınan nesneleri kullanabilir.**
- **Daha performanslıdır**, çünkü her seferinde yeni bir nesne oluşturmaz.

---

## **Farklılıkların Kanıtı: Karşılaştırma Testi**
Aşağıdaki kodu çalıştırarak farkı gözlemleyebiliriz:

```java
public class ShortComparison {
    public static void main(String[] args) {
        Short wrapperTypeShort1 = new Short((short) 127);
        Short wrapperTypeShort2 = 127; // Autoboxing
        
        Short wrapperTypeShort3 = new Short((short) 127);
        Short wrapperTypeShort4 = 127; // Autoboxing
        
        System.out.println(wrapperTypeShort1 == wrapperTypeShort3); // false (Heap'te farklı nesneler)
        System.out.println(wrapperTypeShort2 == wrapperTypeShort4); // true (Cache mekanizması sayesinde aynı nesne)
        
        Short wrapperTypeShort5 = 32767;
        Short wrapperTypeShort6 = 32767;

        System.out.println(wrapperTypeShort5 == wrapperTypeShort6); // false (Çünkü cache dışında)
    }
}
```

---

## **Sonuçlar**
1. **Eğer `new` kullanırsanız**, heap bellekte **yeni bir nesne** oluşur ve `==` operatörü farklı nesneler döndürdüğü için `false` olur.
2. **Eğer `Short wrapperTypeShort2 = 32767;` şeklinde yazarsanız**, Java **autoboxing kullanır**.
3. **Java `-128` ile `127` arasındaki değerleri cache olarak tuttuğu için** bu aralıkta `==` karşılaştırması true dönebilir. Ancak `32767` gibi büyük değerler cache dışında olduğu için farklı nesneler oluşturulur.

---

## **Hangi Kullanımı Tercih Etmeliyiz?**
✔ **Performans açısından `Short wrapperTypeShort = 32767;` (Autoboxing) tercih edilmelidir.**  
❌ **`new Short((short) 32767)` kullanımı gereksiz bellek tüketimine neden olur ve önerilmez.**

Bu yüzden **`new` ile nesne oluşturmaktan kaçınılmalı ve autoboxing kullanımı tercih edilmelidir.** 🚀

## Java Life-Cycles
```sh 

```
---
### **Java'da Compiler mı Önce, Interpreter mı?**
Java programlarının çalışma süreci **hem compiler (derleyici) hem de interpreter (yorumlayıcı)** içerir, ancak **önce compiler çalışır, sonra interpreter devreye girer**.

1. **Compiler (Derleyici) İlk Çalışır:**
    - Java kaynak kodu (`.java` dosyaları) **Javac (Java Compiler)** tarafından **Bytecode**’a (`.class` dosyaları) dönüştürülür.
    - Bytecode **işletim sistemine bağımsızdır**, yani her ortamda çalışabilir.

2. **Interpreter (Yorumlayıcı) Sonra Çalışır:**
    - **Java Virtual Machine (JVM)**, Bytecode’u alır ve **Just-In-Time (JIT) Compiler** ile çalıştırılabilir makine koduna dönüştürür.
    - JVM, Bytecode'u **satır satır yorumlar ve çalıştırır**.

### **Java Programının Life-Cycle (Yaşam Döngüsü)**
Java'daki bir programın baştan sona yaşam döngüsünü adım adım açıklayalım:

---

## **1. Yazılım Aşaması (Source Code - `.java` Dosyası)**
Geliştirici, **Java kaynak kodunu** (`.java` dosyalarını) yazar.  
Örneğin:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

---

## **2. Compilation (Derleme) Aşaması**
Java **compiler** (`javac`), kaynak kodunu **Bytecode**’a çevirir.

### **Bu aşamada şunlar olur:**
- **Syntax kontrolü yapılır:** Derleyici (`javac`), kodun sözdizimi hatalarını kontrol eder.
- **Optimizasyon yapılır:** Kod en verimli hale getirilir.
- **Bytecode üretilir:** **Makineye bağımsız** `.class` dosyası oluşturulur.

### **Kompilasyon (Derleme) Komutu:**
```sh
javac HelloWorld.java
```

Bu komut sonucunda, aşağıdaki dosya oluşur:

```
HelloWorld.class
```

Bu `.class` dosyası **Java Bytecode** içerir.

---

## **3. ClassLoader Aşaması**
Java **ClassLoader**, `.class` dosyalarını JVM’ye yükler.

- **Bootstrap ClassLoader:** Java’nın temel sınıflarını (`java.lang.*`) yükler.
- **Extensions ClassLoader:** Ekstra kütüphaneleri (`lib/ext` dizinindekileri) yükler.
- **Application ClassLoader:** Kullanıcının kendi yazdığı sınıfları yükler.

---

## **4. Bytecode Verification (Bytecode Doğrulama)**
- **JVM, Bytecode’un güvenliğini kontrol eder.**
- **Hatalı veya zararlı kodların çalışmasını önler.**
- **Bellek aşımı veya yasadışı bellek erişimlerini engeller.**

---

## **5. Interpreter (Yorumlayıcı) Aşaması**
- **Java Interpreter**, Bytecode’u **satır satır okur ve çalıştırır**.
- Ancak, **sürekli yorumlama yavaş olabilir**, bu yüzden **JIT (Just-In-Time) Compiler** devreye girer.

---

## **6. Just-In-Time (JIT) Compiler Aşaması**
- JIT Compiler, **tekrar eden kodları alır ve doğrudan makine koduna çevirir**.
- **JVM’nin performansını artırır**, çünkü aynı kodun sürekli yorumlanmasını önler.

---

## **7. Runtime (Çalışma Zamanı)**
- **Garbage Collector (GC):** Kullanılmayan nesneleri bellekten temizler.
- **Thread Management:** Çoklu işlemler arasında zamanlamayı yönetir.
- **Exception Handling:** Çalışma sırasında oluşan hataları yakalar.

---

## **8. Programın Çıkışı**
Eğer her şey doğru giderse, programın çıktısı ekrana yazdırılır:

```sh
Hello, World!
```

---

### **Genel Özet: Java Çalışma Döngüsü**
1. **Source Code (`.java`) yazılır.**
2. **Java Compiler (`javac`) kodu Bytecode (`.class`) haline getirir.**
3. **ClassLoader**, `.class` dosyasını JVM’ye yükler.
4. **Bytecode Verification** aşaması güvenlik kontrolü yapar.
5. **Interpreter**, Bytecode’u **satır satır yorumlar** ve çalıştırır.
6. **JIT Compiler**, sık kullanılan kodları **makine koduna** çevirir (performans artırır).
7. **Garbage Collector**, kullanılmayan bellekleri temizler.
8. **Program sonucu ekrana yazdırılır.**

---

### **Compiler vs. Interpreter: Hangisi Önce?**
✅ **Önce Compiler (`javac`) çalışır → Sonra Interpreter (`JVM`) çalışır.**  
🚀 **Sonuç:** Java hem **compiled** (derlenen) hem de **interpreted** (yorumlanan) bir dildir.


# **Java Wrapper Type Nedir? – Detaylı Açıklama**

## **1. Wrapper Type (Sarmalayıcı Tür) Nedir?**
Java'da **Wrapper Type**, **primitive type (ilkel veri türleri)** ile çalışırken nesneye (Object) ihtiyaç duyduğumuz durumlarda kullanılan **sarmalayıcı (wrapper) sınıflardır**.

### **Neden Wrapper Type Kullanılır?**
Java’daki **primitive veri türleri (`int`, `double`, `boolean` vb.) nesne değildir.** Ancak, Java’da birçok yapı (Koleksiyonlar `List`, `Set`, `Map` vb.) **nesnelerle çalışır**. Bu nedenle **primitive türleri nesnelere dönüştürmek için** Wrapper Type kullanılır.

**Örnek:**
```java
int x = 10;          // Primitive type
Integer y = 10;      // Wrapper type (Nesne)
```
Burada:
- `x` bir **primitive** int türüdür.
- `y` ise **Integer sınıfından bir nesnedir**.

---

## **2. Primitive Type ve Wrapper Type Karşılaştırması**
| **Primitive Type** | **Karşılık Gelen Wrapper Type** |
|-------------------|--------------------------------|
| `byte`           | `Byte`                         |
| `short`          | `Short`                        |
| `int`            | `Integer`                      |
| `long`           | `Long`                         |
| `float`          | `Float`                        |
| `double`         | `Double`                       |
| `char`           | `Character`                    |
| `boolean`        | `Boolean`                      |

💡 **Wrapper sınıflar, primitive türlerin büyük harfle başlayan ve nesne olarak kullanılabilen versiyonlarıdır.**

---

## **3. Wrapper Type Kullanımı**
Wrapper sınıfları genellikle **koleksiyonlarla çalışma, null değer atama, veri türleri arasında dönüşüm yapma** gibi işlemler için kullanılır.

### **Örnek Kullanım:**
```java
import java.util.ArrayList;
import java.util.List;

public class WrapperExample {
    public static void main(String[] args) {
        List<Integer> sayilar = new ArrayList<>();
        sayilar.add(10);  // int → Integer (Autoboxing)
        sayilar.add(20);
        System.out.println(sayilar); // [10, 20]
    }
}
```
📌 **List<int> kullanılamaz!** Java Koleksiyonları nesnelerle çalıştığından, **List<Integer>** kullanmalıyız.

---

## **4. Autoboxing ve Unboxing**
Java 5 ile gelen **Autoboxing ve Unboxing**, primitive türler ile Wrapper türler arasında **otomatik dönüşüm sağlar**.

### **4.1. Autoboxing (Primitive → Wrapper)**
Java, **primitive türleri otomatik olarak nesneye çevirir**.

```java
public class AutoboxingExample {
    public static void main(String[] args) {
        int primitiveValue = 100;
        Integer wrapperValue = primitiveValue; // Autoboxing (int → Integer)

        System.out.println(wrapperValue); // 100
    }
}
```
**Arka planda şuna dönüşür:**
```java
Integer wrapperValue = Integer.valueOf(primitiveValue);
```

---

### **4.2. Unboxing (Wrapper → Primitive)**
Wrapper türleri, **otomatik olarak primitive türlerine dönüştürülür**.

```java
public class UnboxingExample {
    public static void main(String[] args) {
        Integer wrapperValue = 200;
        int primitiveValue = wrapperValue; // Unboxing (Integer → int)

        System.out.println(primitiveValue); // 200
    }
}
```
**Arka planda şuna dönüşür:**
```java
int primitiveValue = wrapperValue.intValue();
```

---

## **5. Wrapper Type Metotları**
Wrapper sınıfları, **primitive türlerde olmayan bazı metotlara sahiptir**.

### **5.1. `valueOf()` – Primitive’den Wrapper’a Dönüştürme**
```java
Integer intObj = Integer.valueOf(10);
Double doubleObj = Double.valueOf(5.5);
Boolean boolObj = Boolean.valueOf(true);

System.out.println(intObj);   // 10
System.out.println(doubleObj); // 5.5
System.out.println(boolObj);  // true
```

---

### **5.2. `xxxValue()` – Wrapper’dan Primitive’e Dönüştürme**
```java
Integer intObj = Integer.valueOf(100);
int primitiveInt = intObj.intValue(); // Wrapper → Primitive

Double doubleObj = Double.valueOf(55.5);
double primitiveDouble = doubleObj.doubleValue(); // Wrapper → Primitive

System.out.println(primitiveInt);  // 100
System.out.println(primitiveDouble); // 55.5
```

---

### **5.3. `parseXXX()` – String’den Primitive’e Dönüştürme**
```java
int sayi = Integer.parseInt("123");
double ondalik = Double.parseDouble("12.34");
boolean dogruMu = Boolean.parseBoolean("true");

System.out.println(sayi);      // 123
System.out.println(ondalik);   // 12.34
System.out.println(dogruMu);   // true
```
📌 **Eğer String geçersizse `NumberFormatException` hatası alınır!**

---

### **5.4. `toString()` – Primitive’den String’e Dönüştürme**
```java
int sayi = 456;
String str = Integer.toString(sayi);
System.out.println(str); // "456"
```

Aynı işlem `String.valueOf()` ile de yapılabilir:
```java
String str2 = String.valueOf(sayi);
System.out.println(str2); // "456"
```

---

## **6. Wrapper Type Kullanım Senaryoları**
| **Senaryo** | **Primitive Kullanımı** | **Wrapper Kullanımı** |
|------------|--------------------|--------------------|
| **Performans & Bellek** | ✅ Daha hızlı, az bellek kullanır. | ❌ Daha fazla bellek kullanır. |
| **Koleksiyonlarla Kullanım** | ❌ Kullanılamaz. (`List<int>` hata verir) | ✅ Kullanılabilir. (`List<Integer>`) |
| **Null Değer Atama** | ❌ Mümkün değil. | ✅ Mümkün (`Integer x = null;`) |
| **Metot Kullanımı** | ❌ Metotları yoktur. | ✅ `valueOf()`, `parseInt()` gibi metotlar içerir. |
| **Generics (Jenerik Türler)** | ❌ Kullanılamaz (`T extends int` olmaz). | ✅ Kullanılabilir (`T extends Number`). |

---

## **7. Ne Zaman Hangi Tür Kullanılmalı?**
- **Performans ve bellek önemliyse → `primitive type` kullanın.**
- **Koleksiyonlar ve nesne yönelimli programlama gerekiyorsa → `wrapper type` kullanın.**
- **Null değeri gerekliyse → `wrapper type` kullanın.**
- **Matematiksel hesaplamalar için → `primitive type` daha hızlıdır.**

---

## **8. Özet**
| **Özellik** | **Primitive Type** | **Wrapper Type** |
|------------|----------------|----------------|
| **Bellek Kullanımı** | Az bellek tüketir. | Daha fazla bellek tüketir. |
| **Hız** | Daha hızlıdır. | Daha yavaştır. |
| **Null Değer** | ❌ Null olamaz. | ✅ Null olabilir. |
| **Nesne mi?** | ❌ Hayır. | ✅ Evet. |
| **Metotları Var mı?** | ❌ Hayır. | ✅ `parseInt()`, `valueOf()` gibi metotları vardır. |
| **Koleksiyonlarla Kullanılabilir mi?** | ❌ Hayır. | ✅ Evet. |

📌 **Özetle:** **Wrapper Type**, nesne yönelimli programlama ve koleksiyonlarla çalışırken kullanılır. Ancak, **performans ve bellek yönetimi açısından primitive type daha avantajlıdır**.

💡 **Soru:** `List<int> list = new ArrayList<>();` neden hata verir?
📌 **Cevap:** Java koleksiyonları nesne tutar. `int` bir nesne değildir, bu yüzden **`List<Integer>`** kullanmalıyız. 🚀



