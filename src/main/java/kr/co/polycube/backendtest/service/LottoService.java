package kr.co.polycube.backendtest.service;

import jakarta.transaction.Transactional;
import kr.co.polycube.backendtest.model.dao.LottoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
@Transactional
public class LottoService {

    @Autowired
    private LottoDao lottoDao;

    public Map<String, Set<Integer>> lottos() {
        Map<String, Set<Integer>> result = new HashMap<String, Set<Integer>>();

        Set<Integer> numbers = new HashSet<Integer>();

        while (true) {
            int number = (int) Math.floor(Math.random() * 45 + 1);

            numbers.add(number);

            if (numbers.size() == 6) break;
        }

        result.put("numbers", numbers);

        return result;
    }
}