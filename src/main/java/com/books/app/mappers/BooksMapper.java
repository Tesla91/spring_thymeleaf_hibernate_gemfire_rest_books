package com.books.app.mappers;

import com.books.app.models.BookRecs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface BooksMapper {

    String GET_BOOK_ID = "SELECT id FROM book_info WHERE title = #{title}"  ;
    String INSERT_BOOK_INFO = "INSERT INTO book_info (id, title, author, description, image) " +
            "VALUES (#{id}, #{title}, #{author}, #{description}, #{image})"  ;
    String GET_BOOK_INFO_BY_TITLE = "SELECT distinct(title) FROM book_info WHERE title = #{title}";
    String GET_BOOK_INFO_BY_ID = "SELECT * FROM book_info WHERE id = #{id}";


    @Select(GET_BOOK_ID)
    public String getBookId(String title);
    @Insert(INSERT_BOOK_INFO)
    public int insertBookInfo(BookRecs book);
    @Select(GET_BOOK_INFO_BY_TITLE)
    public String getBookInfoByTitle(String title);
    @Select(GET_BOOK_INFO_BY_ID)
    public ArrayList<BookRecs> getBookInfoById();

}
