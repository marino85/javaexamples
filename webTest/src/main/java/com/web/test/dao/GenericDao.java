
package com.web.test.dao;


import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TransactionRequiredException;



/**
 * this class contains the logic from create,update and delete of different entities
 * @author hernan.rincon
 * @date 10/03/2015
 */
public abstract class GenericDao <T>{
	
	private Class<T> entityClass;

	
    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     * this method to create a record in database
     * @param entity
     */
    public void create(T entity)  {
    	try{
    		getEntityManager().persist(entity);
    	}catch(EntityExistsException |IllegalArgumentException|TransactionRequiredException e){
    		e.printStackTrace();
    	}
    }

    /**
     * this method updates a record in database
     * @param entity
     */
    public Boolean update(T entity) {
    	try{    		
    		return getEntityManager().merge(entity)!=null?true:false;
    	}catch(IllegalArgumentException|TransactionRequiredException e){
    		e.printStackTrace();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return false;
    }

    /**
     * this method removes a record in database
     * @param entity
     */
    public void remove(T entity){
    	try{
    		getEntityManager().remove(entity);
    	}catch(IllegalArgumentException|TransactionRequiredException e){
    		e.printStackTrace();
    	}
    }

    /**
     * this method finds a record in data base 
     * 
     * @param id is a unique identify of register in database
     * @return returned a entity unique with a supplied id
     */
    public T find(Object id) {
    	try{
    		return getEntityManager().find(entityClass, id);
    	}catch(IllegalArgumentException e){
    		e.printStackTrace();
    	}
        return null;
    }
    
    public void refresh(T entity) {
    	try{
    		 getEntityManager().refresh(entity);
    	}catch(IllegalArgumentException e){
    		e.printStackTrace();
    	}
    }
    
    public void lockEntity(T entity,LockModeType type){
    	getEntityManager().lock(entity, type);
    }
    
    
    


    /**
     * This method return all register by entity
     * @return
     * @throws PbFnPersistenceException
     */
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll(){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).setFirstResult(0).setMaxResults(200).getResultList();
    }




}
