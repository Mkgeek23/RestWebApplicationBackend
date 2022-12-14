package pl.emkgeek.restwebapplicationbackend.pingpong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "status")
public class PingPongController {
    @GetMapping(path = "ping")
    public ResponseEntity<String> getPong() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
