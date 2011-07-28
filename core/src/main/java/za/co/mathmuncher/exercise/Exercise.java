package za.co.mathmuncher.exercise;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Entity
@Configurable
public class Exercise extends za.co.mathmuncher.Entity{

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private List<Cluster> clusters = new ArrayList<Cluster>();

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

	public Date getStartDate() {
        return this.startDate;
    }

	public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

	public Date getEndDate() {
        return this.endDate;
    }

	public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EndDate: ").append(getEndDate()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("StartDate: ").append(getStartDate()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }

}
