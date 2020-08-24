/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.app.models.dto.projection.AreaAsignaturaVista;
import pe.edu.colegiocima.app.models.entity.AreaAsignatura;
import pe.edu.colegiocima.app.models.repository.AreaAsignaturaRepository;

import java.util.List;

@Service    
@Transactional(readOnly = true)
public class AreaAsignaturaServiceImpl implements AreaAsignaturaService
{
    @Autowired
    AreaAsignaturaRepository repository;
    @Override
    public Iterable<AreaAsignatura> findAll() {
        return repository.findAll();
    }

    @Override
    public List<AreaAsignaturaVista> findCustom() {
        return repository.findCustom();
    }        
}
