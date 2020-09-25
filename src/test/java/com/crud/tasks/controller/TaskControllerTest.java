package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import javafx.beans.binding.When;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void shouldGetTaskList() throws Exception {
        //Given
        List<TaskDto> taskBoards = new ArrayList<>();
        when(taskMapper.mapToTaskDtoList(service.getAllTasks())).thenReturn(taskBoards);
        // When & Then
        mockMvc.perform(get("/v1/tasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }
    @Test
    public void shouldGetTask() throws Exception {
        //Given
     Task task = new Task(5L,"test", "test get");
     TaskDto taskDto = new TaskDto(5L,"test", "test get");
     service.saveTask(task);

        when(service.getTask(5L)).thenReturn(java.util.Optional.of(task));
        when(taskMapper.mapToTaskDto(ArgumentMatchers.any(Task.class))).thenReturn(taskDto);
        // When & Then
        mockMvc.perform(get("/v1/tasks/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(5))) ;
    }


    @Test
    public void shouldDeleteTask() throws Exception {
        //Given
        // When & Then
        mockMvc.perform(delete("/v1/tasks/5")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    void shouldUpdateTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(5L,"test", "test get");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        System.out.println(jsonContent);

        when(taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)))).thenReturn(taskDto);

        mockMvc.perform(put("/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(5)))
        ;
    }

    @Test
    void shouldCreateTask() throws Exception {
        //Given
        Task task = new Task(5L,"test", "test get");
        TaskDto taskDto = new TaskDto(5L,"test", "test get");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        System.out.println(jsonContent);

        mockMvc.perform(post("/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));
    }
}