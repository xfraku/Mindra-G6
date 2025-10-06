package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.DetalleUsuarioEstudiante;
import pe.edu.upc.trabajoaw.repositories.IDetalleUsuarioEstudianteRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IDetalleUsuarioEstudianteService;

import java.util.List;

@Service
public class DetalleUsuarioEstudianteServiceImplement implements IDetalleUsuarioEstudianteService {

    @Autowired
    private IDetalleUsuarioEstudianteRepository repository;

    @Override
    public List<DetalleUsuarioEstudiante> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(DetalleUsuarioEstudiante d) {
        repository.save(d);
    }

    @Override
    public DetalleUsuarioEstudiante listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(DetalleUsuarioEstudiante d) {
        repository.save(d);
    }

    @Override
    public List<DetalleUsuarioEstudiante> buscarPorCentro(String centroEstudio) {
        return repository.findByCentroEstudioContainingIgnoreCase(centroEstudio);
    }

    @Override
    public List<DetalleUsuarioEstudiante> listarPorUsuario(int idUsuario) {
        return repository.findByUsuario_IdUsuario(idUsuario);
    }
}