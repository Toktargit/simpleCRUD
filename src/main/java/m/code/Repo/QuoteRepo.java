package m.code.Repo;
import m.code.entity.Quote;
import org.springframework.data.repository.CrudRepository;
public interface QuoteRepo extends CrudRepository<Quote, Long> {
}

