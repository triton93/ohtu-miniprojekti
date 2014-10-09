import tomate.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can add new book references to data storage'
scenario "User adds successfully all requested data items", {
given 'user visits page to add a reference', {
driver = new HtmlUnitDriver();
driver.get("http://localhost:8080");
}
when 'user submits valid data to all the data fields', {
element = driver.findElement(By.id("title"));
element.sendKeys("pekka saariluoma");
element = driver.findElement(By.id("author"));
element.sendKeys("santeri saariluoma");
element = driver.findElement(By.id("publisher"));
element.sendKeys("anita hirvonen");
element = driver.findElement(By.name("year"));
element.sendKeys("1999");
element = driver.findElement(By.name("Save"));
element.submit();
}
then 'reference will be created and saved to repository', {
driver.get("http://localhost:8080");
driver.getPageSource().contains("There aren't any references added yet!").shouldBe true
}
}
scenario "User cant submit the form if one or more data items is left blank", {
given 'user visits page to add a reference'
when 'user doesnt enter valid data to all the data fields'
then 'reference will not be created or saved to repository'
}