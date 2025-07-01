## Java Core File
```sh 

```
---

Java’da `File` sınıfı, dosya ve dizinlerle etkileşim kurmak için kullanılan temel sınıflardan biridir. `java.io` paketinde yer alır ve **fiziksel dosya sistemindeki bir dosya ya da klasörü temsil eder**, yani içeriği değil, **yolunu (path)** ve özelliklerini temsil eder.
Aşağıda Java’daki `File` kavramını **çok detaylı ve örneklerle** sistematik şekilde açıklıyorum:

---

## 📘 1. `File` Sınıfı Nedir?

* `java.io.File`, bir **dosya** ya da **dizin** için **soyut bir temsil** sağlar.
* Bu sınıfın nesnesi, aslında dosyanın **içeriğini değil**, dosyanın **yolunu, var olup olmadığını, okunabilirliğini, yazılabilirliğini vs.** temsil eder.
* Gerçek dosya işlemleri (okuma, yazma) için `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`, `Scanner`, `Files` gibi sınıflar kullanılır.

---

## ⚙️ 2. `File` Nesnesi Nasıl Oluşturulur?

### a) Göreli (relative) path ile:

```java
File file = new File("dosyalar/veri.txt");
```

### b) Mutlak (absolute) path ile:

```java
File file = new File("C:/kullanicilar/hamit/dosya.txt");
```

### c) Dizin belirtme:

```java
File klasor = new File("veriler");
```

---

## 🛠️ 3. ÖNEMLİ `File` METOTLARI VE KULLANIMLARI

| Metot                        | Açıklama                    |
| ---------------------------- | --------------------------- |
| `exists()`                   | Dosya veya dizin var mı?    |
| `createNewFile()`            | Dosya oluşturur             |
| `mkdir()` / `mkdirs()`       | Dizin oluşturur             |
| `delete()`                   | Dosya/silme                 |
| `getName()`                  | Sadece dosya adı            |
| `getPath()`                  | Belirtilen yol              |
| `getAbsolutePath()`          | Tam yol                     |
| `length()`                   | Dosya boyutu (byte)         |
| `canRead()` / `canWrite()`   | Okunabilir/yazılabilir mi?  |
| `isDirectory()` / `isFile()` | Dosya mı klasör mü?         |
| `list()`                     | Dizin altındakileri listele |

---

## 📦 4. DOSYA OLUŞTURMA ÖRNEĞİ

```java
import java.io.File;
import java.io.IOException;

public class FileOrnegi {
    public static void main(String[] args) {
        try {
            File file = new File("ornek.txt");
            if (file.createNewFile()) {
                System.out.println("Dosya oluşturuldu: " + file.getName());
            } else {
                System.out.println("Dosya zaten var.");
            }
        } catch (IOException e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }
}
```

---

## 🧹 5. DOSYA SİLME

```java
File file = new File("ornek.txt");
if (file.delete()) {
    System.out.println("Dosya silindi.");
} else {
    System.out.println("Dosya silinemedi.");
}
```

---

## 📂 6. DİZİN OLUŞTURMA

### Tek klasör:

```java
File klasor = new File("veriler");
klasor.mkdir();
```

### Alt klasörleri ile:

```java
File altKlasor = new File("veriler/raporlar/2025");
altKlasor.mkdirs(); // ara dizinleri de oluşturur
```

---

## 🧾 7. DOSYA VEYA KLASÖRÜN VARLIĞINI KONTROL ETME

```java
File dosya = new File("test.txt");
if (dosya.exists()) {
    System.out.println("Dosya var.");
} else {
    System.out.println("Dosya yok.");
}
```

---

## 📃 8. DİZİNDEKİ TÜM DOSYALARI LİSTELEME

```java
File dizin = new File("veriler");
String[] dosyalar = dizin.list();

for (String dosyaAdi : dosyalar) {
    System.out.println(dosyaAdi);
}
```

---

## 🔐 9. OKUMA/YAZMA İZİNLERİNİ KONTROL ETME

```java
File dosya = new File("example.txt");

System.out.println("Okunabilir mi? " + dosya.canRead());
System.out.println("Yazılabilir mi? " + dosya.canWrite());
```

---

## 📏 10. DOSYA BOYUTUNU ÖLÇME

```java
File file = new File("example.txt");
System.out.println("Boyut: " + file.length() + " byte");
```

---

## ❗ 11. DİKKAT EDİLMESİ GEREKENLER

| Durum                                         | Açıklama                                              |
| --------------------------------------------- | ----------------------------------------------------- |
| `createNewFile()` → Fiziksel dosya oluşturur  | Evet                                                  |
| `new File()` → Sadece dosya nesnesi oluşturur | Evet                                                  |
| `File` sadece yol bilgisidir                  | İçerik yönetimi başka sınıflar ile yapılır            |
| Platform farkı                                | Windows ve Linux dosya yolları farklıdır (`\` vs `/`) |

---

## 🔄 12. `File` vs `Path` vs `Files` Farkı (Java 7+)

| Sınıf   | Açıklama                                                |
| ------- | ------------------------------------------------------- |
| `File`  | Geleneksel dosya sınıfı (`java.io`)                     |
| `Path`  | Modern yol soyutlaması (`java.nio.file.Path`)           |
| `Files` | Statik yardımcı metotlar içerir (`java.nio.file.Files`) |

### Örnek:

```java
Path path = Paths.get("dosyalar/veri.txt");
Files.createFile(path);
```

---

## 🧩 13. UYGULAMA: DOSYA OLUŞTUR, BİLGİLERİNİ YAZDIR

```java
File file = new File("deneme.txt");

if (!file.exists()) {
    file.createNewFile();
}

System.out.println("Adı: " + file.getName());
System.out.println("Yolu: " + file.getAbsolutePath());
System.out.println("Boyut: " + file.length());
System.out.println("Klasör mü? " + file.isDirectory());
System.out.println("Var mı? " + file.exists());
```

---

## 🧠 SONUÇ

| Özellik           | Açıklama                                                 |
| ----------------- | -------------------------------------------------------- |
| Amaç              | Dosya ve klasörlerle ilgili temel işlemleri yapmak       |
| Paket             | `java.io.File`                                           |
| Sorumluluk        | Dosya yolu, varlık kontrolü, oluşturma, silme            |
| İçerik yönetimi   | `FileReader`, `Scanner`, `Files` gibi sınıflarla yapılır |
| Modern alternatif | `java.nio.file.Path`, `Files` (Java 7+)                  |

---