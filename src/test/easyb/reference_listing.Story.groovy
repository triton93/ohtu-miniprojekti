import tomate.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


scenario "Empty reference list shown when there are no references added" {
given 'user visits main page', {
driver = new HtmlUnitDriver();
driver.get("http://localhost:8080");
}
when 'references are loaded' , {
driver2 = new HtmlUnitDriver();
driver2.get("http://localhost:8080/views/list-refs-tmpl.html");
}
then 'reference list is empty', {
driver2.getPageSource().contains("There aren't any references added yet!").shouldBe true
}
}