package seriesmanagement.repository;

import seriesmanagement.entity.DeliverableSeriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by garyskid on 28/06/17.
 */
public interface SeriesRepository extends JpaRepository<DeliverableSeriesEntity, Integer> {
    @Query("from DeliverableSeriesEntity order by name")
    List<DeliverableSeriesEntity> findAllOrderByName();

    Optional<DeliverableSeriesEntity> findById(int id);
}
