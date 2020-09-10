package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {
//    Task task = new Task(5L,"test", "test get");
 //   TaskDto taskDto = new TaskDto(5L,"test", "test get");
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void shouldMapDtoToTask(){
        //Given
        TaskDto taskDto = new TaskDto(5L,"test", "test get");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        long id=task.getId();
        //Then
        Assert.assertEquals(5L,id);
    }
    @Test
    public void shouldMapTaskToDto(){
        //Given
        Task task = new Task(5L,"test", "test get");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        String title=task.getTitle();
        //Then
        Assert.assertEquals("test",title);
    }
    @Test
    public void shouldMapTaskListToDto(){
        //Given

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(5L,"test", "testew get"));
        tasks.add(new Task(15L,"te3st", "tetst get"));
        tasks.add(new Task(4L,"te1st", "tesqt get"));

        //When
        List<TaskDto> taskDto = taskMapper.mapToTaskDtoList(tasks);
        String titleOfThirdTaskDto=tasks.get(2).getTitle();
        //Then
        Assert.assertEquals(3, taskDto.size());
        Assert.assertEquals("te1st",titleOfThirdTaskDto);
    }

}