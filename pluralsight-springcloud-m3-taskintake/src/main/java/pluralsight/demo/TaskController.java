package pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	@Autowired
	private TaskProcessor t;
	
	@RequestMapping(path="/tasks", method= POST)
	public @ResponseBody String launchTask(@RequestBody String s) {
		
		t.publishRequest(s);
		System.out.println("request made");
		
		return "success";
	}
}
