/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.app.models.entity.Asignatura;
import pe.edu.colegiocima.app.models.repository.AsignaturaRepository;

/**
 *
 * @author Luis
 */
@Service
public class AsignaturaServiceImpl implements AsignaturaService{
    @Autowired
    private AsignaturaRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Asignatura> findAll() {
        return repository.findAll();
    }
    
}
