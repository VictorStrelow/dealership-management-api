package com.ctw.strelow.car_management_api.repository;

import com.ctw.strelow.car_management_api.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByMarcaIgnoreCase(String marca);
    Optional<Carro> findByPlaca(String placa);

}