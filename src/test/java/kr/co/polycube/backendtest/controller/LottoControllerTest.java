package kr.co.polycube.backendtest.controller;

import jakarta.transaction.Transactional;
import kr.co.polycube.backendtest.service.LottoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LottoControllerTest {

    @Autowired
    LottoService lottoService;

    @Test
    void lottos() {
        Map<String, Set<Integer>> result = lottoService.lottos();

        assertTrue(result.containsKey("numbers"));
        assertEquals(result.get("numbers").size(), 6);
    }
}