package com.example.wj.service;

import com.example.wj.dao.BookDao;
import com.example.wj.pojo.Book;
import com.example.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryService categoryService;
    public List<Book> list() {

        return bookDao.findAll();
    }

    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category=new Category();

        category.setId(cid);
//        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }
}
