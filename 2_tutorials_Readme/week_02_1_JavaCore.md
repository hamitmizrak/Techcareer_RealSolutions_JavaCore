

## Java Core Operator
```sh 

```
---
Java SE'de **operator (operatör)**, bir veya daha fazla değişken ya da değeri alarak üzerinde işlem yapan özel sembollerdir. Operatörler sayesinde değişkenler üzerinde aritmetik, mantıksal, karşılaştırma gibi işlemler yapılır. Java'da operatörler türlerine göre farklı kategorilere ayrılır. 
---

## ✅ 1. **Aritmetik Operatörler (Arithmetic Operators)**

Aritmetik operatörler, sayısal ifadeler üzerinde matematiksel işlemler yapmak için kullanılır.

| Operatör | Açıklama          | Örnek   |
| -------- | ----------------- | ------- |
| `+`      | Toplama           | `a + b` |
| `-`      | Çıkarma           | `a - b` |
| `*`      | Çarpma            | `a * b` |
| `/`      | Bölme             | `a / b` |
| `%`      | Mod (kalan bulma) | `a % b` |

### Not:

* `/` tam sayı bölmede sonucu **kesirli değil tam sayı** verir. (ör: `5 / 2 = 2`)
* `%` operatörü iki sayının **bölümünden kalanı** verir.

---

## ✅ 2. **Atama Operatörleri (Assignment Operators)**

Değişkenlere değer atamak için kullanılır. `=` temel atama operatörüdür.

| Operatör | Açıklama                       | Örnek    |
| -------- | ------------------------------ | -------- |
| `=`      | Değer atama                    | `a = 5`  |
| `+=`     | Toplayarak atama (`a = a + b`) | `a += 2` |
| `-=`     | Çıkararak atama (`a = a - b`)  | `a -= 3` |
| `*=`     | Çarparak atama (`a = a * b`)   | `a *= 4` |
| `/=`     | Bölerek atama (`a = a / b`)    | `a /= 2` |
| `%=`     | Kalan alarak atama             | `a %= 2` |

---

## ✅ 3. **Karşılaştırma Operatörleri (Comparison / Relational Operators)**

İki değeri karşılaştırarak **boolean (true/false)** sonuç döner.

| Operatör | Anlamı             | Örnek    |
| -------- | ------------------ | -------- |
| `==`     | Eşit mi            | `a == b` |
| `!=`     | Eşit değil mi      | `a != b` |
| `>`      | Büyük mü           | `a > b`  |
| `<`      | Küçük mü           | `a < b`  |
| `>=`     | Büyük veya eşit mi | `a >= b` |
| `<=`     | Küçük veya eşit mi | `a <= b` |

---

## ✅ 4. **Mantıksal Operatörler (Logical Operators)**

Mantıksal (boolean) ifadeler üzerinde işlem yapar.

| Operatör | Açıklama                         | Örnek              |                               |          |   |          |
| -------- | -------------------------------- | ------------------ | ----------------------------- | -------- | - | -------- |
| `&&`     | VE (AND): İkisi de true ise true | `(a > 0 && b > 0)` |                               |          |   |          |
| \`       |                                  | \`                 | VEYA (OR): Biri true ise true | \`(a > 0 |   | b > 0)\` |
| `!`      | DEĞİL (NOT): true → false        | `!(a > 0)`         |                               |          |   |          |

---

## ✅ 5. **Birlikte Kullanım Operatörleri (Unary Operators)**

Tek bir operand (değişken) ile çalışırlar.

| Operatör | Açıklama                       | Örnek           |
| -------- | ------------------------------ | --------------- |
| `+`      | Pozitif işaret                 | `+a`            |
| `-`      | Negatif işaret                 | `-a`            |
| `++`     | 1 artırma (prefix/postfix)     | `++a` / `a++`   |
| `--`     | 1 azaltma (prefix/postfix)     | `--a` / `a--`   |
| `!`      | Boolean değeri tersine çevirir | `!true` → false |

### Not:

* `++a` → önce artırır, sonra kullanır.
* `a++` → önce kullanır, sonra artırır.

---

## ✅ 6. **Bit Düzeyinde Operatörler (Bitwise Operators)**

Sayılara bit düzeyinde işlem yapar. Performans açısından bazı durumlarda tercih edilir.

| Operatör | Açıklama                       | Örnek     |     |     |
| -------- | ------------------------------ | --------- | --- | --- |
| `&`      | AND                            | `a & b`   |     |     |
| \`       | \`                             | OR        | \`a | b\` |
| `^`      | XOR (farklıysa 1)              | `a ^ b`   |     |     |
| `~`      | NOT (bitleri ters çevirir)     | `~a`      |     |     |
| `<<`     | Sol kaydır                     | `a << 2`  |     |     |
| `>>`     | Sağ kaydır                     | `a >> 2`  |     |     |
| `>>>`    | Sıfırla doldurarak sağa kaydır | `a >>> 2` |     |     |

---

## ✅ 7. **Koşul Operatörü (Ternary Operator)**

3 operand ile çalışan tek operatördür. **if-else** yerine kısa yazım sağlar.

```java
String durum = (yas >= 18) ? "Yetişkin" : "Çocuk";
```

### Yapı:

```java
koşul ? doğruysa_değer : yanlışsa_değer;
```

---

## ✅ 8. **instanceof Operatörü**

Bir nesnenin belirli bir sınıfın örneği olup olmadığını kontrol eder.

```java
if (nesne instanceof String) {
    System.out.println("Bu bir String nesnesidir");
}
```

---

## ✅ 9. **Type Cast (Tür Dönüştürme) Operatörü**

Bir veri tipini başka bir türe dönüştürmek için kullanılır.

```java
int sayi = (int) 3.14; // double → int (explicit casting)
```

* **Implicit (otomatik)**: `int → double`
* **Explicit (açıkça yazılır)**: `double → int`

---

## ✅ Ekstra: Operatör Önceliği (Operator Precedence)

Java'da operatörlerin öncelik sırası vardır. Örneğin çarpma işlemi toplama işleminden önce gelir.

```java
int sonuc = 3 + 4 * 2; // sonuç: 11 (çarpma önce)
```

Öncelik sırasına dikkat etmek için parantez kullanılması önerilir:

```java
int sonuc = (3 + 4) * 2; // sonuç: 14
```

---

## Özetle:

| Kategori          | Operatörler                       |                                  |         |
| ----------------- | --------------------------------- | -------------------------------- | ------- |
| Aritmetik         | `+`, `-`, `*`, `/`, `%`           |                                  |         |
| Atama             | `=`, `+=`, `-=`, `*=`, `/=`, `%=` |                                  |         |
| Karşılaştırma     | `==`, `!=`, `>`, `<`, `>=`, `<=`  |                                  |         |
| Mantıksal         | `&&`, \`                          |                                  | `, `!\` |
| Bitwise           | `&`, \`                           | `, `^`, `\~`, `<<`, `>>`, `>>>\` |         |
| Koşullu (ternary) | `?:`                              |                                  |         |
| instanceof        | `instanceof`                      |                                  |         |
| Tür dönüşüm       | `(int)`, `(double)` vs.           |                                  |         |
| Unary             | `++`, `--`, `+`, `-`, `!`         |                                  |         |

---

## Java Core Scanner
```sh 

