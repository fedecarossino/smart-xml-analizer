package com.test.services.analyzer.strategy;

import org.jsoup.nodes.Element;

import java.util.List;

public class IdMatchStrategies implements MatchStrategies {
    @Override
    public int match(Element original, Element diffCaseElement, List<String> matches) {
        if(original.id().equals(diffCaseElement.id())){
            matches.add("id");
            return 100;
        }
        return 0;
    }
}
