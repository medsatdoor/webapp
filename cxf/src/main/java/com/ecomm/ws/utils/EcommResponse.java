package com.ecomm.ws.utils;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


/**
 * ***************************************************************************
 * This utility class will be used to build the response with customized status
 * codes, cookies, headers, response body etc. with the help of the response
 * builder following a particular standard in order to avoid boilerplate codes
 * in the web-service layer.
 * ***************************************************************************
 */
public class EcommResponse {

	// URI builder is not working...
	private static URI getLocationUri(Object wsentity, UriInfo uriInfo)
			throws URISyntaxException {
		if (wsentity instanceof com.ecomm.wsentity.Product) {
			return new URI(String.valueOf(uriInfo.getAbsolutePath())
					+ ((com.ecomm.wsentity.Product) wsentity).getId());
		}
		throw new URISyntaxException(
				String.valueOf(uriInfo.getAbsolutePath()),
				"Failed to resolve the instance type of the entity object to build the response");
	}

	public static Response getResponseCreated(Object wsentity, UriInfo uriInfo)
			throws URISyntaxException {
		return Response.created(getLocationUri(wsentity, uriInfo))
				.entity(wsentity).build();
	}

	public static Response getResponseOk(Object wsentity) throws URISyntaxException {
		return Response.ok().entity(wsentity).build();
	}
}
