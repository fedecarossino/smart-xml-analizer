package com.test.services.analyzer.strategy;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AttributesMatchStrategies implements MatchStrategies {
    @Override
    public int match(Element original, Element diffCaseElement, List<String> matches) {
        Map<String, String> originalAttributes = ElementAttributesToMap(original);
        Map<String, String> difCaseAttributes = ElementAttributesToMap(diffCaseElement);

        return originalAttributes.keySet().stream()
                .filter(difCaseAttributes::containsKey)
                .mapToInt(key -> {
                    String orinalAttribute = originalAttributes.get(key);
                    String difCaseAttribute = difCaseAttributes.get(key);
                    if(orinalAttribute.equals(difCaseAttribute)){
                        matches.add(key);
                        return 10;
                    }
                    return 0;
                }).sum();
    }

    private Map<String, String> ElementAttributesToMap(Element original) {
        return original.attributes()
                .asList()
                .stream()
                .collect(Collectors.toMap(Attribute::getKey, Attribute::getValue));
    }
}
