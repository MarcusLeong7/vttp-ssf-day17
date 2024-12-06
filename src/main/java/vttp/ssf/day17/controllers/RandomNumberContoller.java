package vttp.ssf.day17.controllers;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp.ssf.day17.services.RandomService;

@Controller
@RequestMapping(path = "/random")
public class RandomNumberContoller {

    @Autowired
    private RandomService randomSvc;

    // GET /random
    // Accept: text/html
    @GetMapping
    public ModelAndView getRandom(Model model) {

        ModelAndView mav = new ModelAndView("random-number");
        mav.addObject("randNum", randomSvc.getRandom(100));

        return mav;
    }

    // GET /random
    // Accept: application/json
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getRandomAsJson(
            @RequestParam(defaultValue = "100") int bounds) {

        
        JsonObject result = Json.createObjectBuilder()
                .add("randNum", randomSvc.getRandom(bounds))
                .build();

        return ResponseEntity.ok(result.toString());
    }

}
