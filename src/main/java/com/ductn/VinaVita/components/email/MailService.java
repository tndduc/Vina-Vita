package com.ductn.VinaVita.components.email;

import com.ductn.VinaVita.dto.EmailDTO;

public interface MailService {

    public int sendEmail(EmailDTO mail);
}
