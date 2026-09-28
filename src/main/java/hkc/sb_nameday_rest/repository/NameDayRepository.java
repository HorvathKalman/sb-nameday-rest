package hkc.sb_nameday_rest.repository;

import hkc.sb_nameday_rest.model.NameDay;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface NameDayRepository extends CrudRepository<NameDay, Integer> {

}
