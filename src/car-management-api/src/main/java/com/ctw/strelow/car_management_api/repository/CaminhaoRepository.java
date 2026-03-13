package com.ctw.strelow.car_management_api.repository;

import com.ctw.strelow.car_management_api.entity.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

    List<Caminhao> findByMarcaIgnoreCase(String marca);
    Optional<Caminhao> findByPlaca(String placa);

}