```
---

Java'da `Scanner`, kullanıcıdan (klavye, dosya veya başka bir veri kaynağından) **veri okumak** için kullanılan bir sınıftır. `java.util` paketine aittir ve genellikle **konsol tabanlı uygulamalarda kullanıcı girdisi almak** için kullanılır.

---

## 📌 Temel Tanım:

```java
import java.util.Scanner;
```

* `Scanner` sınıfı, Java 5 (Java SE 1.5) ile gelmiştir.
* Klavyeden veri almak için **`System.in`** ile birlikte kullanılır.
* Girilen veriyi `String`, `int`, `double`, `boolean`, vb. türlere dönüştürebilir.

---

## 📦 Kullanım Şekli

### 1. Scanner Nesnesi Oluşturma:

```java
Scanner input = new Scanner(System.in);
```

Burada:

* `input`: Scanner nesnesi.
* `System.in`: Klavye girişi (InputStream).

---

## 🔍 Yaygın Kullanılan Yöntemler (Metodlar)

| Metot           | Açıklama                             | Örnek Giriş                         |
| --------------- | ------------------------------------ | ----------------------------------- |
| `next()`        | Tek bir kelime okur (boşlukta durur) | `"merhaba dünya"` → `merhaba`       |
| `nextLine()`    | Tüm satırı okur                      | `"merhaba dünya"` → `merhaba dünya` |
| `nextInt()`     | `int` okur                           | `42`                                |
| `nextDouble()`  | `double` okur                        | `3.14`                              |
| `nextBoolean()` | `boolean` okur (`true` veya `false`) | `true`                              |
| `nextFloat()`   | `float` okur                         | `2.5f`                              |
| `nextLong()`    | `long` türünde sayı okur             | `123456789L`                        |

---

## 🧪 Örnek Kullanım

### A. Sayı Girişi

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Scanner oluştur
        System.out.print("Bir sayı girin: ");
        int sayi = input.nextInt();              // int değeri oku
        System.out.println("Girdiğiniz sayı: " + sayi);
    }
}
```

### B. Satır Girişi

```java
Scanner input = new Scanner(System.in);
System.out.print("Adınızı girin: ");
String ad = input.nextLine();
System.out.println("Merhaba " + ad);
```

---

## ⚠️ Dikkat Edilmesi Gerekenler

### 1. `nextLine()` + `nextInt()` Karmaşası:

```java
int yas = input.nextInt();
String isim = input.nextLine(); // Boş bir satır okur!
```

**Çözüm:** `nextLine()`'dan önce fazladan bir `nextLine()` çağır:

```java
input.nextLine(); // dummy read
String isim = input.nextLine();
```

---

## 🔒 Kaynakları Kapatmak

Program sonunda `Scanner` nesnesi kapatılmalıdır:

```java
input.close();
```

> Not: `System.in` kapandığında tekrar kullanılamaz. Büyük projelerde dikkatli olunmalıdır.

---

## 🎯 Nerelerde Kullanılır?

* Konsoldan kullanıcıdan bilgi alma
* Sınav uygulamaları
* Menü tabanlı terminal uygulamaları
* Dosyadan veri okuma (`new Scanner(new File("dosya.txt"))`)

---

## Özet:

* `Scanner`, Java'da **girdi almak** için kullanılır.
* `System.in` ile klavyeden veri okur.
* `nextInt()`, `nextLine()`, `nextDouble()` gibi çok sayıda veri türü için özel metotları vardır.

---


## Java Core JOptionalPane
```sh 

```
---

`JOptionPane`, Java Swing kütüphanesinde yer alan ve **grafiksel arayüz (GUI)** uygulamalarında **kullanıcıya mesaj göstermek veya kullanıcıdan bilgi almak** için kullanılan **hazır pencere bileşenidir**.

---

## 📌 Temel Tanım:

```java
import javax.swing.JOptionPane;
```

* `JOptionPane`, Swing GUI uygulamalarında **popup (açılır) pencere** oluşturmak için kullanılır.
* Hem **bilgi mesajları**, hem de **girdi alma** (input) ve **seçim yaptırma** (confirm) işlemleri için uygundur.

---

## 🧰 Kullanım Tipleri:

### 1. **Mesaj Gösterme (showMessageDialog)**

Kullanıcıya sadece bilgi vermek için:

```java
JOptionPane.showMessageDialog(null, "İşlem başarıyla tamamlandı!");
```

📌 Parametreler:

* `null`: Diyalog ana pencereye bağlanmaz, bağımsız olur.
* `"..."`: Gösterilecek mesaj.

---

### 2. **Girdi Alma (showInputDialog)**

Kullanıcıdan veri almak için:

```java
String ad = JOptionPane.showInputDialog("Adınızı girin:");
System.out.println("Adınız: " + ad);
```

---

### 3. **Onay Almak (showConfirmDialog)**

Kullanıcının evet/hayır gibi seçim yapmasını sağlamak için:

```java
int secim = JOptionPane.showConfirmDialog(null, "Silmek istediğinize emin misiniz?", "Uyarı", JOptionPane.YES_NO_OPTION);

if (secim == JOptionPane.YES_OPTION) {
    System.out.println("Kullanıcı evet dedi");
}
```

---

### 4. **Özel Mesaj Türleri (Icon ve Başlık Kullanımı)**

```java
JOptionPane.showMessageDialog(null, "Bir hata oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
```

📌 `messageType` seçenekleri:

| Sabit Adı             | Anlamı                |
| --------------------- | --------------------- |
| `INFORMATION_MESSAGE` | Bilgilendirme         |
| `WARNING_MESSAGE`     | Uyarı                 |
| `ERROR_MESSAGE`       | Hata                  |
| `QUESTION_MESSAGE`    | Soru                  |
| `PLAIN_MESSAGE`       | Sade mesaj (ikon yok) |

---

## 🎯 Kullanım Örneği:

