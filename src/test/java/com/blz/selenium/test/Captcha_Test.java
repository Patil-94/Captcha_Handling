package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.utility.Captcha_Handler;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class Captcha_Test extends BaseClass {

    @Test
    public void To_TestCaptcha_IsWorking_OrNot() throws InterruptedException, IOException, TesseractException {

        Captcha_Handler captchaHandler = new Captcha_Handler(driver);
        captchaHandler.setUpCaptchaHandler ();
    }
}
