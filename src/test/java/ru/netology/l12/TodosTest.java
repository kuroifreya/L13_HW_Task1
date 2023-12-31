package ru.netology.l12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.l12.classes.Epic;
import ru.netology.l12.classes.Meeting;
import ru.netology.l12.classes.SimpleTask;
import ru.netology.l12.classes.Task;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(3, "Сделать бутики с авокадо в дорогу");

    String[] subtasks = {"банановое соевое немолоко", "тофу", "авокадо"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            111,
            "Что взять с собой?",
            "Отпуск",
            "Сегодня после работы");

    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentTypes() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //тесты на поиск каждого из типов задач
    @Test
    public void shouldFindSimpleTask() {//находится одна задача из массива simpleTask
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("дорог");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEpic() {//находится одна задача из массива epic
        Task[] expected = {epic};
        Task[] actual = todos.search("банан");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMeeting() {//находится одна задача из массива meeting
        Task[] expected = {meeting};
        Task[] actual = todos.search("взять");

        Assertions.assertArrayEquals(expected, actual);
    }

    //тесты на поиск определенного количества элементов
    @Test
    public void shouldFindNothing() {//находится 0 задач
        Task[] expected = {};
        Task[] actual = todos.search("мёд");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindStart() {//не ищет инфо из поля Start класса Meeting
        Task[] expected = {};
        Task[] actual = todos.search("Сегодня");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneElement() {//находится 1 задача
        Task[] expected = {epic};
        Task[] actual = todos.search("тофу");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindFewElements() {//находится несколько задач
        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("авокадо");

        Assertions.assertArrayEquals(expected, actual);
    }
}
