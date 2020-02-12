package me.jdragon.junitinaction.chapter12;

import static org.junit.jupiter.api.Assertions.*;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAbbreviated;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/02/12.
 * @project junitinaction
 * @description
 */
class JavadocPageTestTest {

  @Test
  public void testClassNav() throws IOException  {
    WebClient webClient = new WebClient();
    HtmlPage mainPage = (HtmlPage) webClient
        .getPage("http://htmlunit.sourceforge.net/apidocs/index.html");
    HtmlPage packagePage = mainPage.getFrameByName("packageFrame").getEnclosingPage();
    HtmlPage bVerPage = packagePage.getAnchorByHref("com/gargoylesoftware/htmlunit/BrowserVersion.html")
        .click();
  }

}