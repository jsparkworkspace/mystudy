package bitcamp.myapp.handler.member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class MemberModifyHandler implements MenuHandler {

  Prompt prompt;
  ObjectRepository<Member> objectRepository;

  public MemberModifyHandler(ObjectRepository<Member> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Member oldMember = this.objectRepository.get(index);
    if (oldMember == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = new Member();
    member.email = this.prompt.input("이메일(%s)? ", oldMember.email);
    member.name = this.prompt.input("이름(%s)? ", oldMember.name);
    member.password = this.prompt.input("새 암호? ");
    member.createdDate = this.prompt.input("가입일(%s)? ", oldMember.createdDate);

    this.objectRepository.set(index, member);
  }
}
