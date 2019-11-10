package ufsc.hotel.model.locacao;

import org.springframework.stereotype.Service;

@Service
public class LocacaoService {

    /*
    Elaboração e apresentação de um conjunto de consultas que sumarizem as informações
    partir de cada uma das consultas (elaborar no mínimo 3 (três) consultas) gráficos devem
    do banco de dados envolvendo algumas (mais de duas) tabelas e funções de agregação.


    A ser produzidos. Deve-se ainda prover uma descrição do objetivo de cada consulta, assim
    como, uma pequena amostra do resultado, ou seja, um conjunto de linhas recuperadas a
    partir da consulta (1,0 pontos);
    */

    /*
     * Elaborar 3 graficos com pelo menos 2 ou 3 tabelas, e com funão de agregação
     *
     * Media valor locacao mensal / criar um grafico com os ultimos meses
     * ticket medio de uma locacao / criar um grafico com os ultimos meses
     * porcentagem de ocupação do hotel / criar um grafico com os ultimos meses
     *
     * quarto mais locado
     * funcionarios que fizeram mais locacao
     *
     *
     * */

    private LocacaoRepository repository;

    public LocacaoService(LocacaoRepository repository) {
        this.repository = repository;
    }
}
