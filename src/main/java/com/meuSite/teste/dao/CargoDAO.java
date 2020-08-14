package com.meuSite.teste.dao;

import com.meuSite.teste.domain.Cargo;
import java.util.List;

public interface CargoDAO {

    void save(Cargo departamento);

    void update(Cargo departamento);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
}
