package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1500x1000";
    }

    @Test
    void checkJunit5ExampleTest() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-rightbar ul li button").click();
        $(".wiki-rightbar ul").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                " void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}" ));
    }
}
