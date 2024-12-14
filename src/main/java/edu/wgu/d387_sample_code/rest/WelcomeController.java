package edu.wgu.d387_sample_code.rest;

import com.mysql.cj.protocol.MessageReader;
import edu.wgu.d387_sample_code.DisplayMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.ThemeTag;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WelcomeController {

    private Executor executor  = Executors.newFixedThreadPool(2);

    @GetMapping("/welcome-message")
    public ResponseEntity<List<String>>getWelcomeMessage() {
        List<String> mlist = new ArrayList<String>();

        // add English welcome message to the list
        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            DisplayMessage msgEN = new DisplayMessage("en", "US");
            mlist.add(msgEN.getWelcomeMessage() + threadName);
        });

        // add French welcome message to the list
        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            DisplayMessage msgFR = new DisplayMessage("fr", "CA");
            mlist.add(msgFR.getWelcomeMessage() + threadName);
        });

        return ResponseEntity.ok(mlist);

    }
}