/*
package com.crud.tasks.scheduler;

import com.crud.tasks.TasksApplication;
import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.awaitility.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import static com.google.common.base.Verify.verify;
import static com.google.common.collect.Range.atLeast;
import static org.awaitility.Awaitility.await;


@SpringJUnitConfig(TasksApplication.class)
//@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTest {

    private static final String SUBJECT = "tasks: Once a day email";

*/
/*    @InjectMocks
    EmailScheduler emailScheduler;

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;*//*


    @SpyBean
    EmailScheduler emailScheduler1;

    @Test
    public void shouldWork() {

        await().atMost(Duration.ONE_SECOND).
                untilAsserted(() -> verify(emailScheduler1, atLeast(10)).
                        sendInformationEmail());
    }



}*/
