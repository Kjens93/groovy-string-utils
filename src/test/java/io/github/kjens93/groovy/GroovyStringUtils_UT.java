package io.github.kjens93.groovy;

import com.google.common.collect.ImmutableMap;
import lombok.val;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class GroovyStringUtils_UT {

    @Test
    public void test_interpolate_simpleContext_simpleString() {
        val context = ImmutableMap.of("foo", "FOOZLE");
        val inputs = "foo: ${foo}";
        val output = "foo: FOOZLE";
        assertThat(GroovyStringUtils.interpolate(inputs, context)).isEqualTo(output);
    }

    @Test
    public void test_interpolate_simpleContext_complexString_withQuotes() {
        val context = ImmutableMap.builder()
                .put("foo", "FOOZLE")
                .put("bar", "BARZLE")
                .build();
        val inputs = "{\"foo\":{\"foo\":\"${foo}\",\"bar\":\"${bar}\"}}";
        val output = "{\"foo\":{\"foo\":\"FOOZLE\",\"bar\":\"BARZLE\"}}";
        assertThat(GroovyStringUtils.interpolate(inputs, context)).isEqualTo(output);
    }

    @Test
    public void test_interpolate_complexContext_complexString() {
        val context = ImmutableMap.builder()
                .put("foo", "FOOZLE")
                .put("bar", ImmutableMap.of("baz", "BAZZLE"))
                .put("roc", 123456)
                .put("joc", asList("A", "B", "C"))
                .build();
        val inputs = "foo:{foo:${foo},roc:${roc},bar:${bar}},baz:${bar.baz},joc:${joc}";
        val output = "foo:{foo:FOOZLE,roc:123456,bar:[baz:BAZZLE]},baz:BAZZLE,joc:[A, B, C]";
        assertThat(GroovyStringUtils.interpolate(inputs, context)).isEqualTo(output);
    }

    @Test
    public void test_interpolate_arithmetic() {
        val context = ImmutableMap.of("someNumber", 12);
        val inputs = "foo: ${ someNumber * 2 }, bar: ${ someNumber.toString().toSet() }";
        val output = "foo: 24, bar: [1, 2]";
        assertThat(GroovyStringUtils.interpolate(inputs, context)).isEqualTo(output);
    }



}
