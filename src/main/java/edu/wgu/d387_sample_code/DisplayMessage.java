package edu.wgu.d387_sample_code;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.protocol.MessageReader;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.Getter;
import netscape.javascript.JSObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SimpleTimeZone;
import java.util.concurrent.ExecutorService;

public class DisplayMessage {

    private ResourceBundle bundle;

    public String getWelcomeMessage() {
        return bundle.getString("welcome");
    }

    public DisplayMessage() {
    }

    public DisplayMessage(String language, String country) {
        Locale locale = new Locale(language, country);
        bundle = ResourceBundle.getBundle("welcome", locale);
    }

}