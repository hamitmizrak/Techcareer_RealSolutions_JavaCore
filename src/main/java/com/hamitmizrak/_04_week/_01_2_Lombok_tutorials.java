package com.hamitmizrak._04_week;

import lombok.*;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;


// LOMBOK
@Getter
@Setter
@RequiredArgsConstructor // Injection : Constructor
@ToString
@EqualsAndHashCode
//@Data = Aşağıdakileri yerine geçiyor.
//@Getter
//@Setter
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode

@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Log4j
//@Log4j2
public class _01_2_Lombok_tutorials {

    // Field
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private Long number;

    public static void main(String[] args) {
        _01_2_Lombok_tutorials tutorials=  _01_2_Lombok_tutorials
                .builder()
                    .name("adı").surname("soyadı").number(44L)
                .build();

        System.out.println(tutorials);
    }
}
