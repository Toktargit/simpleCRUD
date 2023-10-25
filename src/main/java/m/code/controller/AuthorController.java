package m.code.controller;

import m.code.entity.Author;
import m.code.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import java.util.List;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

   @GetMapping("/authors")
    public String findAll(Model model){
        List<Author> authors = authorService.findAll();
        model.addAttribute("author", authors);
        return "author-list";
    }

      @GetMapping("/author-create")
    public String createAuthorForm(Author author){
        return "author-create";
    }

    @PostMapping("/author-create")
    public String createUser(Author author){
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

     @GetMapping("author-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        authorService.deleteById(id);
        return "redirect:/authors";
    }

    @GetMapping("/authors-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "authors-update";
    }

    @PostMapping("/authors-update")
    public String updateUser(Author author){
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }
}