package pe.edu.upc.trabajoaw.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.dtos.RankingEmocionViewDTO;
import pe.edu.upc.trabajoaw.dtos.UsuarioRegistroViewDTO;
import pe.edu.upc.trabajoaw.repositories.IHistoriaEmocionalRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IHistoriaEmocionalService;

import java.util.List;

@Service
public class HistoriaEmocionalServiceImplement implements IHistoriaEmocionalService {

    @Autowired
    private IHistoriaEmocionalRepository repository;

    @Override
    public List<UsuarioRegistroViewDTO> findUsuariosMasRegistrosPorEmocion() {
        return repository.findUsuariosMasRegistrosPorEmocion();
    }

    @Override
    public List<RankingEmocionViewDTO> findRankingEmociones() {
        return repository.findRankingEmociones();
    }
}