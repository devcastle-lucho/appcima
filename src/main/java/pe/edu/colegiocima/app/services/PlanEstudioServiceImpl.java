/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.colegiocima.app.models.entity.PlanEstudio;
import pe.edu.colegiocima.app.models.repository.PlanEstudioMapper;
import pe.edu.colegiocima.app.models.repository.PlanEstudioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanEstudioServiceImpl implements PlanEstudioService{
    @Autowired
    private PlanEstudioRepository repository;
    @Autowired
    private PlanEstudioMapper repositoryMapper;
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<PlanEstudio> findAll() {        
        return repository.findAll();
    }

    @Override    
    public PlanEstudio save(PlanEstudio entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Short id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PlanEstudio> findById(Short id) {
        return repository.findById(id);
    }    

    @Override
    public List<PlanEstudio> busquedaPersonalizada(Short idAnioLectivo, Short idGrado) {
        List<PlanEstudio> listaMapper =new ArrayList<>();
        /*List<Map<String,Object>>lista=repository.busquedaPersonalizada(idAnioLectivo, idGrado);
        for (Map<String, Object> map : lista) {
        PlanEstudio o=repositoryMapper.mapperRowBusquedaPersonalizada(map);
        listaMapper.add(o);
        }*/
        repository.busquedaPersonalizada(idAnioLectivo, idGrado)
                .stream().map((map) -> repositoryMapper.mapperRowBusquedaPersonalizada(map)).forEachOrdered(o ->listaMapper.add(o));
        return listaMapper;
    }
}
