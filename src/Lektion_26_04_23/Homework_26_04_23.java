package Lektion_26_04_23;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework_26_04_23 {

  //Задание 1
  //Расширьте программу Task2MonthsEnums.
  //
  //Добавьте ещё один enum, который будет описывать времена года (зима, лето, весна, осень).
  //
  //Для введённого пользователем месяца напишите,
  // к какому именно времени года относится выбранный месяц.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    daysPerMonth(monthName(scanner));

  }

  private static String monthName(Scanner scanner) {
    System.out.print("Enter your favorite month : ");
    String monthName = scanner.nextLine();

    return monthName;
  }

  private enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER
  }

  private enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
  }

  private static Month daysPerMonth(String monthName) {

    Map<Month, Integer> daysPerMonth = new HashMap<>();
    daysPerMonth.put(Month.JANUARY, 31);
    daysPerMonth.put(Month.FEBRUARY, 28); // год не високосный
    daysPerMonth.put(Month.MARCH, 31);
    daysPerMonth.put(Month.APRIL, 30);
    daysPerMonth.put(Month.MAY, 31);
    daysPerMonth.put(Month.JUNE, 30);
    daysPerMonth.put(Month.JULY, 31);
    daysPerMonth.put(Month.AUGUST, 31);
    daysPerMonth.put(Month.SEPTEMBER, 30);
    daysPerMonth.put(Month.OCTOBER, 31);
    daysPerMonth.put(Month.NOVEMBER, 30);
    daysPerMonth.put(Month.DECEMBER, 31);

    Month monthKey = Month.valueOf(monthName.toUpperCase()); // месяц "как ключ словаря"
    System.out.println(monthName + " has " + daysPerMonth.get(monthKey) + " days");
    System.out.println(monthName + " is a month of " + parseSeason(monthKey));

    return monthKey;

  }

  private static Season parseSeason(Month month) {

    return switch (month) {
      case DECEMBER, JANUARY, FEBRUARY -> Season.WINTER;

      case MARCH, APRIL, MAY -> Season.SPRING;

      case JUNE, JULY, AUGUST -> Season.SUMMER;

      case SEPTEMBER, OCTOBER, NOVEMBER -> Season.AUTUMN;
    };


  }

}






