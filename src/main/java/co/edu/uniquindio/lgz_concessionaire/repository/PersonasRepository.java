package co.edu.uniquindio.lgz_concessionaire.repository;

import co.edu.uniquindio.lgz_concessionaire.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Persona,Long> {
}
