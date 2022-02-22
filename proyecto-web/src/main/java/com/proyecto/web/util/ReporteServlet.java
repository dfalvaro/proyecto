/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.web.util;

import com.proyecto.web.dataManager.CabeceraDM;
import com.proyecto.web.dataManager.MenuDM;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TPV
 */
@WebServlet(name = "ReporteServlet", urlPatterns = {"/ReporteServlet"})
public class ReporteServlet extends HttpServlet {

    @Inject
    private MenuDM accesoDM;

    @Inject
    private CabeceraDM cabeceraDM;
    private static final long serialVersionUID = 1L;

    public ReporteServlet() {
        super();
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        try {
            //        doPost(request, response);
            if (cabeceraDM.getPdfArray() == null) {
                return;
            }
            response.setContentType("application/pdf");
            response.setContentLength(cabeceraDM.getPdfArray().length);
            response.getOutputStream().write(cabeceraDM.getPdfArray());
//            cabeceraDM.setPdfArray(null);
        } catch (IOException ex) {
            Logger.getLogger(ReporteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
