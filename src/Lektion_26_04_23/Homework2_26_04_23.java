package Lektion_26_04_23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework2_26_04_23 {

  //Задание 2* (необязательно)
  //Усовершенствуйте программу Task2MonthsEnums так,
  // чтобы число дней в месяце читалось из файла res/months.csv и сохранялось в Map<Month, Integer>.
  public static void main(String[] args) throws IOException {
    Map<Month, Integer> dayPerMonth = monthIntegerHashMap("res/month.csv");
    System.out.println(dayPerMonth + "\n");

  }

  public static Map<Month, Integer> monthIntegerHashMap(String fileName) throws IOException {
    Map<Month, Integer> monthIntegerHashMap = new HashMap<>();
    //создаём Маp, куда будем записывать наши параметры

    BufferedReader br = new BufferedReader(new FileReader(fileName));

    String line; // строка, каторая читает из файла
    while ((line = br.readLine()) != null) {  // пока строка в файле не будет пустая делаем запись
      String monthName = line.substring(0, line.indexOf(","));
      // первое слово до запятой
      String dayToMonth = line.substring(line.indexOf(",") + 1);
      // второе слово/значение после запятой и до конца строки

      //теперь у нас есть два String, а нам надо Моnth и Integer.

      // преобразуем String monthName и String dayToMonth
      Month monthKey = Month.valueOf(monthName);
      int daysValue = Integer.parseInt(dayToMonth);

      //добовляем в нашу Map
      monthIntegerHashMap.put(monthKey, daysValue);


    }

    return monthIntegerHashMap;

  }

  //{JANUARY=31, OCTOBER=31, NOVEMBER=30,SEPTEMBER=30, APRIL=30, JUNE=30,

  // AUGUST=31, JULY=31,FEBRUARY=28,DECEMBER=31,MARCH=31, MAY=31}


}
