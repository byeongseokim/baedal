package com.example.baedal.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersId;

    //@JsonBackReference
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name="member_Id", nullable = false)
    private Member member;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "orders",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderHasItem> orderHasItems;


}
