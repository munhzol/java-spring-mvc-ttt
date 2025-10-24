package com.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    private int arr[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("Hello World!");
        return "{'message':'Hello World!'}";
    }

    // @RequestMapping("/get-cell")
    @GetMapping(value = "/get-cell", produces = "application/json")
    @ResponseBody
    public String getCell(@RequestParam("cellNo") int cellNo) {

        if (cellNo < 0 || cellNo >= arr.length) {
            return "{'error':'Invalid cell number'}";
        }

        if (arr[cellNo] != 0) {
            return "{'error':'Already filled cell'}";
        }

        arr[cellNo] = 1;

//       comMove();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 2;
                break;
            }
        }

        return Arrays.toString(arr);
    }

    public void comMove() {
        do{
            int cellNo = (int) (Math.random() * 9);
            if (arr[cellNo] == 0) {
                arr[cellNo] = 2;
                break;
            }
        }while (true);
    }

    // @RequestMapping("/reset")
    @GetMapping(value = "/reset", produces = "application/json")
    @ResponseBody
    public String reset() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        return Arrays.toString(arr);
    }

    @GetMapping(value = "/json", produces = "application/json")
    @ResponseBody
    public String jsonResponse() {
        return "{\"message\": \"Hello JSON\"}";
    }

    @RequestMapping("/check-win")
    @ResponseBody
    public String checkWin() {

        if (arr[0] != 0 && arr[0] == arr[1] && arr[1] == arr[2]) {
            return wonText(arr[0]);
        } else if (arr[3] != 0 && arr[3] == arr[4] && arr[4] == arr[5]) {
            return wonText(arr[3]);
        } else if (arr[6] != 0 && arr[6] == arr[7] && arr[7] == arr[8]) {
            return wonText(arr[6]);
        } else if (arr[0] != 0 && arr[0] == arr[3] && arr[3] == arr[6]) {
            return wonText(arr[0]);
        } else if (arr[1] != 0 && arr[1] == arr[4] && arr[4] == arr[7]) {
            return wonText(arr[1]);
        } else if (arr[2] != 0 && arr[2] == arr[5] && arr[5] == arr[8]) {
            return wonText(arr[2]);
        } else if (arr[0] != 0 && arr[0] == arr[4] && arr[4] == arr[8]) {
            return wonText(arr[0]);
        } else if (arr[2] != 0 && arr[2] == arr[4] && arr[4] == arr[6]) {
            return wonText(arr[2]);
        } else if (Arrays.stream(arr).allMatch(i -> i != 0)) {
            return "Draw";
        }
        return "";
    }

    public String wonText(int player) {
        switch (player) {
            case 1:
                return "X wins";
            case 2:
                return "O wins";
            default:
                return "";
        }
    }

}
