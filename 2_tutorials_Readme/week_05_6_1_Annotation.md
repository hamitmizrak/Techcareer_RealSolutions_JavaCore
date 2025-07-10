## Java Core Annotation
```sh 

```
---

Java'da **Annotation (Açıklama, Yorumlama)**, **kod üzerine meta bilgi (metadata)** eklememizi sağlayan bir yapıdır. Derleyiciye, derleme zamanı araçlarına veya çalışma zamanı (runtime) framework’lerine **o kod hakkında bilgi** verir. Kendi başına bir iş yapmaz, fakat ilgili araçlar tarafından işlenir.

---

## 📘 1. ANNOTATION NEDİR?

> Annotation, Java koduna iliştirilen bir tür etikettir. Sınıflara, metotlara, field’lara, parametrelere veya package’lara eklenebilir.

Java’daki en yaygın örnek:

```java
@Override
public String toString() {
    return "abc";
}
```

Yukarıdaki `@Override`, derleyiciye bu metodun bir **superclass’taki metodu override ettiğini** bildirir.

---

## 🧠 2. ANNOTATION NEDEN KULLANILIR?

| Kullanım Amacı                | Açıklama                                  |
| ----------------------------- | ----------------------------------------- |
| ✔️ Meta veri sağlama          | Kod hakkında bilgi ekler                  |
| ✔️ Derleyici uyarısı sağlama  | Eksik veya hatalı kullanımı tespit eder   |
| ✔️ Framework’lere bilgi verme | Spring, Hibernate gibi araçlara yön verir |
| ✔️ Otomatik işlem/üretim      | Kod üretimi (Lombok, JPA gibi)            |
| ✔️ Reflection ile işlem       | Runtime’da nesne tarama                   |

---

## 🏷️ 3. ANNOTATION TÜRLERİ

Java'da 3 temel annotation kategorisi vardır:

| Kategori                   | Açıklama                                                             |
| -------------------------- | -------------------------------------------------------------------- |
| 🔹 **Built-in (Yerleşik)** | Java'nın sağladığı (`@Override`, `@Deprecated`, `@SuppressWarnings`) |
| 🔹 **Custom (Özel)**       | Kullanıcının kendi yazdığı anotasyonlar                              |
| 🔹 **Framework Tabanlı**   | Spring, JPA, Lombok, Jakarta EE gibi framework’lerin sağladığı       |

---

## 🧪 4. JAVA’NIN YERLEŞİK (BUILT-IN) ANNOTATION'LARI

### ✅ `@Override`

```java
@Override
public String toString() {
    return "Data";
}
```

> Üst sınıftan gelen metodu ezdiğimizi belirtir. Hata varsa derleme hatası olur.

---

### ✅ `@Deprecated`

```java
@Deprecated
public void eskiMetot() {
    // kullanılmaması önerilir
}
```

> Metodun eski olduğunu gösterir. Yeni projelerde kullanılmaması önerilir.

---

### ✅ `@SuppressWarnings`

```java
@SuppressWarnings("unchecked")
List liste = new ArrayList();
```

> Derleyicinin belirli uyarılarını bastırmak için kullanılır.

---

## 🔧 5. CUSTOM ANNOTATION NASIL YAZILIR?

### a) Basit bir annotation:

```java
@interface Hamit {
}
```

### b) Değer içeren bir annotation:

```java
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value();
    int count() default 1;
}
```

### Kullanımı:

```java
@MyAnnotation(value = "Örnek", count = 5)
public void myMethod() {
}
```

---

## 🔬 6. ANNOTATION BİLEŞENLERİ (PARAMETRELER)

| Bileşen       | Açıklama                                                                          |
| ------------- | --------------------------------------------------------------------------------- |
| `@Target`     | Annotation’ın nerede kullanılabileceğini belirler (class, method, field...)       |
| `@Retention`  | Annotation'ın ne zamana kadar geçerli olacağını belirtir (SOURCE, CLASS, RUNTIME) |
| `@Documented` | Javadoc içine dahil edilmesini sağlar                                             |
| `@Inherited`  | Annotation’ın alt sınıflara miras kalmasını sağlar                                |

### Örnek:

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Example {}
```

---

## 🧭 7. `@Target` ve `@Retention` DETAYI

### 🔸 `@Target` (Kullanım alanı):

```java
@Target({
    ElementType.TYPE,       // class, interface
    ElementType.FIELD,      // field
    ElementType.METHOD,     // method
    ElementType.PARAMETER   // parametre
})
```

### 🔸 `@Retention` (Yaşam süresi):

```java
@Retention(RetentionPolicy.SOURCE)  // derleyiciye kadar
@Retention(RetentionPolicy.CLASS)   // JVM'e kadar (default)
@Retention(RetentionPolicy.RUNTIME) // çalışma zamanı (reflection ile erişilebilir)
```

---

## 🧩 8. REFLECTION İLE ANNOTATION OKUMA

```java
Method method = MyClass.class.getMethod("myMethod");
MyAnnotation ann = method.getAnnotation(MyAnnotation.class);
System.out.println(ann.value());  // -> "Örnek"
```

---

## 💠 9. SPRING VE FRAMEWORK ANNOTATION ÖRNEKLERİ

| Annotation         | Framework | Görev                                  |
| ------------------ | --------- | -------------------------------------- |
| `@RestController`  | Spring    | Controller sınıfı                      |
| `@Autowired`       | Spring    | Bağımlılık enjeksiyonu                 |
| `@Entity`          | JPA       | DB tablosu tanımı                      |
| `@Table(name="X")` | JPA       | Tablo ismi belirtme                    |
| `@Builder`         | Lombok    | Builder deseni                         |
| `@Data`            | Lombok    | Getter/Setter/ToString otomatik üretir |

---

## 📚 10. ANNOTATION VS COMMENT

| Özellik            | Annotation | Comment      |
| ------------------ | ---------- | ------------ |
| İşlem yapılır      | ✅ Evet     | ❌ Hayır      |
| Meta veri mi?      | ✅ Evet     | ❌ Değil      |
| Kodda aktif etkisi | ✅ Evet     | ❌ Sadece not |
| Derleyici etkisi   | ✅ Olabilir | ❌ Yok        |

---

## 📌 ÖZET

| Özellik            | Açıklama                                       |
| ------------------ | ---------------------------------------------- |
| Annotation nedir?  | Kod hakkında bilgi sağlayan özel etiketlerdir  |
| Java'da türü       | Built-in, Custom, Framework                    |
| Nerede kullanılır? | Class, method, field, parametre vs.            |
| Hangi amaçla?      | Uyarı, işlem yönlendirme, dependency injection |
| Ne işe yaramaz?    | İçerik işlemek, akış yönetimi (doğrudan)       |

---
