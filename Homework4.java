import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework4 {
    @Test
     public void Registration(){
        Selenide.open("https://redmed.ge/ka/user/register");
        $(byText("რეგისტრაცია")).click();
        $("#userName").setValue("ცაგო");
        $("#lastName").setValue("თელია");
        $("#mobileNumber").setValue("551151515");
        $("#email").setValue("t.telia@gmail.com");
        $("#terms").click();
        $("#user-registration-button").shouldBe(Condition.visible);
        sleep(3000);
    }
    @Test

    public void FailRegistration(){
        Selenide.open("https://redmed.ge/ka/user/register");
        $("#userName").setValue("ცაგო");
        $("#lastName").setValue("0"); // მაინც გაუშვებს დასარეგისტრირებლად
        $("#mobileNumber").setValue("551151515");
        $$(".standard-input ng-invalid ng-touched ng-dirty").shouldBe(empty); // თუ ცარიელია ველი რომ გააწითლოს
        $("#user-registration-button").click();
        $(byText("გთხოვთ, დაეთანხმოთ წესებს და პირობებს")).shouldBe(Condition.visible);
        sleep(3000);

    }




}
