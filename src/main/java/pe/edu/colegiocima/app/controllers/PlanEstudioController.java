/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pe.edu.colegiocima.app.exception.EntityNotFoundException;
import pe.edu.colegiocima.app.models.entity.AnioLectivo;
import pe.edu.colegiocima.app.models.entity.AreaAsignatura;
import pe.edu.colegiocima.app.models.entity.Grado;
import pe.edu.colegiocima.app.models.entity.PlanEstudio;
import pe.edu.colegiocima.app.services.PlanEstudioService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController(value="planestudio")
@RequestMapping("/planestudio")
@Api(tags = "API Plan Estudio", description = "API del CRUD Plan Estudio")
@Slf4j
//@Log4j2
public class PlanEstudioController {
    @Autowired
    private PlanEstudioService service;
    
    //@GetMapping("/listar")
    @RequestMapping(value="/listar", method = RequestMethod.GET
            //, produces ="application/json",consumes = "application/json"
    )
    @ApiOperation(value = "Lista todos los plan de estudio")
    public ResponseEntity<?> listar(){
        try {
           // int a=1/0;//Simulacion
            return ResponseEntity.ok(service.findAll());//200
        }catch(Exception e) {
            log.error("error del sistema",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value="/filtar/aniolectivo/{idAnioLectivo}/grado/{idGrado}", method = RequestMethod.GET)
    @ApiOperation(value = "Filtra los planes de estudio segun el año lectivo y el grado")
    public ResponseEntity<?> filtrar(
            @PathVariable
            Short idAnioLectivo,
            @PathVariable
            Short idGrado
        ){
         return ResponseEntity.ok(service.busquedaPersonalizada(idAnioLectivo, idGrado));
    }
    //@PostMapping()
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo registro del plan de estudio")
    public ResponseEntity<?> crear(@Valid @RequestBody
        @ApiParam(value = "Estructura del modelo plan estudio")
        PlanEstudio  planEstudio, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }

        PlanEstudio gradoDB= service.save(planEstudio);
        return ResponseEntity.status(HttpStatus.CREATED).body(gradoDB);
    }

    public   ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        List<FieldError> lError = result.getFieldErrors();
        for (FieldError error : lError) {
            errores.put(error.getField(),"El campo " +error.getField() +" "+error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errores);
    }

    //@PutMapping("/{id}")
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Edita un registro del plan de estudio")
    public ResponseEntity<?> editar(@Valid @RequestBody
        @ApiParam(value = "Estructura del modelo del plan estudio")
        PlanEstudio planEstudio, BindingResult result,
        @ApiParam(value = "Identificador del plan estudio")
        @PathVariable Short id) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
         var o = service.findById(id).orElseThrow(() -> new EntityNotFoundException(PlanEstudio.class,"id",id.toString()));
         /*if(Objects.isNull(o)) {
             return  ResponseEntity.notFound().build();
         }*/
         AnioLectivo oAnioLectivo=Objects.nonNull(planEstudio.getAnioLectivo())?planEstudio.getAnioLectivo():new AnioLectivo();
         Grado oGrado=Objects.nonNull(planEstudio.getGrado())?planEstudio.getGrado():new Grado();
         AreaAsignatura oAreaAsignatura=Objects.nonNull(planEstudio.getAreaAsignatura())?planEstudio.getAreaAsignatura():new AreaAsignatura();
         
         PlanEstudio planEstudioDb= o;
         planEstudioDb.setHoras(planEstudio.getHoras());
         planEstudioDb.setAnioLectivo(oAnioLectivo);
         planEstudioDb.setGrado(oGrado);
         planEstudio.setAreaAsignatura(oAreaAsignatura);
         
         return ResponseEntity.status(HttpStatus.CREATED).body(service.save(planEstudioDb));
    }

    //@DeleteMapping("{id}")
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Elimina registro del plan de estudio")
    public ResponseEntity<?> eliminar(
            @PathVariable
            @ApiParam(value = "Identificador del plan estudio",required = true,example = "16")
            Short id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Ver plan de estudio")
    public ResponseEntity<?> ver(
            @PathVariable
            @ApiParam(value = "Identificador del plan estudio",required = true,example = "16")
                    Short id) {
        PlanEstudio oPlanEstudio = service.findById(id).orElseThrow(() -> new EntityNotFoundException(PlanEstudio.class,"id",id.toString()));
        return ResponseEntity.ok(oPlanEstudio);
    }
}
