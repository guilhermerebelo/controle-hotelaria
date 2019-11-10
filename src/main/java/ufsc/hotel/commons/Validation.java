package ufsc.hotel.commons;

import java.util.Arrays;
import java.util.List;

//TODO utlizar validation para criar as validações dos objetos, criar as validaçãoes em objetos separados
public class Validation<T extends Validate> {
    private List<T> o;

    public Validation(T ...o) {
        this.o.addAll(Arrays.asList(o));
    }

    public void create(T ...o) {
        this.o.addAll(Arrays.asList(o));
    }

    public Boolean validate() {
        return o.stream().anyMatch(Validate::validate);
    }

}
