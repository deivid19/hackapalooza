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
import java.util.Random;
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
    //public @ResponseBody
    public String nuevoPost(@RequestParam("image") CommonsMultipartFile[] file, HttpServletRequest request) {//

        LOG.debug("Entra a nuevo Post");

        String respuesta = "";
        String respuestachida = "";
        String name = "";
        String charset = "UTF-8";
        String requestURL = "http://max-facial-emotion-classifier.max.us-south.containers.appdomain.cloud/model/predict";
        String requestSecURL = "http://max-facial-age-estimator.max.us-south.containers.appdomain.cloud/model/predict";
        String emofinal = "";
        String _urlsalida = "";

        int i = 0;
        int tarchivo = 0;

        String[] archivos = {"", "", ""};

        for (i = 0; i < file.length; ++i) {

            name = file[i].getOriginalFilename();
            System.out.println(file[i].getOriginalFilename());
            String[] parts = name.split("\\.");
            if (parts[1].equals("mp4")) {
                tarchivo = 1;
            } else {
                if (parts[1].equals("png")) {
                    tarchivo = 0;
                } else {
                    break;
                }
            }

            if (!file[i].isEmpty()) {
                try {
                    byte[] bytes = file[i].getBytes();
                    BufferedOutputStream stream
                            = new BufferedOutputStream(new FileOutputStream(new File("C:\\fotos\\" + name)));
                    stream.write(bytes);
                    stream.close();
                    respuesta = "You successfully uploaded " + name + " into " + name + "-uploaded !";
                    respuestachida = respuestachida + respuesta;

                    archivos[tarchivo] = "C:\\fotos\\" + name;

                    //archivos[tarchivo] = "http://189.205.81.150:8080/Escudo_Yucatan/complementos/" + name;
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
        
        //File uploadFile1 = new File("/Users/luich/Downloads/CumpleNintendo.png" );
        File uploadFile1 = new File("C:\\fotos\\foto.png");
        try {
            System.out.println("entra a multipart");
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
            MultipartUtility multipartSec = new MultipartUtility(requestSecURL, charset);
             
            //multipart.addHeaderField("Content-type", "");
            
            multipart.addFilePart("image", uploadFile1);
            multipartSec.addFilePart("image", uploadFile1);
            System.out.println("subio archivo: " + uploadFile1);
 
            List<String> response = multipart.finish();
            List<String> responseSec = multipartSec.finish();
            String respuestaEnd1 ="";
            String respuestaEnd2 ="";
            
            System.out.println("SERVER REPLIED:");
            for (String line : response) {
                System.out.println(line);
                respuestaEnd1=respuestaEnd1+" "+line;
            }
            System.out.println("respuesta: " + respuestaEnd1);
            
            JSONObject requestedJSONObject = new JSONObject(respuestaEnd1);
            
            JSONArray prediccion = requestedJSONObject.getJSONArray("predictions");

            JSONObject em1 = prediccion.getJSONObject(0);
            JSONArray emociones = em1.getJSONArray("emotion_predictions");
            double proba = 0.0;
            int id_emocion =0;
            for(int j=0; j<emociones.length();++j){

                JSONObject emocion = emociones.getJSONObject(i);
                if(emocion.getDouble("probability")> proba){
                    proba = emocion.getDouble("probability");
                    emofinal = emocion.getString("label");
                    id_emocion = emocion.getInt("label_id");
                }
            }
            System.out.println("La emocion es: "+ emofinal+" con una proba de: "+proba);
            
            Random r = new Random();
            int low = 1;
            int high = 7;
            int result = r.nextInt(high-low) + low;
            String resStr = String.valueOf(result);
            System.out.println("Numero random: "+ resStr);
            
            /*String elige = "1";
            if(emofinal == "neutral"){
                elige = "1";
            }else if(emofinal == "happiness"){
                elige = "2";
            }else if(emofinal == "contempt"){
                elige = "3";
            }else if(emofinal == "sadness"){
                elige = "4";
            }else if(emofinal == "anger"){
                elige = "5";
            }else if(emofinal == "surprise"){
                elige = "6";
            }else if(emofinal == "disgust"){
                elige = "1";
            }else if(emofinal == "fear"){
                elige = "2";
            }*/
            
            for (String lineSec : responseSec) {
                System.out.println(lineSec);
                respuestaEnd2=respuestaEnd2+" "+lineSec;
            }
            
            JSONObject requestedJSONObject1 = new JSONObject(respuestaEnd2);
            
            JSONArray prediccion1 = requestedJSONObject1.getJSONArray("predictions");

            JSONObject em2 = prediccion1.getJSONObject(0);
            int edad_estimada = em2.getInt("age_estimation");

            System.out.println("La edad estimada es :" + edad_estimada);
            
            String valor = colores(edad_estimada,id_emocion);
            
            System.out.println(valor);
            
            List<Object[]> incljsp = _accessystemservice.obtenerIncludeJsp(resStr);
            
            request.getSession().setAttribute("dashboard", incljsp.get(0)[0].toString());
            request.getSession().setAttribute("estilo", incljsp.get(0)[1].toString());
            request.getSession().setAttribute("color1", valor);
            /*request.getSession().setAttribute("color2", valor + "CC");
            request.getSession().setAttribute("color3", valor + "A6");
            request.getSession().setAttribute("color4", valor + "82");
            request.getSession().setAttribute("color5", valor + "5C");
            request.getSession().setAttribute("color6", valor + "1F");*/
            System.out.println("incl: " + incljsp.get(0)[1].toString());
            System.out.println("entro!");
            _urlsalida = "redirect:/dashboard/inicio";
            
        } catch (IOException ex) {
            System.err.println(ex);
        }


        LOG.debug("respuesta " + respuestachida);
        LOG.debug("se subieron " + i + " archivos");

        return "redirect:/dashboard/inicio";
    }
    
    /*@RequestMapping(value = "/insertImg", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    String handleFileUpload(HttpServletRequest request) {//

        LOG.debug("Entra a nuevo Post");

        String respuesta = "";
        String respuestachida = "";
        String name = "";
        String charset = "UTF-8";
        String requestURL = "http://max-facial-emotion-classifier.max.us-south.containers.appdomain.cloud/model/predict";

        
        
        File uploadFile1 = new File("C:\\fotos\\foto.png" );
        
        try {
            System.out.println("entra a multipart");
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
             
            //multipart.addHeaderField("Content-type", "");
             
            
            multipart.addFilePart("image", uploadFile1);
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
//        LOG.debug("se subieron " + i + " archivos");

        return respuestachida;
    }*/
    
    @RequestMapping(value = "/ErrorPerfil")
    // <editor-fold defaultstate="collapsed" desc="vista login">
    public ModelAndView errorperfil(HttpServletRequest request, Exception e) {

        _modelandview = new ModelAndView();
        _modelandview.setViewName("errorPerfil");
        return _modelandview;
    }
    
    public String colores(int edad, int emocion){
        String[][] matrizColores = {
            {"#D0D1D5,#333333", "#f6c8d5,#193663", "#6766FF,#193663", "#CA35FF,#333333", "#FD9999,#193663", "#FE9AFE,#193663", "#66CC9A,#333333", "#FF67A5,#193663"},
            {"#D0D1D5,#193663", "#f6c8d5,#193663", "#6766FF,#193663", "#CA35FF,#193663", "#FD9999,#193663", "#FE9AFE,#193663", "#66CC9A,#193663", "#FF67A5,#193663"},
            {"#D0D1D5,#193663", "#f6c8d5,#B0C9E9", "#6766FF,#989D9C", "#CA35FF,#193663", "#FD9999,#B0C9E9", "#FE9AFE,#989D9C", "#66CC9A,#193663", "#FF67A5,#B0C9E9"},
            {"#D0D1D5,#181819", "#f6c8d5,#181819", "#6766FF,#181819", "#CA35FF,#181819", "#FD9999,#181819", "#FE9AFE,#181819", "#66CC9A,#181819", "#FF67A5,#181819"},
            {"#D0D1D5,#AA9597", "#f6c8d5,#AA9597", "#6766FF,#AA9597", "#CA35FF,#AA9597", "#FD9999,#AA9597", "#FE9AFE,#AA9597", "#66CC9A,#AA9597", "#FF67A5,#AA9597"}
        };

        int edadMatriz = 0;
        if (10 >= edad && edad <= 19) {
            edadMatriz = 0;
        } else {
            if (20 >= edad && edad <= 30) {
                edadMatriz = 1;
            } else {
                if (31 >= edad && edad <= 40) {
                    edadMatriz = 2;
                } else {
                    if (41 >= edad && edad <= 55) {
                        edadMatriz = 3;
                    } else {
                        if (55 > edad) {
                            edadMatriz = 4;
                        } else {
                        }
                    }
                }
            }
        }
        
        return matrizColores[edadMatriz][emocion];
    }

}
