package org.mvpigs.cotxox.repo;

import org.mvpigs.cotxox.domain.Conductor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConductorRepo extends CrudRepository<Conductor, String> {

    List<Conductor> findByOcupado(Integer i);
}
