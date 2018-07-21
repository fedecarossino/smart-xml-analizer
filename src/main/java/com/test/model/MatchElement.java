package com.test.model;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class MatchElement {

    private Element element;
    private Integer weighing;
    private List<String> matches = new ArrayList<>();

    public MatchElement(Element element, Integer weighing, List<String> matches) {
        this.element = element;
        this.weighing = weighing;
        this.matches = matches;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Integer getWeighing() {
        return weighing;
    }

    public void setWeighing(Integer weighing) {
        this.weighing = weighing;
    }

    public List<String> getMatches() {
        return matches;
    }

    public void addMatch(String matchElement) {
        this.matches.add(matchElement);
    }
}
