package com.hendisantika.springbootssedemo2.controller;

import com.hendisantika.springbootssedemo2.model.Coins;
import com.hendisantika.springbootssedemo2.service.CoinEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sse-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/20
 * Time: 07.34
 */
@RestController
public class CoinRestController {

    private final List<Coins> coinsList = new ArrayList<>();

    @Autowired
    private CoinEventService coinEventService;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            initializeCoins();
        };
    }

    private void initializeCoins() {
        Coins coin1 = new Coins("Bitcoin", "$ " + Math.round(100 + (1000 - 100) * new Random().nextDouble()) + " USD");
        Coins coin2 = new Coins("Litecoin", "$ " + Math.round(100 + (1000 - 100) * new Random().nextDouble()) + " USD");
        coinsList.add(coin1);
        coinsList.add(coin2);
    }

}
