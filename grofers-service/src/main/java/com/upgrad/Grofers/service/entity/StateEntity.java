package com.upgrad.Grofers.service.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * StateEntity class contains all the attributes to be mapped to all the fields in state table in the database.
 * All the annotations which are used to specify all the constraints to the columns in the database must be correctly implemented.
 */
@Entity
@Table(name = "state")
@NamedQueries({
        @NamedQuery(name = "getStateByUUID", query = "select s from StateEntity s where s.uuid =:uuid"),
        @NamedQuery(name = "getAllStates", query = "select s from StateEntity s")
})
public class StateEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID", length = 64, nullable = false)
    private String uuid;

    @Column(name = "state_name", nullable = false)
    private String stateName;

    public StateEntity() {
    }

    public StateEntity(String uuid, String stateName) {
        this.uuid = uuid;
        this.stateName = stateName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
