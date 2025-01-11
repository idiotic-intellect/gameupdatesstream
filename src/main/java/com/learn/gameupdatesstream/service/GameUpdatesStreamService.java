package com.learn.gameupdatesstream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.learn.gameupdatesstream.entity.Game;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class GameUpdatesStreamService {

	@Autowired
	private Sinks.Many<Game> gameSink;
	
	@Autowired
	private Flux<Game> gameFlux;
	
	public Mono<Void> updateGame(@RequestBody Game game) {
	    gameSink.tryEmitNext(game);
	    return Mono.empty();
	}
	
	public Flux<Game> getGameUpdates() {
	    return this.gameFlux;
	}
}
