package com.hamitmizrak.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// LOMBOK
@Getter
@Setter
@AllArgsConstructor

// ==> Bu abstract Classı Tüm Entity'ler için ortak bir sınıftır
// ==> Ortak özellikler ve davranışlar içeren bu soyut(abstract) sınıfıdır.
// ==> Diğer entitler bu sınıfı kalıtımlayacaktır ve buradaki ortak davranışa sahip olacaklardır.
abstract public class BaseDto {

    // Field
    protected Long id;
    protected Date creatAt;

    // Parametresiz Constructor
    public BaseDto() {
        // Default
        id = System.currentTimeMillis();
        creatAt= new Date();
    }

    // Parametreli Constuctor
    public BaseDto(Long id) {
        this.id = id;
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

} // end
