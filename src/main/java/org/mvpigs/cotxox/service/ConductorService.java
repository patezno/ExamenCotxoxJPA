package org.mvpigs.cotxox.service;

import org.mvpigs.cotxox.domain.Conductor;
import org.mvpigs.cotxox.repo.ConductorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepo conductorRepo;

    public String saveConductor(String tarjeta, String nombre, String matricula, String modelo) {
        Conductor conductor = new Conductor();
        conductor.setTarjeta(tarjeta);
        conductor.setNombre(nombre);
        conductor.setMatricula(matricula);
        conductor.setModelo(modelo);
        conductorRepo.save(conductor);
        return conductor.getTarjeta();
    }

    public Conductor recuperarConductor(String id) {
        return conductorRepo.findById(id).get();
    }
}
