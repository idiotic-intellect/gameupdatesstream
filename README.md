# Reactor - reactive programming

Reactor - Java based library for reactive programming

## Installation

Needs Spring Web Flux dependency to use on Spring Projects

```mvn
Check in https://mvnrepository.com/ => spring-boot-starter-webflux
```

## Usage

```java
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
```

#Code

Emit events

```
Sink.One<Type> oneEmitVar = Sinks.one();
Sinks.Many<Type> manyEmitVar = Sinks.many().replay().limit(1);
```

Subscribe events

```
Mono<Type> oneSubsVar = sink.asMono().cache(num);
Flux<Type> manySubsVar = manyEmitVar.asFlux().cache(num);
```

# Sink
	* Sinks - to create event source which can be subscribed
	* Sinks.one - to emit only one event , we can use  event handler to constraint
	* Sinks.many - to emit multiple events 
	* Sinks.many.unicast -to emit multiple events to one subscriber - onBackPressureBuffer
	* Sinks.many.multicast - to emit multiple events to multiple subscribers  - onBackPressureBuffer
	* Sinks.many.multicast with directBestEffort - will send events to all and not sure delivered to all or not, which not makes other to wait
	* Sinks.many.multicast with directAllOrNothing -  ensures all subscribers receives update or none.
	* Sinks.many.replay - ensures new subscriber also gets all history of events, use limit(1) - will emit only last one history event
	* Sinks.empty - for no data just complete or error

```Java
@GetMapping(value = "/result", produces = MediaType.TEXT_EVENT_STREAM_VALUE) 
```
To tell this emits Server Sent Events

# Return types
	* Mono - emits zero or one data to subscribers
	* Flux - emits zero or more data to subscribers

# Additional types
	* Tuple - used to store items of different types from 1 to 10 using of(...args) method and its immutable

# Working - local running
Open Postman or any webclient after starting project create request as below

```HTTP POST Request
POST
URL: http://localhost:8080/api/match/update
body: {
			"team1": 1 <int>,
			"team2": 2 <int>,
			"commentry": "Some message" <String>
		}
```
Open browser with below URL

```HTTP GET Request
GET
URL: http://localhost:8080/api/match/stream
```
	

	