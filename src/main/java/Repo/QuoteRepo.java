package Repo;
import entity.Quote;
import org.springframework.data.repository.CrudRepository;
public interface QuoteRepo extends CrudRepository<Quote, Long> {
}

