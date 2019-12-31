package net.thomasmaestas.aws;
// Java Lambda using API Gateway trigger. 

//
//  AWS Lambda Core SDK for `RequestHandler` implementation which 
//  is called by the trigger
//
//                        ARCHITECTURE:
//
// Lambda_API-->API_Gateway------------>Lambda<----->S3
//                  ^                      ^ 
//                  ^----AWS-CloudWatch----^

//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//
//import java.util.Collections;
//
//public class LambdaAPI implements RequestHandler<Object, GatewayResponse> {
//
//	public GatewayResponse handleRequest(Object object, Context context) {
//
//		String message = "Greetings from thomasm1 Lambda";
//		System.out.println(message);
//
//		GatewayResponse response = new GatewayResponse(message, 200,
//				Collections.singletonMap("X-Powered-By", "thomasm1"), false);
//		return response;
//	}
//}
