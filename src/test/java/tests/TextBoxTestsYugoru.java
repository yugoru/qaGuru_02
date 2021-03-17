package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTestsYugoru {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Iuliia");
        $("#lastName").setValue("Gorshkova");
        $("#userEmail").setValue("iuliia@qahacking.ru");
        $("label[for=gender-radio-2]").click();
        $("#userNumber").setValue("9996387733");
        $("#dateOfBirthInput").setValue("09 Mar 2006");
        $("#subjectsInput").setValue("Sub");
        $("#hobbiesWrapper").find(byText("Music")).click();
        $("#hobbiesWrapper").find(byText("Reading")).click();
        $("#uploadPicture").sendKeys("/Volumes/Macintosh HD - Data/JavaLesson/qaGuru_2/src/files/1.jpeg");
        $("#currentAddress").setValue("St.Petersburg, Viborgskaya naberejnaya");
        $("#stateCity-wrapper").find(byId("state")).click();
        $("#react-select-3-option-2").click();
        $("#stateCity-wrapper").find(byId("city")).click();
        $("#react-select-4-option-1").click();
        $("#submit").click();
        $(".modal-content").find(byCssSelector("#closeLargeModal")).click();

    }
}