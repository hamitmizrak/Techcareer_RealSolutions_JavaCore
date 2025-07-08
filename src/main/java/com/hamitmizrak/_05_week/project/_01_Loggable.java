package com.hamitmizrak._05_week.project;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Sınıflar üzerinden kullanmak
@Retention(RetentionPolicy.RUNTIME) // Çalışma zamanında erişmek
public @interface _01_Loggable {
    String value() default "General Class";
}
