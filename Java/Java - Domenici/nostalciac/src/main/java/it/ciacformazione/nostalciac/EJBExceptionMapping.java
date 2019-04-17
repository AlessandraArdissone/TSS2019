/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac;

import javax.ejb.EJBException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author tss
 */
@Provider
public class EJBExceptionMapping implements ExceptionMapper<EJBException> {

    @Override
    public Response toResponse(EJBException ex) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header("caused-by", "errore nell'accesso ai dati")
                .build();
    }
    
}
