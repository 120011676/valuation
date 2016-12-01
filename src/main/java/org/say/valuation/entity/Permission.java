package org.say.valuation.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by say on 28/11/2016.
 */
@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity {
    @Column
    private String name;
    @Column
    private String uri;
    @ManyToOne
    private Permission permission;
    @OneToMany
    private List<Permission> permissions;
    @ManyToMany
    private List<Role> roles;
}
