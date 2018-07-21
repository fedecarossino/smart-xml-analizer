package com.test;

import java.io.File;
import java.util.Optional;

import com.test.model.MatchElement;
import com.test.services.analyzer.SmartXmlAnalyzerImpl;
import com.test.utils.XmlUtils;
import org.apache.log4j.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SmartXmlAnalyzerApp {

    private static org.apache.log4j.Logger log = Logger.getLogger(SmartXmlAnalyzerApp.class);

    private static SmartXmlAnalyzerImpl smartXmlAnalyzerImpl = new SmartXmlAnalyzerImpl();

    public static void main(String[] args) {
        if(args.length < 3){
            log.error("missing arguments. Example java javar <original_document> <diff_case> <target_id>");
            return;
        }

        String original = args[0];
        String diffCase = args[1];
        String targetElementId = args[2];

        Optional<Document> document = XmlUtils.parseToDocument(new File(original));
        if(!document.isPresent()){
            log.error(String.format("No original document was found in: %s", original));
            return;
        }

        Optional<Element> element = XmlUtils.searchElementById(document.get(), targetElementId);
        if(!element.isPresent()){
            log.error(String.format("No element find under id: %s", targetElementId));
            return;
        }else{
            log.info(String.format("Element: %s", element.get()));
        }

        Optional<Document> diffCaseDocument = XmlUtils.parseToDocument(new File(diffCase));
        if(!diffCaseDocument.isPresent()){
            log.error(String.format("No diff-case document was found in: %s", diffCase));
            return;
        }

        Optional<Elements> elementsByTag = XmlUtils.searchElementsByTag(diffCaseDocument.get(), element.get().tagName());
        if(!elementsByTag.isPresent()){
            log.error(String.format("Same element not found: %s", element.get().tagName()));
            return;
        }

        Optional<MatchElement> matchElement = smartXmlAnalyzerImpl.findElement(element.get(), elementsByTag.get());

        if(matchElement.isPresent()){
            log.info(String.format("Match: %s", matchElement.get().getElement().toString()));
            log.info(String.format("Path: %s", XmlUtils.getElementPath(matchElement.get().getElement())));
            log.info("Matched attributes: ");
            matchElement.get().getMatches().stream().forEach(System.out::println);
        }else{
            log.warn("No similar element was found");
        }
    }
}
