package bitcamp.myapp;

import java.util.Scanner;

public class App {

  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR;
  static final String[] MENUS = {"1. 과제", "2. 게시글", "3. 도움말", ANSI_RED + "4. 종료" + ANSI_CLEAR};


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    printMenu();

    loop:
    while (true) {
      String input = prompt(sc);

      switch (input) {
        case "1":
          System.out.println("과제입니다.");
          break;
        case "2":
          System.out.println("게시글입니다.");
          break;
        case "3":
          System.out.println("도움말 입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("범위를 벗어난 값입니다.");
          break;
      }// switch
    }//while

  }// main

  static void printMenu() {
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }//printMenu method

  static String prompt(Scanner sc) {
    System.out.print("> ");
    return sc.nextLine();
  }//prompt method

}// class
