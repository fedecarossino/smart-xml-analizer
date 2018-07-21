package com.test.services.analyzer;

import com.test.model.MatchElement;
import com.test.services.analyzer.strategy.AttributesMatchStrategies;
import com.test.services.analyzer.strategy.IdMatchStrategies;
import com.test.services.analyzer.strategy.MatchStrategies;
import com.test.services.analyzer.strategy.TextMatchStrategies;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class SmartXmlAnalyzerImpl implements SmartXmlAnalyzer {

    private static final List<MatchStrategies> strategies = Arrays.asList(new IdMatchStrategies(), new TextMatchStrategies(), new AttributesMatchStrategies());

    @Override
    public Optional<MatchElement> findElement(Element original, Elements diffCases) {
        TreeSet<MatchElement> matchesSet = new TreeSet((Comparator<MatchElement>) (m1, m2) -> m2.getWeighing().compareTo(m1.getWeighing()));

        for(Element diffCase : diffCases){
            List<String> matches = new ArrayList<>();
            int weight = strategies
                    .stream()
                    .mapToInt(strategy -> strategy.match(original, diffCase, matches))
                    .sum();
            if(weight > 0) {
                MatchElement match = new MatchElement(diffCase, weight, matches);
                matchesSet.add(match);
            }
        }

        return Optional.ofNullable(matchesSet.first());
    }

}
