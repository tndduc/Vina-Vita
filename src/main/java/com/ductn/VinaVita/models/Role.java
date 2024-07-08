package com.ductn.VinaVita.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "role")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
        @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId"),
        @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName"),
        @NamedQuery(name = "Role.findByCreatedDate", query = "SELECT r FROM Role r WHERE r.createdDate = :createdDate"),
        @NamedQuery(name = "Role.findByUpdatedDate", query = "SELECT r FROM Role r WHERE r.updatedDate = :updatedDate"),
        @NamedQuery(name = "Role.findByDeletedDate", query = "SELECT r FROM Role r WHERE r.deletedDate = :deletedDate"),
        @NamedQuery(name = "Role.findByActive", query = "SELECT r FROM Role r WHERE r.active = :active")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @Column(name = "active")
    private Boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "roleId")
    private Set<User> userSet;

    @Override
    public int hashCode() {
        return roleId != null ? roleId.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        return this.roleId != null && this.roleId.equals(other.roleId);
    }

    @Override
    public String toString() {
        return "com.ductn.VinaVita.models.Role[ roleId=" + roleId + " ]";
    }
}
