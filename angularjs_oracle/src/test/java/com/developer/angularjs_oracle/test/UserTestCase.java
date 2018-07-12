package com.developer.angularjs_oracle.test;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.developer.angularjs_oracle.config.RootConfig;
import com.developer.angularjs_oracle.dto.User;
import com.developer.angularjs_oracle.model.DomainResponseModel;
import com.developer.angularjs_oracle.model.UserModel;
import com.developer.angularjs_oracle.service.UserService;





public class UserTestCase {

	private static AnnotationConfigApplicationContext context = null;
	private static UserService userService = null;
	public User user = null;
	DomainResponseModel model = null;
	
	/* Initialize the class */
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(RootConfig.class);
		userService = (UserService) context.getBean("userService");
	}
	
	
	/*@Test
	public void testAdd() {
		
		user = new User();
		String random = UUID.randomUUID().toString().substring(26).toUpperCase();
		user.setFirstName("Samuel");
		user.setLastName("Gavidia");
		user.setEmail("KZN" + random +"@gmail.com");
		user.setPassword("Niit@2017");
		user.setUsername("KZN" + random);
		user.setContactNumber("9819000000");
			
		// testing for user object
		model = userService.add(user);
		assertEquals("Failed to store user object!",201,model.getCode());
		
		// testing for null object
		model = userService.add(null);
		assertEquals("Testing with null object failed!", 499, model.getCode());		
	
	}*/
	
	/*@Test
	public void testAddDuplicate() {
		// checking for uniqueness of username and email
		user = new User();
		user.setFirstName("jose");
		user.setLastName("sucapuca");
		user.setEmail("josesuca@gmail.com");
		user.setPassword("Niit@2017");
		user.setUsername("josesuca");
		user.setContactNumber("9819000000");
		// should not allow to store duplicate object
		model = userService.add(user);
		assertEquals ("Duplicate Object is getting Stored!",497, model.getCode());
	}*/
	
	
	/*@Test
	public void testGetByParam(){
		// verificar la exclusividad del nombre de usuario y el correo electrónico
		user=userService.getByParam("username", "samuelgav");
		// verificando si el valor válido es exitoso
		assertEquals("¡No se puede obtener el usuario dado con el parámetro nombre de usuario!","samuelgav",user.getUsername());
		
		// verificando si el valor no válido es exitoso
		user=userService.getByParam("username", "arrietafeo");
		assertEquals("¡Obtener a un usuario pasando el valor incorrecto!", user);
		

		// verificando si el parámetro inválido es exitoso
		user=userService.getByParam("usernames", "samuelgav");
		assertEquals("¡Obtener a un usuario pasando el parámetro incorrecto!",user);
		

		// verificando si el valor nulo es exitoso
		user=userService.getByParam(null, null);
		assertEquals("¡Obtener un usuario pasando valor nulo!", user);		
	}*/
	
	@Test
	public void testValidate(){
		user = new User();
		// with valid credentials
		user.setUsername("kozi2017");
		user.setPassword("Niit@2017");
		model = userService.validate(user);	
		assertEquals("Failed to fetch UserModel!", UserModel.class , model.getClass());
		
		// with invalid credentials
		user.setUsername("kozi__2017");
		user.setPassword("Niit@2017");
		model = userService.validate(user);
		assertEquals("Failed to fetch DomainResponseModel!", DomainResponseModel.class , model.getClass());
		
		// with null values
		user.setUsername(null);
		user.setPassword(null);
		model = userService.validate(user);
		assertEquals("Failed to fetch DomainResponseModel!", DomainResponseModel.class , model.getClass());
	}
}
