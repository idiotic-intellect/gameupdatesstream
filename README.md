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
# Sink
	* sink - to create event source which can be subscribed
	* sink.one - to emit only one event , we can use  event handler to constraint
	* sink.many - to emit multiple events 
	* sink.many.unicast -to emit multiple events to one subscriber - onBackPressureBuffer
	* sink.many.multicast - to emit multiple events to multiple subscribers  - onBackPressureBuffer
	* sink.many.multicast with directBestEffort - will send events to all and not sure delivered to all or not, which not makes other to wait
	* sink.many.multicast with directAllOrNothing -  ensures all subscribers receives update or none.
	* sink.many.replay - ensures new subscriber also gets all history of events, use limit(1) - will emit only last one history event
	* sink.empty - for no data just complete or error

```Java
@GetMapping(value = "/result", produces = MediaType.TEXT_EVENT_STREAM_VALUE) 
```
To tell this emits Server Sent Events

# Return types
	* Mono - emits zero or one data to subscribers
	* Flux - emits zero or more data to subscribers

# Additional types
	* Tuple - used to store items of different types from 1 to 10 using of(...args) method and its immutable