package com.books.app.services;

import com.books.app.mappers.BooksMapper;
import com.books.app.models.BookRecs;
import com.books.app.models.MainBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;

@Service
@SuppressWarnings("unused")
public class BooksService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BooksMapper booksMapper;

    @Cacheable("Books")
    public String getBookId(String title){

        if(inDB(title)) {
            System.out.println("Getting Id from DB");
            //System.out.println("id from db" + booksMapper.getBookId());
            return booksMapper.getBookId(title);

        }else{
            ArrayList<BookRecs> recs = new ArrayList<>();
            System.out.println("entering first api call");
            MainBook getBookId;
            String title2 = title.replaceAll(" ", "+").toLowerCase();
            System.out.println("title " + title2);
            getBookId = restTemplate.getForObject(
                    "https://www.googleapis.com/books/v1/volumes?q=" + title2 +
                            "&key=AIzaSyATKdd7AuMK5-aI5QRP20Y0IuntMupV75E", MainBook.class);

            BookRecs bookRec = new BookRecs();

            bookRec.setId(getBookId.getItems()[0].getId());
            bookRec.setTitle(getBookId.getItems()[0].getVolumeInfo().getTitle());
            try {
                bookRec.setAuthor(getBookId.getItems()[0].getVolumeInfo().getAuthors()[0]);
            }catch(NullPointerException e){
            }
            try {
                bookRec.setDescription(StringUtils.abbreviate(getBookId.getItems()[0].getVolumeInfo()
                        .getDescription(), 1000));
            }catch (NullPointerException e){
            }
            try {
                bookRec.setImage(getBookId.getItems()[0].getVolumeInfo().getImageLinks().getThumbnail());
            }catch (NullPointerException e){
            }
            recs.add(bookRec);

            booksMapper.insertBookInfo(recs.get(0));

            System.out.println(bookRec.getId());
            return bookRec.getId();
        }
    }

    public ArrayList<BookRecs> getBookRecs(String id) {
        ArrayList<BookRecs> recs = new ArrayList<>();


        System.out.println("entering second api call");

        MainBook getBookRecs;
        //String bookId = getBookId(id);
        //String id2 = id.replaceAll("\"", "");
        System.out.println("Id " + id);

        getBookRecs = restTemplate.getForObject(
                "https://www.googleapis.com/books/v1/volumes/" + id +
                        "/associated?key=AIzaSyATKdd7AuMK5-aI5QRP20Y0IuntMupV75E", MainBook.class);

        System.out.println("Id after second api call" + id);
        System.out.println("sout recs" + recs);
        for(int i =0; i < getBookRecs.getItems().length; i++) {
            BookRecs bookRec = new BookRecs();
            bookRec.setId(getBookRecs.getItems()[i].getId());
            bookRec.setTitle(getBookRecs.getItems()[i].getVolumeInfo().getTitle());
            try {
                bookRec.setAuthor(getBookRecs.getItems()[i].getVolumeInfo().getAuthors()[0]);
            }catch (NullPointerException e){
            }
            try {
                bookRec.setDescription(getBookRecs.getItems()[i].getVolumeInfo().getDescription());
            }catch (NullPointerException e){
            }
            try{
                bookRec.setImage(getBookRecs.getItems()[i].getVolumeInfo().getImageLinks().getThumbnail());
            }catch (NullPointerException e){
            }
            recs.add(bookRec);
        }


        return recs;
    }

    public boolean inDB(String title){
        if (booksMapper.getBookInfoByTitle(title) != null){
            System.out.println("title from bd " + booksMapper.getBookInfoByTitle(title) );
            return true;

        }else return false;
    }


}