```java
import javax.swing.JOptionPane;

public class DialogOrnek {
    public static void main(String[] args) {
        String isim = JOptionPane.showInputDialog("Adınızı giriniz:");
        JOptionPane.showMessageDialog(null, "Merhaba " + isim + "!");
        
        int karar = JOptionPane.showConfirmDialog(null, "Devam etmek istiyor musunuz?", "Karar", JOptionPane.YES_NO_OPTION);
        if (karar == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Devam ediyorsunuz...");
        } else {
            JOptionPane.showMessageDialog(null, "İşlem iptal edildi.");
        }
    }
}
```

---

## 🧠 Avantajları:

* Hızlı ve kolay pencere oluşturma.
* Swing arayüzleri ile uyumlu.
* Basit kullanıcı etkileşimleri için idealdir.

---

## ⚠️ Dikkat Edilecek Noktalar:

* Sadece masaüstü (GUI) uygulamaları içindir.
* `main()` fonksiyonlarında doğrudan kullanılabilir, ekstra pencere çerçevesi (JFrame) gerektirmez.
* `JOptionPane`, modal (kullanıcı yanıt vermeden diğer işlemler durur) pencere olarak çalışır.

---



## Java Core Cast
```sh 

```
---


Java'da **casting (tür dönüşümü)**, bir veri tipinin başka bir veri tipine **dönüştürülmesidir**. Bu işlem genellikle iki tür arasında veri aktarımı yapılırken gereklidir. Java’da **primitive türler** ve **referans türleri (nesneler)** için farklı casting kuralları geçerlidir.

---

## ✅ 1. **Primitive (ilkel) Türler Arası Casting**

### 🔹 **A. Genişletme (Widening Casting) – Otomatik**

Küçük veri tipinin daha büyük veri tipine **otomatik** olarak dönüştürülmesidir.

> Otomatik yapılır (data loss yoktur)

**Sıralama:**

```
byte → short → int → long → float → double
```

### ✅ Örnek:

```java
int sayi = 10;
double sonuc = sayi;  // Otomatik dönüşüm (int → double)
```

---

### 🔹 **B. Daraltma (Narrowing Casting) – Manuel**

Daha büyük bir veri tipini daha küçük bir tipe **manuel olarak dönüştürmektir**. Veri kaybı olabilir.

> El ile yapılır: `(tip)`

### ✅ Örnek:

```java
double deger = 9.8;
int tamSayi = (int) deger;  // Kesir kısmı kaybolur → 9
```

---

## 📝 Örnek:

```java
public class CastOrnek {
    public static void main(String[] args) {
        int sayi = 150;
        double ondalik = sayi;         // widening (otomatik)

        double d = 99.99;
        int i = (int) d;               // narrowing (manuel)

        System.out.println(ondalik);  // 150.0
        System.out.println(i);        // 99
    }
}
```

---

## ✅ 2. **Referans (Object) Türleri Arası Casting**

### 🔹 A. **Upcasting** (Alt sınıftan üst sınıfa) → Otomatik

```java
class Hayvan {}
class Kedi extends Hayvan {}

Hayvan h = new Kedi();  // upcasting (otomatik)
```

### 🔹 B. **Downcasting** (Üst sınıftan alt sınıfa) → Manuel

```java
Hayvan h = new Kedi();  
Kedi k = (Kedi) h;      // downcasting (manuel ve güvenli)
```

🛑 **Dikkat!** Eğer gerçek tür farklıysa `ClassCastException` hatası alırsın:

```java
Hayvan h = new Hayvan();
Kedi k = (Kedi) h; // HATA: Hayvan nesnesi Kedi'ye cast edilemez
```

### ✅ Güvenli casting için `instanceof` kontrolü:

```java
if (h instanceof Kedi) {
    Kedi k = (Kedi) h;
}
```

---

## ✅ 3. **Wrapper (sarmalayıcı) Sınıflar Arası Casting**

Java’daki primitive türlerin nesne karşılığı:

| Primitive | Wrapper |
| --------- | ------- |
| int       | Integer |
| double    | Double  |
| boolean   | Boolean |

**Autoboxing (Otomatik nesneye dönüşüm):**

```java
int sayi = 42;
Integer nesne = sayi;  // autoboxing
```

