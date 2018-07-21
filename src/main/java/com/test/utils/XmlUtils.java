package com.test.utils;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class XmlUtils {

    private static org.apache.log4j.Logger log = Logger.getLogger(XmlUtils.class);

    private static String DEFAULT_CHARSET_NAME = "utf8";

    public static Optional<Document> parseToDocument(File htmlFile){
        try {
            Document doc =  Jsoup.parse(
                    htmlFile,
                    DEFAULT_CHARSET_NAME,
                    htmlFile.getAbsolutePath());
            return Optional.ofNullable(doc);

        } catch (IOException e) {
            log.error("Error reading file");
            return Optional.empty();
        }
    }

    public static Optional<Element> searchElementById(Document source, String elementId) {
        return Optional.ofNullable(source.body().getElementById(elementId));
    }

    public static Optional<Elements> searchElementsByTag(Document source, String tag) {
        return Optional.ofNullable(source.body().getElementsByTag(tag));
    }

    public static String getElementPath(Element element) {
        final List<String> path = element.parents()
                .stream()
                .map(XmlUtils::pathToString)
                .collect(Collectors.toList());
        final StringBuilder builder = new StringBuilder();

        for (int i = path.size() - 1; i >= 0; i--) {
            final String s = path.get(i);
            builder.append(s).append(" > ");
        }

        builder.append(pathToString(element));

        return builder.toString();
    }

    private static String pathToString(Element element) {
        return String.format("%s[%s] ", element.tagName(), element.elementSiblingIndex());
    }

}
