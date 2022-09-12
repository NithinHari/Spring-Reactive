package com.springflux.Spring.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonofluxTest {

	@Test
	public void testMono() {
		Mono<?> monoString = Mono.just("Nithin@6")
				.then(Mono.error(new RuntimeException("Exception occured")))
				.log();
		monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
	}
	@Test
	public void testFlux(){
		Flux<String> fluxString = Flux.just("Spring","Java","Python","Sql")
				.concatWithValues("Mongodb")
				.concatWith(Flux.error(new RuntimeException("Error occured at runtime")))
				.log();

		fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
	}
	@Test
	public void testFluxNum(){
		Flux<Integer>integerFlux=Flux.just(1,2,3,4);
		integerFlux.subscribe(System.out::println);
	}
}

