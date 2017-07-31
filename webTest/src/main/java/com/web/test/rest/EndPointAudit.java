/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.test.rest;

import com.google.gson.Gson;
import com.web.test.dao.AuditDao;
import com.web.test.model.PbfnAudit;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author edwin
 */
@Path("/listall")
public class EndPointAudit {

    @EJB
    private AuditDao dao;

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet() {
        List<PbfnAudit> listaRes = dao.findAll();

        Gson gson = new Gson();

        String respuesta = gson.toJson(listaRes);
        return Response.ok(respuesta).build();
    }

}
