/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Tipos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Jose Lira
 */
public class TiposCtrl {
     public boolean guar(Tipos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
 public Tipos cons(Integer codiTipo)
    {
        Tipos resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(Tipos.class, codiTipo);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Tipos> cons()
    {
        List<Tipos> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("Tipos.findAll", Tipos.class).getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public boolean edit(Tipos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.merge(obje);
            //em.flush();
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
   public boolean dele(Tipos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.remove(em.merge(obje));
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
}
