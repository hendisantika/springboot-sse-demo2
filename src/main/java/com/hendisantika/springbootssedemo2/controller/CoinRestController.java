package com.hendisantika.springbootssedemo2.controller;

import com.hendisantika.springbootssedemo2.model.Coins;
import com.hendisantika.springbootssedemo2.service.CoinEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}
