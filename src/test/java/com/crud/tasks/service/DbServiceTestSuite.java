package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {
    @InjectMocks
    DbService dbService;
    @Mock
    TaskRepository taskRepository;

    @Test
    public void shouldGetAllTasks(){
        //Given
        List<Task>tasks = new ArrayList<>();
        tasks.add(new Task(2L, "task", "content"));
        when(taskRepository.findAll()).thenReturn(tasks);
        //When
        List<Task>taskList = dbService.getAllTasks();
        //Then
        Assert.assertEquals(tasks, taskList);
    }

    @Test
    public void shouldGetTask(){
        //Given
        Task task = new Task(2L, "task", "content");
        when(taskRepository.findById(4L)).thenReturn(Optional.of(task));
        //When
        Optional<Task> task1 = dbService.getTask(4L);
        //Then
        Assert.assertEquals(task.getId(), task1.get().getId());
    }

    @Test
    public void shouldSaveTask(){
        //Given
        Task task = new Task(2L, "task", "content");
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        //When
        Task task1 = dbService.saveTask(task);
        //Then
        Assert.assertEquals(task.getContent(), task1.getContent());
    }


}