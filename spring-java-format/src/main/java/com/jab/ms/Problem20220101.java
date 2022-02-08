package com.jab.ms;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Problem20220101 {

    public static void main(String[] args) {

        var roundingMode = RoundingMode.HALF_UP;
        var precision = new MathContext(10);
        var parameter = BigDecimal.valueOf(216).sqrt(precision);

        // https://www.google.com/search?q=tetrahedron+surface+area
        var surface = BigDecimal.valueOf(3).sqrt(precision).multiply(parameter.pow(2));

        // https://www.google.com/search?q=tetrahedron+volume
        var volume = parameter.pow(3).divide(BigDecimal.valueOf(6).multiply(BigDecimal.valueOf(2).sqrt(precision)),
                roundingMode);

        var result = surface.divide(volume, roundingMode);

        System.out.println(result);
    }

}
