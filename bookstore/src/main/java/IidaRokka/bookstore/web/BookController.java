package IidaRokka.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import IidaRokka.bookstore.domain.bookEntity;
import IidaRokka.bookstore.domain.bookRepository;

@Controller
public class BookController {
	@Autowired
	private bookRepository repository;

	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new bookEntity());
		return "addbook";
	}

	@PostMapping("/save")
	public String save(bookEntity book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long BookId, Model model) {
		repository.deleteById(BookId);
		return "redirect:../booklist";
	}

	// Edit ei toimi, tyyliin koska luulee /edit/save olevan id, en kyllä tiedä
	// miten lähtisin korjaamaan :/
	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long BookId, Model model) {
		model.addAttribute("book", repository.findById(BookId));
		return "editbook";
	}

	@GetMapping("/index")
	public String test() {
		return "booklist";
	}

}
