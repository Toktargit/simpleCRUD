package m.code.service;

import m.code.Repo.QuoteRepo;
import m.code.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    private static QuoteRepo quoteRepo;

    public List<Quote> listAll(){
        return quoteRepo.findAll();
    }

    public Quote get (Long id){
        return quoteRepo.findById(id).get();
    }

    public void DeleteById(Long id){
        quoteRepo.deleteById(id);
    }
    public Quote saveQuote(Quote quote) {
        return quoteRepo.save(quote);
    }
}
