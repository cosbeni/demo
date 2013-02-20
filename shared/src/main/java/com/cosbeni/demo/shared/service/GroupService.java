package com.cosbeni.demo.shared.service;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import com.cosbeni.demo.shared.entity.Group;


@Path("group")
public interface GroupService {
  
  @POST
  @Path("/add")
  @Produces("application/json")  
  @Consumes("application/json")
  public String add(Group group);
  
  @POST
  @Path("/update")
  @Produces("application/json")  
  @Consumes("application/json")
  public String update(Group group);
  
  @GET
  @Path("/delete/{id}")
  @Produces("application/json")    
  public String delete(@PathParam("id") String id);

  @GET
  @Path("/groups")
  @Produces("application/json")    
  public List<Group> getGroups();

  @GET
  @Path("/group/{id}")
  @Produces("application/json")
  public Group getGroup(@PathParam("id") String id);
  
}
