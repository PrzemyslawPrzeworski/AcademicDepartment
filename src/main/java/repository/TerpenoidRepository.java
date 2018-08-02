package repository;

import entity.Terpenoid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TerpenoidRepository extends JpaRepository<Terpenoid, Long> {
    Terpenoid findFirstById(Long id);

    @Query(value = "SELECT * FROM (SELECT * FROM terpenoid ORDER BY ABS(retention_index - :calculated_retention_index) LIMIT 12) AS T ORDER BY retention_index;", nativeQuery = true)
    List<Terpenoid> findClosestTerpenoid(@Param("calculated_retention_index") double calculated_retention_index);


}
