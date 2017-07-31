/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.test.dao;

import com.web.test.model.PbfnAudit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author edwin
 */
@Stateless
public class AuditDao extends GenericDao<PbfnAudit>{

    @PersistenceContext(unitName = "com.web.test_webTest_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public AuditDao() {
        super(PbfnAudit.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
   

   

    
}
