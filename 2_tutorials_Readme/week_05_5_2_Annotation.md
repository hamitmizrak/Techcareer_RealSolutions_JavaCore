## Java Core Annotation
```sh 

```
---

Java’da **annotation (açıklama/etiket)**, kod üzerinde **meta bilgi (metadata)** tutmak için kullanılan bir yapıdır. Derleyiciye, derleme zamanı araçlarına, çalışma zamanındaki frameworklere bilgi sağlar. Annotation’lar doğrudan kodun anlamını değiştirmez ama **Java Reflection API** veya özel araçlar tarafından işlenerek belirli davranışların uygulanmasını sağlar.

---

## 🔍 1. Annotation Nedir?

* Annotation’lar `@` sembolüyle başlar.
* Sınıf, metot, alan (field), parametre gibi kod bloklarına eklenebilir.
* Javadoc gibi dokümantasyon araçları, derleyici uyarıları, runtime işlemler veya framework davranışları için kullanılır.

```java
@Override
public String toString() {
    return "Merhaba";
}
```

---

## 🧠 2. Annotation Ne Değildir?

* Annotation bir yorum satırı değildir.
* Annotation doğrudan bir kod bloğunu çalıştırmaz.
* Ancak işleyici (örneğin Spring framework’ü veya kendi yazdığınız bir `Annotation Processor`) tarafından yorumlanarak çalıştırılabilir.

---

## 🧱 3. Annotation Türleri

### A. Java Built-in (Hazır Gelen) Annotation’lar

#### @Override

Bir metot, süper sınıftaki metodu override ediyorsa kullanılır. Derleyici bu metodun doğru override edildiğini doğrular.

```java
@Override
public String toString() {
    return "Merhaba";
}
```

#### @Deprecated

Bu öğe (sınıf, metot vs.) artık kullanılmamalı. Alternatif bir yapı öneriliyorsa ona geçilmelidir.

```java
@Deprecated
public void eskiYontem() {
    // yeni metotla değiştirilmeli
}
```

#### @SuppressWarnings

Derleyicinin verdiği uyarıları bastırmak için kullanılır.

```java
@SuppressWarnings("unchecked")
List liste = new ArrayList(); // Raw type uyarısı bastırılır
```

#### @FunctionalInterface

Bu interface yalnızca **bir tane abstract metot** içerebilir. Lambda expression ile kullanılmak üzere tanımlanır.

```java
@FunctionalInterface
interface Hesapla {
    int islem(int a, int b);
}
```

---

### B. Meta-Annotation (Annotation üstü Annotation’lar)

Meta-annotation'lar, başka annotation’ları tanımlamak için kullanılır:

* `@Retention`
* `@Target`
* `@Documented`
* `@Inherited`
* `@Repeatable`

#### @Retention

Annotation’ın hangi aşamaya kadar korunacağını belirtir.

```java
@Retention(RetentionPolicy.RUNTIME)
```

3 türü vardır:

* `SOURCE`: Sadece kaynak kodda kalır, derlemeyle silinir.
* `CLASS`: Derlenir ama çalışırken erişilemez (default).
* `RUNTIME`: Hem derlenir hem runtime’da kullanılabilir (**Reflection** ile).

#### @Target

Annotation'ın hangi öğelere uygulanabileceğini belirtir.

```java
@Target(ElementType.METHOD)
```

Bazı `ElementType` türleri:

* TYPE (class, interface, enum)
* FIELD
* METHOD
* PARAMETER
* CONSTRUCTOR
* LOCAL\_VARIABLE
* ANNOTATION\_TYPE

#### @Inherited

Annotation'ın alt sınıflar tarafından devralınmasını sağlar (sadece class’lar için geçerli).

#### @Documented

Javadoc oluşturulurken annotation'ın da dokümana eklenmesini sağlar.

---

## 🔨 4. Kendi Annotation’ını Yazmak

Örnek: Bir metodun loglanması gerektiğini göstermek için özel bir annotation oluşturalım:

### Annotation Tanımı

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loglanabilir {
    String value() default "varsayılan";
}
```

### Kullanımı

```java
public class IslemSinifi {

    @Loglanabilir("Veritabanı işlemi")
    public void veriEkle() {
        System.out.println("Veri eklendi.");
    }
}
```

### Reflection ile İşleme

```java
import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = IslemSinifi.class;
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Loglanabilir.class)) {
                Loglanabilir annotation = method.getAnnotation(Loglanabilir.class);
                System.out.println("Loglanacak: " + method.getName() + ", Açıklama: " + annotation.value());
            }
        }
    }
}
```

---

## 🧪 5. Gerçek Hayattan Kullanım Örnekleri

### ✅ Spring Boot

```java
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
}
```

Buradaki `@RestController`, `@GetMapping` gibi annotation’lar Spring tarafından yorumlanır.

### ✅ JPA (Hibernate)

```java
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;
}
```

ORM ile ilişkili nesne veritabanına bağlanmak için annotation’lar kullanır.

---

## 📘 6. Annotation ile AOP (Aspect Oriented Programming)

```java
@LogExecutionTime
public void işlemYap() {
   // bu metot çalıştığında otomatik olarak loglanır
}
```

`@LogExecutionTime` anotasyonu, Spring AOP ile bir metot öncesinde/süresince/sonrasında işlem yapmanı sağlar (örneğin zaman ölçme).

---

## 🧮 7. Annotation ile Validasyon

```java
public class KullaniciDTO {

