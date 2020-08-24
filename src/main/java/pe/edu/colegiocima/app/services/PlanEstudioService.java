/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.services;

import pe.edu.colegiocima.app.models.entity.PlanEstudio;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luis
 */
public interface PlanEstudioService {
    public Iterable<PlanEstudio> findAll();
    public List<PlanEstudio> busquedaPersonalizada(Short idAnioLectivo, Short idGrado);
    public PlanEstudio save(PlanEstudio entity);
    public void deleteById(Short id);
    public Optional<PlanEstudio> findById(Short id);
}
