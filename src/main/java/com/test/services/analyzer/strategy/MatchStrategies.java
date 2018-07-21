package com.test.services.analyzer.strategy;

import org.jsoup.nodes.Element;

import java.util.List;

public interface MatchStrategies {

    int match(Element original, Element diffCaseElement, List<String> matches);

}
