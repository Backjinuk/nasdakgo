package com.example.nasdak.Repository;

import com.example.nasdak.Domain.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface LedgerRepository extends JpaRepository<Ledger, Long> {


    @Transactional
    @Modifying
    @Query(value =
            "UPDATE Ledger l " +
            "SET l.comment= :comment ," +
                "l.dw= :dw ," +
                "l.location= :location," +
                "l.price= :price " +
            "WHERE l.file_manager_no= :fileManagerNo"
            , nativeQuery = true
           )
    void ledgerUpdate(long fileManagerNo, long dw, long price, String comment, String location);
}
