package fr.sofiane.applications.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sofiane on 24/10/2016.
 */
@MappedSuperclass
public abstract class CommonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version" )
    private Integer version= 0;

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
