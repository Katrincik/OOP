package Lab3.src.main.java.command;

import Lab3.src.main.java.snapshot.Snapshot;

/**
 * Command interface. All supported commands should implement it.
 */
public interface Command {
  void execute(String[] args, Snapshot snapshot);
  //запуск комаманды в зависимости что юзер ввел
  //юзер сделал инпут и должны выполнить команду
}
