package fr.eni.movielibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.movielibrary.bll.MemberService;
import fr.eni.movielibrary.bo.Member;


@Controller
@SessionAttributes({"loggedUser"})
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/login")
	public String login(Model model, @ModelAttribute("formLogin") Member member, RedirectAttributes redirAttrs) {
		Optional<Member> result = this.memberService.getByLogin(member.getLogin());
		
		if (result.isPresent() && result.get().getPassword().equals(member.getPassword())) {
			model.addAttribute("loggedUser", new Member(member.getLogin()));
			return "redirect:/";
		} else {
			redirAttrs.addFlashAttribute("message", "Identifiant is not correct");
			return "redirect:/loginForm";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/";	
	}
	
	@GetMapping("/loginForm")
    public String loginPage(Model model) {
		if (model.getAttribute("loggedUser") != null) {
			return "redirect:/";
		} else {
			model.addAttribute("member", new Member());
	        return "login";
		}
    }
	
}
