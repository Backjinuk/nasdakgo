package com.example.nasdak.Repository;

import com.example.nasdak.Domain.Ledger;
import com.example.nasdak.Dto.LedgerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Query(value =
            "SELECT DISTINCT FORMATDATETIME(REG_DATE, 'yyyy-MM-dd') AS REG_DATE " +
                    "FROM Ledger l " +
            "WHERE l.user_no= :userNo",
            nativeQuery = true)
    List<?> findAllUsers(long userNo);

    @Query(value =
            "SELECT * " +
                    "FROM Ledger l " +
                    "WHERE l.user_no = :userNo " +
                    "AND l.reg_date >= PARSEDATETIME(:regDate || ' 00:00:00', 'yyyy-MM-dd HH:mm:ss') " +
                    "AND l.reg_date <= PARSEDATETIME(:regDate || ' 23:59:59', 'yyyy-MM-dd HH:mm:ss')"
            , nativeQuery = true)
    List<Ledger> ledgerItem(String regDate,  long userNo);
}
