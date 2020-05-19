package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import models.Customer;

@JsonAutoDetect
@XmlRootElement(name = "response")
public class CustomerCollectionResponse {
	// Fields
		private int code;
		private String status;
		private String message;
		private String requestId;
		private List<Customer> data;

		// Properties
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}

		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

		public String getRequestId() {
			return requestId;
		}
		public void setRequestId(String requestId) {
			this.requestId = requestId;
		}
		
		public List<Customer> getData() {
			return data;
		}
		public void setData(List<Customer> data) {
			this.data = data;
		}
		
		
		// Constructors
		public CustomerCollectionResponse() {
		}

		public CustomerCollectionResponse(int code, String status, String message) {
			this();
			this.code = code;
			this.status = status;
			this.message = message;
		}

		
		// Overrides
		@Override
		public String toString() {
			return "[response : code=" + code + ", status=" + status + ", message=" + message + ", requestId="
					+ requestId + ", data=" + data + "]";
		}
}
