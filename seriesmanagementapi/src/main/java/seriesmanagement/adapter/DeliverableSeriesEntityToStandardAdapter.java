package seriesmanagement.adapter;

/**
 * Created by garyskid on 28/06/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import seriesmanagement.configuration.SeriesServiceConfiguration;
import seriesmanagement.entity.DeliverableSeriesEntity;
import seriesmanagement.response.Series;

import java.util.function.Function;

@Component
final class DeliverableSeriesEntityToStandardAdapter implements Function<DeliverableSeriesEntity, Series> {

    private final SeriesServiceConfiguration standardsServiceConfiguration;

    @Autowired
    public DeliverableSeriesEntityToStandardAdapter(SeriesServiceConfiguration standardsServiceConfiguration) {
        this.standardsServiceConfiguration = standardsServiceConfiguration;
    }

    @Override
    public Series apply(DeliverableSeriesEntity deliverableSeriesEntity) {
        Series series = new Series(deliverableSeriesEntity.getId(),
                deliverableSeriesEntity.getName(),
                deliverableSeriesEntity.getDescription());

        series.add(new Link(standardsServiceConfiguration.getEndPoint() + "/" + deliverableSeriesEntity.getId()));

        return series;
    }
}
