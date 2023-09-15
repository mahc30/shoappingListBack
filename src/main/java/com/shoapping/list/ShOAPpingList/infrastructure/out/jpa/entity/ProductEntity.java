package com.shoapping.list.ShOAPpingList.infrastructure.out.jpa.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String note;
    private int price;
}
