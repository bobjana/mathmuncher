package za.co.mathmuncher.exercise;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import za.co.mathmuncher.exercise.template.ExerciseTemplate;
import za.co.mathmuncher.exercise.template.ExerciseTemplateRepository;

@RequestMapping("/exercise")
@Controller
public class ExerciseController {

    private ExerciseService exerciseService;
    private ExerciseTemplateRepository exerciseTemplateRepository;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, ExerciseTemplateRepository exerciseTemplateRepository) {
        this.exerciseService = exerciseService;
        this.exerciseTemplateRepository = exerciseTemplateRepository;
    }

    @RequestMapping(value = "start/{type}", method = RequestMethod.GET)
    public @ResponseBody Exercise start(@PathVariable Type type) {
        Assert.notNull(type, "Type must be specified");
        ExerciseTemplate exerciseTemplate = exerciseTemplateRepository.findByType(type);
        Exercise exercise = exerciseService.generate(exerciseTemplate);
        exercise.setStartDate(new Date());
        return exercise;
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Throwable ex, HttpServletResponse response) {
        try {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//	@RequestMapping(value = "/quiz/save/{quizId}", method = RequestMethod.POST)
//	public void submitAnswers(@PathVariable Long quizId,
//		@RequestBody List<Answer> answers, HttpServletResponse response) {
//		Quiz quiz = Quiz.findQuiz(quizId);
//		quiz.saveAnswers(answers);
//		quiz.merge();
//		response.setHeader("Location", String.format("/quiz/%s", quizId));
//	}
//
//	@RequestMapping(value = "/quiz/{quizId}", method = RequestMethod.GET)
//	public @ResponseBody Quiz show(@PathVariable Long quizId) {
//		return Quiz.findQuiz(quizId);
//	}
//

//	@RequestMapping(method = RequestMethod.POST)
//    public String create(@Valid Exercise exercise, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
//        if (bindingResult.hasErrors()) {
//            uiModel.addAttribute("exercise", exercise);
//            addDateTimeFormatPatterns(uiModel);
//            return "exercises/create";
//        }
//        uiModel.asMap().clear();
//        exercise.persist();
//        return "redirect:/exercises/" + encodeUrlPathSegment(exercise.getId().toString(), httpServletRequest);
//    }
//
//	@RequestMapping(params = "form", method = RequestMethod.GET)
//    public String createForm(Model uiModel) {
//        uiModel.addAttribute("exercise", new Exercise());
//        addDateTimeFormatPatterns(uiModel);
//        return "exercises/create";
//    }
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String show(@PathVariable("id") Long id, Model uiModel) {
//        addDateTimeFormatPatterns(uiModel);
//        uiModel.addAttribute("exercise", Exercise.findExercise(id));
//        uiModel.addAttribute("itemId", id);
//        return "exercises/show";
//    }
//
//	@RequestMapping(method = RequestMethod.GET)
//    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
//        if (page != null || size != null) {
//            int sizeNo = size == null ? 10 : size.intValue();
//            uiModel.addAttribute("exercises", Exercise.findExerciseEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
//            float nrOfPages = (float) Exercise.countExercises() / sizeNo;
//            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
//        } else {
//            uiModel.addAttribute("exercises", Exercise.findAllExercises());
//        }
//        addDateTimeFormatPatterns(uiModel);
//        return "exercises/list";
//    }
//
//	@RequestMapping(method = RequestMethod.PUT)
//    public String update(@Valid Exercise exercise, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
//        if (bindingResult.hasErrors()) {
//            uiModel.addAttribute("exercise", exercise);
//            addDateTimeFormatPatterns(uiModel);
//            return "exercises/update";
//        }
//        uiModel.asMap().clear();
//        exercise.merge();
//        return "redirect:/exercises/" + encodeUrlPathSegment(exercise.getId().toString(), httpServletRequest);
//    }
//
//	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
//    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
//        uiModel.addAttribute("exercise", Exercise.findExercise(id));
//        addDateTimeFormatPatterns(uiModel);
//        return "exercises/update";
//    }
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
//        Exercise.findExercise(id).remove();
//        uiModel.asMap().clear();
//        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
//        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
//        return "redirect:/exercises";
//    }
//
//	@ModelAttribute("exercises")
//    public Collection<Exercise> populateExercises() {
//        return Exercise.findAllExercises();
//    }

    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("exercise_startdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("exercise_enddate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {
        }
        return pathSegment;
    }
}
