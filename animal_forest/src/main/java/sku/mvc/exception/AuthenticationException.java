package sku.mvc.exception;

/**
 * �α����Ҷ� ������ �����ϸ� �߻��ϴ� ��������
 * */
public class AuthenticationException extends Exception { //üũ����!!!
	public AuthenticationException() {}
	public AuthenticationException(String message) {
		super(message);
	}

}
