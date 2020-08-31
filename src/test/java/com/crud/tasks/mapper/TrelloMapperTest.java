package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void shouldMapDtoToTrelloBoard() {
        //Given
        List<TrelloBoardDto> trelloBoardDto=new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("1","sddsa", new ArrayList<>()));
        //When

        //Then
        assertEquals(TrelloBoard.class, trelloMapper.mapToBoards(trelloBoardDto).get(0).getClass());
    }

    @Test
    public void shouldMapDomainToTrelloBoardDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1","sddsa", new ArrayList<>()));
        //When

        //Then
        assertEquals(TrelloBoardDto.class, trelloMapper.mapToBoardsDto(trelloBoards).get(0).getClass());
    }

    @Test
    public void shouldMapDtoToTrelloList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1","sddsa", false));
        //When

        //Then
        assertEquals(TrelloList.class, trelloMapper.mapToList(trelloListDto).get(0).getClass());
    }

    @Test
    public void shouldMapDomainToTrelloListDto() {
        //Given
        List<TrelloList> trelloLists=new ArrayList<>();
        trelloLists.add(new TrelloList("1","sddsa", false));
        //When

        //Then
        assertEquals(TrelloListDto.class, trelloMapper.mapToListDto(trelloLists).get(0).getClass());
    }


    @Test
    public void shouldMapDomainToTrelloCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");
        //When

        //Then
        assertEquals(TrelloCardDto.class, trelloMapper.mapToCardDto(trelloCard).getClass());
    }
    @Test

    public void shouldMapDtoToTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");
        //When

        //Then
        assertEquals(TrelloCard.class, trelloMapper.mapToCard(trelloCardDto).getClass());
    }




}