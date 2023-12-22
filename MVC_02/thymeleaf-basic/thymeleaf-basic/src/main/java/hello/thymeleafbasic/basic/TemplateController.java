package hello.thymeleafbasic.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateController {
    @GetMapping("/fragment")
    public String template() {
        return "template/fragment/fragmentMain";
    }

    @GetMapping("/layout")
    public String layout() {
        return "template/layout/layoutMain";
    }
}