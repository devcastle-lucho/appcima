/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.services;

import pe.edu.colegiocima.app.models.dto.AnioLectivoDTO;
import pe.edu.colegiocima.app.models.entity.AnioLectivo;

import java.util.List;

/**
 *
 * @author Luis
 */
public interface AnioLectivoService {
    public Iterable<AnioLectivo> findAll();
    public AnioLectivo findById(Short id);
    public List<AnioLectivoDTO> findActive();
}
