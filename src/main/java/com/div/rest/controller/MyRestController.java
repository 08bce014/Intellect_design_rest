package com.div.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.div.rest.CustomErrorObject;
import com.div.rest.model.User;
import com.div.rest.service.MyUserService;

@RestController
public class MyRestController {

	@Autowired
	MyUserService userService;
	
    @RequestMapping(value="/getUser/{userId}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable(value="userId") String userId) {
    	System.out.println("getUser: "+userId);
    	if(userId != null)
    	{
    		User user = userService.getUser(userId);
    		if(user!=null)
    			return user;
    	}
        return null;
    }
    
    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) 
    {
    	System.out.println("saveUser: "+user);
    	if	(user == null)
    	{
    		return "error";
    	}
    	else
    	{
    		userService.createUser(user);
    	}
    	return "success";
    }
    
    @RequestMapping(value="/deleteUser/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(value="userId") String userId) 
    {
    	System.out.println("deleteUser: "+userId);
    	
    		userService.deleteUser(userId);

    	return "success";
    }
    
    @RequestMapping(value="/updateUser/{userId}", method = RequestMethod.POST)
    public String updateUser(@RequestBody User user, @PathVariable(value="userId") String userId) 
    {
    	System.out.println("updateUser: "+user);
    	if	(user == null)
    	{
    		return "error";
    	}
    	else
    	{
    		User userTemp = userService.getUser(userId);
    		if(userTemp!=null)
    		{
    			userTemp.setBirthDate(user.getBirthDate());
    			userTemp.setPinCode(user.getPinCode());
    			userService.updateUser(user);
    		}
    		else 
    		 return "error";
    		
    	}
    	return "success";
    }
    
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorObject processValidationError(HttpMessageNotReadableException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
 
        CustomErrorObject errorObject = new CustomErrorObject();
        errorObject.setErrors(fieldErrors);
        return errorObject;
    }
}
