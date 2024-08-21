package kr.co.polycube.backendtest.controller;

import kr.co.polycube.backendtest.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class LottoController {

    @Autowired
    private LottoService lottoService;

    @PostMapping("/lottos")
    public Map<String, Set<Integer>> lottos() {

        return lottoService.lottos();
    }
}
