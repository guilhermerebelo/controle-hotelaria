package ufsc.hotel.model.hotel;

import ufsc.hotel.model.funcionario.Funcionario;

import java.util.List;

public final class HotelBuilder {
    private Long id;
    private String nome;
    private List<Funcionario> funcionarios;

    private HotelBuilder() {
    }

    public static HotelBuilder create() {
        return new HotelBuilder();
    }

    public HotelBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public HotelBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public HotelBuilder funcionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
        return this;
    }

    public Hotel build() {
        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setNome(nome);
        hotel.setFuncionarios(funcionarios);
        return hotel;
    }
}
