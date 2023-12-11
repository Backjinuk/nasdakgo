package com.example.nasdak.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LedgerToTotal {

    @Id @GeneratedValue
    @Column(name = "ggb_collection_no")
    private long ggbCollectionNo;

    @ManyToOne
    @JoinColumn(name = "ggb_no")
    private Ledger ledger;

    @ManyToOne
    @JoinColumn(name = "collection_no")
    private Collection collection;
}
