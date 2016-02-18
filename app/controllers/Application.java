package controllers;

import play.mvc.*;
import views.html.*;

public class Application extends Controller 
{
	public Result index() 
	{
		return ok(index.render());
	}
	
	public Result preflight(String all) 
	{
	        response().setHeader("Access-Control-Allow-Origin", "*");
	        response().setHeader("Allow", "*");
	        response().setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
        	response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
        	return ok();
	}
}
