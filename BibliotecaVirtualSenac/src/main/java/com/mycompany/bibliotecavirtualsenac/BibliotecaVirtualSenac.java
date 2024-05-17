/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotecavirtualsenac;

import javax.swing.SwingUtilities;
import view.TelaTeste;

/**
 *
 * @author tuany.bcristo
 */
public class BibliotecaVirtualSenac {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaTeste().setVisible(true);
            }
            
        });
    }

}
