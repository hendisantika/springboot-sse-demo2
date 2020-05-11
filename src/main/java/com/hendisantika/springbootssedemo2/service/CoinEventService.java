package com.hendisantika.springbootssedemo2.service;

import com.hendisantika.springbootssedemo2.model.Coins;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sse-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/20
 * Time: 07.33
 */
@Service
public class CoinEventService {

    public Flux<List<Coins>> getCoinsEvents(List<Coins> coinsList, String country) {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(3));
        interval.subscribe((i) -> coinsList.forEach(coin -> coin.setPrice(changePrice(country))));

        Flux<List<Coins>> coinTransactionFlux = Flux.fromStream(Stream.generate(() -> coinsList));
        return Flux.zip(interval, coinTransactionFlux).map(Tuple2::getT2);
    }

    private String changePrice(String country) {
        if (country.equalsIgnoreCase("AUD")) {
            return "$ " + Math.round(10 + (100 - 10) * new Random().nextDouble()) + " AUD";
        } else if (country.equalsIgnoreCase("ID")) {
            return "Rp " + Math.round(10 + (100 - 10) * new Random().nextDouble()) + " ID";
        }

        return "$ " + Math.round(100 + (1000 - 100) * new Random().nextDouble()) + " USD";
    }
}
