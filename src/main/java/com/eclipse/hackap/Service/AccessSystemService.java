/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eclipse.hackap.Service;

import com.eclipse.hackap.Model.Usuario;
import java.util.List;

/**
 *
 * @author iCharly
 */
public interface AccessSystemService {
    public List<Object[]> getCredenciales(String usuario, String pass);
    public List<Object[]> obtenerUsuario(String id_usuario);
    public List<Object[]> obtenerIncludeJsp (String id_tipo);
}
