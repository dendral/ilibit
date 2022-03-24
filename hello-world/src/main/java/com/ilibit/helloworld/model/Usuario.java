package com.ilibit.helloworld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String name;
    private String lastname;
    private Integer age;
    private List<String> hobbies;

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
