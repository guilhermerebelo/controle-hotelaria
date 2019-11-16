package ufsc.hotel.gerador;

import me.xdrop.jrand.JRand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ufsc.hotel.model.funcionario.Funcionario;
import ufsc.hotel.model.funcionario.FuncionarioBuilder;
import ufsc.hotel.model.funcionario.FuncionarioRepository;
import ufsc.hotel.model.hospede.Hospede;
import ufsc.hotel.model.hospede.HospedeBuilder;
import ufsc.hotel.model.hospede.HospedeRepository;
import ufsc.hotel.model.hotel.Hotel;
import ufsc.hotel.model.hotel.HotelBuilder;
import ufsc.hotel.model.hotel.HotelRepository;
import ufsc.hotel.model.locacao.LocacaoRepository;
import ufsc.hotel.model.pessoa.PessoaFisica;
import ufsc.hotel.model.pessoa.PessoaFisicaBuilder;
import ufsc.hotel.model.pessoa.PessoaFisicaRepository;
import ufsc.hotel.model.produto.Produto;
import ufsc.hotel.model.produto.ProdutoBuilder;
import ufsc.hotel.model.produto.ProdutoRepository;
import ufsc.hotel.model.quarto.Quarto;
import ufsc.hotel.model.quarto.QuartoBuilder;
import ufsc.hotel.model.quarto.QuartoRepository;
import ufsc.hotel.model.tipoquarto.TipoQuarto;
import ufsc.hotel.model.tipoquarto.TipoQuartoBuilder;
import ufsc.hotel.model.tipoquarto.TipoQuartoRepository;

import java.math.BigDecimal;
import java.util.*;

import static ufsc.hotel.gerador.TipoEntidade.*;

@Component
public class GeradorDados {

    public static HashMap<TipoEntidade, List<?>> dados = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(GeradorDados.class);

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private TipoQuartoRepository tipoQuartoRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LocacaoRepository locacaoRepository;

    public void gerar() {
        try {
            this.gerarFuncionario();
            this.gerarHospede();
            this.gerarHotel();

            this.gerarProduto();
            this.gerarTipoQuarto();
            this.gerarQuarto();
            this.gerarLocacao();

            LOGGER.info("Dados gerados com sucesso!");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    private void gerarPessoaFisica() {
        gerarPessoaFisica(20);
    }

    private void gerarPessoaFisica(int total) {
        List<PessoaFisica> pessoaFisicas = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            PessoaFisica pessoaFisica = PessoaFisicaBuilder.create()
                    .nome(JRand.name().gen())
                    .cpf(JRand.string().digits().length(11).gen())
                    .dataNascimento(JRand.birthday().adult().gen())
                    .build();

            pessoaFisicas.add(pessoaFisica);
        }

        dados.put(PESSOA_FISICA, pessoaFisicaRepository.saveAll(pessoaFisicas));
    }

    private void gerarFuncionario() {
        int TOTAL = 20;

        List<Funcionario> entidades = new ArrayList<>();
        gerarPessoaFisica(TOTAL);

        dados.get(PESSOA_FISICA)
                .stream()
                .map(o -> (PessoaFisica) o)
                .forEach(pessoaFisica -> {
                    Funcionario funcionario = funcionarioRepository.save(
                            FuncionarioBuilder.create()
                                    .pessoaFisica(pessoaFisica)
                                    .build()
                    );

                    entidades.add(funcionario);
                });

        dados.put(FUNCIONARIO, entidades);
    }

    private void gerarHospede() {
        int TOTAL = 20;

        List<Hospede> entidades = new ArrayList<>();
        gerarPessoaFisica(TOTAL);

        dados.get(PESSOA_FISICA)
                .stream()
                .map(o -> (PessoaFisica) o)
                .forEach(pessoaFisica -> {
                    Hospede hospede = hospedeRepository.save(
                            HospedeBuilder.create()
                                    .pessoaFisica(pessoaFisica)
                                    .build()
                    );

                    entidades.add(hospede);
                });

        dados.put(HOSPEDE, entidades);
    }

    private void gerarHotel() {
        Hotel hotel = hotelRepository.save(
                HotelBuilder.create()
                        .nome("Hotel")
                        .funcionarios((List<Funcionario>) dados.get(FUNCIONARIO))
                        .build()
        );

        dados.put(HOTEL, Collections.singletonList(hotel));
    }

    private void gerarProduto() {
        List<Produto> produtos = Arrays.asList(
                ProdutoBuilder.create()
                        .descricao("Água")
                        .valor(BigDecimal.valueOf(3))
                        .build(),
                ProdutoBuilder.create()
                        .descricao("Coca cola")
                        .valor(BigDecimal.valueOf(5))
                        .build(),
                ProdutoBuilder.create()
                        .descricao("Pepsi")
                        .valor(BigDecimal.valueOf(4))
                        .build(),
                ProdutoBuilder.create()
                        .descricao("Pizza")
                        .valor(BigDecimal.valueOf(25))
                        .build(),
                ProdutoBuilder.create()
                        .descricao("Vinho")
                        .valor(BigDecimal.valueOf(80))
                        .build()
        );

        dados.put(PRODUTO, produtoRepository.saveAll(produtos));
    }

    private void gerarTipoQuarto() {
        List<TipoQuarto> tipoQuartos = Arrays.asList(
                createTipoQuarto("Quarto solteiro", (List<Produto>) dados.get(PRODUTO), 100),
                createTipoQuarto("Quarto solteiro duplo",(List<Produto>) dados.get(PRODUTO), 80),
                createTipoQuarto("Quarto casal", (List<Produto>) dados.get(PRODUTO), 150),
                createTipoQuarto("Master", (List<Produto>) dados.get(PRODUTO),350),
                createTipoQuarto("Deluxe",(List<Produto>) dados.get(PRODUTO), 500)
        );

        dados.put(TIPO_QUARTO, tipoQuartoRepository.saveAll(tipoQuartos));
    }

    private TipoQuarto createTipoQuarto(String s, List<Produto> produtos, int i) {
        return TipoQuartoBuilder.create()
                .descricao(s)
                .produtos(produtos)
                .diaria(BigDecimal.valueOf(i))
                .build();
    }

    private void gerarQuarto() {
        int TOTAL = 35;

        List<Quarto> entidades = new ArrayList<>();
        List<TipoQuarto> quartos = (List<TipoQuarto>) dados.get(TIPO_QUARTO);

        for (int i = 0; i < TOTAL; i++) {
            Quarto quarto = QuartoBuilder.create()
                    .codigo(JRand.string().digits().length(3).gen())
                    .tipoQuarto(quartos.get(JRand.natural().range(0, quartos.size() - 1).gen()))
                    .build();

            entidades.add(quarto);
        }

        dados.put(QUARTO, quartoRepository.saveAll(entidades));
    }


    private void gerarLocacao() {

    }
}
