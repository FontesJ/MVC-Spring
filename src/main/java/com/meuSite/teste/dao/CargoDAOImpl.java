package com.meuSite.teste.dao;

import com.meuSite.teste.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoDAOImpl extends AbstractDao<Cargo, Long> implements CargoDAO {

    public PaginacaoUtil<Cargo> buscaPaginada(int pagina) {
        int tamanho = 5;
        int inicio = (pagina-1) * tamanho;
        List<Cargo> cargos = getEntityManager()
                .createQuery("select c from Cargo c order by c.nome asc", Cargo.class)
                .setFirstResult(inicio)
                .setMaxResults(tamanho)
                .getResultList();

        long totalRegistros = count();
        long totalPaginas = (totalRegistros + (tamanho-1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalPaginas, Cargos);
    }

    public long count(){
        return getEntityManager().createNamedQuery("select count(*) from cargo", Long.class)
                .getSingleResult();
    }
}
