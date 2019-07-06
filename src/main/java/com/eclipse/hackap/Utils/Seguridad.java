/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclipse.hackap.Utils;

import org.apache.axis.encoding.Base64;
/**
 *
 * @author luich
 */
public class Seguridad {

    public Seguridad() {
    }

    public static String encripta(String cadena) {
        String claveEncriptada = null;
        try {
            cadena = cadena.trim();
            claveEncriptada = Base64.encode(cadena.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claveEncriptada;
    }

    public static String desencripta(String cadena) {
        byte[] decodeBytes = null;
        String str = null;
        try {
            cadena = cadena.trim();
            decodeBytes = Base64.decode(cadena);
            str = new String(decodeBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

}
