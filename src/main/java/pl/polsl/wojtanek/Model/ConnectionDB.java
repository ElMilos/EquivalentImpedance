/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.wojtanek.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import pl.polsl.wojtanek.Entity.CircutDB;
import pl.polsl.wojtanek.Entity.CircutPartDB;

/**
 *
 * @author m
 * Klasa ConnectionDB służy do zarządzania połączeniami z bazą danych i operacjami na bazie danych.
 * Umożliwia zapisywanie i odczytywanie danych dotyczących obwodów elektrycznych.
 
 */
public class ConnectionDB {
    
   private int countParts=0;
   private EntityManagerFactory emf;
  public EntityManager em;
    
    /**
     * Konstruktor klasy ConnectionDB.
     * Inicjalizuje EntityManagerFactory i EntityManager do zarządzania połączeniami z bazą danych.
     */
    public ConnectionDB()
   {
         emf = Persistence.createEntityManagerFactory("my_persistence_unit");
         em = emf.createEntityManager();
   }
   
    /**
     * Metoda służąca do zapisywania danych do bazy danych.
     *
     * @param conn Typ połączenia (Szeregowo, Równolegle).
     * @param mode Tryb pracy elementu obwodu.
     * @param resultList Lista wyników zawierająca pary danych.
     * @param ListCount Liczba elementów w liście wyników.
     */
    public void SaveToDB(String conn, String mode, List<Pair<String, String, String>> resultList, int ListCount)
    {
        
         switch (conn) {
            case "Szeregowo":
                CircutDB circutDB = new CircutDB();
                CircutPartDB entity = new CircutPartDB();
                
              entity.setNamee(mode);
              entity.setCircut(circutDB);
                               
              persist(circutDB);
              persist(entity);
                break;
                
            case "Rownolegle":
                if(countParts==1)
                {
                    CircutPartDB entity1 = new CircutPartDB();
                    entity1.setNamee(mode);
                    
                    CircutPartDB entity2 = new CircutPartDB();
                    entity2.setNamee(resultList.get(ListCount-2).getSecond());
                
                    CircutDB circutDbA = new CircutDB();
                    
                   entity1.setCircut(circutDbA);
                   entity2.setCircut(circutDbA);
                    
                    persist(circutDbA);
                    persist(entity2);
                    persist(entity1);
                    countParts=0;
                }  
                else
                {
                    countParts++;
                }
                break;
                
            default:
                
                
                break;
    }
    
    }
   
    /**
     * Metoda do odczytywania danych z bazy danych.
     * 
     * @return Lista obiektów CircutPartDB reprezentujących części obwodu.
     */
    public List<CircutPartDB> ReadFromDB()
    {

  List<CircutPartDB> results = null;
    try {
        TypedQuery<CircutPartDB> query = em.createQuery("SELECT * FROM CircutPartDB ", CircutPartDB.class);
        results = query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return results;

        }
    

   
    /**
     * Metoda służąca do zapisywania obiektów w bazie danych.
     *
     * @param object Obiekt do zapisania w bazie danych.
     */
    public void persist(Object object) {

        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
          //  em.close();
        }
}
}

