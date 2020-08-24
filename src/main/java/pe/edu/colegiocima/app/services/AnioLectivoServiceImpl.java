/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.services;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.app.models.dto.AnioLectivoDTO;
import pe.edu.colegiocima.app.models.entity.AnioLectivo;
import pe.edu.colegiocima.app.models.repository.AnioLectivoRepository;

import java.util.List;
import java.util.logging.Level;

//@Log
@Slf4j
//@Log4j2
@Service
public class AnioLectivoServiceImpl implements AnioLectivoService{
    @Autowired
    private AnioLectivoRepository repository;
    @Override
    @Transactional(readOnly = true)
    public Iterable<AnioLectivo> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AnioLectivo findById(Short id) {
        //3 peticiones:
        // 1 sentencia 30 segundos
        // 2 sentencia 25 segundos
        // 3 sentencia 1m:20 segundos

        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnioLectivoDTO> findActive() {
        //log.log(Level.INFO,"Service: Listar año lectivo");
        log.info("Service: Listar año lectivo");
        return repository.busquedaActivo();
    }
    
}
