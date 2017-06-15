package kelley.josh.repository;

import kelley.josh.model.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Locale;

/**
 * Created by joshuakelley on 2/25/17.
 */
public interface EntryRepository extends CrudRepository<Entry, Long>{
    List<Entry> findByClientAccountNumber(long clientAccountNumber);

}
