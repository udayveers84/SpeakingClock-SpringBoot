package com.example.speakingclock.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.time.LocalTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class TimeController {

    @ApiOperation(value = "Convert time to words")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })

    @GetMapping("/")
    public RedirectView redirectToSwaggerUI() {
        return new RedirectView("/swagger-ui.html");
    }
    
    @GetMapping("/current-time")
    public ResponseEntity<String> getCurrentTimeInWords() {
        try {
            LocalTime currentTime = LocalTime.now();
            int hours = currentTime.getHour();
            int minutes = currentTime.getMinute();
    
            String wordTime=convertTimeToWord(hours,minutes);
            String result = "It's " + wordTime;
    
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid time format");
        }
    }
    

    @GetMapping("/convert")
    public ResponseEntity<String> convertToWords(@RequestParam("time") String timeStr) {
        try {
            String[] timeParts = timeStr.split(":");
    
            if (timeParts.length != 2) {
                return ResponseEntity.badRequest().body("Invalid time format");
            }
    
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
    
            if ((hours < 0 || hours > 23 || minutes < 0 || minutes > 59) && !(hours == 24 && minutes == 0)) {
                throw new IllegalArgumentException("Invalid time format");
            }         
    
            String wordTime=convertTimeToWord(hours,minutes);
            String result = "It's " + wordTime;   
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid time format");
        }
    }
    
    private String convertTimeToWord( int hours, int minutes) {
        if (hours==12 && minutes==0) {
            return "Midday";
        }
        else if ((hours==0 && minutes==0) || (hours==24 && minutes==0)){
            return "Midnight";
        }
        else {           
            String result = getHourWord(hours) + " " + getMinuteString(minutes % 60);
            return result;

        }
    }
    
    private String getHourWord(int hours) {
        String[] hourWords = {
                "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven","twelve"
        };
        return hourWords[hours % 12];
    }
    
    private String getMinuteString(int minutes) {
        String[] minuteWords = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three",
            "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight",
            "twenty-nine", "thirty", "thirty-one", "thirty-two", "thirty-three", "thirty-four",
            "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty",
            "forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six",
            "forty-seven", "forty-eight", "forty-nine", "fifty", "fifty-one", "fifty-two",
            "fifty-three", "fifty-four", "fifty-five", "fifty-six", "fifty-seven", "fifty-eight",
            "fifty-nine"
        };
        return minuteWords[minutes];
    }
     


}
