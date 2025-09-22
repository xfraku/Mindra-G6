package pe.edu.upc.trabajoaw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.trabajoaw.dtos.RankingEmocionViewDTO;
import pe.edu.upc.trabajoaw.dtos.UsuarioRegistroViewDTO;
import pe.edu.upc.trabajoaw.servicesinterfaces.IHistoriaEmocionalService;

import java.util.List;

@RestController
@RequestMapping("/historiaemocional")
public class HistoriaEmocionalController {

    @Autowired
    private IHistoriaEmocionalService service;

    @GetMapping("/usuarios-mas-registros-por-emocion")
    public List<UsuarioRegistroViewDTO> getUsuariosMasRegistrosPorEmocion() {
        return service.findUsuariosMasRegistrosPorEmocion();
    }

    @GetMapping("/ranking-emociones")
    public List<RankingEmocionViewDTO> getRankingEmociones() {
        return service.findRankingEmociones();
    }
}