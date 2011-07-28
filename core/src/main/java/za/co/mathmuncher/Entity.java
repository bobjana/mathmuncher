package za.co.mathmuncher;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Entity implements Serializable{

    private static final long serialVersionUID = -1;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private Long id;
	@Version
    @Column(name = "version")
    private Integer version;

    protected Entity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
