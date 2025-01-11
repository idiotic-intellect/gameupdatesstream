package com.learn.gameupdatesstream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.gameupdatesstream.entity.Game;
import com.learn.gameupdatesstream.service.GameUpdatesStreamService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/match")
public class GameUpdatesStreamController {

	@Autowired
	private GameUpdatesStreamService gameService;
	
	@PostMapping("/update")
	public Mono<Void> updateGame(@RequestBody Game game) {
	    return this.gameService.updateGame(game);
	}
	
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Game> getGameUpdates() {
	    return this.gameService.getGameUpdates();
	}
}
