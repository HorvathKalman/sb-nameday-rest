package hkc.sb_nameday_rest.repository;

import hkc.sb_nameday_rest.model.NameDay;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface NameDayRepository extends CrudRepository<NameDay, Integer> {

    @Modifying
    @Query("""
            UPDATE name_day
            SET date = :date
            WHERE name = :name;
            """)
    int changeDate(@Param("date") String date, @Param("name") String name);

    @Query("""
            SELECT *
            FROM name_day
            WHERE name = :name;
            """)
    NameDay getNameDayByName(@Param("name") String name);
}