**Unboxing (Otomatik primitive'e dönüşüm):**

```java
Integer nesne = 100;
int deger = nesne;     // unboxing
```

---

## 🔒 Casting ile İlgili Özet Tablo:

| Tür             | Açıklama                           | Cast Türü                                  |
| --------------- | ---------------------------------- | ------------------------------------------ |
| `int → double`  | Veri büyür                         | Otomatik                                   |
| `double → int`  | Veri küçülür (veri kaybı olabilir) | Manuel                                     |
| `Kedi → Hayvan` | Alt sınıf → Üst sınıf              | Otomatik                                   |
| `Hayvan → Kedi` | Üst sınıf → Alt sınıf              | Manuel (`instanceof` ile kontrol önerilir) |

---

## 📌 Gerçek Hayattan Örnek:

### Kullanıcının girdiği metni sayıya çevirmek:

```java
Scanner input = new Scanner(System.in);
System.out.print("Bir sayı girin: ");
String girilen = input.nextLine();

int sayi = Integer.parseInt(girilen); // String → int (parse)
```

---



## Java Core String
```sh 

```
---

Java'da `String`, **karakter dizilerini (yazı/veri metinlerini)** temsil eden **özel bir referans veri tipidir (sınıftır)**. `String`, `java.lang` paketinde yer alır ve Java'nın en çok kullanılan sınıflarından biridir.

---

## ✅ 1. **String Nedir?**

* Karakterlerden oluşan bir veri yapısıdır.
* `char[]` (karakter dizisi) temellidir.
* Nesne (object) olarak çalışır, ancak **literal (sabit)** yazımı sayesinde kolayca kullanılabilir.
* `String` nesneleri **değiştirilemezdir (immutable)** → bir kere oluşturulduğunda içeriği değiştirilemez.

---

## 🧱 Tanımlama Yolları

### 1. Literal Yöntemi (hafıza dostu):

```java
String ad = "Hamit";
```

> JVM, bu tür string’leri **string pool** içinde saklar (hafıza optimizasyonu).

### 2. `new` Anahtar Kelimesi ile:

```java
String soyad = new String("Mızrak");
```

> Her zaman yeni bir nesne oluşturur. String pool kullanılmaz.

---

## 🛠️ 2. **Temel String Metotları**

| Metot                   | Açıklama                               | Örnek Sonuç                                 |
| ----------------------- | -------------------------------------- | ------------------------------------------- |
| `length()`              | Karakter sayısını döner                | `"abc".length()` → 3                        |
| `charAt(int index)`     | Belirli indeksteki karakter            | `"java".charAt(1)` → 'a'                    |
| `toUpperCase()`         | Harfleri büyütür                       | `"abc".toUpperCase()` → "ABC"               |
| `toLowerCase()`         | Harfleri küçültür                      | `"JAVA".toLowerCase()` → "java"             |
| `trim()`                | Baş/son boşlukları siler               | `"  merhaba  ".trim()` → "merhaba"          |
| `substring(start, end)` | Parça alır                             | `"merhaba".substring(0, 3)` → "mer"         |
| `equals(String s)`      | İçerik karşılaştırması (== değil!)     | `"a".equals("a")` → true                    |
| `equalsIgnoreCase()`    | Büyük/küçük harf farkı olmadan eşitlik | `"A".equalsIgnoreCase("a")`                 |
| `contains("a")`         | İçeriyor mu?                           | `"haydar".contains("da")` → true            |
| `startsWith("Ha")`      | Belirli önekle başlıyor mu?            | `"Hamit".startsWith("Ha")` → true           |
| `endsWith("rak")`       | Belirli ekle bitiyor mu?               | `"Mızrak".endsWith("rak")` → true           |
| `replace("a", "e")`     | Karakter/metin değiştirme              | `"java".replace("a", "e")` → "jeve"         |
| `split(" ")`            | Ayırma                                 | `"ad soyad".split(" ")` → `["ad", "soyad"]` |
| `indexOf("a")`          | İlk eşleşen index                      | `"java".indexOf("a")` → 1                   |

---

## ⚠️ 3. == ile `equals()` Farkı

```java
String a = "test";
String b = "test";
String c = new String("test");

System.out.println(a == b);      // true (aynı havuz)
System.out.println(a == c);      // false (farklı nesne)
System.out.println(a.equals(c)); // true (içerik aynı)
```

📌 `==` → bellekte aynı adresi mi gösteriyor?
📌 `equals()` → içerik eşit mi?

---

## 🔐 4. String Immutable (Değiştirilemezdir)

```java
String s = "java";
s.concat(" se");  // Bu işlem s’yi değiştirmez!
System.out.println(s);  // "java" (değişmedi)
```

Değişiklik istiyorsan yeni string atamalısın:

```java
s = s.concat(" se");  // Artık s = "java se"
```

---

## 📦 5. StringBuilder ve StringBuffer (Alternatifler)

Çok sık string değiştirilecekse, performans için:

* `StringBuilder` → hızlı, thread-safe değil
* `StringBuffer` → yavaş ama thread-safe

```java
StringBuilder sb = new StringBuilder("merhaba");
sb.append(" dünya");
System.out.println(sb);  // "merhaba dünya"
```

---

## 🧪 Örnek Uygulama:

```java
public class StringOrnek {
    public static void main(String[] args) {
        String ad = "Hamit";
        System.out.println("Uzunluk: " + ad.length());
        System.out.println("İlk harf: " + ad.charAt(0));
        System.out.println("Büyük harf: " + ad.toUpperCase());
    }
}
```

---

## 🎯 Kullanım Alanları:

* Kullanıcı adı/şifre kontrolü
* Dosya/dizin işlemleri
* Regex ile metin arama/değiştirme
* Web uygulamalarında URL ve parametre analizi
* Loglama, mesaj üretimi

---

## Özet:

* `String`, karakter dizilerini temsil eder.
* Değiştirilemez (immutable).
* Çok sayıda yerleşik metotla gelir.
* `==` yerine `equals()` ile karşılaştırılmalı.
* Sık değişen string işlemleri için `StringBuilder` tercih edilmeli.

---


## Java Core StringBuilder,StringTokenizer, StringBuffer
```sh 

```
---

Java'da `StringBuilder`, `StringBuffer` ve `StringTokenizer` sınıfları, **metin (String)** işlemleri için kullanılan güçlü araçlardır. Ancak her biri farklı amaçlara ve durumlara yöneliktir.

Aşağıda her birini detaylı, örnekli ve farklarıyla birlikte açıklıyorum:

---

## ✅ 1. `StringBuilder` Nedir?

`StringBuilder`, değiştirilebilir (mutable) **karakter dizileri** oluşturmak ve düzenlemek için kullanılır. Performans açısından, bir String üzerinde çok fazla ekleme, silme veya değiştirme işlemi yapılacaksa `StringBuilder` tercih edilir.

### 📌 Temel Özellikler:

* **Mutable (değiştirilebilir)**
* **Thread-safe değildir** → çoklu iş parçacığında kullanılmaz
* Tek iş parçacıklı uygulamalarda `StringBuffer`'dan **daha hızlıdır**
* `String` gibi değil, kendi belleğini dinamik olarak yönetir.

### 🧪 Örnek:

```java
StringBuilder sb = new StringBuilder("Merhaba");
sb.append(" Dünya");           // Sonuna ekler
sb.insert(0, "Selam ");        // Başına ekler
sb.delete(0, 6);               // Belirli aralığı siler
sb.reverse();                  // Ters çevirir

System.out.println(sb);       // Çıktı: aynüD abahreM
```

### 📌 Yaygın Metotlar:

* `append(String s)`
* `insert(int offset, String s)`
* `delete(int start, int end)`
* `replace(int start, int end, String s)`
* `reverse()`
* `toString()`

---

## ✅ 2. `StringBuffer` Nedir?

`StringBuffer`, `StringBuilder` ile hemen hemen aynıdır ama **thread-safe (eşzamanlı çalışmalara uygun)** olacak şekilde tasarlanmıştır.

### 📌 Temel Özellikler:

* **Mutable**
* **Thread-safe** (senkronizedir)
* Daha yavaştır ama çok iş parçacıklı ortamlarda güvenlidir.

### 🧪 Örnek:

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" SE");
System.out.println(sb);  // Java SE
```

### 📌 Karşılaştırma:

| Özellik          | String      | StringBuilder | StringBuffer |
| ---------------- | ----------- | ------------- | ------------ |
| Değiştirilebilir | ❌ Immutable | ✅ Mutable     | ✅ Mutable    |
| Thread-safe      | ❌ Hayır     | ❌ Hayır       | ✅ Evet       |
| Hız              | 🐢 Yavaş    | 🚀 Hızlı      | 🐇 Orta      |

---

## ✅ 3. `StringTokenizer` Nedir?

`StringTokenizer`, bir string’i **belirli ayırıcılarla parçalara (token) ayırmak** için kullanılır. Eski bir sınıftır ve yerine `String.split()` veya `Scanner` tavsiye edilir.

### 📌 Temel Özellikler:

* Ayırıcı karakterleri baz alır (varsayılan: boşluk)
* Bir `String` içinde kelimeleri ayrıştırmak için kullanılır.

### 🧪 Örnek:

```java
import java.util.StringTokenizer;

