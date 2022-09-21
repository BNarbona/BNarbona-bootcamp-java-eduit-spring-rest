package ar.com.educationit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.educationit.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long>{

}
