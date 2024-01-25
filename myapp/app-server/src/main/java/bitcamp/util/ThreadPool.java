package bitcamp.util;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

  List<WorkerThread> list = new ArrayList<>();

  public WorkerThread get() {
    if (list.size() > 0) {
      return list.remove(0);
    }
    WorkerThread thread = new WorkerThread(this);
    thread.start();
    return thread;
  }

  public void revert(WorkerThread thread) {
    list.add(thread);
  }
}
