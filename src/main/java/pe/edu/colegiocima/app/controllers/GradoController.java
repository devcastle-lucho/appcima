package pe.edu.colegiocima.app.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pe.edu.colegiocima.app.models.entity.Grado;
import pe.edu.colegiocima.app.services.GradoService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController(value = "grado")
@RequestMapping("/grado")
@Api(tags = "API Grado", description = "API del CRUD Grado")
public class GradoController {
    @Autowired
    private GradoService service;
    //Log Estandar de Java: JUL -> Java Util Logging
    private static final Logger log = Logger.getLogger(GradoController.class.getName());

    @GetMapping(value = "/listar")
    @ApiOperation(value = "Lista todos los grados")
    @PreAuthorize("hasRole('ROLE_DIRECTOR')")
    public ResponseEntity<?> listar(){
        log.log(Level.INFO,"Antes de listar grado");
         return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/listar-nivelcolegio/{id}")
    @ApiOperation(value = "Lista todos los grados")
    public ResponseEntity<?> listarPorNivelColegio(
            @PathVariable Integer id
    ){
        //int a=1/0;
        return ResponseEntity.ok(service.findByIdNivelColegioOrderByDescripcion(id));
    }
    
    @GetMapping("/listar/nivelcolegio/{id}/pagina")
    @ApiOperation(value = "Lista todos los grados y paginado por nivel colegio")
    public ResponseEntity<?> listarPorNivelColegio(
            @PathVariable Integer id,
            Pageable pageable
    ){
        return ResponseEntity.ok(service.findByIdNivelColegioOrderByDescripcionAsc(id,pageable));
    }

    @PostMapping(
            consumes = "application/json",produces = "application/json"
    )
    @ApiOperation(value = "Crea un nuevo registro del grado academico")
    public ResponseEntity<?> crear(@Valid @RequestBody
        @ApiParam(value = "Estructura del modelo Grado Academico")
        Grado grado , BindingResult result
    ) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Grado gradoDB= service.save(grado);
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

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_TECNOLOGÍA DE INFORMACIÓN (SISTEMAS)')")
    @ApiOperation(value = "Edita un registro del grado academico")
    public ResponseEntity<?> editar(@Valid @RequestBody
        @ApiParam(value = "Estructura del modelo Grado Academico")
        Grado grado, BindingResult result,
        @ApiParam(value = "Identificador del grado")
        @PathVariable Short id) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
         Grado o =service.findById(id);
        // if(o == null)
         if(Objects.isNull(o)) {
             return  ResponseEntity.notFound().build();
         }

         Grado gradoDb= o;
         gradoDb.setDescripcion(grado.getDescripcion());
         gradoDb.setEdad(grado.getEdad());
         gradoDb.setIdNivelColegio(grado.getIdNivelColegio());
         gradoDb.setCirculoEstudio(grado.isCirculoEstudio());
         gradoDb.setIdGradoAnterior(grado.getIdGradoAnterior());

         return ResponseEntity.status(HttpStatus.CREATED).body(service.save(gradoDb));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Elimina registro del grado academico")
    public ResponseEntity<?> eliminar(
            @PathVariable
            @ApiParam(value = "Identificador del grado",required = true,example = "16")
            Short id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
