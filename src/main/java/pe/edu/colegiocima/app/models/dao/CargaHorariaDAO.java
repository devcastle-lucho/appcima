/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.dao;

import pe.edu.colegiocima.app.models.dto.udt.CargaHorariaUDT;

/**
 *
 * @author Luis
 */
public interface CargaHorariaDAO {
    public Integer generar(Short bimestre,Short idPlanEstudio,
                           CargaHorariaUDT[] aCargaHoraria,
                           Short idUsuario);
    public Integer generar(Short bimestre,Short idPlanEstudio,
                           Short[] idDocente, Short[] idGradoSeccion,
                           Short idUsuario, Integer size);
}
