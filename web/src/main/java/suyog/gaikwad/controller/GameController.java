package suyog.gaikwad.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import suyog.gaikwad.service.GameService;
import suyog.gaikwad.util.AttributeNames;
import suyog.gaikwad.util.GameMappings;
import suyog.gaikwad.util.ViewNames;

@Slf4j
@Controller
public class GameController {

    // == fields ==
    private final GameService gameService;

    // == constructor ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // == request methods ==
    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);
        if(gameService.isGameOver()) {
            gameService.reset();
            return ViewNames.GAME_OVER;
        }
        return ViewNames.PLAY;
    }


    @PostMapping(GameMappings.PLAY)
    public String processGuess(@RequestParam int guess) {
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }



}
