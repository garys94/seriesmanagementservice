package seriesmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by garyskid on 28/06/17.
 */
@Entity
@Table(name="series", schema= "test")
public class DeliverableSeriesEntity {
    @Column(name="series_id")
    @Id
    private int id;

    @Column(name="series_name")
    private String name;

    @Column(name="seriesDescription")
    private String description;

    public DeliverableSeriesEntity(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String seriesName){
        this.name = seriesName;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
