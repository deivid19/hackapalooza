/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eclipse.hackap.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author iCharly
 */
@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    
    @Column(name="valcol")    
    private String valcol;
    
    @Column(name="idperfil")    
    private int idperfil;
    
    @Column(name="usuario")    
    private String usuario;
    
    @Column(name="email")    
    private String email;
    
    @Column(name="password")    
    private String password;
    
    @Column(name="foto")    
    private String foto;
    
    @Column(name="nombre") 
    private String nombre;
    
    @Column(name="appat") 
    private String appat;
    
    @Column(name="apmat") 
    private String apmat;
    
    @Transient   
    private String perfil;
    
    
    public Usuario(int id, String valcol, int idperfil, String usuario, String email, String password, String foto) {
        this.id = id;
        this.valcol = valcol;
        this.idperfil = idperfil;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.foto = foto;
    }

    public Usuario() {
    }

    public Usuario(int id, String valcol, int idperfil, String usuario, String email, String password, String foto, String nombre, String appat, String apmat, String perfil) {
        this.id = id;
        this.valcol = valcol;
        this.idperfil = idperfil;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.foto = foto;
        this.nombre = nombre;
        this.appat = appat;
        this.apmat = apmat;
        this.perfil = perfil;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdPerfil() {
        return idperfil;
    }

    public void setIdPerfil(int perfil) {
        this.idperfil = perfil;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

 
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getValcol() {
        return valcol;
    }

    public void setValcol(String valcol) {
        this.valcol = valcol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }
    
    
    
    
}
