package dev.gustavoteixeira;

import io.micronaut.runtime.Micronaut;

public class AppRunner {
    public static void main(String[] args) {
        Micronaut.run(AppRunner.class, args);
    }
}
