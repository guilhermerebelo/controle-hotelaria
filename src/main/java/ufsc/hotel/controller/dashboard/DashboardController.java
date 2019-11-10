package ufsc.hotel.controller.dashboard;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufsc.hotel.model.funcionario.Funcionario;
import ufsc.hotel.model.locacao.LocacaoService;

import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping("dashboard")
public class DashboardController {

    private LocacaoService service;

    public DashboardController(LocacaoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Funcionario> findAll() {
//        return service.findAll(PageRequest.of(0, 20));
        return null;
    }
}