public class Ornek {
    public static void main(String[] args) {
        String cumle = "Java SE Android Spring";
        StringTokenizer st = new StringTokenizer(cumle);

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
```

### 📌 Ayırıcı Belirtme:

```java
StringTokenizer st = new StringTokenizer("elma,armut,üzüm", ",");
```

---

## 🔄 `String.split()` yerine `StringTokenizer` farkı:

| Özellik            | String.split()      | StringTokenizer       |
| ------------------ | ------------------- | --------------------- |
| Daha yeni mi?      | ✅ Modern            | ❌ Eski (Java 1.0)     |
| Regex destekli mi? | ✅ Evet              | ❌ Hayır               |
| Array mı döner?    | ✅ Evet (`String[]`) | ❌ Hayır (`token`)     |
| Hız                | Orta                | Genellikle daha hızlı |

---

## 🎯 Hangi Durumda Hangisi Kullanılır?

| Amaç                                 | Kullanılacak Sınıf |
| ------------------------------------ | ------------------ |
| Performanslı string birleştirme      | `StringBuilder`    |
| Thread-safe string birleştirme       | `StringBuffer`     |
| String kelimelere ayırma (eski stil) | `StringTokenizer`  |
| Modern string parçalama              | `String.split()`   |

---

## Özet:

| Sınıf             | Amacı                     | Mutable | Thread-safe | Modern Mi? |
| ----------------- | ------------------------- | ------- | ----------- | ---------- |
| `StringBuilder`   | Hızlı metin birleştirme   | ✅       | ❌           | ✅          |
| `StringBuffer`    | Güvenli metin birleştirme | ✅       | ✅           | ✅          |
| `StringTokenizer` | Eski tip kelime ayırıcı   | ❌       | ✅           | ❌          |

---




## Java Core Method
```sh 

```
---

Java’da **method (yöntem/metot)**, belirli bir görevi yerine getiren **kod bloklarıdır**. Kodun daha düzenli, okunabilir ve **yeniden kullanılabilir (reusable)** olmasını sağlar. Temel anlamda bir Java methodu, bir işi yapan, bazen değer alan ve bazen değer döndüren fonksiyondur.

---

## ✅ 1. Java’da Method Nedir?

Bir method:

* Bir **isim**e sahiptir.
* Genellikle bir veya daha fazla **parametre** alabilir.
* Belli bir **görev/iş** yapar.
* İsteğe bağlı olarak bir **değer döndürebilir** (`return` ile).

---

## 🧱 2. Methodun Yapısı

### 📌 Genel Söz Dizimi (Syntax):

```java
erişimBelirteci dönüşTürü methodAdı(parametreler) {
    // method gövdesi
    // işlemler
    return dönüşDeğeri; // eğer dönüş türü void değilse
}
```

### 🔍 Açıklamalar:

* **erişimBelirteci:** `public`, `private`, `protected` (erişim kontrolü sağlar)
* **dönüşTürü:** `int`, `String`, `void`, `boolean` vb.
* **parametreler:** methoda gönderilen değişkenler
* **return:** methodun geri döndürdüğü değer

---

## 🧪 3. Örnekler

### 📍 A. Geri Değer Döndürmeyen (void) Method:

```java
public void selamla() {
    System.out.println("Merhaba, Java!");
}
```

### 📍 B. Parametre Alan ve Değer Döndüren Method:

```java
public int topla(int a, int b) {
    return a + b;
}
```

### Kullanımı:

```java
int sonuc = topla(3, 4);  // sonuc = 7
```

---

## 🧠 4. Neden Method Kullanırız?

* Kod tekrarını önler.
* Okunabilirlik artırır.
* Kod bakımı kolaylaşır.
* Büyük projelerde görevler bölünebilir.

---

## 📦 5. Method Türleri

### 🔹 A. Parametreli vs. Parametresiz

```java
void mesaj()                    // parametresiz
int topla(int a, int b)         // parametreli
```

### 🔹 B. Geri Döndüren vs. Döndürmeyen

```java
void yazdir(String x)           // döndürmeyen
String formatla(String x)       // döndüren
```

---

## 🧮 6. Main Method (Giriş Noktası)

Her Java uygulamasının çalıştığı yer `main` methodudur:

```java
public static void main(String[] args) {
    // program buradan başlar
}
```

### `main()` İçindeki Terimler:

* `public`: Her yerden erişilebilir
* `static`: Nesne oluşturmadan çalışabilir
* `void`: Geriye değer döndürmez
* `String[] args`: Komut satırı argümanları

---

## 🔁 7. Overloading (Aşırı Yükleme)

Aynı isimli ama farklı parametreli methodlar tanımlayabilirsin:

```java
public int topla(int a, int b) {
    return a + b;
}

public double topla(double a, double b) {
    return a + b;
}
```

---

## 🧪 Tümünü İçeren Mini Örnek:

```java
public class HesapMakinesi {

    public void selamla() {
        System.out.println("Hoşgeldiniz!");
    }

    public int carp(int x, int y) {
        return x * y;
    }

    public static void main(String[] args) {
        HesapMakinesi h = new HesapMakinesi();
        h.selamla();
        int sonuc = h.carp(4, 5);
        System.out.println("Çarpım: " + sonuc);
    }
}
```

---

## 🔐 8. Method Erişim Belirleyicileri

| Belirteç    | Anlamı                           |
| ----------- | -------------------------------- |
| `public`    | Her yerden erişilebilir          |
| `private`   | Sadece bulunduğu sınıfta geçerli |
| `protected` | Aynı pakette veya alt sınıflarda |
| `default`   | Sadece aynı pakette (yazılmazsa) |

---

## Özet:

| Terim         | Anlamı                                 |
| ------------- | -------------------------------------- |
| `method`      | Belirli bir işi yapan kod bloğu        |
| `void`        | Geriye değer döndürmeyen method        |
| `return`      | Geriye değer döndürmek için kullanılır |
| `static`      | Nesne oluşturmadan çağrılabilir        |
| `overloading` | Aynı isimli farklı parametreli method  |

---


## Java Core Recursive Method
```sh 

```
---

Java'da **recursive method (özyinelemeli yöntem)** konusunu detaylıca, sade örneklerle açıklayayım.

---

## 🔁 1. Recursive Method Nedir?

**Recursive (özyinelemeli)** bir metot, **kendi kendini çağıran** bir metottur. Genellikle **bir problemi daha küçük alt parçalara bölerek** çözmek için kullanılır.

> 📌 Örnek: Faktöriyel, Fibonacci, dosya/dizin tarayıcıları, ağaç (tree) yapıları vb.

---

## ✅ 2. Recursive Yapının Temel Özellikleri

### a) **Base Case**:

Yinelemenin duracağı yer. **Sonsuz döngüye** girmemesi için mutlaka olmalı.

### b) **Recursive Case**:

Metot, daha küçük bir problemi çözmek için **kendini yeniden çağırır.**

---


public class NumberUtils {

    // Faktöriyel - Iterative
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Faktöriyel - Recursive
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorialRecursive(n - 1);
    }

    // Asal Sayı - Iterative
    public static boolean isPrimeIterative(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Asal Sayı - Recursive
    public static boolean isPrimeRecursive(int n) {
        return isPrimeHelper(n, 2);
    }

    private static boolean isPrimeHelper(int n, int divisor) {
        if (n <= 1) return false;
        if (divisor > Math.sqrt(n)) return true;
        if (n % divisor == 0) return false;
        return isPrimeHelper(n, divisor + 1);
    }

    // Test
    public static void main(String[] args) {
        int sayi = 5;

        System.out.println("Faktöriyel (Iterative): " + factorialIterative(sayi));
        System.out.println("Faktöriyel (Recursive): " + factorialRecursive(sayi));

        System.out.println("Asal mı? (Iterative): " + isPrimeIterative(sayi));
        System.out.println("Asal mı? (Recursive): " + isPrimeRecursive(sayi));
    }
}


## 🔢 3. Örnek 1: Faktöriyel Hesaplama

`n! = n * (n-1)!`

```java
public class RecursiveExample {
    public static int factorial(int n) {
        if (n == 0)  // base case
            return 1;
        else
            return n * factorial(n - 1); // recursive case
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    }
}
```

### 📌 Açıklama:

```text
factorial(5)
→ 5 * factorial(4)
→ 5 * 4 * factorial(3)
→ 5 * 4 * 3 * factorial(2)
→ 5 * 4 * 3 * 2 * factorial(1)
→ 5 * 4 * 3 * 2 * 1 * factorial(0)
→ 5 * 4 * 3 * 2 * 1 * 1 = 120
```

---

## 🐢 4. Örnek 2: Fibonacci Serisi

Fibonacci: `0, 1, 1, 2, 3, 5, 8, ...`
Formül: `F(n) = F(n-1) + F(n-2)`

```java
public class FibonacciExample {
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.print(fibonacci(i) + " ");
        // Çıktı: 0 1 1 2 3 5 8
    }
}
```

---

## 📁 5. Örnek 3: Dizinleri Listeleme (Recursive Kullanımı)

```java
import java.io.File;

public class DirectoryExplorer {
    public static void listFiles(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    listFiles(f.getAbsolutePath());
                } else {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        listFiles("C:/Users"); // Gerçek dizin verin
    }
}
```

---

## ⚠️ 6. Dikkat Edilmesi Gerekenler

| Uyarı          | Açıklama                                                                      |
| -------------- | ----------------------------------------------------------------------------- |
| Sonsuz döngü   | `base case` olmazsa, **StackOverflowError** oluşur                            |
| Performans     | Bazı recursive işlemler (örneğin klasik Fibonacci) **çok fazla tekrar** yapar |
| Alternatif     | Her recursive işlem **iteratif (döngüsel)** yapılabilir                       |
| Tail recursion | JVM desteklemese de bazı dillerde optimize edilir                             |

---

## 🔁 7. Recursive vs Iterative (Kıyaslama)

| Özellik          | Recursive                           | Iterative                  |
| ---------------- | ----------------------------------- | -------------------------- |
| Yazımı           | Daha kısa ve sade                   | Daha uzun ama performanslı |
| Bellek kullanımı | Fazladır (stack kullanır)           | Daha azdır                 |
| Hata riski       | StackOverflow riski vardır          | Daha güvenlidir            |
| Kullanım alanı   | Ağaç, grafik, matematiksel işlemler | Genel amaçlı               |

---

## 🧠 8. Gerçek Hayatta Nerede Kullanılır?

* Ağaç yapılarında gezinme (DOM, JSON, dosya sistemi)
* Matematiksel hesaplar: Faktöriyel, Fibonacci, GCD (ebob)
* Yapay zeka ve oyun algoritmaları (DFS, Minimax)
* Derleyici yapıları (AST ağacı çözümleme)

---

## 📌 9. Bonus: GCD (En Büyük Ortak Bölen)

```java
public static int gcd(int a, int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}
```

---

## 🎯 Sonuç

* Recursive metotlar problemi **kendi kendini çağırarak** çözer.
* Her zaman **base case** içermelidir.
* Kodun sadeleşmesini sağlar ancak belleğe dikkat edilmelidir.

---




## Java Core Date
```sh 

```
---

Java'da `Date` sınıfı zamanla ilgili işlemlerde en temel sınıflardan biridir ancak tarihsel olarak biraz eski kalmıştır. Bu nedenle hem `Date` sınıfını hem de onun yerine gelen `java.time` paketindeki modern alternatiflerini detaylı bir şekilde açıklayacağım.

---

## 🔹 1. `java.util.Date` Sınıfı (Klasik Tarih Zaman Sınıfı)

### 🔧 Tanım:

`Date` sınıfı, milisaniye cinsinden bir zaman damgasını tutar. 1 Ocak 1970 UTC tarihinden itibaren geçen zamanı ifade eder (Epoch time).

```java
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);  // Çıktı: Wed Jun 18 17:00:00 TRT 2025
    }
}
```

---

### 📌 Önemli Metotlar:

| Metot                  | Açıklama                                  |
| ---------------------- | ----------------------------------------- |
| `getTime()`            | Epoch time olarak milisaniye verir        |
| `before(Date date)`    | Bu tarih verilen tarihten önce mi?        |
| `after(Date date)`     | Bu tarih verilen tarihten sonra mı?       |
| `compareTo(Date date)` | Karşılaştırma yapar (negatif, 0, pozitif) |
| `toString()`           | Tarihi okunabilir formatta döner          |

```java
Date d1 = new Date();
Thread.sleep(1000); // 1 saniye beklet
Date d2 = new Date();

