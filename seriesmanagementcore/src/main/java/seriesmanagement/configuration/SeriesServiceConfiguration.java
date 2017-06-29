package seriesmanagement.configuration;

/**
 * Created by garyskid on 28/06/17.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "seriesService")
public class SeriesServiceConfiguration {

    private String endPoint;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
