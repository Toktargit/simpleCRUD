package controller;

import entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotes")
public class QuoteRepository {

    @Autowired
    private QuoteRepository quoteRepository;

    @PostMapping
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteRepository.save(quote);
    }

    @GetMapping("/{id}")
    public Optional<Quote> getQuote(@PathVariable Long id) {
        return quoteRepository.findById(id);
    }

    @GetMapping
    public Iterable<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @PutMapping("/{id}")
    public Quote updateQuote(@PathVariable Long id, @RequestBody Quote updatedQuote) {
        updatedQuote.setId(id);
        return quoteRepository.save(updatedQuote);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id) {
        quoteRepository.deleteById(id);
    }
}
