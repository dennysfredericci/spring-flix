package br.com.fredericci.springflix.controller;

import br.com.fredericci.springflix.domain.VideoEntity;
import br.com.fredericci.springflix.repository.VideoRepository;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final VideoRepository videoRepository;

    public HomeController(final VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("videos", this.videoRepository.findAll());
        return "home";
    }


    @PostConstruct
    public void loadDatabase() {
        VideoEntity videoEntity1 = new VideoEntity();
        videoEntity1.setTitle("Learn Java 8 - Full Tutorial for Beginners");
        videoEntity1.setDescription("Learn Java 8 and object oriented programming with this complete Java course for beginners.");
        videoEntity1.setYoutubeUrl("http://www.youtube.com/embed/grEKMHGYyns");
        videoRepository.save(videoEntity1);

        VideoEntity videoEntity2 = new VideoEntity();
        videoEntity2.setTitle("Java Lambda Expressions #1 - The Basics");
        videoEntity2.setDescription("Java lambda expressions are great for implementing small event listeners, callbacks, or for functional programming in Java, e.g. with the Java streams API.");
        videoEntity2.setYoutubeUrl("http://www.youtube.com/embed/lIXs4Y8sJCk");
        videoRepository.save(videoEntity2);

        VideoEntity videoEntity3 = new VideoEntity();
        videoEntity3.setTitle("Get a Taste of Lambdas and Get Addicted to Streams");
        videoEntity3.setDescription("Get a Taste of Lambdas and Get Addicted to Streams");
        videoEntity3.setYoutubeUrl("http://www.youtube.com/embed/1OpAgZvYXLQ");
        videoRepository.save(videoEntity3);

        VideoEntity videoEntity4 = new VideoEntity();
        videoEntity4.setTitle("Usando API de Datas do Java - LocalDate");
        videoEntity4.setDescription("Veja como manipular dadas no Java com a nova API de datas presente no Java 8.");
        videoEntity4.setYoutubeUrl("http://www.youtube.com/embed/oW_ArKTfJFU");
        videoRepository.save(videoEntity4);

        VideoEntity videoEntity5 = new VideoEntity();
        videoEntity5.setTitle("Como usar Git e Github na prática: Guia para iniciantes");
        videoEntity5.setDescription("Você já se perguntou o que é Git? E o que é GitHub? Quais as diferenças? Por que devo usar Git nos meus projetos?");
        videoEntity5.setYoutubeUrl("http://www.youtube.com/embed/2alg7MQ6_sI");
        videoRepository.save(videoEntity5);

        VideoEntity videoEntity6 = new VideoEntity();
        videoEntity6.setTitle("Java Enum");
        videoEntity6.setDescription("A Java enum is a mechanism for creating a collection of constants in Java. A Java enum is short for an \"enumeration of constants\". Typically you will create an enum containing related constants, e.g. HIGH, MEDIUM and LOW. This video explains how Java enums works.");
        videoEntity6.setYoutubeUrl("http://www.youtube.com/embed/1612Ngij7_c");
        videoRepository.save(videoEntity5);

        VideoEntity videoEntity7 = new VideoEntity();
        videoEntity7.setTitle("How to use Printf method in Java");
        videoEntity7.setDescription("How to use Printf method in Java");
        videoEntity7.setYoutubeUrl("http://www.youtube.com/embed/0-nM4IoQXsY");
        videoRepository.save(videoEntity7);

        VideoEntity videoEntity8 = new VideoEntity();
        videoEntity8.setTitle("Learning How to Learn | Talks at Google");
        videoEntity8.setDescription("Learning How to Learn By Barbara Oakley");
        videoEntity8.setYoutubeUrl("http://www.youtube.com/embed/vd2dtkMINIw");
        videoRepository.save(videoEntity8);

        VideoEntity videoEntity9 = new VideoEntity();
        videoEntity9.setTitle("Project Lombok | GoodBye Boilerplate Code");
        videoEntity9.setDescription("Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.");
        videoEntity9.setYoutubeUrl("http://www.youtube.com/embed/745W-dng3wk");
        videoRepository.save(videoEntity9);
    }
}
