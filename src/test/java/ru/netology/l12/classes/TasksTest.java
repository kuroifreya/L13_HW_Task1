package ru.netology.l12.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    SimpleTask simpleTask = new SimpleTask(3, "Погладить кота");

    String[] subtasks = {"банановое соевое немолоко", "тофу", "авокадо"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            111,
            "Что взять с собой?",
            "Отпуск",
            "Сегодня после работы");

    @Test
    public void shouldFindMeeting() {
        boolean expected = true;
        boolean actual = meeting.matches("Отпуск");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeeting() {
        boolean expected = false;
        boolean actual = meeting.matches("после");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpic() {
        boolean expected = true;
        boolean actual = epic.matches("банан");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpic() {
        boolean expected = false;
        boolean actual = epic.matches("сыр");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSimpleTask() {
        boolean expected = true;
        boolean actual = simpleTask.matches("кот");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSimpleTask() {
        boolean expected = false;
        boolean actual = simpleTask.matches("собак");

        Assertions.assertEquals(expected, actual);
    }
}
