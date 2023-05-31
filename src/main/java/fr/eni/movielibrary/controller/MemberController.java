package fr.eni.movielibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.eni.movielibrary.bo.Member;


@Controller
@SessionAttributes({"loggedUser"})
public class MemberController {
	
	@PostMapping("/login")
	public String login(Model model, @ModelAttribute("formLogin") Member member) {
		
		//TODO effectuer le check si existe avec bdd
		// si oui connecter et rediriger sur home avec la session
		// sinon renvoyer sur la route loginBefore avec message d'erreur
		model.addAttribute("loggedUser", new Member(member.getLogin(), member.getPassword()));
		return "redirect:/";
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
