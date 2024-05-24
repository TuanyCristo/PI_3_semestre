/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.dao.ReservaDAO;
import model.reserva.Reserva;

/**
 *
 * @author tcris
 */
public class ReservaController{
    
    private ReservaDAO dao;
    private LivroController livroController;
    
    public ReservaController() {
        this.dao = new ReservaDAO();
        this.livroController = new LivroController();
    }
    
        public ReservaController(int id) {
        this.dao = new ReservaDAO();
        this.livroController = new LivroController();
    }
    
    public boolean fazerReserva(int idUser, List<Integer> idLivros) {
        try {
            Reserva novaReserva = new Reserva(idUser);
            int idReserva = dao.retornaReserva(novaReserva);

            if (idReserva != -1) { 
                for (int idLivro : idLivros) {
                    if (!dao.associarLivroReserva(idReserva, idLivro)) {
                        dao.cancelarReserva(idReserva);
                        return true;
                    }
                }
            } else {
                return false; 
            }
        } catch (Exception e) {
            return false; 
        }
        return true;
    }

}
