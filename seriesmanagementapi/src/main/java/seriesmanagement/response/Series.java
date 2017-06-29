package seriesmanagement.response;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by garyskid on 28/06/17.
 */
public class Series extends ResourceSupport {
    private int id;
    private String seriesName;
    private String seriesDescription;

    public Series(int id, String seriesName, String seriesDescription){
        this.id = id;
        this.seriesName = seriesName;
        this.seriesDescription = seriesDescription;
    }

    public int getItemId(){
        return id;
    }

    public String getName(){
        return seriesName;
    }

    public String getDescription(){
        return seriesDescription;
    }
}
