package com.example.wj.dao;

import com.example.wj.pojo.Book;
import com.example.wj.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookDao {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);

    List<Book> findAll();
//主键存在时更新，不存在时插入
    void save(Book book);

    void deleteById(int id);
}
