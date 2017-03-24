package com.inthergroup.internship.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * An entity Groups composed by two fields (id, group_name). The Entity
 * annotation indicates that this class is a JPA entity. The Table annotation
 * specifies the name for the table in the db.
 *
 * @author interns
 */
@Entity
@Table(name = "groups")
public class Group {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An autogenerated id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String groupName;
    
    @ManyToMany(mappedBy="groups")
    private List<User> users;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    public Group() {
    }

    public Group(long id) {
        super();
        this.id = id;
    }
    
    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(long id, String groupName) {
        super();
        this.id = id;
        this.groupName = groupName;
    }
    
    // Getter and setter methods

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public void addUser(User user) {        
        users.add(user);
        
        if (!user.getGroups().contains(this)) { // warning this may cause performance issues if you have a large data set since this operation is O(n)
            user.getGroups().add(this);
        }
    }

} // class Groups
