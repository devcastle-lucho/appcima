/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.services;

import pe.edu.colegiocima.app.models.dto.projection.AreaAsignaturaVista;
import pe.edu.colegiocima.app.models.entity.AreaAsignatura;

import java.util.List;

/**
 *
 * @author Luis
 */
public interface AreaAsignaturaService {
    public Iterable<AreaAsignatura> findAll();
    public List<AreaAsignaturaVista> findCustom();
}
