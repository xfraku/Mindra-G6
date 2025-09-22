package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.SitiosWeb;

import java.util.Optional;

public interface ISitiosWebRepository extends JpaRepository<SitiosWeb, Integer> {
    Optional<SitiosWeb> findByDominio(String dominio);
    boolean existsByDominio(String dominio);

}
