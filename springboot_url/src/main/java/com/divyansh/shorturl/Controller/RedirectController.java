package com.divyansh.shorturl.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.divyansh.shorturl.Repository.RedirectEntity;
import com.divyansh.shorturl.Request.RedirectRequest;
import com.divyansh.shorturl.Service.RedirectService;


@Controller
public class RedirectController {
	
	private RedirectService redirectService;
	
	@Autowired
	public RedirectController(RedirectService redirectService) {
		this.redirectService = redirectService;
	}
	
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String homeForm(Model model) {
		model.addAttribute("short", new RedirectEntity());
		return "index";
	}
    
    @PostMapping("/")
    public String homeResult(@ModelAttribute @RequestBody @Valid RedirectEntity redirectEntity, Model model) {
		model.addAttribute("short", redirectEntity);
		redirectService.createRedirect(redirectEntity);
		return "result";
	}

	@GetMapping("/{alias}")
	public ResponseEntity<?> handleRedirect(@PathVariable String alias) throws URISyntaxException{
		RedirectEntity redirectEntity =  redirectService.getRedirect(alias);
		URI uri = new URI(redirectEntity.getUrl());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uri);
		return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
	}
		
	@PostMapping("/json")
	public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectRequest redirectRequest){
		return ResponseEntity.ok(redirectService.createRedirect(redirectRequest));
	}
	
}
