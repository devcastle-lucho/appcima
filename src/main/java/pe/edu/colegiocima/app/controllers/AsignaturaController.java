/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.colegiocima.app.services.AsignaturaService;

@RestController(value="asignatura")
@RequestMapping("/asignatura")
@Api(tags = "API Asignatura", description = "API del Listado de las asignaturas")
public class AsignaturaController {
    @Autowired
    private AsignaturaService service;
    
    @GetMapping("/listar")
    @ApiOperation(value = "Lista todas las signaturas")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.findAll());
    }
}
