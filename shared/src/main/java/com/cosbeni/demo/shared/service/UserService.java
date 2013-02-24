package com.cosbeni.demo.shared.service;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import com.cosbeni.demo.shared.entity.User;


@Path("user")
public interface UserService {
  
  @POST
  @Path("/add")
  @Produces("application/json")  
  @Consumes("application/json")
  public User add(User user);
  
  @POST
  @Path("/update")
  @Produces("application/json")  
  @Consumes("application/json")
  public User update(User user);
  
  @GET
  @Path("/users")
  @Produces("application/json")    
  public List<User> getUsers();

  @GET
  @Path("/user/{id}")
  @Produces("application/json")
  public User getUser(@PathParam("id") String id);
  
  @POST
  @Path("/delete")
  @Produces("application/json")
  @Consumes("application/json")  
  public User delete(User user);

}