System.out.println(d1.before(d2)); // true
System.out.println(d1.compareTo(d2)); // -1
```

---

### ⚠️ Eksiklikler ve Sorunlar:

* Aylar 0'dan başlar (`0 = Ocak`, `11 = Aralık`)
* Yıllar 1900'e göre verilir: `new Date(122, 5, 18)` → 2022-06-18
* Zaman dilimi desteği yetersizdir.
* `Date` **mutable** (değiştirilebilir) bir sınıftır → **Thread-safe değildir.**
* Bu yüzden **`java.time` paketi** önerilir.

---

## 🔹 2. `java.sql.Date`, `Time`, `Timestamp` (JDBC için)

* `java.sql.Date` → sadece tarih
* `java.sql.Time` → sadece saat
* `java.sql.Timestamp` → tarih + saat + nanosaniye

```java
import java.sql.Date;
Date sqlDate = new Date(System.currentTimeMillis());
```

---

## ✅ 3. `java.time` Paketi (Java 8+ Modern Zaman API’si)

Bu paket `Joda-Time` benzeri modern bir API sağlar. Immutable ve Thread-safe'dir.

### 🎯 Temel Sınıflar:

| Sınıf           | Açıklama                    |
| --------------- | --------------------------- |
| `LocalDate`     | Sadece tarih (YYYY-MM-DD)   |
| `LocalTime`     | Sadece saat (HH\:mm\:ss)    |
| `LocalDateTime` | Tarih + saat                |
| `ZonedDateTime` | Tarih + saat + zaman dilimi |
| `Instant`       | Epoch time benzeri          |
| `Period`        | Tarihler arası fark         |
| `Duration`      | Zaman aralıkları            |

---

### 🔍 Örnekler

#### 🗓️ `LocalDate`

```java
import java.time.LocalDate;

LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(1990, 5, 15);
System.out.println(today); // 2025-06-18
```

#### 🕒 `LocalTime`

```java
import java.time.LocalTime;

LocalTime now = LocalTime.now();
System.out.println(now); // 17:04:33.123456
```

#### 📅 `LocalDateTime`

```java
import java.time.LocalDateTime;

LocalDateTime now = LocalDateTime.now();
System.out.println(now); // 2025-06-18T17:05:00
```

#### 🌍 `ZonedDateTime`

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Europe/Istanbul"));
System.out.println(istTime);
```

#### 🧮 Tarih farkı: `Period` ve `Duration`

```java
import java.time.*;
import java.time.temporal.ChronoUnit;

LocalDate start = LocalDate.of(2020, 1, 1);
LocalDate end = LocalDate.now();
Period period = Period.between(start, end);

System.out.println(period.getYears()); // Yıl farkı
System.out.println(ChronoUnit.DAYS.between(start, end)); // Gün farkı
```

---

## 🔁 `Date` ↔ `LocalDateTime` Dönüştürme

```java
// Date → LocalDateTime
Date date = new Date();
LocalDateTime ldt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

// LocalDateTime → Date
Date date2 = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
```

---

## 📚 Tavsiye Edilen Kullanım

* Modern projelerde **`java.time` (Java 8+)** kullanın.
* Eski projelerle uyumluluk gerekiyorsa `Date` → `LocalDateTime` dönüşümleri yapın.
* Thread-safe, test edilebilir ve anlaşılır API sağlar.

---

## 🎓 Özet Tablo

| Amaç                | Eski Sınıf (`java.util`) | Yeni Sınıf (`java.time`) |
| ------------------- | ------------------------ | ------------------------ |
| Sadece tarih        | `Date`                   | `LocalDate`              |
| Sadece saat         | `Date`                   | `LocalTime`              |
| Tarih + saat        | `Date`, `Calendar`       | `LocalDateTime`          |
| Zaman dilimli tarih | Yok                      | `ZonedDateTime`          |
| Epoch time          | `Date.getTime()`         | `Instant`                |
| Aralık hesaplama    | Elle yapılırdı           | `Period`, `Duration`     |

---




## Java Core Exception
```sh 

```
---


 Java'da **Exception (istisna)** kavramı çok temel ve kritik bir konudur. Hataları yönetmenin yapısal ve kontrollü bir yoludur. Şimdi detaylıca, örneklerle birlikte adım adım inceleyelim:

---

## ✅ 1. Exception Nedir?

**Exception**, program çalışırken meydana gelen **olağan dışı durumları** temsil eder. Bu durumlar programın normal akışını bozar. Java'da bu hatalar nesne olarak temsil edilir.

> 📌 Örnek: Bir sayıyı sıfıra bölmeye çalışmak, bir dosyaya erişememek, bir dizinin sınırları dışında erişim sağlamak gibi.

---

## ✅ 2. Exception Kavramının Amacı Nedir?

* Hataları yönetilebilir hale getirmek
* Programın çökmesini önlemek
* Kullanıcıya anlamlı mesajlar göstermek
* Kodun güvenliğini ve okunabilirliğini artırmak

---

## ✅ 3. Exception Hiyerarşisi

```text
java.lang.Object
   ↳ java.lang.Throwable
        ↳ java.lang.Error         (Sistem hataları)
        ↳ java.lang.Exception     (Program hataları)
              ↳ java.lang.RuntimeException (Unchecked)
```

### 📌 İki Ana Tür:

| Tür                   | Açıklama                                                               |
| --------------------- | ---------------------------------------------------------------------- |
| `Checked Exception`   | Derleme zamanında kontrol edilir, `try-catch` veya `throws` zorunludur |
| `Unchecked Exception` | Çalışma zamanında ortaya çıkar, `try-catch` zorunlu değildir           |

---

## ✅ 4. Checked Exception Nedir?

Java tarafından zorunlu tutulur. Derleyici sizi uyarır.

### 📌 Örnekler:

* `IOException` → dosya erişimi
* `SQLException` → veritabanı hataları
* `ParseException` → tarih dönüşüm hatası

```java
import java.io.*;

public class CheckedExample {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("dosya.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + e.getMessage());
        }
    }
}
```

---

## ✅ 5. Unchecked Exception Nedir?

Derleyici sizi zorlamaz, ama çalışma zamanında program çökerse hatayı gösterir.

### 📌 Örnekler:

* `ArithmeticException` → 10 / 0
* `NullPointerException`
* `ArrayIndexOutOfBoundsException`
* `NumberFormatException`

```java
public class UncheckedExample {
    public static void main(String[] args) {
        String text = null;
        System.out.println(text.length()); // NullPointerException
    }
}
```

---

## ✅ 6. Try-Catch-Finally Yapısı

```java
try {
    // Hata çıkarabilecek kodlar
} catch (ExceptionType e) {
    // Hata yakalandığında çalışır
} finally {
    // Her durumda çalışır (temizlik işleri için)
}
```

