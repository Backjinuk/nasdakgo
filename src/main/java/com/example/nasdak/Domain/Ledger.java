package com.example.nasdak.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Ledger extends FileManager {

//    @Id @GeneratedValue
//    @Column(name = "ggb_no")
//    private long ggbNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "category_no")
    private Category category;

    private long price;

    private long dw;
    private String location;

    private String comment;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

}
