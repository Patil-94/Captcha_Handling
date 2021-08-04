package com.blz.selenium.utility;

import com.blz.selenium.base.BaseClass;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class Captcha_Handler extends BaseClass {

    @FindBy(xpath = "/html/body/form/table/tbody/tr[3]/td[2]/img")
    WebElement captchaImage;

    @FindBy(id = "captchacode")
    WebElement answer;

    public  Captcha_Handler(WebDriver driver){
        PageFactory.initElements (driver,this);

    }

    public void setUpCaptchaHandler() throws InterruptedException, IOException, TesseractException {

        File scr =  captchaImage.getScreenshotAs (OutputType.FILE);
        //String path = System.getProperty ("user.dir")+ "/screenshot/captcha.jpg";
        String path="C:\\Users\\sachin\\IdeaProjects\\Handle_Captcha\\src\\screenshot\\captcha.png";
        FileHandler.copy (scr, new File (path));
        ITesseract image = new Tesseract();
        image.setDatapath("C:\\Users\\sachin\\IdeaProjects\\Handle_Captcha\\tessdata");


        String imageTest =  image.doOCR (new File (path));
        Thread.sleep(2000);
        String finalTest = imageTest.replaceAll (" [^0-9]","");
        Thread.sleep(2000);
        answer.sendKeys (finalTest);
        System.out.println (finalTest);

    }
}
