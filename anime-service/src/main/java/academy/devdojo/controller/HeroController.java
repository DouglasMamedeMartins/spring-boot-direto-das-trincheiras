package academy.devdojo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/heroes")
public class HeroController {
  private static final List<String> HEROES = List.of("Guts", "Zoro", "Goku", "Kakashi");

  @GetMapping
  public List<String> listAllHeores() {
    return HEROES;
  }

  @GetMapping("filter")
  public List<String> listAllHeoresParam(@RequestParam(defaultValue = "") String name) {
    return HEROES.stream().filter(hero -> hero.equalsIgnoreCase(name)).toList();
  }

  @GetMapping("filterList")
  public List<String> listAllHeoresParamList(@RequestParam(defaultValue = "") List<String> names) {
    return HEROES.stream().filter(names::contains).toList();
  }


  @GetMapping("{name}")
  public String findByName(@PathVariable String name) {
    return HEROES
        .stream()
        .filter(hero -> hero.equalsIgnoreCase(name))
        .findFirst().orElse("");
  }
}
