package io.github.kjens93.groovy;

import groovy.text.GStringTemplateEngine;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.val;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GroovyStringUtils {

    private static final GStringTemplateEngine templateEngine = new GStringTemplateEngine();

    public static String interpolate(String string, Map context) {
        try {
            val stringReader = new StringReader(string);
            val stringWriter = new StringWriter();
            templateEngine.createTemplate(stringReader).make(context).writeTo(stringWriter);
            return stringWriter.toString();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
