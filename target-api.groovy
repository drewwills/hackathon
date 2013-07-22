
@Grapes([
	@Grab(group='commons-httpclient', module='commons-httpclient', version='3.1')
])
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

class ApiInvoker {
	ApiResponse invoke(String url, String accept, String body) {
		PostMethod post = new PostMethod(url);
		post.addRequestHeader('Accept', accept);
		RequestEntity entity = new StringRequestEntity(body, 'application/json', 'UTF-8');
		post.setRequestEntity(entity);
		
		HttpClient httpclient = new HttpClient();
		try {
			int status = httpclient.executeMethod(post);
			return new ApiResponse(status: status, body: post.getResponseBodyAsString());
		} finally {
			// Release current connection to the connection pool once you are done
			post.releaseConnection();
		}
	}
	
	public static class ApiResponse {
		int status;
		String body;
	}

}

return new ApiInvoker();
