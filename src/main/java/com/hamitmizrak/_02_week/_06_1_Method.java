package com.hamitmizrak._02_week;

/**
 Access Modifier(Erişim belirleyiciler) public, private, default, protected çağırırken performansı nasıl etkiler ?

 Java derleyiciler(Javac) kaynak kodu derlerken erişim belirleyicilerin derlenmesinde bytecode içinde metadata olarak eklendiğinden JVM bu metodun yada alanın kontroluünü sağlar.
 Bundan dolayı:  JVM doğrudan çağırıyor (invokevirtual)
 Ancak Reflection(Yansımda) kullanan private erişimiden performans metriğinden değişim söz konusudur.


 Erişim belirleticin çağrılmasında çağrı hızınını etkilemez ancak instance oluşturulduğundan dolayı (constructor default değerlerin) yüklenmesinden dolayı bir miktar performans kaybı yaşamabilir.
  */

public class _06_1_Method {

    // 1-) Parametresiz Returnsuz
    public void parametresizReturnsuz() {
        System.out.println("1- parametresiz Returnsuz");
    }

    // 2-) Parametreli Returnsuz
    public void parametreliReturnsuz(String name) {
        System.out.println("2- parametreli Returnsuz " + name);
    }

    // 3-) Parametresiz Returnlu
    public String parametresizReturnlu() {
        return "3- parametresizReturnlu";
    }

    // 4-) Parametreli Returnlu
    public String parametreliReturnlu(String name, String surname) {
        return "4- ADI: " + name + " SOYADI: " + surname;
    }

    // Overloading (Aşırı Yükleme)
    public String parametreliReturnlu(String name, String surname,int number) {
        return "5- ADI: " + name + " SOYADI: " + surname+" NUMARA: "+number;
    }

    // PSVM
    public static void main(String[] args) {
        // Instance
        _06_1_Method method = new _06_1_Method();

        // 1-) Parametresiz Returnsuz
        method.parametresizReturnsuz();

        // 2-) Parametreli Returnsuz
        method.parametreliReturnsuz("Hamit"); // Argüman

        // 3-) Parametresiz Returnlu
        String result3 = method.parametresizReturnlu();
        System.out.println(result3);

        // 4-) Parametreli Returnlu
        String result4 = method.parametreliReturnlu("Hamit", "Mızrak");
        System.out.println(result4);

        // Overloading
        String result5 = method.parametreliReturnlu("Hamit", "Mızrak",44);
        System.out.println(result5);

    }
}
