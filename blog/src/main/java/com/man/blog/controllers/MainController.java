package com.man.blog.controllers;

import com.man.blog.models.About;
import com.man.blog.repo.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "главная страница");
        return "home";
    }



    @Autowired
    private AboutRepository aboutRepository;

    // Вывод всех записей на странице про нас
    @GetMapping("/about")
    public String about(Model model) {
        Iterable<About> data = aboutRepository.findAll();
        model.addAttribute("info", data);
        model.addAttribute("title", "Страничка про нас!");
        return "about";
    }

    // На той же странице отслеживаем получение данных из формы
    @PostMapping("/about")
    public String blogPostAdd(@RequestParam String info, Model model) {
        About post = new About(info);
        aboutRepository.save(post);
        return "redirect:/about";
    }
}
