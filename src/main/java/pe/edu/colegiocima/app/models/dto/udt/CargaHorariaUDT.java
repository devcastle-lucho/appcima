/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.colegiocima.app.models.dto.udt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

@AllArgsConstructor
@NoArgsConstructor
public class CargaHorariaUDT  implements SQLData{
      public static final String TYPE_NAME = "public.tp_cargahoraria";
      private Short iddocente;
      private Short idgradoseccion;

    @Override
    public String getSQLTypeName() throws SQLException {
        return TYPE_NAME;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.iddocente = stream.readShort();
        this.idgradoseccion = stream.readShort();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeShort(this.iddocente);
        stream.writeShort(this.idgradoseccion);
    }

    public Short getIddocente() {
        return this.iddocente;
    }

    public Short getIdgradoseccion() {
        return this.idgradoseccion;
    }

    public void setIddocente(Short iddocente) {
        this.iddocente = iddocente;
    }

    public void setIdgradoseccion(Short idgradoseccion) {
        this.idgradoseccion = idgradoseccion;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CargaHorariaUDT)) return false;
        final CargaHorariaUDT other = (CargaHorariaUDT) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$iddocente = this.getIddocente();
        final Object other$iddocente = other.getIddocente();
        if (this$iddocente == null ? other$iddocente != null : !this$iddocente.equals(other$iddocente)) return false;
        final Object this$idgradoseccion = this.getIdgradoseccion();
        final Object other$idgradoseccion = other.getIdgradoseccion();
        if (this$idgradoseccion == null ? other$idgradoseccion != null : !this$idgradoseccion.equals(other$idgradoseccion))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CargaHorariaUDT;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $iddocente = this.getIddocente();
        result = result * PRIME + ($iddocente == null ? 43 : $iddocente.hashCode());
        final Object $idgradoseccion = this.getIdgradoseccion();
        result = result * PRIME + ($idgradoseccion == null ? 43 : $idgradoseccion.hashCode());
        return result;
    }

    public String toString() {
        return "CargaHorariaUDT(iddocente=" + this.getIddocente() + ", idgradoseccion=" + this.getIdgradoseccion() + ")";
    }
}
