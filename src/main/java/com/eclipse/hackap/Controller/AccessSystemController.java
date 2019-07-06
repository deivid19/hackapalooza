/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclipse.hackap.Controller;

import com.eclipse.hackap.Model.Usuario;
import com.eclipse.hackap.Service.AccessSystemService;
import com.eclipse.hackap.Utils.MultipartUtility;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.httpclient.HttpClient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author deivi
 */
@Controller
@Scope(value = "session")
public class AccessSystemController implements Serializable {

    @Autowired
    public AccessSystemService _accessystemservice;

    public ModelAndView _modelandview;
    public Map<String, Object> _model;
    
    private static final Logger LOG = LogManager.getLogger(AccessSystemController.class.getName());
    
    @Value("${mediosvirtual.value}")
    private String pathmediosvirtual;
    
    @Value("${mediosfisico.value}")
    private String pathmediosfisico;

    @PostConstruct
    public void init() {
        LOG.debug("Crea instancia: " + AccessSystemController.class.getName());
    }

    @PreDestroy
    public void destroy() {
        LOG.debug("Destruye instancia: " + AccessSystemController.class.getName());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String L1(HttpServletRequest request) {
        return "redirect:login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpServletRequest request) {
        _modelandview = new ModelAndView();
        _modelandview.setViewName("login");
        request.getSession().invalidate();
        return _modelandview;

    }

    // Redireccionar a login_usuario
    @RequestMapping(value = "/validaruser", method = RequestMethod.POST)
    //@ResponseBody
    public String validarUsuario(HttpServletRequest request) {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        String _urlsalida = "";

        //System.out.println("pass: " + password + " usuario: " + usuario);
        List<Object[]> respuesta = _accessystemservice.getCredenciales(usuario, password);
        String resp1 = respuesta.get(0)[0].toString();
        System.out.println("resp: " + resp1);
        
        if (respuesta != null) {
            
            List<Object[]> validacion = _accessystemservice.obtenerUsuario(resp1);
            String valida1 = validacion.get(0)[0].toString();
            System.out.println("valida: " + valida1);
            List<Object[]> incljsp = _accessystemservice.obtenerIncludeJsp(valida1);
            
            request.getSession().setAttribute("dashboard", incljsp.get(0)[0].toString());
            request.getSession().setAttribute("estilo", incljsp.get(0)[1].toString());
            System.out.println("incl: " + incljsp.get(0)[1].toString());
            _urlsalida = "redirect:/dashboard/inicio";
        } else {
            _urlsalida = "redirect:/errorPerfil";
        }

        return _urlsalida;

    }
    
    @RequestMapping(value = "/nuevoPost", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    String handleFileUpload(@RequestParam("file") CommonsMultipartFile[] file,
            HttpServletRequest request) {//

        LOG.debug("Entra a nuevo Post");

        String respuesta = "";
        String respuestachida = "";
        String name = "";
        String charset = "UTF-8";
        String requestURL = "http://max-facial-emotion-classifier.max.us-south.containers.appdomain.cloud/model/predict";

        int i = 0;
        int tarchivo = 0;

        String[] archivos = {"", "", ""};

        for (i = 0; i < file.length; ++i) {

            name = file[i].getOriginalFilename();
            System.out.println(file[i].getOriginalFilename());
            String[] parts = name.split("\\.");
            /*if (parts[1].equals("mp4")) {
                tarchivo = 1;
            } else {
                if (parts[1].equals("png")) {
                    tarchivo = 0;
                } else {
                    break;
                }
            }*/

            if (!file[i].isEmpty()) {
                try {
                    byte[] bytes = file[i].getBytes();
                    BufferedOutputStream stream
                            = new BufferedOutputStream(new FileOutputStream(new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\HackaProject\\complementos\\" + name)));
                    stream.write(bytes);
                    stream.close();
                    respuesta = "You successfully uploaded " + name + " into " + name + "-uploaded !";
                    respuestachida = respuestachida + respuesta;

                    archivos[tarchivo] = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\HackaProject\\complementos\\" + name;

                    //archivos[tarchivo] = "http://189.205.81.150:8080/Escudo_Yucatan/complementos/" + name;
                    //archivos[tarchivo] = "http://54.183.159.116/Escudo_Yucatan/complementos/" + name;
                    //archivos[tarchivo] = "http://services-promad.ddns.net:8585/Escudo_Yucatan/complementos/" + name;
                } catch (Exception e) {
                    respuesta = "You failed to upload " + name + " => " + e.getMessage();
                    return respuesta;
                }
            } else {
                respuesta = "You failed to upload " + name + " because the file was empty.";
                respuestachida = respuestachida + respuesta;
                //return respuesta;
            }
        }
        
        File uploadFile1 = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\HackaProject\\complementos\\" + name);
        
        try {
            System.out.println("entra a multipart");
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
             
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
             
            multipart.addFormField("description", "Cool Pictures");
            multipart.addFormField("keywords", "Java,upload,Spring");
            
            multipart.addFilePart("fileUpload", uploadFile1);
            System.out.println("subio archivo");
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
             
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

        LOG.debug("respuesta " + respuestachida);
        LOG.debug("se subieron " + i + " archivos");

        return respuestachida;
    }
    
    @RequestMapping(value = "/ErrorPerfil")
    // <editor-fold defaultstate="collapsed" desc="vista login">
    public ModelAndView errorperfil(HttpServletRequest request, Exception e) {

        _modelandview = new ModelAndView();
        _modelandview.setViewName("errorPerfil");
        return _modelandview;
    }

}
