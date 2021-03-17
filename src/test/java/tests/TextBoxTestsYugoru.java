package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTestsYugoru {
    String firstName = "Ada", lastName = "Lovelace",
            subject = "Hindi",
            subject2 = "Maths",
            currentAddress = "Russia \n St.Petersburg \n Viborgskaya naberejnaya \n Rozoviy dom",
            email = "e@ma.ru",
            phone = "0909090909",
            gender = "label[for=gender-radio-2]",
            genderName = "Female",
            hobby2 = "Music", hobby3 = "Reading",
            month = "April",
            year = "1991",
            day = ".react-datepicker__day--026",
            convertedDate = "26 "+ month + "," + year,
            state = "Haryana",
            city = "Panipat";


    Path fileP = Paths.get("./qaGuru_2/src/files/1.jpeg");
    File file = new File(fileP.toString());
    String fileName = fileP.getFileName().toString();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(gender).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find(byText(month)).click();
        $(".react-datepicker__year-select").find(byText(year)).click();
        $(day).click();
        $("#subjectsInput").sendKeys(subject);
        $(".css-26l3qy-menu div").find(byText(subject)).click();
        $("#subjectsInput").sendKeys(subject2);
        $(".css-26l3qy-menu div").find(byText(subject2)).click();
        $("#hobbiesWrapper").find(byText(hobby2)).click();
        $("#hobbiesWrapper").find(byText(hobby3)).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#stateCity-wrapper").scrollIntoView(true);
        $("#stateCity-wrapper").find(byId("state")).click();
        $(".css-26l3qy-menu div").find(byText(state)).click();
        $("#stateCity-wrapper").find(byId("city")).click();
        $(".css-26l3qy-menu div").find(byText(city)).click();
        $("#submit").click();

        $(".table-responsive").shouldHave((text(firstName + " " + lastName)),
                text(email),
                text(genderName),
                text(phone),
                text(convertedDate),
                text(subject),
                text(subject2),
                text(hobby2),
                text(hobby3),
                text(fileName),
                text(currentAddress),
                text(state + " " + city));

        $(".modal-content").find(byCssSelector("#closeLargeModal")).click();

    }
}