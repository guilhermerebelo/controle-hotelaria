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
import ufsc.hotel.model.locacao.Locacao;
import ufsc.hotel.model.locacao.LocacaoBuilder;
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

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static ufsc.hotel.gerador.TipoEntidade.*;

@Component
public class GeradorDados {

    //TODO separar em classes
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

    @Transactional
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

        dados.put(PESSOA_FISICA, saveAllPessoaFisica(pessoaFisicas));
    }

    private List<PessoaFisica> saveAllPessoaFisica(List<PessoaFisica> pessoaFisicas) {
        return pessoaFisicas.stream()
                .map(this::savePessoaFisica)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private PessoaFisica savePessoaFisica(PessoaFisica p) {
        try {
            return pessoaFisicaRepository.save(p);
        } catch (RuntimeException e) {
            LOGGER.info("Erro ao tentar persitir algum dado");
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    private void gerarFuncionario() {
        int TOTAL = 20;

        List<Funcionario> entidades = new ArrayList<>();
        gerarPessoaFisica(TOTAL);

        dados.get(PESSOA_FISICA)
                .stream()
                .map(o -> (PessoaFisica) o)
                .forEach(pessoaFisica -> {
                    entidades.add(FuncionarioBuilder.create()
                            .pessoaFisica(pessoaFisica)
                            .build());
                });

        dados.put(FUNCIONARIO, saveAllFuncionarios(entidades));
    }

    private List<Funcionario> saveAllFuncionarios(List<Funcionario> entidades) {
        return entidades.stream()
                .map(this::saveFuncionario)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Funcionario saveFuncionario(Funcionario funcionario) {
        try {
            return funcionarioRepository.save(funcionario);
        } catch (RuntimeException e) {
            LOGGER.info("Erro ao tentar persitir algum dado");
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    private void gerarHospede() {
        int TOTAL = 20;

        List<Hospede> entidades = new ArrayList<>();
        gerarPessoaFisica(TOTAL);

        dados.get(PESSOA_FISICA)
                .stream()
                .map(o -> (PessoaFisica) o)
                .forEach(pessoaFisica -> {
                    entidades.add(HospedeBuilder.create()
                            .pessoaFisica(pessoaFisica)
                            .build());
                });

        dados.put(HOSPEDE, salveAllHospede(entidades));
    }

    private List<Hospede> salveAllHospede(List<Hospede> entidades) {
        return entidades.stream()
                .map(this::saveHospede)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Hospede saveHospede(Hospede hospede) {
        try {
            return hospedeRepository.save(hospede);
        } catch (RuntimeException e) {
            LOGGER.info("Erro ao tentar persitir algum dado");
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    private void gerarHotel() {
        try {
            Hotel hotel = hotelRepository.save(
                    HotelBuilder.create()
                            .nome("Hotel")
                            .funcionarios((List<Funcionario>) dados.get(FUNCIONARIO))
                            .build()
            );

            dados.put(HOTEL, Collections.singletonList(hotel));
        } catch (RuntimeException e) {
            LOGGER.info("Erro ao tentar persitir algum dado");
            LOGGER.warn(e.getMessage());
        }
    }

    @Transactional
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

        dados.put(PRODUTO, saveAllProdutos(produtos));
    }

    private List<Produto> saveAllProdutos(List<Produto> entidades) {
        return entidades.stream()
                .map(this::saveProduto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Produto saveProduto(Produto produto) {
        try {
            return produtoRepository.save(produto);
        } catch (RuntimeException e) {
            LOGGER.info("Erro ao tentar persitir algum dado");
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    private void gerarTipoQuarto() {
        List<TipoQuarto> tipoQuartos = Arrays.asList(
                createTipoQuarto("Quarto solteiro", (List<Produto>) dados.get(PRODUTO), 100),
                createTipoQuarto("Quarto solteiro duplo", (List<Produto>) dados.get(PRODUTO), 80),
                createTipoQuarto("Quarto casal", (List<Produto>) dados.get(PRODUTO), 150),
                createTipoQuarto("Master", (List<Produto>) dados.get(PRODUTO), 350),
                createTipoQuarto("Deluxe", (List<Produto>) dados.get(PRODUTO), 500)
        );

        dados.put(TIPO_QUARTO, saveAllTipoQuarto(tipoQuartos));
    }

    private List<TipoQuarto> saveAllTipoQuarto(List<TipoQuarto> entidades) {
        return entidades.stream()
                .map(this::saveTipoQuarto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private TipoQuarto saveTipoQuarto(TipoQuarto tipoQuato) {
        try {
            return tipoQuartoRepository.save(tipoQuato);
        } catch (RuntimeException e) {
            LOGGER.info("Erro ao tentar persitir algum dado");
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    private TipoQuarto createTipoQuarto(String s, List<Produto> produtos, int i) {
        return TipoQuartoBuilder.create()
                .descricao(s)
                .produtos(produtos)
                .diaria(BigDecimal.valueOf(i))
                .build();
    }

    @Transactional
    private void gerarQuarto() {
        int TOTAL = 35;

        List<Quarto> entidades = new ArrayList<>();

        for (int i = 0; i < TOTAL; i++) {
            Quarto quarto = QuartoBuilder.create()
                    .codigo(JRand.string().digits().length(3).gen())
                    .tipoQuarto((TipoQuarto) randomEntity(TIPO_QUARTO))
                    .build();

            entidades.add(quarto);
        }

        dados.put(QUARTO, saveAllQuarto(entidades));
    }

    private List<Quarto> saveAllQuarto(List<Quarto> entidades) {
        return entidades.stream()
                .map(this::saveQuarto)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Quarto saveQuarto(Quarto quarto) {
        try {
            return quartoRepository.save(quarto);
        } catch (RuntimeException e) {
            LOGGER.info("Erro ao tentar persitir algum dado");
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    @Transactional
    private void gerarLocacao() {
        int TOTAL = 150;
        List<Locacao> entidades = new ArrayList<>();

        for (int i = 0; i < TOTAL; i++) {
            Integer totalDiasLocacao = randomNumber(1, 15);

            LocalDate inicioLocacao = gerarDataRandomica();
            LocalDate finalLocacao = inicioLocacao.plusDays(totalDiasLocacao);

            List<Produto> produtos = new ArrayList<>();
            for (int j = 0; j < randomNumber(1, dados.get(PRODUTO).size() - 1); j++) {
                produtos.add((Produto) randomEntity(PRODUTO));
            }

            entidades.add(gerarLocacao(inicioLocacao, finalLocacao, produtos));
        }

        dados.put(LOCACAO, saveAllLocacao(entidades));
    }

    private List<Locacao> saveAllLocacao(List<Locacao> entidades) {
        return entidades.stream()
                .map(this::saveLocacao)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Locacao saveLocacao(Locacao locacao) {
        try {
            return locacaoRepository.save(locacao);
        } catch (RuntimeException e) {
            LOGGER.info("Erro ao tentar persitir algum dado");
            LOGGER.warn(e.getMessage());
            return null;
        }
    }

    private Locacao gerarLocacao(LocalDate inicioLocacao, LocalDate finalLocacao, List<Produto> produtos) {
        return LocacaoBuilder.create()
                .dataInicial(Date.from(inicioLocacao.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .dataFinal(Date.from(finalLocacao.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .quarto((Quarto) randomEntity(QUARTO))
                .hospede((Hospede) randomEntity(HOSPEDE))
                .pagante((PessoaFisica) randomEntity(PESSOA_FISICA))
                .funcionarioIniciouLocacao((Funcionario) randomEntity(FUNCIONARIO))
                .funcionarioFinalizouLocacao((Funcionario) randomEntity(FUNCIONARIO))
                .produtoConsumidos(produtos)
                .build();
    }

    private LocalDate gerarDataRandomica() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2018, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2019, 10, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    private Object randomEntity(TipoEntidade tipoEntidade) {
        List<?> objects = dados.get(tipoEntidade);
        return objects.get(randomNumber(0, objects.size() - 1));
    }

    private Integer randomNumber(int n1, int n2) {
        return JRand.natural().range(n1, n2).gen();
    }
}
