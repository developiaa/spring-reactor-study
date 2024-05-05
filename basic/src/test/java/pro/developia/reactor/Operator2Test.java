package pro.developia.reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class Operator2Test {
    private Operator2 operator2 = new Operator2();

    @Test
    void fluxConcatMap() {
        StepVerifier.create(operator2.fluxConcatMap())
                .expectNextCount(100)
                .verifyComplete();
    }


    @Test
    void monoFlatMapMany() {
        StepVerifier.create(operator2.monoFlatMapMany())
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void defaultIfEmpty() {
        StepVerifier.create(operator2.defaultIfEmpty())
                .expectNext(30)
                .verifyComplete();
    }

    @Test
    void switchIfEmpty() {
        StepVerifier.create(operator2.switchIfEmpty())
                .expectNext(60)
                .verifyComplete();
    }

    @Test
    void switchIfEmpty2() {
        StepVerifier.create(operator2.switchIfEmpty2())
                .expectErrorMessage("Not exists value..")
                .verify();
    }

    @Test
    void fluxMerge() {
        StepVerifier.create(operator2.fluxMerge())
                .expectNext("1","2","3","4")
                .verifyComplete();
    }

    @Test
    void monoMerge() {
        StepVerifier.create(operator2.monoMerge())
                .expectNext("1","2")
                .verifyComplete();
    }

    @Test
    void fluxZip() {
        StepVerifier.create(operator2.fluxZip())
                .expectNext("ad","be","cf")
                .verifyComplete();
    }

    @Test
    void monoZip() {
        StepVerifier.create(operator2.monoZip())
                .expectNext(6)
                .verifyComplete();
    }
}