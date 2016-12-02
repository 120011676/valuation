package org.say.valuation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
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
    private Boolean status = true;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date();
}
