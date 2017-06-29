package seriesmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seriesmanagement.entity.DeliverableSeriesEntity;
import seriesmanagement.repository.SeriesRepository;

import java.util.List;

/**
 * Created by garyskid on 28/06/17.
 */
@Service
public class SeriesService {

    private final SeriesRepository repository;

    @Autowired
    public SeriesService(SeriesRepository repository){
        this.repository = repository;
    }

    public List<DeliverableSeriesEntity> getSeries() throws Exception {
        try{
            return repository.findAllOrderByName();
        }catch(Exception e){
            throw new Exception("The following error occurred: " + e.getMessage());
        }
    }

    public void AddSeries(DeliverableSeriesEntity series) throws Exception {

        try {
            if (series != null) {
                repository.save(series);
            }
        } catch (Exception e) {
            //Log exception then throw
            throw new Exception("The following error occurred: " + e.getMessage());
        }

    }
}
