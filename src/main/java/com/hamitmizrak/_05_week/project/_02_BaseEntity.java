package com.hamitmizrak._05_week.project;

import java.util.Date;

// ==> Bu abstract Classı Tüm Entity'ler için ortak bir sınıftır
// ==> Ortak özellikler ve davranışlar içeren bu soyut(abstract) sınıfıdır.
// ==> Diğer entitler bu sınıfı kalıtımlayacaktır ve buradaki ortak davranışa sahip olacaklardır.
abstract public class _02_BaseEntity {
    protected final Long id;
    protected final Date creatAt;

    // Parametresiz Constructor
    public _02_BaseEntity() {
        // Default
        id = System.currentTimeMillis();
        creatAt= new Date();
    }

    // METHOD (Gövdesiz)
    public abstract String getLogInfo();

    // GETTER AND SETTER
    public Long getId() {
        return id;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    // Test
        /***
            public static void main(String[] args) {
                _01_BaseEntity baseEntity = new _01_BaseEntity() {
                    @Override
                    public String getLogInfo() {
                        return "";
                    }
                };
                System.out.println(baseEntity.getId());
                System.out.println(baseEntity.getCreatAt());
            }
        */

}
