package edu.wgu.d387_sample_code.rest;

//import edu.wgu.d387_sample_code.TimeConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@CrossOrigin
@RequestMapping("/times")
public class TimeController {

    private String timeStart = "12:30 PM Eastern Time";
    private String timeFormat = "HH:mm aa z";
    private String[] timeZones = new String[] {"America/New_York", "America/Denver", "UTC"};
    private SimpleDateFormat timeFormatter = new SimpleDateFormat(timeFormat);

    @GetMapping("/timezones")
    public ResponseEntity<List<String>> getConvertedTimes() {
        List<String> convertedTimes = new ArrayList<String>();

        try {
            Date date = timeFormatter.parse(timeStart);

            for (String tm : timeZones) {

                TimeZone tz = TimeZone.getTimeZone(tm);
                timeFormatter.setTimeZone(tz);

                String times = timeFormatter.format(date);
                convertedTimes.add(times);
            }

            TimeZone etTz = TimeZone.getTimeZone("America/New_York");
            timeFormatter.setTimeZone(etTz);

            TimeZone mtTz = TimeZone.getTimeZone("America/Denver");

            TimeZone utcTz = TimeZone.getTimeZone("UTC");

        } catch (Exception e) {
            System.out.println(e.toString());
            convertedTimes.add(e.toString());
        }

        return ResponseEntity.ok(convertedTimes);
    }
}
