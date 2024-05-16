/*
 * CircutPartDB.java
 * 
 * The CircutPartDB class represents an entity in the database for circuit parts information.
 * It is annotated with JPA annotations for entity mapping.
 * 
 * @author m
 * @version 1.0
 */

package pl.polsl.wojtanek.Entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Query;
import java.util.List;
import pl.polsl.wojtanek.Model.ConnectionDB;

/**
 * The CircutPartDB class is an entity class representing circuit parts information in the database.
 * It is annotated with JPA annotations for entity mapping.
 * 
 * @author m
 * @version 1.0
 * @since 1.0
 */
@Entity
public class CircutPartDB implements Serializable {

    /**
     * The serial version UID for serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier for the circuit part entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The reference to the circuit entity that this part belongs to.
     */
    @ManyToOne
    private CircutDB circutDB;

    /**
     * The name of the circuit part.
     */
    private String namee;

    /**
     * Get the unique identifier of the circuit part.
     * 
     * @return The unique identifier of the circuit part.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the circuit part.
     * 
     * @param id The unique identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the circuit part.
     * 
     * @return The name of the circuit part.
     */
    public String getNamee() {
        return namee;
    }

    /**
     * Set the name of the circuit part.
     * 
     * @param name The name to set.
     */
    public void setNamee(String name) {
        this.namee = name;
    }

    /**
     * Generate the hash code for the circuit part entity based on its unique identifier.
     * 
     * @return The hash code of the circuit part entity.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Check if this circuit part entity is equal to another object based on their unique identifiers.
     * 
     * @param object The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CircutPartDB)) {
            return false;
        }
        CircutPartDB other = (CircutPartDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Generate a string representation of the circuit part entity, including its name and the associated circuit ID.
     * 
     * @return A string representation of the circuit part entity.
     */
    @Override
    public String toString() {
        return "id=" + id + " name=" + namee + " Circut_ID= " + circutDB.getId() + "\n";
    }

    /**
     * Get the circuit entity that this part belongs to.
     * 
     * @return The circuit entity.
     */
    public CircutDB getCircut() {
        return circutDB;
    }

    /**
     * Set the circuit entity that this part belongs to.
     * 
     * @param circutDB The circuit entity to set.
     */
    public void setCircut(CircutDB circutDB) {
        this.circutDB = circutDB;
    }

    /**
     * Find and retrieve all circuit part entities from the database.
     * 
     * @return A list of all circuit part entities.
     */
    public List findAll() {
        ConnectionDB CDB = new ConnectionDB();
        Query query = CDB.em.createQuery("SELECT c FROM CircutPartDB c");
        List results = query.getResultList();
        return results;
    }
}