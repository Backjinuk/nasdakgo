package com.example.nasdak.Repository;

import com.example.nasdak.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Modifying
    @Transactional
    @Query(value =
            "update Category c " +
                "SET c.content = :content " +
            "WHERE c.category_no = :categoryNo"
            , nativeQuery = true)
    void categoryUpdate(long categoryNo, String content);
}
