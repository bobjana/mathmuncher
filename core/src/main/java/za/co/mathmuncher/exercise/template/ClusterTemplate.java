package za.co.mathmuncher.exercise.template;

import za.co.mathmuncher.Entity;
import za.co.mathmuncher.exercise.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class ClusterTemplate extends Entity {

    @ElementCollection
    @CollectionTable(name = "modifiers", joinColumns = @JoinColumn(name = "clustertemplate_id"))
    @Column(name = "modifier")
    private List<Integer> allowedModifiers = new ArrayList<Integer>();

    @ElementCollection
    @CollectionTable(name = "nodes", joinColumns = @JoinColumn(name = "clustertemplate_id"))
    @Column(name = "node")
    private List<Integer> allowedNodes = new ArrayList<Integer>();
    private Type type;

    ClusterTemplate() {
    }

    public ClusterTemplate(Type type, List<Integer> allowedModifiers, List<Integer> allowedNodes) {
        this.type = type;
        this.allowedModifiers = allowedModifiers;
        this.allowedNodes = allowedNodes;
    }

    public List<Integer> getAllowedModifiers() {
        return allowedModifiers;
    }

    public void setAllowedModifiers(List<Integer> allowedModifiers) {
        this.allowedModifiers = allowedModifiers;
    }

    public List<Integer> getAllowedNodes() {
        return allowedNodes;
    }

    public void setAllowedNodes(List<Integer> allowedNodes) {
        this.allowedNodes = allowedNodes;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
