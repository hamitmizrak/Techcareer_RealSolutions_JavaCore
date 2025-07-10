## Java Core (Java 8 – @FunctionalInterface )
```sh 

```
---

Java 8 – Functional Interface Nedir?
📌 1. Tanım (Nedir?)
Java 8 ile gelen Functional Interface (Fonksiyonel Arayüz), yalnızca bir adet abstract method içeren, ancak istediğimiz kadar default ve static method barındırabilen özel bir interface türüdür.

Java 8 ile birlikte gelen lambda expression ve method reference yapılarını kullanabilmemizin temelini bu interface'ler oluşturur.

📌 2. Kurallar (Temel Özellikleri)
Özellik	Açıklama
Tek abstract method	Sadece 1 tane abstract method içermelidir. (@FunctionalInterface)
default/static method olabilir	İstediğiniz kadar default veya static method ekleyebilirsiniz.
Anotasyon kullanımı	@FunctionalInterface kullanmak önerilir ancak zorunlu değildir.
Java'daki örnek interface'ler	Runnable, Callable, Comparator, Predicate, Function, Consumer, Supplier

📌 3. @FunctionalInterface Anotasyonu Neden Kullanılır?
Bu anotasyon derleyiciye bu interface'in "sadece bir tane abstract method içermesi gerektiğini" belirtir.
Avantajı:
Yanlışlıkla ikinci bir abstract method eklerseniz derleme zamanı hatası alırsınız.
Interface’in gerçekten lambda için kullanılabileceğini garanti altına alır.

📌 4. Neden Java 8 ile Geldi?
Java 8 ile gelen lambda expressions, Java'yı daha fonksiyonel programlama paradigmalarına yaklaştırdı. Ancak Java'nın OOP yapısı içinde fonksiyonları doğrudan parametre olarak geçmek mümkün değildi. Bu ihtiyacı karşılamak için fonksiyonel interface’ler tanımlandı.
// Fonksiyonel arayüz sayesinde şu yapılabilir:
doSomething(() -> System.out.println("Merhaba"));

public static void doSomething(Runnable runnable) {
runnable.run();
}
📌 5. Lambda ile İlişkisi Nedir?
Lambda ifadeleri, anonim sınıf yazmadan fonksiyonel interface’in abstract method’unu override etmemizi sağlar.

Örnek:
@FunctionalInterface
interface MyFunctionalInterface {
void print(String message);
}

// Kullanımı
MyFunctionalInterface mf = (msg) -> System.out.println("Mesaj: " + msg);
mf.print("Merhaba Dünya");
✅ ÖRNEK: Kendi Fonksiyonel Interface'imizi Tanıyalım
1️⃣ Fonksiyonel Interface Tanımı:
@FunctionalInterface
public interface MatematikIslem {
int islemYap(int a, int b);
    // Bu default method'dur, sayılır ama abstract değildir!
    default void bilgi() {
        System.out.println("Bu bir matematik işlemi yapar.");
    }

    // Static method olabilir
    static void genelBilgi() {
        System.out.println("Toplama, çıkarma gibi işlemler...");
    }
}

2️⃣ Lambda Expression ile Kullanımı:
public class FonksiyonelInterfaceTest {
public static void main(String[] args) {

        // Toplama işlemi
        MatematikIslem toplama = (a, b) -> a + b;
        System.out.println("Toplama: " + toplama.islemYap(10, 5)); // 15

        // Çıkarma işlemi
        MatematikIslem cikarma = (a, b) -> a - b;
        System.out.println("Çıkarma: " + cikarma.islemYap(10, 5)); // 5

        // Çarpma işlemi
        MatematikIslem carpma = (a, b) -> a * b;
        System.out.println("Çarpma: " + carpma.islemYap(10, 5)); // 50

        // Default method çağırımı
        carpma.bilgi();

        // Static method çağırımı
        MatematikIslem.genelBilgi();
    }
}
📌 Java'da Hazır Functional Interface'ler (java.util.function paketi)
Interface	Açıklama
Function<T,R>	T tipinde input alır, R tipinde sonuç döner (apply metodu).
Predicate<T>	T tipinde input alır, true/false döner (test metodu).
Consumer<T>	T tipinde input alır, sonuç döndürmez (accept metodu).
Supplier<T>	Parametre almaz, T tipinde sonuç döndürür (get metodu).
UnaryOperator<T>	T → T dönüşüm işlemi
BinaryOperator<T>	T, T → T dönüşüm işlemi

📌 Gerçek Dünya Kullanım Senaryosu
import java.util.function.Predicate;

public class PredicateExample {
public static void main(String[] args) {
Predicate<String> kontrol = (str) -> str.length() > 5;

        System.out.println(kontrol.test("Java"));       // false
        System.out.println(kontrol.test("Fonksiyonel")); // true
    }
}
Özetle
@FunctionalInterface ile tanımlanan interface’ler lambda ile uyumludur.

Java'da fonksiyonları parametre olarak taşımanın tek yoludur.

Kendi interface’lerinizi yazabileceğiniz gibi, java.util.function paketindeki hazır fonksiyonel interface’leri de kullanabilirsiniz.