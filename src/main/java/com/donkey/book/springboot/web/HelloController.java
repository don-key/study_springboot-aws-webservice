package com.donkey.book.springboot.web;

import com.donkey.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다
@RestController
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //@RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션, 외부 파라미터를  메소드 파라미터에 저장한다.
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
