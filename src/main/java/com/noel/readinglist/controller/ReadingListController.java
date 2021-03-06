package com.noel.readinglist.controller;

import com.noel.readinglist.entity.Book;
import com.noel.readinglist.repository.ReadingListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/")
@Slf4j
public class ReadingListController {

    @Autowired
    private ReadingListRepository readingListRepository;

    @GetMapping(value = "/{reader}")
    public String readersBooks(@PathVariable("reader") String reader, Model model) {

        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
        }
        return "readingList";
    }

    @PostMapping(value = "/{reader}")
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);

        log.debug("book: {}", book);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
