package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class auto14s12auto {
    public static void main(String[] args) {

        String[][] data = {

                // firster test case (  existing email address.)
                {"Mohamed", "Yehiadskjhdskjh","01122620999","myeiha7@gmail.com","Y01234567","Y01234567",""},
                // Second test case (not matching password )
                //hihihihihihihi
                {"salma", "samy","014123679","troy_143@hotmail.com","131314Mm","131314MmK",""},
                // Third test case (valid ddkjfhkjdshata with new email address )
                {"Mo", "salah","0144244987539847533563","tarek_yehia@yahoo.com","12345Mm","12345Mm",""},

        };

        String[] iterableData= {"firstname","lastname","phone","email","password","confirmpassword"};
        // open chrome driver and browse registeration page
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\a815201\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.phptravels.net/register");
        System.out.println(driver.getTitle());
        WebElement element =null;

        // for loop for input data by iterating rows
        for(int i=0 ; i<data.length;i++) {
            // for loop for clear data
            for (String iterableDatum : iterableData) {
                element = driver.findElement(By.name(iterableDatum));
                // function clearing all data field
                element.clear();

            }

            for(int j=0;j<data[i].length-1;j++) {
                element = driver.findElement(By.name(iterableData[j]));
                element.sendKeys(data[i][j]);



            }
            // submit data sign up button
            element.submit();
            // delay between every send request of submit data button 3 second.
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // if page redirect to My account so it prints true and if not and user existing  it prints false
            if(driver.getTitle().equals("My Account"))
            {
                data[i][data[i].length-1]="True";
            }
            else {
                data[i][data[i].length-1]="False";

            }
            System.out.println(data[i][data[i].length-1]);
        }

    }

}

