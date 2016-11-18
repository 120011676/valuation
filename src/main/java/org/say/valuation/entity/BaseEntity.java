package org.say.valuation.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by say on 18/11/2016.
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private Boolean status;
    @Column
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
