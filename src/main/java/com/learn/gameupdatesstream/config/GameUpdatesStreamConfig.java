package com.learn.gameupdatesstream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.gameupdatesstream.entity.Game;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class GameUpdatesStreamConfig {

	@Bean
    Sinks.Many<Game> eventSource() {
        return Sinks.many().replay().limit(1);
    }

    @Bean
    Flux<Game> subscribeSource(Sinks.Many<Game> sink) {
        return sink.asFlux();
    }
}
