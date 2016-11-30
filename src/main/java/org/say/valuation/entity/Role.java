package org.say.valuation.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by say on 18/11/2016.
 */
@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {
    @Column
    private String name;
    @ManyToMany
    private List<User> users;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permission> permissions;
}