### 📌 Örnek:

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Sıfıra bölme hatası: " + e.getMessage());
} finally {
    System.out.println("Her durumda çalışır.");
}
```

---

## ✅ 7. throws Anahtar Kelimesi

Bir metodun hata fırlatabileceğini belirtir.

```java
public static void dosyaOku() throws IOException {
    FileReader fr = new FileReader("yok.txt");
}
```

---

## ✅ 8. throw Anahtar Kelimesi

Kendi exception’ınızı fırlatmak için kullanılır.

```java
public static void kontrolEt(int yas) {
    if (yas < 18) {
        throw new IllegalArgumentException("18 yaşından küçük!");
    }
}
```

---

## ✅ 9. Çoklu Catch Kullanımı

```java
try {
    // kod
} catch (IOException | SQLException e) {
    e.printStackTrace();
}
```

Veya klasik biçimle:

```java
try {
    // kod
} catch (IOException e) {
    // IO hatası
} catch (SQLException e) {
    // DB hatası
}
```

---

## ✅ 10. Kendi Özel Exception Sınıfını Yazmak

```java
public class YasGecersizException extends Exception {
    public YasGecersizException(String mesaj) {
        super(mesaj);
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        try {
            int yas = 15;
            if (yas < 18) {
                throw new YasGecersizException("Yaş 18'den küçük!");
            }
        } catch (YasGecersizException e) {
            System.out.println("Özel hata: " + e.getMessage());
        }
    }
}
```

---

## ✅ 11. finally Bloğunun Kullanımı

`finally` bloğu, **exception çıksa da çıkmasa da** mutlaka çalışır.

```java
try {
    int a = 10 / 2;
} catch (ArithmeticException e) {
    System.out.println("Hata var");
} finally {
    System.out.println("Bu blok her zaman çalışır.");
}
```

---

## ✅ 12. try-with-resources (Java 7+)

`AutoCloseable` arabirimini kullanan nesneler için otomatik kapanma sağlar.

```java
try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## 🎯 Özet Tablo

| Özellik               | Açıklama                                                            |
| --------------------- | ------------------------------------------------------------------- |
| `Checked Exception`   | Derleyici hatayı yakalamanızı ister (`IOException`, `SQLException`) |
| `Unchecked Exception` | Runtime’da çıkar, `try-catch` zorunlu değil                         |
| `throw`               | Exception fırlatır                                                  |
| `throws`              | Hata fırlatabileceğini belirtir                                     |
| `try-catch-finally`   | Hataları yakalar ve yönetir                                         |
| `finally`             | Her durumda çalışır                                                 |
| `try-with-resources`  | Otomatik kaynak kapatma sağlar                                      |

---



Harika bir soru Hamit Hocam. `switch-case` mi yoksa `if-else if` mi daha performanslıdır, konusu Java’da hem teorik hem pratik düzeyde önemlidir. Detaylı, karşılaştırmalı ve teknik olarak açıklayayım:

---

## ✅ 1. Temel Fark: `switch` vs `if-else if`

| Özellik                 | `switch-case`                                    | `if-else if`                                               |   |     |
| ----------------------- | ------------------------------------------------ | ---------------------------------------------------------- | - | --- |
| Kullanım Alanı          | Sabit değerler (`int`, `char`, `String`, `enum`) | Her türlü koşullu ifade (`boolean`, aralık, karşılaştırma) |   |     |
| Performans              | Genelde daha hızlı                               | Daha esnek ama biraz daha yavaş                            |   |     |
| Derleyici Optimizasyonu | `tableswitch` veya `lookupswitch` ile optimize   | Zincirleme `if` kontrolleri                                |   |     |
| Koşul Tipi              | Eşitlik karşılaştırması (`==`)                   | Her türlü mantıksal koşul (`<`, `>`, `&&`, \`              |   | \`) |
| Okunabilirlik           | Sabit eşleşmelerde temizdir                      | Karmaşık mantıkta daha uygundur                            |   |     |

---

## ⚙️ 2. JVM Seviyesinde Ne Oluyor?

### `switch-case`:

Derleyici `switch` yapısını şu iki bytecode komutuna dönüştürür:

| Komut          | Açıklama                                  |
| -------------- | ----------------------------------------- |
| `tableswitch`  | Ardışık sayılar için hızlı atlama tablosu |
| `lookupswitch` | Dağınık sayılar için binary search gibi   |

➡️ Bu, sabit sayı eşleşmelerinde **çok hızlı** çalışmasını sağlar.

### `if-else if`:

Java, her `if` bloğunu sırayla değerlendirir. Yani:

```java
if (a == 1) ...
else if (a == 2) ...
```

Bu durumda `a` her defasında `==` ile karşılaştırılır. Derleyici sıralı kontrol eder, **atlama optimizasyonu** yapılmaz.

---

## 🧪 3. Performans Testi: Basit Senaryo

```java
// Değişken
int value = 7;

// Switch-case
switch (value) {
    case 1: ... break;
    case 2: ... break;
    ...
    case 10: ... break;
}

// if-else if
if (value == 1) ...
else if (value == 2) ...
...
else if (value == 10) ...
```

### ⏱ Sonuç:

* `switch-case` daha **optimize** çalışır (özellikle 5+ case varsa).
* `if-else` daha **esnektir**, ama kontrol zinciri uzarsa **daha yavaştır.**

---

## 🔍 4. Ne Zaman Hangisi?

| Senaryo                                                           | Tercih Edilen                 |
| ----------------------------------------------------------------- | ----------------------------- |
| Sabit sayılar veya enum'lar varsa                                 | `switch-case` ✅               |
| Karşılaştırma, aralık, mantıksal işlem varsa (`x > 10 && x < 20`) | `if-else if` ✅                |
| 3’ten fazla sabit eşleşme varsa                                   | `switch-case` daha hızlıdır ✅ |
| Birden fazla koşul birleştiriliyorsa                              | `if-else` daha esnektir ✅     |

---

## 🧠 5. Örnek: Hız Kıyaslama (Teorik)

### `switch` (optimize bytecode):

```java
switch (n) {
    case 1 -> {...}
    case 2 -> {...}
    ...
    case 1000 -> {...}
}
```

➡️ JVM, `tableswitch` ile doğrudan n. index'e atlar. **O(1)** karmaşıklık.

### `if-else if`:

```java
if (n == 1) {...}
else if (n == 2) {...}
...
else if (n == 1000) {...}
```

➡️ JVM, sırayla kontrol eder. En kötü senaryoda **O(n)** çalışır.

---

## 📌 Özet

| Kriter        | switch-case                                         | if-else if                              |
| ------------- | --------------------------------------------------- | --------------------------------------- |
| Performans    | Daha iyi (özellikle 5+ sabit varsa) ✅               | Daha yavaş (sıralı kontrol)             |
| Okunabilirlik | Eşitlik durumlarında çok iyi ✅                      | Koşullar karmaşıksa daha okunaklı ✅     |
| Esneklik      | Sabitlerle sınırlı                                  | Tüm mantıksal karşılaştırmalar mümkün ✅ |
| Optimizasyon  | JVM optimize eder (`tableswitch`, `lookupswitch`) ✅ | Zincir halinde çalışır                  |

---

## 🧠 Son Tavsiye

* **Performans odaklıysanız ve sabit değerlerle çalışıyorsanız → `switch-case`**
* **Koşullar karmaşıksa veya değişken ifadelerle çalışıyorsanız → `if-else if`**

---

 JMH (Java Microbenchmark Harness) ile gerçek ölçümle kıyaslayan örnekler





