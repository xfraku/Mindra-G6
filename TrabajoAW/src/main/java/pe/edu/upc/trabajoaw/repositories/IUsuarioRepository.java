package pe.edu.upc.trabajoaw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoaw.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
