package se.emirbuc.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The <code>Class HelloController</code>.
 *
 * @author Emir Bucalovic (embuc)
 * @since 2015-dec-08
 */
@RestController
@RequestMapping("/")
@SuppressWarnings("javadoc")
public class HelloController {

	@RequestMapping(value="/hello", produces="text/plain")
	public String hello() {
		return "Answering from Hello!";
	}

}
