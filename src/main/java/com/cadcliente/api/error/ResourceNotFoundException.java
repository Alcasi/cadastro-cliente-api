package com.cadcliente.api.error;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8953631407874355973L;

		public ResourceNotFoundException(String mensagem) {
			super(mensagem);
		}
		
		public ResourceNotFoundException(Exception ex, String mensagem) {
			super(mensagem + " - "+ ex.getMessage());
		}

		public ResourceNotFoundException(Exception ex) {
			super(ex);
		}
}
