package com.hamitmizrak._04_week;

import lombok.*;
import lombok.experimental.FieldDefaults;


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
@Builder  // Builder parametreli constructor eklemek zorundayız.
//@Log4j
//@Log4j2

@FieldDefaults(level = AccessLevel.PRIVATE) // Erişim belirleyeiclerden hepsini private yap
// @SneakyThrows //
public class _01_2_Lombok_tutorials {

    // Field
    @NonNull String name;
    @NonNull String surname;
    @NonNull Long number;

    // Default için: 1.şart Builder 2.Builder'de parametreli constructor
    @Builder.Default
    private boolean isLogin=true;

    // PSVM
    public static void main(String[] args) {
        _01_2_Lombok_tutorials tutorials=  _01_2_Lombok_tutorials
                .builder()
                    .name("adı").surname("soyadı").number(44L)
                .build();

        //
        System.out.println(tutorials);
    }
}
