package pe.edu.upc.trabajoaw.servicesinterfaces;

import pe.edu.upc.trabajoaw.dtos.RankingEmocionViewDTO;
import pe.edu.upc.trabajoaw.dtos.UsuarioRegistroViewDTO;

import java.util.List;

public interface IHistoriaEmocionalService {

    List<UsuarioRegistroViewDTO> findUsuariosMasRegistrosPorEmocion();
    List<RankingEmocionViewDTO> findRankingEmociones();
}