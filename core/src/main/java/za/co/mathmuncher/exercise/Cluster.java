package za.co.mathmuncher.exercise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cluster extends za.co.mathmuncher.Entity implements Question {

    @ElementCollection
    @CollectionTable(name = "nodes", joinColumns = @JoinColumn(name = "cluster_id"))
    @Column(name = "node")
    private List<Integer> nodes = new ArrayList<Integer>();
    private Integer modifier;

    public Cluster(){}

    public Cluster(List<Integer> nodes, Integer modifier) {
        this.nodes = nodes;
        this.modifier = modifier;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public List<Integer> getNodes() {
        return nodes;
    }

    public void setNodes(List<Integer> nodes) {
        this.nodes = nodes;
    }
}
