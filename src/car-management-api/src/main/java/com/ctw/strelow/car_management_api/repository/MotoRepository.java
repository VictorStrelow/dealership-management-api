package com.ctw.strelow.car_management_api.repository;

import com.ctw.strelow.car_management_api.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

    List<Moto> findByMarcaIgnoreCase(String marca);
    Optional<Moto> findByPlaca(String placa);

}