package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.entities.HistoriaEmocionalDetalle;
import pe.edu.upc.trabajoaw.repositories.IHistoriaEmocionalDetalleRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IHistoriaEmocionalDetalleService;

import java.util.List;

@Service
public class HistoriaEmocionalDetalleServiceImplement implements IHistoriaEmocionalDetalleService {

    @Autowired
    private IHistoriaEmocionalDetalleRepository repository;

    @Override
    public List<HistoriaEmocionalDetalle> list() {
        return repository.findAll();
    }

    @Override
    public void insertar(HistoriaEmocionalDetalle d) {
        repository.save(d);
    }

    @Override
    public HistoriaEmocionalDetalle listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(HistoriaEmocionalDetalle d) {
        repository.save(d);
    }

    @Override
    public List<HistoriaEmocionalDetalle> listarPorHistorial(int idHistorialEmocional) {
        return repository.findByHistorialEmocional_IdHistoriaEmocional(idHistorialEmocional);
    }
}