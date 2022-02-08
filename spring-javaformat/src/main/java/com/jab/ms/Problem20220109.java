/// usr/bin/env jbang "$0" "$@" ; exit $?
// DEPS org.assertj:assertj-core:3.21.0
// DEPS org.apache.commons:commons-math3:3.6.1

package edu.jab.math;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem20220109 {

    public static void main(String[] args) {

        // Alternative 1

        // @formatter:off
        Predicate<Integer> isDivisible_1_to_20 = number -> {
                    var counter = IntStream.rangeClosed(1, 20)
                                    .boxed()
                                    .map(n -> (number % n == 0) ? 1 : 0)
                                    .reduce(0, Integer::sum);

                    return (counter == 20) ? true : false;
                };
        // @formatter:on

        Function<Integer, Integer> toDigitSize = number -> String.valueOf(number).length();

        Supplier<Integer> compute = () -> Stream.iterate(1, i -> i + 1) // Infinite Stream
                .parallel().filter(isDivisible_1_to_20).limit(1).peek(System.out::println).map(toDigitSize).findFirst()
                .orElseThrow();

        // Defensive coding using Timeout handling
        // Stream API doesn´t have timeout support
        Supplier<Integer> computeAsync = () -> CompletableFuture.supplyAsync(() -> compute.get())
                .orTimeout(120, TimeUnit.SECONDS).handle((response, ex) -> (Objects.isNull(ex)) ? response : -99)
                .join();

        System.out.println("Number of CPU Cores: " + Runtime.getRuntime().availableProcessors());

        Instant start = Instant.now();

        var result = computeAsync.get();
        System.out.println(result);

        Instant end = Instant.now();
        System.out.println("Process time: " + Duration.between(start, end).toSeconds() + " seconds");

        assertThat(result).isEqualTo(9);
    }

}
