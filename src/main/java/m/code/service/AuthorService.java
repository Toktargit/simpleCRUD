package m.code.service;

import m.code.Repo.AuthorRepo;
import m.code.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private static AuthorRepo authorRepository;

    public static List<Author> findAll() {
        return authorRepository.findAll();
    }


    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    public Author findById(Long id) {
        return authorRepository.getOne(id);
    }
}
