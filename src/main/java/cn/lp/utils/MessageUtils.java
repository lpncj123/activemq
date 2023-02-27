package cn.lp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Locale;

public class MessageUtils {
    private static final Logger log = LoggerFactory.getLogger(MessageUtils.class);
    private static MessageSource messageSource;

    public MessageUtils(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    public String get(String msgKey) {
        Locale locale = null;

        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            String language = requestAttributes.getRequest().getHeader("x-lang-key");
            log.debug("language {}", language);
            if (language == null) {
                locale = new Locale("en", "US");
            } else {
                String[] langs = language.split("-");
                locale = new Locale(langs[0], langs[1]);
            }
        } catch (Exception var7) {
            log.error("i18n exception  ", var7);
            locale = new Locale("en", "US");
        }

        String local;
        try {
            local = messageSource.getMessage(msgKey, (Object[])null, locale);
        } catch (Exception var6) {
            log.error("i18n 异常 " + var6.getMessage());
            local = msgKey;
        }

        return local;
    }

    public String get(String msgKey, Locale locale) {
        String local = messageSource.getMessage(msgKey, (Object[])null, locale);
        return local;
    }
}
