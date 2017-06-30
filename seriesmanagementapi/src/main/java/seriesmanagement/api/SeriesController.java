package seriesmanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seriesmanagement.configuration.SeriesServiceConfiguration;
import seriesmanagement.entity.DeliverableSeriesEntity;
import seriesmanagement.response.Series;
import seriesmanagement.response.*;
import seriesmanagement.service.SeriesService;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by garyskid on 28/06/17.
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class SeriesController {

    private final SeriesService seriesService;
    private final Function<DeliverableSeriesEntity, Series> deliverableSeriesEntityToStandardAdapter;
    private final SeriesServiceConfiguration seriesConfiguration;

    @Autowired
    public SeriesController(SeriesService seriesService,
                            Function<DeliverableSeriesEntity, Series> deliverableSeriesEntityToStandardAdapter,
                            SeriesServiceConfiguration seriesConfiguration){
        this.seriesService = seriesService;
        this.deliverableSeriesEntityToStandardAdapter = deliverableSeriesEntityToStandardAdapter;
        this.seriesConfiguration = seriesConfiguration;
    }

    @RequestMapping(method = RequestMethod.GET, value = "series/{seriesId}")
    public HttpEntity<Series> getSeries(@PathVariable("seriesId") int seriesId){

        try {
            List<Series> seriesList = seriesService.getSeries()
                    .stream()
                    .map(deliverableSeriesEntityToStandardAdapter::apply)
                    .collect(Collectors.toList());

            Resources<Series> resources = new Resources<>(seriesList, new Link(seriesConfiguration.getEndPoint()));

            return new ResponseEntity(new SeriesDto(seriesList.size(), resources), HttpStatus.OK);

        }catch(Exception e){
            //log or throw the error
            return new ResponseEntity("Unable to retrieve series records", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "series")
    public ResponseEntity addSeries(@RequestBody Series series) {
        try {
            if (series != null) {
                DeliverableSeriesEntity seriesEntity = new DeliverableSeriesEntity(
                        series.getItemId(), series.getName(), series.getDescription());

                seriesService.AddSeries(seriesEntity);

                return new ResponseEntity(HttpStatus.CREATED);
            }else{
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            //Log error
            return new ResponseEntity("The following error occurred: " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
