package seriesmanagement.response;

/**
 * Created by garyskid on 28/06/17.
 */
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.Resources;

public class SeriesDto {

    private int count;

    @JsonUnwrapped
    private final Resources<Series> series;

    public SeriesDto(int count, Resources<Series> series) {
        this.count = count;
        this.series = series;
    }

    public int getCount() {
        return count;
    }

    public Resources<Series> getSeries() {
        return series;
    }
}
