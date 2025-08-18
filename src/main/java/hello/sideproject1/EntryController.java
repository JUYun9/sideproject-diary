package hello.sideproject1;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/entries")
public class EntryController {

    private final EntryRepository entryRepository;

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("entry", new Entry());
        return "/addForm";
    }

    @PostMapping
    public String create(@ModelAttribute Entry entry, RedirectAttributes redirectAttributes) {
        Entry saveEntry = entryRepository.save(entry);

        redirectAttributes.addAttribute("entryId", saveEntry.getId());

        return "redirect:/entries/{entryId}";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Entry entry = entryRepository.findEntry(id);
        model.addAttribute("entry", entry);
        return "/entry";
    }

    @PutMapping("/{id}")
    public String saveEdit(@PathVariable("id") Long id, @ModelAttribute Entry updateEntry) {
        Entry currentEntry = entryRepository.findEntry(id);

        entryRepository.edit(id, currentEntry);

        return "redirect:/entries/{id}";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Entry entry = entryRepository.findEntry(id);
        model.addAttribute("entry", entry);
        return "/edit";
    }

    @GetMapping
    public String list(Model model) {
        List<Entry> entries = entryRepository.findAll();
        model.addAttribute("entries", entries);
        return "/list";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        entryRepository.delete(id);
        return "redirect:/entries";
    }

    /**
     * 테스트용 데이터
     */
    @PostConstruct
    public void init() {
        entryRepository.save(new Entry("첫 번째 일기", "첫 번째 일기 본문", LocalDateTime.now()));
        entryRepository.save(new Entry("두 번째 일기", "두 번째 일기 본문", LocalDateTime.now()));
    }
}
