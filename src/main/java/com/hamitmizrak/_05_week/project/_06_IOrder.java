package com.hamitmizrak._05_week.project;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface _06_IOrder {

    // 1 - Toplam fiyat hesaplaması (Seri)
    public double getSeriTotalAmount();

    // 2 - Toplam fiyat hesaplaması (Paralelleştirme)
    public double getParallelTotalAmount();

    // 3 - Tüm ürünlerin adlarını liste olarak dönsün
    public List<String> getProductNameList();

    // 4 - Belirli fiyat üstü ürünleri lsitelesin
    public List<_05_ProductDto> getProductsMoreThan(double price);

    // 5 - Ortalama ürün fiyatını hesapla
    public OptionalDouble getAveragePrice();

    // 6- En pahalı ürünü dönder
    public Optional<_05_ProductDto> getMostExpensiveProduct();

    // 7- Tüm ürünlerimiz aynı isimle mi yazılmış
    public boolean isSameProductsName(String name);

    // 8- En az bir ünüde belirli isimde mi?
    public boolean containsProductNamed(String name);

    // 9- Bütün ürünlerden Ücretsiz ürün var mı ?
    public boolean nonIsPriveFree();

}
