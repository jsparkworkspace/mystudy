package algorithm.test;

import java.util.Date;

public class DateTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Date date = new Date();
    date.setTime(0);
    System.out.println(date);

    Long test = date.getTime();

    System.out.println(test);
    java.sql.Date sqlDate1 = new java.sql.Date(test);
    System.out.println(sqlDate1);


  }

}
