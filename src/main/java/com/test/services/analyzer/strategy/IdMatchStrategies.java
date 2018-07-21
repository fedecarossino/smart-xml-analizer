package com.test.services.analyzer.strategy;

import org.jsoup.nodes.Element;

import java.util.List;

public class IdMatchStrategies implements MatchStrategies {

    public static final String ELEMENT_ID = "id";
    public static final int ATTRIBUTE_ID_WEIGHT = 100;
    public static final int ZERO = 0;

    @Override
    public int match(Element original, Element diffCaseElement, List<String> matches) {
        if(original.id().equals(diffCaseElement.id())){
            matches.add(ELEMENT_ID);
            return ATTRIBUTE_ID_WEIGHT;
        }
        return ZERO;
    }
}
