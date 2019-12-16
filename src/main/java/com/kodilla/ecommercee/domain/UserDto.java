package com.kodilla.ecommercee.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private boolean isBlocked;
}