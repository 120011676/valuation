package org.say.valuation.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Created by say on 18/11/2016.
 */
@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Column(unique = true, nullable = false)
    @NotBlank
    private String username;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String passwordSalt;
    @ManyToMany
    private List<Role> roles;
}
