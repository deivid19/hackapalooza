/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclipse.hackap.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Deivid
 */
@Controller
@RequestMapping("/dashboard")
public class InicioController extends AccessSystemController {
    
    @Autowired
    //public InicioService inicioService;

    static final Logger LOG = LogManager.getLogger(InicioController.class.getName());

    public ModelAndView _modelandview;
    public Map<String, Object> _model;

    @PostConstruct
    public void init() {
        LOG.debug("Crea instancia: " + InicioController.class.getName());
    }

    @PreDestroy
    public void destroy() {
        LOG.debug("Destruye instancia: " + InicioController.class.getName());
    }
    
    @RequestMapping(value = "/inicio", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView certificaciones(HttpServletRequest request) {

        System.out.println("inicio");
        _modelandview = new ModelAndView();
        _modelandview.setViewName("dashboard/inicio");
        _model = new HashMap<>();
        _modelandview.addAllObjects(_model);

        return _modelandview;
    }
    
    
    
}
