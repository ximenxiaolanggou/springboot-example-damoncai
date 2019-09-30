package com.ximen.cxf.service;

import com.ximen.cxf.entity.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author ZhiShun.Cai
 * @Date 2019/9/7 14:14
 */
public interface CityInterface {
    @GET
    @Path("/weather/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Student getWeather(@PathParam("id")String cityID);
}
