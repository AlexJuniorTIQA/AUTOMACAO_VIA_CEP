package br.com.viacep.regressivo;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/br/com/viacep/features/",
        glue = {"br/com/viacep/steps"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)
public class Runners {
}