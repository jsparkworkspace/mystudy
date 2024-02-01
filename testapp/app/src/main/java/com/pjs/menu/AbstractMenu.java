package com.pjs.menu;

import com.pjs.util.Prompt;
import java.util.Stack;

public abstract class AbstractMenu implements Menu {

  protected Stack<String> breadcrumb;
  String title;

  public AbstractMenu(String title, Stack<String> breadcrumb) {
    this.title = title;
    this.breadcrumb = breadcrumb;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  public String getMenuPath() {
    return String.join("/", breadcrumb.toArray(new String[0]));
  }

  public abstract void execute(Prompt prompt);
}
