package com.example.baedal.domain;

import com.example.baedal.shared.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Store extends Timestamped{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "store",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Item> items = new ArrayList<>();
}
