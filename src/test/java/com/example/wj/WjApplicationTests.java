package com.example.wj;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.wj.dao.*;
import com.example.wj.pojo.*;
import com.example.wj.service.AdminRoleService;
import com.example.wj.service.BookService;
import com.example.wj.service.CategoryService;
import com.example.wj.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class WjApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserDao userdao;
    @Autowired
    UserService userService;
    @Autowired
    User user;
    @Autowired
    BookService bookService;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AdminMenuDao adminMenuDao;
    @Autowired
    AdminUserRoleDao adminUserRoleDao;
    @Autowired
    AdminRoleMenuDao adminRoleMenuDao;
    @Autowired
    AdminRolePermissionDao adminRolePermissionDao;
    @Autowired
    AdminPermissionDao adminPermissionDao;
    @Autowired
    AdminRoleService adminRoleService;
    @Test
    public void context() throws SQLException {
        String sql = "select * from user";
        List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
        for (Map m : map) {
            for (Object key : m.keySet()) {
                System.out.println(m.get(key));
            }
        }

    }

    @Test
    public void contextload() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource" + druidDataSource.getInitialSize());
        connection.close();
    }

    @Test
    public void setlist() {
        user.setUsername("admin");
        user.setPassword("123456");
        userdao.save(user);
//          System.out.println(userdao.getByUsernameAndPassword("admin","123"));
//          System.out.println(userService.getByName("admin"));
    }

    @Test
    public void bookall() {
//         List<Book> list = bookService.list();
//         for (Book book:list){
//             System.out.println(book.getCategory().toString());
//         }

//         List<Book> list = bookService.listByCategory(1);
//         for (Book book:list){
//             System.out.println(book.getCategory().toString());
//         }
//        Book book = new Book();
//        book.setTitle("你好");
//        book.setAuthor("sunhui");
//        book.setCover("sshh");
//        book.setDate("2020");
//        book.setAbs("1");
//        book.setPress("2");
//        bookService.addOrUpdate(book);
        bookService.deleteById(80);

    }

    @Test
    public void catogerytest() {
//        List<Category> list=new ArrayList<>();
//        list=categoryService.list();
//        for(Category c:list){
//            System.out.println(c);
//        }
//    }
        Category category = categoryService.get(1);
        System.out.println(category.getId());
        System.out.println(category.getName());
    }
 @Test
    public void menu(){
//        List<Integer> list=new ArrayList<>();
//        list.add(1);list.add(2);list.add(3);
//     List<AdminMenu> menu = adminMenuDao.findAllById(list);
//     for(AdminMenu a:menu) {
//         System.out.println(a.toString());
//     }
//     List<Integer> list = adminUserRoleDao.listAllByUid(1);
     List<Integer> l=new ArrayList<>();
     l.add(1);
    List<Integer> list = adminRoleMenuDao.findmidByrid(l);
     System.out.println(list.get(0));
     System.out.println(list.size());

 }

 @Test
    public void pession(){
     List<Integer> l=new ArrayList<>();
     l.add(1);
     List<AdminPermission> list = adminPermissionDao.findAllById(l);
     System.out.println(list.get(0));
     System.out.println(list.size());

 }

 @Test
    public void role(){
     System.out.println(adminRoleService.listWithPermsAndMenus());
 }
}
