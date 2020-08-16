package com.meuSite.teste.service;

import com.meuSite.teste.dao.CargoDAO;
import com.meuSite.teste.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.PaginacaoUtil;

import java.util.List;

@Service @Transactional(readOnly= false)
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDAO dao;

    @Override
    public void salvar(Cargo cargo) {
        dao.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
        dao.update(cargo);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean cargoTemFuncionarios(Long id) {
        if (buscarPorId(id).getFuncionarios().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public PaginacaoUtil<Cargo> buscarPorPagina(int pagina) {
        return dao.buscaPaginada(pagina);
    }
}
