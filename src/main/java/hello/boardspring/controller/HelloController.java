package hello.boardspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // /hello 로 들어왔을 때
    @GetMapping("hello")
    public String hello(Model model){ //파라미터의 Model model은 스프링이 자동으로 전달함
        model.addAttribute("data","hello!"); //뷰로 전달될 모델
        return "hello"; //src>main>resources>templates의 hello.html을 의미
        //즉 파라미터로 들어온 model을 뷰에 전달하는 것
    }
    
    
    // /hello-mvc 로 들어왔을 때
    //이번에는 url 파라미터를 전달받아서 그걸 model에 담아서 넘겨주자.
    //즉 위의 hello 는 model에 내가 걍 임의로 무조건 hello만 model에 담아서 넘겨주는 거고, 
    //얘는 파라미터로 받은 애를 model에 담아서 넘겨주는 것
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){//파라미터의 이름은 "name", 전달받은 파라미터 값은 String name 에 들어가는 것
        model.addAttribute("name",name);//뷰로 전달될 모델 //즉 "name"은 말 그대로 키의 이름, name이 파라미터로 전달받은 value
        return "hello-template"; //src>main>resources>templates의 hello-template.html을 의미
        //그리고 뷰는 전달받은 모델을 반영해서 보여줌
    }
    
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name")String name){
        return "hello "+name;
    }
    
    
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello;
    }
    
    
    static class Hello{
        private String name;
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    }
}
