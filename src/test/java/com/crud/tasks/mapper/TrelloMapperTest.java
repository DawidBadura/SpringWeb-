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
        String trelloBoardName=trelloBoardDto.get(0).getName();

        //Then
        assertEquals(trelloBoardName, "sddsa");
        assertEquals(TrelloBoard.class, trelloMapper.mapToBoards(trelloBoardDto).get(0).getClass());
    }

    @Test
    public void shouldMapDomainToTrelloBoardDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1","sddsa", new ArrayList<>()));
        //When
        String trelloBoardId = trelloBoards.get(0).getId();

        //Then
        assertEquals(trelloBoardId,"1");
        assertEquals(TrelloBoardDto.class, trelloMapper.mapToBoardsDto(trelloBoards).get(0).getClass());
    }

    @Test
    public void shouldMapDtoToTrelloList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1","sddsa", false));
        //When
        String trelloListDtoId = trelloListDto.get(0).getId();

        //Then
        assertEquals(trelloListDtoId,"1");
        assertEquals(TrelloList.class, trelloMapper.mapToList(trelloListDto).get(0).getClass());
    }

    @Test
    public void shouldMapDomainToTrelloListDto() {
        //Given
        List<TrelloList> trelloLists=new ArrayList<>();
        trelloLists.add(new TrelloList("1","sddsa", false));
        //When
        String trelloListId = trelloLists.get(0).getId();

        //Then
        assertEquals(trelloListId,"1");
        assertEquals(TrelloListDto.class, trelloMapper.mapToListDto(trelloLists).get(0).getClass());
    }


    @Test
    public void shouldMapDomainToTrelloCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");
        //When
        String trelloCardName = trelloCard.getName();

        //Then
        assertEquals(trelloCardName,"name");
        assertEquals(TrelloCardDto.class, trelloMapper.mapToCardDto(trelloCard).getClass());
    }
    @Test

    public void shouldMapDtoToTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");
        //When
        String trelloCardDtoName = trelloCardDto.getName();

        //Then
        assertEquals(trelloCardDtoName,"name");
        assertEquals(TrelloCard.class, trelloMapper.mapToCard(trelloCardDto).getClass());
    }




}