/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.services;

import pe.edu.colegiocima.app.models.entity.Asignatura;

/**
 *
 * @author Luis
 */
public interface AsignaturaService {
    public Iterable<Asignatura> findAll();
}
