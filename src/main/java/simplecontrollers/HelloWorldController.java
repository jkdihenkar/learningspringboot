package simplecontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api")
public class HelloWorldController {

    @GetMapping("/v1")
    public HelloWorld sayHelloReqParam(@RequestParam(name = "content", defaultValue = "Hello World!") String message) {
        return new HelloWorld(1, message);
    }

    @GetMapping("/v1/{content}")
    public HelloWorld sayHelloPathVar(@PathVariable(name = "content") String message) {
        return new HelloWorld(1, message);
    }

}
