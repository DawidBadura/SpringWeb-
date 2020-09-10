package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.domain.TrelloBoard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {
    @InjectMocks
    TrelloValidator trelloValidator;

    @Test
    public void shouldValidateTrelloBoards(){
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "Test", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("3", "Test", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("4", "my Task", new ArrayList<>()));
        //When
        List<TrelloBoard> trelloFiltredBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        Assert.assertEquals(1,trelloFiltredBoards.size());
    }

}