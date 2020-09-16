package com.crud.tasks.domain;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String message;
    private String toCc;

    public Mail(String mailTo, String subject, String message) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mail mail = (Mail) o;

        if (mailTo != null ? !mailTo.equals(mail.mailTo) : mail.mailTo != null) return false;
        if (subject != null ? !subject.equals(mail.subject) : mail.subject != null) return false;
        if (message != null ? !message.equals(mail.message) : mail.message != null) return false;
        return toCc != null ? toCc.equals(mail.toCc) : mail.toCc == null;
    }

    @Override
    public int hashCode() {
        int result = mailTo != null ? mailTo.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (toCc != null ? toCc.hashCode() : 0);
        return result;
    }
}
