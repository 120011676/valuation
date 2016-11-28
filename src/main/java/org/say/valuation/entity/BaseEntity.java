package org.say.valuation.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by say on 18/11/2016.
 */
@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private Boolean status;
    @Column
    private Date createDate;
}
