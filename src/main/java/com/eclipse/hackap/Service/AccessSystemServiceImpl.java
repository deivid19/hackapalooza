/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eclipse.hackap.Service;

import com.eclipse.hackap.DAO.AccesSystemDAO;
import com.eclipse.hackap.Model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iCharly
 */
@Service
public class AccessSystemServiceImpl implements AccessSystemService{
    
    @Autowired
    private AccesSystemDAO _accessystemdao;


    @Override
    public List<Object[]> getCredenciales(String usuario, String password) {
        return _accessystemdao.getCredenciales(usuario, password);
    }

    @Override
    public List<Object[]> obtenerUsuario(String id_usuario) {
        return _accessystemdao.obtenerUsuario(id_usuario);
    }

    @Override
    public List<Object[]> obtenerIncludeJsp(String id_tipo) {
        return _accessystemdao.obtenerIncludeJsp(id_tipo);
    }

  
    
}
