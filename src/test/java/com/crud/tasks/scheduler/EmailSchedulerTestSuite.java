package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CoreConfiguration;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import javafx.beans.binding.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTestSuite {
    @InjectMocks
    EmailScheduler emailScheduler;
    @Mock
    SimpleEmailService simpleEmailService;
    @Mock
    TaskRepository taskRepository;
    @Mock
    AdminConfig adminConfig;



    @Test
    public void shouldSendEmail() throws InterruptedException {
        //Given
        when(taskRepository.count()).thenReturn(1L);
        when(adminConfig.getAdminMail()).thenReturn("test");
        emailScheduler.sendInformationEmail();
        Mail mail = new Mail("test","tasks: Once a day email", "Currently in database you got: 1 task");

        verify(simpleEmailService, times(1)).send(mail);




    }

}
