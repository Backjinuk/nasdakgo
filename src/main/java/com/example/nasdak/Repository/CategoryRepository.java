package com.example.nasdak.Repository;

import com.example.nasdak.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Modifying
    @Transactional
    @Query(value =
            "update Category c " +
                "SET c.content = :content " +
            "WHERE c.category_no = :categoryNo"
            , nativeQuery = true)
    void categoryUpdate(long categoryNo, String content);

    @Query(value = "SELECT * " +
                        "FROM Category c " +
                    "WHERE c.user_no= :userNo ",
                    nativeQuery = true)
    List<Category> categoryUserList(long userNo);
}