    @NotNull
    @Size(min = 3, max = 50)
    private String isim;

    @Email
    private String email;
}
```

Bu örnekte Bean Validation (JSR-380) annotation’ları, veri girişlerinde doğrulama sağlar.

---

## 🧩 8. Annotation ile Builder, DTO, Lombok Kullanımı

```java
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KisiDTO {
    private String isim;
    private String soyisim;
}
```

Lombok annotation’ları otomatik olarak getter/setter, constructor, toString gibi metotları üretir.

---

## 🎯 Özet

| Annotation          | Amaç                                                  |
| ------------------- | ----------------------------------------------------- |
| `@Override`         | Override edilen metodu belirtir                       |
| `@Deprecated`       | Kullanımdan kaldırıldığını belirtir                   |
| `@SuppressWarnings` | Derleyici uyarılarını bastırır                        |
| `@Retention`        | Annotation’ın yaşam süresini belirler                 |
| `@Target`           | Annotation hangi öğelere uygulanabilir                |
| `@Inherited`        | Alt sınıfa annotation mirası verir                    |
| `@Custom`           | Kendi özel annotation'ınızı tanımlar ve kullanırsınız |

---



## Java Core Annotation tabanlı bir validasyon
```sh 

```
---
Java'da **annotation tabanlı validasyon sistemi**, kullanıcıdan gelen verilerin doğruluğunu `@NotNull`, `@Email`, `@Size` gibi **anlamlı, okunabilir annotation’larla** kontrol etmeyi sağlar. Bu sistem özellikle DTO'larda (Data Transfer Object) ve Form işleme süreçlerinde önemlidir.

Burada adım adım:

* Custom validation annotation oluşturacağız
* Annotation’a özel bir `Validator` sınıfı tanımlayacağız
* Spring Boot uygulamasında bu validator’ü aktif kullanacağız

---

## 🔧 Senaryo

Kullanıcı kayıt formu var. `username` alanı:

* Boş olamaz
* En az 5 karakter içermeli
* Ve `@UsernameAvailable` adında **özel bir annotation** ile veritabanında daha önce kayıtlı olup olmadığını kontrol etmeliyiz.

---

## ✅ 1. Bağımlılıklar (`pom.xml`)

```xml
<dependency>
    <groupId>jakarta.validation</groupId>
    <artifactId>jakarta.validation-api</artifactId>
</dependency>

<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
</dependency>
```

Spring Boot kullanıyorsanız zaten starter'larda bunlar vardır.

---

## 🧱 2. DTO Oluştur (Kullanıcı Girdisi)

```java
public class RegisterRequest {

    @NotNull(message = "Kullanıcı adı boş olamaz.")
    @Size(min = 5, message = "Kullanıcı adı en az 5 karakter olmalı.")
    @UsernameAvailable // ÖZEL ANNOTATION
    private String username;

    @NotNull(message = "Email boş olamaz.")
    @Email(message = "Geçersiz email formatı.")
    private String email;

    @NotNull
    @Size(min = 6, message = "Şifre en az 6 karakter olmalı.")
    private String password;

    // getter-setter
}
```

---

## 🏷️ 3. Custom Annotation Oluştur (`@UsernameAvailable`)

```java
@Documented
@Constraint(validatedBy = UsernameAvailableValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameAvailable {

    String message() default "Bu kullanıcı adı zaten mevcut.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
```

> `@Constraint` ⇒ Hangi class’ın bu anotasyonu işleyeceğini belirtir.

---

## 🔍 4. Annotation'ı İşleyecek Validator Sınıfı

```java
public class UsernameAvailableValidator implements ConstraintValidator<UsernameAvailable, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UsernameAvailable constraintAnnotation) {
        // Gerekirse annotation parametrelerini burada alabiliriz.
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null) return false;
        return !userRepository.existsByUsername(username); // false dönerse validasyon başarısız
    }
}
```

> Spring Boot'ta `@Autowired` çalışması için bu sınıf `@Component` veya `@Service` ile işaretlenmelidir.

---

## 🧭 5. Repository (Simülasyon Amaçlı)

```java
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
}
```

---

## 📤 6. Controller Katmanı

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        // Validasyon başarılı ise buraya gelir
        return ResponseEntity.ok("Kayıt başarılı: " + request.getUsername());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
          .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}
```

---

## 🔁 7. Validasyon Akışı

| Alan       | Annotation           | Kontrol               |
| ---------- | -------------------- | --------------------- |
| `username` | `@NotNull`           | Null değil            |
|            | `@Size(min=5)`       | En az 5 karakter      |
|            | `@UsernameAvailable` | Veritabanında var mı? |
| `email`    | `@Email`             | Format kontrolü       |
| `password` | `@Size(min=6)`       | Uzunluk kontrolü      |

---

## 🎯 Gelişmiş: Parametreli Annotation

Annotation içine parametre verebilirsin:

```java
@Min(value = 18, message = "Yaşınız en az 18 olmalı.")
private int age;
```

Aynı şekilde custom annotation'lara da parametre verebiliriz:

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BlacklistValidator.class)
public @interface NotBlacklisted {
    String[] blacklist() default {};
    String message() default "Bu değer yasaklı listede.";
}
```

---

## 📘 Özet

Annotation tabanlı validasyon sistemi şunları sağlar:

* Anlamlı ve okunabilir DTO’lar
* Framework destekli hatasız kullanıcı verisi kontrolü
* Custom davranışlarla esnek mimari

---

