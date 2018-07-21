package com.test.services.analyzer;

import com.test.model.MatchElement;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Optional;

interface SmartXmlAnalyzer {

    Optional<MatchElement> findElement(Element original, Elements difCases);

}
