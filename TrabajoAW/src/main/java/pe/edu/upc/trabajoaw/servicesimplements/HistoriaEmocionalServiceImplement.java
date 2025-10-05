package pe.edu.upc.trabajoaw.servicesimplements;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoaw.dtos.RankingEmocionViewDTO;
import pe.edu.upc.trabajoaw.dtos.UsuarioRegistroViewDTO;
import pe.edu.upc.trabajoaw.repositories.IHistoriaEmocionalRepository;
import pe.edu.upc.trabajoaw.servicesinterfaces.IHistoriaEmocionalService;

import java.util.List;

@Slf4j
@Service
public class HistoriaEmocionalServiceImplement implements IHistoriaEmocionalService {

    @Autowired
    private IHistoriaEmocionalRepository repository;

    @Override
    public List<UsuarioRegistroViewDTO> findUsuariosMasRegistrosPorEmocion() {
        log.info("Obteniendo usuarios con más registros por emoción...");
        return repository.findUsuariosMasRegistrosPorEmocion();
    }

    @Override
    public List<RankingEmocionViewDTO> findRankingEmociones() {
        log.info("Consultando ranking de emociones...");
        return repository.findRankingEmociones();
    }
}
