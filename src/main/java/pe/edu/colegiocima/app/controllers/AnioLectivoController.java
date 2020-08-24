/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.colegiocima.app.models.dto.AnioLectivoDTO;
import pe.edu.colegiocima.app.models.entity.AnioLectivo;
import pe.edu.colegiocima.app.services.AnioLectivoService;

import java.util.Objects;

/**
 *
 * @author Luis
 */
@RestController(value="aniolectivo")
@RequestMapping("/aniolectivo")
@Api(tags = "API Año Lectivo", description = "API del Listado Año Lectivo")
public class AnioLectivoController {
    @Autowired
    private AnioLectivoService service;
    
    @GetMapping("/listar")
    @ApiOperation(value = "Lista todos los años lectivos")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/listar-activo")
    @ApiOperation(value = "Lista todos los años lectivos activos y ordenados por el identificador")    
    public ResponseEntity<Iterable<AnioLectivoDTO>> listarActivo() {
        return ResponseEntity.ok(service.findActive());
    }
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Se busca un año lectivo por su identificador")
    public ResponseEntity<?> ver(
            @ApiParam(value = "Identificador del registro")
            @PathVariable Short id) {
        AnioLectivo o= service.findById(id);
        if (Objects.isNull(o)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findById(id));
    }
    
}
