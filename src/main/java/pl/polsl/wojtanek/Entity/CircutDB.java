/*
 * CircutDB.java
 * 
 * The CircutDB class represents an entity in the database for circuit information.
 * It is annotated with JPA annotations for entity mapping.
 * 
 * @author m
 * @version 1.0
 */

package pl.polsl.wojtanek.Entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import pl.polsl.wojtanek.Model.ConnectionDB;

/**
 * The CircutDB class is an entity class representing circuit information in the database.
 * It is annotated with JPA annotations for entity mapping.
 * 
 * @author m
 * @version 1.0
 * @since 1.0
 */
@Entity
public class CircutDB implements Serializable {

    /**
     * The serial version UID for serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier for the circuit entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The list of circuit parts associated with this circuit.
     */
    @OneToMany(mappedBy = "circutDB")
    List<CircutPartDB> circutPartsDB;

    /**
     * Get the unique identifier of the circuit.
     * 
     * @return The unique identifier of the circuit.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the circuit.
     * 
     * @param id The unique identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Generate the hash code for the circuit entity based on its unique identifier.
     * 
     * @return The hash code of the circuit entity.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Check if this circuit entity is equal to another object based on their unique identifiers.
     * 
     * @param object The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CircutDB)) {
            return false;
        }
        CircutDB other = (CircutDB) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Generate a string representation of the circuit entity.
     * 
     * @return A string representation of the circuit entity.
     */
    @Override
    public String toString() {
        return "CircutDB id=" + id + " ";
    }

    /**
     * Find and retrieve all circuit entities from the database.
     * 
     * @return A list of all circuit entities.
     */
    public List findAll() {
        ConnectionDB CDB = new ConnectionDB();
        Query query = CDB.em.createQuery("SELECT c FROM CircutDB c");
        List results = query.getResultList();
        return results;
    }
}