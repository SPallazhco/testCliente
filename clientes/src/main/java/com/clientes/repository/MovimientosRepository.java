package com.clientes.repository;

import com.clientes.entity.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public interface MovimientosRepository extends JpaRepository<Movimientos, Integer> {

    @Query(nativeQuery = true, value="select * from clientes.movimientos where fecha between :startDate and :endDate")
    List<Movimientos> getDataBetween(@Param("startDate") Date date, @Param("endDate") Date date2);
    @Query(value = "SELECT saldo FROM clientes.movimientos WHERE cuenta_idcuenta = :idCuenta ORDER BY fecha DESC LIMIT 1;",
    nativeQuery = true)
    Long findSaldoActualByIdCuenta(@Param("idCuenta") Integer idCuenta);
    List<Movimientos> findByCuentaIdcuenta(Integer idCuenta);

    Integer deleteMovimientosByIdmovimientos(Integer idMovimientos);


}
