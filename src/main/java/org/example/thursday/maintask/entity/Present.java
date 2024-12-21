package org.example.thursday.maintask.entity;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class Present {
    private String name;
    private String description;
}