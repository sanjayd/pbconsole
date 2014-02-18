package net.sanjayd.pb.web;

import net.sanjayd.pb.service.AlarmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @RequestMapping(value = "/alarm", method = RequestMethod.POST)
    public ResponseEntity<String> toggle(@RequestParam("armed") Boolean armed) {
        return new ResponseEntity<String>("" + alarmService.switchTo(armed), HttpStatus.OK);
    }

    @RequestMapping(value = "/alarm", method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<String>> isArmed(@RequestParam(value = "alertWhen", required = false) Boolean alertWhen) {
        return alarmService.isArmed(alertWhen);
    }
}
