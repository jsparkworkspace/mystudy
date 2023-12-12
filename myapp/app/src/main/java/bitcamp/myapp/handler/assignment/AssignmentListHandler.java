package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;

public class AssignmentListHandler implements MenuHandler {

  ObjectRepository objectRepository;


  public AssignmentListHandler(ObjectRepository objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

//    for (int i = 0; i < this.assignmentRepository.length; i++) {
//      Assignment assignment = this.assignmentRepository.assignments[i];
//      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
//    }
    for (Object object : objectRepository.toArray()) {
      Assignment assignment = (Assignment) object;
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}
