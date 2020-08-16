package com.meuSite.teste.dao;

import com.meuSite.teste.domain.Cargo;
import com.meuSite.teste.util.PaginacaoUtil;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CargoDAOImpl extends AbstractDao<Cargo, Long> implements CargoDAO {

    public PaginacaoUtil<Cargo> buscaPaginada(int pagina, String direcao) {
        int tamanho = 5;
        int inicio = (pagina-1) * tamanho;
        List<Cargo> cargos = getEntityManager()
                .createQuery("select c from Cargo c order by c.nome " + direcao, Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalPaginas = (totalRegistros + (tamanho-1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalPaginas, direcao, cargos);
    }

    public long count(){
        return getEntityManager().createQuery("select count(*) from cargo", Long.class)
                .getSingleResult();
    }
}
