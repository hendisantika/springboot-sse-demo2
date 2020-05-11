package com.hendisantika.springbootssedemo2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sse-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/05/20
 * Time: 07.32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Coins {
    private String name;
    private String price;
}
