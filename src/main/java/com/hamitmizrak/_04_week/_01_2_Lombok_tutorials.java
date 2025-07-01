package com.hamitmizrak._04_week;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;


// LOMBOK
@Getter
@Setter
@RequiredArgsConstructor // Injection : Constructor
@ToString
@EqualsAndHashCode

//@Data =  // ===> @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
//@Getter
//@Setter
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode

@NoArgsConstructor  // ===> Parametresiz constructor
@AllArgsConstructor // ===> Tüm field’ları içeren constructor
@Builder  // Builder parametreli constructor eklemek zorundayız.
//@Log4j
//@Log4j2
//@Slf4j // ===> log.info(...) gibi kullanmak için

@FieldDefaults(level = AccessLevel.PRIVATE) // ===> Tüm alanları private yapar
// @SneakyThrows //
@Accessors(chain = true, fluent = false) // ===> setName(...).setEmail(...) zincirleme setter
public class _01_2_Lombok_tutorials {

    // Field
    @NonNull
    String name;
    @NonNull
    String surname;
    @NonNull
    Long number;

    @NonNull
    String email;

    final LocalDate createdDate = LocalDate.now(); // ===> final alanlar immutable olur

    // Default için: 1.şart Builder 2.Builder'de parametreli constructor
    @Builder.Default
    private boolean isLogin = true;

    // PSVM
    public static void main(String[] args) {
        _01_2_Lombok_tutorials tutorials = _01_2_Lombok_tutorials
                .builder()
                .name("adı")
                .surname("soyadı")
                .number(44L)
                .email("deneme@mail")
                .build();
        System.out.println(tutorials);

        // @Accessors
        tutorials.setName("adı22").setSurname("soyadı22").setNumber(55L).setEmail("hamitmizrak@gmail.com");
        System.out.println(tutorials);

        // 7. Final
        System.out.println("Oluşturulma Tarihi: " + tutorials.getCreatedDate());
    }
}
