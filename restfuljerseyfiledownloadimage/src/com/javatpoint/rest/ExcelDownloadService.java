package com.javatpoint.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/files")
public class ExcelDownloadService {
	private static final String FILE_PATH = "C:\\myexcel.xls";
	 
	@GET
	@Path("/excel")
	@Produces("application/vnd.ms-excel")
	public Response getFile() {
 
		File file = new File(FILE_PATH);
 
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition","attachment; filename=\"javatpoint_myexcel.xls\"");
		return response.build();
 
	}
 }


