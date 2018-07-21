package com.test.services.analyzer.strategy;

import org.jsoup.nodes.Element;

import java.util.List;

public class TextMatchStrategies implements MatchStrategies {

    public static final String ELEMENT_TEXT = "Text";

    @Override
    public int match(Element original, Element diffCaseElement, List<String> matches) {
        if(original.hasText() && diffCaseElement.hasText()
                && original.text().equals(diffCaseElement.text())){
            matches.add(ELEMENT_TEXT);
            return 25;
        }

        return 0;
    }
}
