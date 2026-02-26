package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonCode;
import utilities.ExcelWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultsPage {
    WebDriver driver;
    WebDriverWait wait;
    CommonCode commonCode;

    @FindBy(xpath = "//button[@data-testid='filter-dropdown-productDifficultyLevel']")
    WebElement difficultyLevel;
    @FindBy(xpath = "//span[text()='View']")
    WebElement viewBtn;
    @FindBy(xpath = "//a[@data-e2e='header-login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//h3[contains(@class,'cds-CommonCard-title')]")
    List<WebElement> allTitles;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-language']")
    WebElement languageOptions;
    @FindBy(xpath = "(//div[@class='cds-ProductCard-content'])[position()<=2]")
    List<WebElement> courseDetails;
    @FindBy(xpath = "//div[contains(@data-testid,'language')]/label/div/span")
    List<WebElement> languages;
    @FindBy(xpath = "//div[@class='cds-CommonCard-interactiveArea']")
    List<WebElement> companyName;
    @FindBy(xpath = "//div[contains(@data-testid,'productDifficultyLevel')]/label/div/span")
    List<WebElement> difficultyLevels;
    @FindBy(xpath = "//div[contains(text(),'reviews')]")
    List<WebElement> review;
    @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']")
    List<WebElement> level;
    @FindBy(xpath = "//button[@data-testid='filter-dropdown-productTypeDescription']")
    WebElement guidedProjectElement;
    @FindBy(xpath = "//span[contains(text(),'Guided Projects')]")
    WebElement guidedProjectChk;
    @FindBy(className = "cds-ProductCard-content")
    List<WebElement> productCard;
    @FindBy(className = "cds-ProductCard-body")
    WebElement productCardBody;

    @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']")
    WebElement metadata;

    @FindBy(xpath = "//*[@data-testid='filter-and-sort-button']")
    WebElement filterBtn;

    @FindBy(xpath = "//*[@class='cds-AccordionHeader-labelGroup']//span[contains(text(),'Topic')]")
    WebElement topicBtn;

    @FindBy(xpath = "//*[@class='cds-checkboxAndRadio-labelText']//span[text()='Computer Science']")
    WebElement ComputerScienceBtn;

    @FindBy(xpath = "//*[@class='cds-button-label' and contains(text(),'View')]")
    WebElement viewFilterBtn;

    @FindBy(xpath = "//h2[contains(text(),'Frequently')]")
    WebElement faq;

    @FindBy(xpath = "(//*[@class='cds-ProductCard-gridCard'])[position()<=1]")
    WebElement course;


    By titleElement=By.xpath(".//h3");
    By rating=By.xpath(".//div[@class='cds-ProductCard-footer']/div/div/div/span");
    By duration=By.xpath("//div[@class='cds-CommonCard-metadata']/p");
    public ResultsPage(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        commonCode=new CommonCode(driver,wait);
        PageFactory.initElements(driver,this);
    }

    public boolean difficultyLevelVisibility(){
        return wait.until(ExpectedConditions.visibilityOf(difficultyLevel)).isDisplayed();
    }
    public void selectDifficultyLevel(String difficultyInput){
        difficultyLevel.click();
        By beginnerOption=By.xpath("//span[text()='"+difficultyInput+"']");
        driver.findElement(beginnerOption).click();
    }
    public boolean isViewButtonEnabled(){
        return wait.until(ExpectedConditions.visibilityOf(viewBtn)).isDisplayed();
    }
    public void clickViewButton(){
        viewBtn.click();
    }

    public boolean areLanguageOptionsClickable(){
        return wait.until(ExpectedConditions.elementToBeClickable(languageOptions)).isEnabled();
    }
    public void selectLanguage(String language){
        languageOptions.click();
        By englishLanguage =By.xpath("//span[text()='"+language+"']");
        driver.findElement(englishLanguage).click();
    }
    public void getLanguages() throws IOException {
        languageOptions.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(languages));
        List<String> languagesList=new ArrayList<>();
        commonCode.takeScreenshot();
        for(WebElement language:languages){
            languagesList.add(language.getText());
        }
        ExcelWriter.writeList("Languages",languagesList,"Languages");
    }

    public void getLevels() throws IOException {
        difficultyLevel.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(difficultyLevels));
        int difficultyCount=difficultyLevels.size();
        commonCode.takeScreenshot();
        List<String> levelsList=new ArrayList<>();
        for(WebElement difficulty:difficultyLevels){
            levelsList.add(difficulty.getText());
        }
        ExcelWriter.writeList("Levels",levelsList,"Level");
    }

    public boolean searchAndLoadCards() throws IOException {
        wait.until(ExpectedConditions.visibilityOfAllElements(allTitles));
        WebElement ele=wait.until(ExpectedConditions.visibilityOf(allTitles.get(0)));
        commonCode.scrollIntoViewer(ele);
        commonCode.takeScreenshot();
        boolean check=false;
        List<String> titlesList=new ArrayList<>();
        for (WebElement card : allTitles) {
            check=!card.getText().isEmpty();
            titlesList.add(card.getText());
        }
        ExcelWriter.writeList("Titles",titlesList,"Title");
        return check;
        }

    public boolean courseReviews() throws IOException {
        List<WebElement> courseCards = review;
        boolean bool = false;
        List<String> reviewsList=new ArrayList<>();
        for (WebElement card : courseCards){
            bool = !card.getText().isEmpty();
           reviewsList.add(card.getText());
        }
        ExcelWriter.writeList("Titles",reviewsList,"review");
        return bool;
    }

    public boolean courseLevel() throws IOException {
        List<WebElement> courseCards = level;
        boolean bool = false;
        List<String> courseList=new ArrayList<>();
        for(WebElement card: courseCards){
            bool = !card.getText().isEmpty();
            courseList.add(card.getText());
        }
        ExcelWriter.writeList("Courses",courseList,"course");
        return bool;
    }

    public boolean companyCourseName() throws IOException {
        wait.until(ExpectedConditions.visibilityOfAllElements(companyName));
        List<WebElement> courseCards = companyName;
        boolean check = false;
        List<String> companyList=new ArrayList<>();
        for(WebElement card : courseCards){
            check = !card.getText().isEmpty();
            companyList.add(card.getText());
        }
        ExcelWriter.writeList("Companies",companyList,"Company");
        return check;
    }

    public void getListOfTitles() throws IOException {
        wait.until(ExpectedConditions.visibilityOfAllElements(courseDetails));
        List<String> courseTitles=new ArrayList<>();
        List<String> courseRatings=new ArrayList<>();
        List<String> courseDurations=new ArrayList<>();
        for(WebElement card:courseDetails){
            wait.until(ExpectedConditions.visibilityOfElementLocated(rating));
            courseTitles.add(card.findElement(titleElement).getText());
            courseRatings.add(card.findElement(rating).getText());
            courseDurations.add(card.findElement(duration).getText());
        }
        ExcelWriter.writeList("CourseDetails",courseTitles,"Title");
        ExcelWriter.writeList("CourseDetails",courseRatings,"Rating");
        ExcelWriter.writeList("CourseDetails",courseDurations,"Duration");

    }

    public boolean isLoginButtonEnabled(){
        return (wait.until(ExpectedConditions.elementToBeClickable(loginButton)).isEnabled());
    }

    public  void guidedProject(){
        wait.until(ExpectedConditions.visibilityOf(guidedProjectElement));
        guidedProjectElement.click();
        wait.until(ExpectedConditions.visibilityOf(guidedProjectChk));
        guidedProjectChk.click();
        clickViewButton();
    }

    public boolean getSkills(){
        List<WebElement> l= productCard;
        boolean check=true;
        for(WebElement search: l){
            String str= search.getText();
            if(!productCardBody.isDisplayed() && str.isEmpty()){
                    check=false;
            }
        }
        return check;
    }

    public boolean getTimeline(){
        List<WebElement> l= productCard;
        boolean check=true;
        for(WebElement search: l){
            String str=search.findElement((By) metadata).getText();
            if(!str.contains("Less Than 2 Hours")){
                check=false;
            }
        }
        return check;
    }

    public boolean FilterAndSortVisible(){
        return filterBtn.isDisplayed();
    }

    public void FilterAndSortClick() {
        filterBtn.click();
        wait.until(ExpectedConditions.visibilityOf(topicBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(ComputerScienceBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(viewFilterBtn)).click();
    }

    public void clickOnCourse() {
        wait.until(ExpectedConditions.elementToBeClickable(course)).click();
    }

    public boolean checkForFAQ() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", faq);
        return faq.isDisplayed();
    }

    public boolean clickCourseSwitchCheckFAQReturn() {
        String parentHandle = driver.getWindowHandle();
        int beforeCount = driver.getWindowHandles().size();
        clickOnCourse();
        wait.until(d -> d.getWindowHandles().size() > beforeCount);
        String childHandle = getNewTabHandle(parentHandle);
        driver.switchTo().window(childHandle);
        try {
            return checkForFAQ();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        } finally {
            try { driver.close(); } catch (Exception ignored) {}
            driver.switchTo().window(parentHandle);
        }
    }

    private String getNewTabHandle(String parentHandle) {
        for (String h : driver.getWindowHandles()) {
            if (!h.equals(parentHandle)) return h;
        }
        throw new IllegalStateException("New tab not found after clicking the course.");
    }

}
