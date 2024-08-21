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

        Map<String, Set<Integer>> result = new HashMap<String, Set<Integer>>();

        Set<Integer> numbers = new HashSet<Integer>();

        while (true) {
            int number = (int)Math.floor(Math.random()*45 + 1);

            numbers.add(number);

            if (numbers.size() == 6) break;
        }

        result.put("numbers", numbers);

        return result;
    }
}
