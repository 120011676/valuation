package org.say.valuation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String password;
    @Column
    @JsonIgnore
    private String passwordSalt;
    @ManyToMany
    private List<Role> roles;
}
