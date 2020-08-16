package com.meuSite.teste.service;

import com.meuSite.teste.domain.Cargo;
import com.meuSite.teste.util.PaginacaoUtil;

import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo);

    void editar (Cargo cargo);

    void excluir(Long id);

    Cargo buscarPorId(Long id);

    List<Cargo> buscarTodos();

    boolean cargoTemFuncionarios(Long id);

    PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao);
}
