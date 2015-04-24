package com.olyv.wortschatz.appium;

import com.olyv.wortschatz.appium.entity.Word;
import com.olyv.wortschatz.appium.pages.editor.EditorScreen;
import com.olyv.wortschatz.appium.pages.StartScreen;
import com.olyv.wortschatz.appium.pages.editor.IEditor;
import com.olyv.wortschatz.appium.pages.editor.TranslationWordPageObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewAdjektiveTest extends BaseTest
{
    private StartScreen startScreen;
    private EditorScreen editor;
    private TranslationWordPageObject translationWordEditor;

    @Test
    public void testAddNewAdjektive() throws Exception
    {
        Word newAdjektive = new Word()
                .setWord("testAdj")
                .setTranslation("testTransl");

        startScreen = PageFactory.initElements(driver, StartScreen.class);
        editor = startScreen.openEditor(driver);
        editor.clickSpinner(driver);
        translationWordEditor = (TranslationWordPageObject) editor
                    .selectSpinnerValue(driver, Word.TRANSLATION_TYPE)
                    .enterWord(newAdjektive.getWord())
                    .enterTranslation(newAdjektive.getTranslation())
                    .saveWord();

        Assert.assertTrue(startScreen.assertStartScreenDisplayed());
    }
}