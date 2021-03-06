package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "tasks: Once a day email";
    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled
            //(fixedDelay = 15)
            (cron = "0 0 10 * * *")
    public void sendInformationEmail(){
        long size = taskRepository.count();
        String mailMessage = "Currently in database you got: " + size + " task";
        if(size!=1)mailMessage+="s";
        simpleEmailService.send(new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        mailMessage
                )
        );
    }

}
