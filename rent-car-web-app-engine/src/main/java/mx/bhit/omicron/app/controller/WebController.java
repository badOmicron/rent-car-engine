package mx.bhit.omicron.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rent.car.bean.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);

	public WebController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/conf", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response init(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Web COntroller");
		Response responseBody = new Response();
		// if (somecondition == "false") {
		// // here i am returning only the string
		// // in this case, render response yourself and just return null
		// response.getWriter().write("notok");
		// return null;
		// } else {
		// // redirect
		// return "redirect:checkPage";
		// }
		responseBody.setCodigo(1);
		responseBody.setMensaje("OK");
		return responseBody;
	}

}
