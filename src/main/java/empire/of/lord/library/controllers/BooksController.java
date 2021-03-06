package empire.of.lord.library.controllers;

import empire.of.lord.library.dao.BookDAO;
import empire.of.lord.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("books", bookDAO.showAll());
        return "books/all";
    }

    @PostMapping
    public String create(@ModelAttribute("book") Book book){
        bookDAO.create(book);
        return "redirect:/books";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "books/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model, @ModelAttribute("book") Book book){
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){
        model.addAttribute("book", bookDAO.show(id));
        return "books/show";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute Book updatedBook){
        bookDAO.update(updatedBook);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        bookDAO.delete(id);
        return "redirect:/books";
    }
}
