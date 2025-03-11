package com.tk.SpringSecurity;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data // Includes:
// @Getter and @Setter
// @ToString
// @EqualsAndHashCode
// @RequiredArgsConstructor (constructor for final fields)
public class Student {
    private Integer id;
    private String name;
    private Integer marks;

}
