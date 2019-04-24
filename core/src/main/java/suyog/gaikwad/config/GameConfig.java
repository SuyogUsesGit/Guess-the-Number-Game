package suyog.gaikwad.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import suyog.gaikwad.GuessCount;
import suyog.gaikwad.MaxNumber;
import suyog.gaikwad.MinNumber;

@Configuration
@ComponentScan(basePackages = "suyog.gaikwad")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == Fields ==
    @Value("${game.maxNumber}")
    private int maximum;

    @Value("${game.guessCount}")
    private int guessCount;

    @Value("${game.minNumber}")
    private int minimum;


    // == Bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maximum;
    }

    @Bean
    @GuessCount
    public int guessCountbday() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumberbday() {
        return minimum;
    }
}
